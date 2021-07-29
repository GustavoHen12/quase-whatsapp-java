import java.util.ArrayList;
public class MensagemTexto extends Mensagem {
    String mensagem;
    
    public MensagemTexto(Usuario emissor){
        this.visualizada = new ArrayList<Usuario>();
        this.visualizada.add(emissor);
        this.excluida = false;
        this.emissor = emissor;
    }

    public void setTexto(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }

    static MensagemTexto criaMensagem(Usuario usuario, String mensagem){
        ICriadorMensagem criadorMensagem = new CriadorMensagemTexto();
        Mensagem msg = criadorMensagem.createMensagem(usuario);
        ((MensagemTexto)msg).setTexto(mensagem);
        return (MensagemTexto)msg;
    }

}