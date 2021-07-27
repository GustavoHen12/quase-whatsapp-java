import java.util.ArrayList;

public interface IConversa {

    public boolean adicionarParticipante();

    public boolean enviarMensagem();

    public boolean cancelarUltimaMensagem();

    public ArrayList getMensagens();
}