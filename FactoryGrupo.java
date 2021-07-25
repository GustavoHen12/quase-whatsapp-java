public interface ICriadorConversa {
    public IConversa createConversa();
}

public class CriadorGrupo implements ICriadorConversa{
    public IConversa createConversa (String nomeGrupo, Usuario criadorGrupo){
        return new Grupo(nomeGrupo, criadorGrupo);
    }
}


