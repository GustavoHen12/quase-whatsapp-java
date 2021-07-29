import java.util.ArrayList;

public abstract class Mensagem {
    Usuario emissor;
    public boolean excluida;
    ArrayList<Usuario> visualizada;
    
    abstract String getMensagem();

    public void visualizar(Usuario usuario){
        this.visualizada.add(usuario);
    }

    public boolean visualizadaPor(Usuario usuario){
        for (Usuario u : visualizada){
            if (usuario.equals(u)){
                return true;
            }
        }
        return false;
    }

    public void cancela(){
        this.excluida = true;
    }
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