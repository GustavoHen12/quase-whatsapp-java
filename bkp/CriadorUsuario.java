public class CriadorUsuario implements ICriadorUsuario{
    public Usuario criaUsuario (String nome, String telefone){
        Usuario usuario = new Usuario(nome, telefone);
        DadosUsuarios.adicionaUsuario(usuario); 
        return usuario;
    }
}
