package trabalho.grupo;

import trabalho.usuario.Usuario;

public class CriadorGrupo implements ICriadorConversa{
    @Override
    public IConversa createConversa (String nomeGrupo, Usuario administrador){
        Grupo grupo = new Grupo(nomeGrupo, administrador);
        administrador.adicionadoConversa(grupo);
        return grupo;
    }
}


