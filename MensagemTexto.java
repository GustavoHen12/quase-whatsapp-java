public class MensagemTexto extends Mensagem {
    String mensagem;
    
    public MensagemTexto(Usuario emissor){
        this.emissor = emissor;
    }

    public void setTexto(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return this.mensagem;
    }

}