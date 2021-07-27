public interface IMensagem {
    public String getMensagem();
}

public class MensagemTexto implements IMensagem {
    static Integer TIPO_TEXTO = 1;
}

public class MensagemArquivo implements IMensagem {
    static Integer TIPO_ARQUIVO = 2;
}