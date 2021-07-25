import java.util.ArrayList;

public interface IConversa {

    public boolean adicionarParticipante();

    public boolean enviarMensagem();

    public boolean cancelarUltimaMensagem();

    public ArrayList visualizarMensagens();

}

public class Grupo implements IConversa {

    public ArrayList <IMensagens> mensagens;

    private ArrayList<Integer> participantes;
    private Integer administrador;

    public String nomeGrupo;
    public String descricaoGrupo;
    

    
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
        return new ArrayList<Mensagem>();
    }

    //
    public void notificaParticipantes() {
        for(Usuario participante: this.participantes){
            participante.aplicativo.notifica("Nova Mensagem");
        }
    }
}