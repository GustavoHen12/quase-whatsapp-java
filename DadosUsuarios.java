class DadosUsuarios{
    private ArrayList<Usuario> todosUsuarios;
    private Integer ultimoId;

    private static DadosUsuarios instance = null;

    private void DadosUsuarios(){
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
        this.ultimoId += 1;
        return this.ultimoId;
    }

    public static Usuario getUsuarioPorId(Integer Id){
        for(Usuario usuario : todosUsuarios){
            if(usuario.id.equals(id)){
                return usuario;
            }
        }

        return null;
    }
    
    public static Usuario getUsuarioPorNome(String nome){
        for(Usuario usuario : todosUsuarios){
            if(usuario.nome.equals(nome)){
                return usuario;
            }
        }
        
        return null;
    }

    public static void adicionaUsuario(Usuario usuario){
        todosUsuarios.push(usuario);
    }
}