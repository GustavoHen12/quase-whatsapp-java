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
        return this.mensagem;
    }
}
