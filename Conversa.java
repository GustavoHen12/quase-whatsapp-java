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
}
