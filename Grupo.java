import java.util.ArrayList;

interface IConversa {

    public boolean adicionarParticipante(Usuario administrador, String nomeNovoParticipante);

    public boolean enviarMensagem(Mensagem mensagem);

    public boolean cancelarUltimaMensagem(Usuario usuario);

    public ArrayList getMensagens();
}

class Grupo implements IConversa {

    public ArrayList <Mensagem> mensagens;

    private ArrayList<Usuario> participantes;
    private Usuario administrador;

    public String nomeGrupo;
    public String descricaoGrupo;

    public Grupo (String nomeGrupo, Usuario administrador) {
        this.administrador = administrador;
        this.nomeGrupo = nomeGrupo;

        this.participantes = new ArrayList<Usuario>();
        participantes.add(administrador);

        this.mensagens = new ArrayList<Mensagem>();
    }

    public static void criaGrupo(Usuario usuario, String nomeGrupo){
        CriadorGrupo criadorGrupo = new CriadorGrupo();
        criadorGrupo.createConversa(nomeGrupo, usuario);
    }
    
    public boolean adicionarParticipante(Usuario administrador, String nomeNovoParticipante){
        if(isAdministrador(administrador)){
            DadosUsuarios dadosUsuarios = DadosUsuarios.getInstance();
            Usuario novoParticipante = dadosUsuarios.getUsuarioPorNome(nomeNovoParticipante);
            if(novoParticipante != null){
                participantes.add(novoParticipante);
                novoParticipante.adicionadoConversa(this);
                return true;
            }
        }
        return false;
    }

    private boolean isAdministrador (Usuario administrador) {
        return administrador.equals(this.administrador);
    }
    
    public boolean enviarMensagem(Mensagem mensagem/*Integer idUsuario, String msgTexto, String arquivo */){
        this.mensagens.add(mensagem);
        return true;
    }

    public boolean cancelarUltimaMensagem(Usuario usuario){
        int i = this.mensagens.size() - 1;
        while (i >= 0){
            if (mensagens.get(i).emissor.equals(usuario)){
                mensagens.get(i).cancela();
                return true;
            }
        }
        return false;
    }

    public ArrayList<Mensagem> getMensagens(){
        return this.mensagens;
    }

    public void visualizaMensagens(Usuario usuario){
        for (Mensagem m : this.mensagens){
            if (!m.excluida && !m.visualizadaPor(usuario)){
                m.visualizar(usuario);
                notificaParticipantes(usuario, m.emissor);
            }
        }
    }
    
    public void notificaParticipantes(Usuario usuario, Usuario emissor) {
        for(Usuario participante: this.participantes){
            if(!participante.idUsuario.equals(usuario.idUsuario)){
                participante.notifica(this.nomeGrupo + ": " + usuario.nome + " vizualizou a mensagem enviada por "+ emissor.nome +".|");
            }
        }
    }
}