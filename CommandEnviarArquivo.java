public class CommandEnviarArquivo extends Command {
    Grupo grupo;
    TipoArquivo arquivo

    CommandEnviarMensagem (Usuario usuario, TipoArquivo arquivo){
        super(usuario);
        this.grupo = grupo;
        this.arquivo = arquivo;
    }

    @Override
    boolean executar() {
        Grupo.enviarMensagem(this.usuario, this.arquivo);
        return true;
    }
}