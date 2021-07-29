public class CommandAdicionarParticipante extends Command {
    String nomeParticipante;
    Grupo grupo;

    CommandAdicionarParticipante (Usuario usuario){
        super(usuario);
        this.grupo = null;
    }

    @Override
    boolean executar() {
        grupo.adicionarParticipante(this.usuario, nomeParticipante);
        return true;
    }
}