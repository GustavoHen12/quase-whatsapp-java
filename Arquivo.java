public class Arquivo {
    final String tipoArquivo;
    final String nomeArquivo;

    public Arquivo (String tipoArquivo, String nomeArquivo){
        this.tipoArquivo = tipoArquivo;
        this.nomeArquivo = nomeArquivo;
    }

    public String getTipo() {
        return tipoArquivo;
    }
    public String getNome() {
        return nomeArquivo;
    }
}
