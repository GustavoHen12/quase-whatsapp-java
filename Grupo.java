import java.util.ArrayList;

interface IConversa {

    public boolean adicionarParticipante();

    public boolean enviarMensagem(Mensagem mensagem);

    public boolean cancelarUltimaMensagem();

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
    
    public boolean adicionarParticipante(/*Integer IdUsuarioOrigem, Integer IdNovoParticipante*/){
        return true;
    }
    
    public boolean enviarMensagem(Mensagem mensagem/*Integer idUsuario, String msgTexto, String arquivo */){
        this.mensagens.add(mensagem);
        return true;
    }

    public boolean cancelarUltimaMensagem(/*Integer idUsuario */){
        return true;
    }

    public ArrayList getMensagens(/*Integer idUsuario*/){
        // pegar Mensagem
        // filtra msg por usuario
        // add usuario lista visualizados
        // idUsuario
        return new ArrayList<Mensagem>();
    }

    //
    // public void notificaParticipantes() {
    //     for(Usuario participante: this.participantes){
    //         participante.aplicativo.notifica("Nova Mensagem");
    //     }
    // }
}