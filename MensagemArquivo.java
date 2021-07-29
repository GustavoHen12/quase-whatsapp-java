import java.util.ArrayList;
public class MensagemArquivo extends Mensagem {
    Arquivo arquivo;

    public MensagemArquivo(Usuario emissor){
        this.visualizada = new ArrayList<Usuario>();
        this.visualizada.add(emissor);
        this.excluida = false;
        this.emissor = emissor;
    }

    public String getMensagem(){
        return arquivo.nomeArquivo;
    }

    public void setArquivo(Arquivo arquivo){
        this.arquivo = arquivo;
    }
}
