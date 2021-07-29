//public class CommandEnviarArquivo extends Command {
//    Grupo grupo;
//    TipoArquivo arquivo
//
//    CommandEnviarMensagem (Usuario usuario, TipoArquivo arquivo){
//        super(usuario);
//        this.grupo = grupo;
//        this.arquivo = arquivo;
//    }
//
//    @Override
//    boolean executar() {
//        Grupo.enviarMensagem(this.usuario, this.arquivo);
//        return true;
//    }
//}

public class CommandEnviarArquivo extends Command {
    Arquivo arquivo;
    Grupo grupo;

    CommandEnviarArquivo (Usuario usuario){
        super(usuario);
    }

    @Override
    boolean executar() {
        ICriadorMensagem criadorArquivo = new CriadorMensagemArquivo();
        Mensagem msg = criadorArquivo.createMensagem(this.usuario);
        ((MensagemArquivo)msg).setArquivo(this.arquivo);

        this.grupo.enviarMensagem(msg);
        return true;
    }
}
