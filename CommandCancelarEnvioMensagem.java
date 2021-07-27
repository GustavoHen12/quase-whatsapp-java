public class CommandCancelarEnvioMensagem extends Command {

    CommandCancelarEnvioMensagem (Usuario usuario, String nomeGrupo){
        super(usuario);
    }

    @Override
    boolean executar() {
        Grupo.cancelarUltimaMensagem(this.usuario);
        return true;
    }
}