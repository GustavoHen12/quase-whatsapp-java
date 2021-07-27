package trabalho;

public class Arquivo {
    final String tipoArquivo;
    final String nomeArquivo;

    public Arquivo (String tipoArquivo, String nomeArquivo){
        this.tipoArquivo = tipoArquivo;
        this.nomeArquivo = nomeArquivo;
    }

    /**
     * Retorna tipo do arquivo
     */
    public String getTipo() {
        return tipoArquivo;
    }

    /**
     * Retorna nome do arquivo
     */
    public String getNome() {
        return nomeArquivo;
    }
}
