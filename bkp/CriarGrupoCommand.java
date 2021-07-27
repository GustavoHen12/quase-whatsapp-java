public class CriarGrupoCommand extends Command {
    String nomeGrupo;

    public CriarGrupoCommand (Usuario usuario, String nomeGrupo){
        super(usuario);
        this.nomeGrupo = nomeGrupo;
    }

    @Override
    public boolean executar() {
        Grupo.criaGrupo(this.usuario, this.nomeGrupo);
        return true;
    }
}