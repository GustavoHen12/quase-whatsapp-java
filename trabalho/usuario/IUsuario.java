package trabalho.usuario;
import trabalho.grupo.IConversa;

public interface IUsuario {
    public void adicionadoConversa(IConversa conversa);
    public String getListaGrupos();
}
