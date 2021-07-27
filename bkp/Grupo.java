import java.util.ArrayList;
public class Grupo implements IConversa {

    public ArrayList <IMensagem> mensagens;

    private ArrayList<Usuario> participantes;
    private Usuario administrador;

    public String nomeGrupo;
    public String descricaoGrupo;

    public Grupo (String nomeGrupo, Usuario administrador) {
        this.administrador = administrador;
        this.nomeGrupo = nomeGrupo;

        this.participantes = new ArrayList<Usuario>();
        participantes.add(administrador);
        
        this.mensagens = new ArrayList<IMensagem>();
    }

    public static void criaGrupo(Usuario usuario, String nomeGrupo){
        CriadorGrupo criadorGrupo = new CriadorGrupo();
        criadorGrupo.createConversa(nomeGrupo, usuario);
    }
    
    public boolean adicionarParticipante(/*Integer IdUsuarioOrigem, Integer IdNovoParticipante*/){
        return true;
    }
    
    public boolean enviarMensagem(/*Integer idUsuario, String msgTexto, String arquivo */){
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
        return new ArrayList<IMensagem>();
    }

    //
    // public void notificaParticipantes() {
    //     for(Usuario participante: this.participantes){
    //         participante.aplicativo.notifica("Nova Mensagem");
    //     }
    // }
}