public class MensagemArquivo extends Mensagem {
    Arquivo arquivo;
    public String getMensagem(){
        return arquivo.nomeArquivo;
    }

    public void setArquivo(Arquivo arquivo){
        this.arquivo = arquivo;
    }

    public MensagemArquivo(Usuario emissor){
        this.emissor = emissor;
    }
}
