public class CommandEnviarMensagem extends Command {
    String mensagem;
    Grupo grupo;

    CommandEnviarMensagem (Usuario usuario){
        super(usuario);
    }

    @Override
    boolean executar() {
        Mensagem msg = MensagemTexto.criaMensagem(this.usuario, this.mensagem);
        this.grupo.enviarMensagem(msg);
        return true;
    }
}