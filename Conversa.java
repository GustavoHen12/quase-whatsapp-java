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

    public boolean addParticipante (Usuario novoParticipante, Usuario administrador){
        if(isAdministrador(administrador)){
            participantes.add(novoParticipante);
            novoParticipante.adicionadoConversa(this);
            return true;
        }
        return false;
    }

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
     * Função não oficial. Usada para testar se mensagem está no grupo
     */
    public Mensagem ultimaMensagem() {
        Integer n_msgs = this.mensagens.size();
        Mensagem msg = this.mensagens.get(n_msgs-1);
        return msg;
    }

    public ArrayList<Mensagem> getConversa(){
        return mensagens;
    }

    public String getNomeGrupo(){
        return this.nomeGrupo;
    }
}
