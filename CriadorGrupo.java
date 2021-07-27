interface ICriadorConversa {
    public IConversa createConversa (String nomeGrupo, Usuario administrador);
}

public class CriadorGrupo implements ICriadorConversa{
    public IConversa createConversa (String nomeGrupo, Usuario administrador){
        Grupo grupo = new Grupo(nomeGrupo, administrador);
        administrador.adicionadoConversa(grupo);
        return grupo;
    }
}

