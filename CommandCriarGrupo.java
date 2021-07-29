public class CommandCriarGrupo extends Command {
    String nomeGrupo;

    CommandCriarGrupo (Usuario usuario){
        super(usuario);
        this.nomeGrupo = null;
    }

    @Override
    boolean executar() {
        if(this.nomeGrupo != null){
            Grupo.criaGrupo(this.usuario, this.nomeGrupo);
        }
        return true;
    }
}