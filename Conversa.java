import java.util.ArrayList;

public class Conversa {
    private ArrayList<Usuario> participantes;
    private ArrayList<Mensagem> mensagens;
    private Usuario administrador;    
    public String nomeGrupo;
    public String descricao;

    public Conversa (String nomeGrupo, Usuario administrador) {
        this.administrador = administrador;
        this.nomeGrupo = nomeGrupo;

        this.participantes = new ArrayList<Usuario>();
        this.mensagens = new ArrayList<Mensagem>();
    }

    /**
     * Se usuario 'administrador' for o administrador do grupo, insere usuario
     * 'novoParticipante' na conversa e retorna true. Senão, retorna false
     */
    public boolean addParticipante (Usuario novoParticipante, Usuario administrador){
        if(isAdministrador(administrador)){
            participantes.add(novoParticipante);
            novoParticipante.adicionadoConversa(this);
            return true;
        }
        return false;
    }

    /**
     * Retorna true se usuario 'administrador' é o administrador da conversa.
     * Caso contrário, retorna false
     */
    public boolean isAdministrador (Usuario administrador) {
        return administrador.equals(this.administrador);
    }

    /**
     * Adiciona mensagem de texto na conversa
     */
    public boolean addMensagem (String mensagem, Usuario autor, Arquivo arquivo) {
        Mensagem new_mensagem = new Mensagem(mensagem, arquivo, autor, this);
        this.mensagens.add(new_mensagem);
        return true;
    }

    /**
     * Retorna arraylist com todas as mensagens da conversa.
     */
    public ArrayList<Mensagem> getConversa(){
        return mensagens;
    }

    /**
     * Retorna string com nome do grupo
     */
    public String getNomeGrupo(){
        return this.nomeGrupo;
    }

    /**
     * Exclui última mensagem mandada pelo usuario 'usuario' no grupo atual
     * Se não houver nenhuma mensagem desse usuario, não faz nada
     */
    public void excluirMensagemUsuario(Usuario usuario){
        ArrayList<Mensagem> msgs = this.mensagens;
        for (int i = msgs.size() - 1; i >= 0; i--){
            if (msgs.get(i).origem.equals(usuario)){
                msgs.remove(i);
                return;
            }
        }
    }
}
