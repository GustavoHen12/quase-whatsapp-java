public class CommandEnviarMensagem extends Command {
    String mensagem;
    Grupo grupo;

    CommandEnviarMensagem (Usuario usuario, String mensagem){
        super(usuario);
        this.grupo = grupo;
        this.mensagem = mensagem;
    }

    @Override
    boolean executar() {
        Grupo.enviarMensagem(this.usuario, this.mensagem);
        return true;
    }
}