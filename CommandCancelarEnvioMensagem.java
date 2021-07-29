public class CommandCancelarEnvioMensagem extends Command {
    public Grupo grupo;

    CommandCancelarEnvioMensagem (Usuario usuario){
        super(usuario);
    }

    @Override
    boolean executar() {
        return this.grupo.cancelarUltimaMensagem(this.usuario);
    }
}