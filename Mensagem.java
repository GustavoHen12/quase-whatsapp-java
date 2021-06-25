public class Mensagem {
    final String mensagem;
    final Arquivo anexo;
    final Usuario origem;
    final Conversa destino;
    
    public Mensagem (String mensagem, Arquivo anexo, Usuario origem, Conversa destino){
        this.mensagem = mensagem;
        this.anexo = anexo;
        this.origem = origem;
        this.destino = destino;
    }

    public String getTexto() {
        String msg = this.mensagem;
        if (anexo != null) {
            msg = msg + "\n\t  Anexo: " + this.anexo.getNome();
            msg = msg + "\n\t  " + this.anexo.getTipo() + "\n";
        }
        return msg;
    }
}
