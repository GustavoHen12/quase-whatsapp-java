import java.util.ArrayList;

class DadosUsuarios{
    private ArrayList<Usuario> todosUsuarios;
    private Integer ultimoId;

    private static DadosUsuarios instance = null;

    private DadosUsuarios(){
        this.todosUsuarios = new ArrayList();
        this.ultimoId = 0;
    }

    public static DadosUsuarios getInstance(){
      if(instance == null){
         instance = new DadosUsuarios();
        }
        return instance;
    }

    public static Integer getProxId(){
        DadosUsuarios instance = DadosUsuarios.getInstance();
        instance.ultimoId += 1;
        return instance.ultimoId;
    }

    public static Usuario getUsuarioPorId(Integer id){
        DadosUsuarios instance = DadosUsuarios.getInstance();
        for(Usuario usuario : instance.todosUsuarios){
            if(usuario.idUsuario.equals(id)){
                return usuario;
            }
        }

        return null;
    }
    
    public static Usuario getUsuarioPorNome(String nome){
        DadosUsuarios instance = DadosUsuarios.getInstance();
        for(Usuario usuario : instance.todosUsuarios){
            if(usuario.nome.equals(nome)){
                return usuario;
            }
        }
        
        return null;
    }

    public static void adicionaUsuario(Usuario usuario){
        DadosUsuarios instance = DadosUsuarios.getInstance();
        instance.todosUsuarios.add(usuario);
    }
}