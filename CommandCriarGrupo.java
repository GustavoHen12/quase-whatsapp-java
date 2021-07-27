public class CommandCriarGrupo extends Command {
    String nomeGrupo;

    CommandCriarGrupo (Usuario usuario, String nomeGrupo){
        super(usuario);
        this.nomeGrupo = nomeGrupo;
    }

    @Override
    boolean executar() {
        Grupo.criaGrupo(this.usuario, this.nomeGrupo);
        return true;
    }
}