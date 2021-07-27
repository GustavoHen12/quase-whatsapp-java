package trabalho.grupo.command;

import trabalho.grupo.Grupo;
import trabalho.usuario.Usuario;

public class CriarGrupoCommand extends Command {
    public String nomeGrupo;

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