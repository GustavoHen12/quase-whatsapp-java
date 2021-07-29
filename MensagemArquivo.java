import java.util.ArrayList;
public class MensagemArquivo extends Mensagem {
    Arquivo arquivo;

    public MensagemArquivo(Usuario emissor){
        this.visualizada = new ArrayList<Usuario>();
        this.visualizada.add(emissor);
        this.excluida = false;
        this.emissor = emissor;
    }

    public void setArquivo(Arquivo arquivo){
        this.arquivo = arquivo;
    }

    public String getMensagem(){
        return arquivo.nomeArquivo;
    }

        static MensagemArquivo criaMensagem(Usuario usuario, Arquivo arquivo){
        ICriadorMensagem criadorMensagem = new CriadorMensagemArquivo();
        Mensagem msg = criadorMensagem.createMensagem(usuario);
        ((MensagemArquivo)msg).arquivo = arquivo;
        return (MensagemArquivo)msg;
    }
}
