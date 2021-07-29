public class CommandEnviarMensagem extends Command {
    String mensagem;
    Grupo grupo;

    CommandEnviarMensagem (Usuario usuario){
        super(usuario);
    }

    @Override
    boolean executar() {
        ICriadorMensagem criadorMensagem = new CriadorMensagemTexto();
        Mensagem msg = criadorMensagem.createMensagem(this.usuario);
        ((MensagemTexto)msg).setTexto(this.mensagem);

        this.grupo.enviarMensagem(msg);
        return true;
    }
}