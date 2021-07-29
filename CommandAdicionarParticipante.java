public class CommandAdicionarParticipante extends Command {
    String nomeParticipante;
    Grupo grupo;

    CommandAdicionarParticipante (Usuario usuario, Grupo grupo){
        super(usuario);
        this.grupo = grupo;
    }

    @Override
    boolean executar() {
    //    Grupo.adicionarParticipante(this.usuario, nomeParticipante);
        return true;
    }
}