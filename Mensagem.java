public abstract class Mensagem {
    Usuario emissor;
    abstract String getMensagem();
}

//public class Mensagem implements IMensagem {
//    static Integer TIPO_TEXTO = 1;
//    public String getMensagem(){
//        return "vazio";
//    }
//}

// public interface IMensagem {
//     public String getMensagem();
// }

// public class MensagemArquivo implements IMensagem {
//     static Integer TIPO_ARQUIVO = 2;
// }