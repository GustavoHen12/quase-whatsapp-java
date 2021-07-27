public abstract class Command {
    public Usuario usuario;

    Command (/* Usuario usuario, Grupo grupo */){
        // this.app = app
    }

    public abstract boolean executar();
}

public class CriarGrupoCommand extends Command {
    
    @Override
    public boolean executar() {
        // TODO Auto-generated method stub
        return false;
    }
}

public class AddPaticipanteCommand extends Command {
    
    @Override
    public boolean executar() {
        // TODO Auto-generated method stub
        return false;
    }
}

public class EnviarMensagemCommand extends Command {
    
    @Override
    public boolean executar(/* String Mensagem , Grupo grupo*/) {
        return grupo.enviarMensagem(/*usuario, mensagem*/);;
    }
}

public class EnviarArquivoCommand extends Command {
    
    @Override
    public boolean executar(/* String Mensagem */) {
        return grupo.enviarMensagem(/*usuario, mensagem*/);;
    }
}

public class CancelarEnvioMensagemCommand extends Command {
    
    @Override
    public boolean executar() {
        // TODO Auto-generated method stub
        return false;
    }
}
