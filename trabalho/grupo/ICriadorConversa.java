package trabalho.grupo;

import trabalho.usuario.Usuario;

public interface ICriadorConversa {
    public IConversa createConversa (String nomeGrupo, Usuario administrador);
}