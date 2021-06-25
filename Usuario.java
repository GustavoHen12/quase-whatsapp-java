import java.util.ArrayList;

public class Usuario {
    public final String nome;
    public final Integer numeroTelefone;
    public Arquivo foto;
    public String status;
    private ArrayList<Conversa> conversas;

    public Usuario (String nome, Integer numeroTelefone){
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.conversas = new ArrayList<Conversa>();
    }

    /**
     * Permite ao usuario criar um novo grupo de conversa
     * o grupo passa a ser listado como uma conversa, na lista de "conversas"
     * o usuário que cria um grupo passa a ser o administrador dele
     * @param nomeGrupo Nome do grupo que será criado
     */
    public void criaGrupo (String nomeGrupo) {
        Conversa novoGrupo = new Conversa(nomeGrupo, this);
        this.conversas.add(novoGrupo);
    }

    /**
     * Permite a um administrador, a apenas ele, adicionar
     * um participante ao grupo.
     * Após a adição, o grupo passa ser listado como uma conversa
     * do novo participante
     * @param nomeGrupo Nome do grupo que o participante deverá ser adicionado
     * @param novoMembro Usuário que será adicionado ao grupo
     * @return true se conseguiu adicionar, false caso contrário (não encontrou grupo ou não possui permissão)
     */
    public boolean addParticipanteGrupo (String nomeGrupo, Usuario novoMembro){
        Conversa grupo = buscaGrupo(nomeGrupo);
        if(grupo != null){
            return grupo.addParticipante(novoMembro, this);
        }

        return false;
    }

    /**
     * Busca nas conversas um grupo e, se encontrado, retorna o objeto 
     * @param nomeGrupo Nome do grupo que deverá ser buscado
     * @return null se não encontrar, o objeto Conversa caso contrario
     */
    private Conversa buscaGrupo (String nomeGrupo) {
        if(this.conversas != null && this.conversas.size() > 0){
            for(int i = 0; i < this.conversas.size(); i++){
                if(conversas.get(i).nomeGrupo.equals(nomeGrupo)){
                    return conversas.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Chamado pela conversa, adiciona conversa a lista de conversas
     * do usuario
     * @param conversa
     */
    public void adicionadoConversa (Conversa conversa) {
        this.conversas.add(conversa);
    }

        /**
     * Retorna uma string com o nome dos grupos (conversas)
     * Formato: "nomegrupo nomegrupo nomegrupo "
     * @return string com o nome dos grupos
     */
    public String getNomesGrupos () {
        String nomesGruposList = "";
        if(this.conversas != null && this.conversas.size() > 0){
            for(int i = 0; i < this.conversas.size(); i++){
                nomesGruposList += conversas.get(i).nomeGrupo + " ";
            }
        }
        return nomesGruposList;
    }

    /**
     * Usuário manda mensagem para o grupo.
     * @return true se mensagem foi enviada com sucesso, false caso contrário.
     */
    public boolean mandarMensagemGrupo (String nomeGrupo, String mensagem, Arquivo arquivo) {
        Conversa grupo = this.buscaGrupo(nomeGrupo);
        if ( grupo != null ) {
            return grupo.addMensagem(mensagem, this, arquivo);
        }
        return false;
    }

    /**
     * Função oficial.
     */
    public void getTela(){
        System.out.println("-------------------------");
        System.out.println("Usuário: " + this.nome);
        System.out.println("Telefone: " + this.numeroTelefone);
        System.out.println("-------------------------");

        for(Conversa conversa : this.conversas){
            System.out.println("[" + conversa.getNomeGrupo() + "]");
            ArrayList<Mensagem> mensagens;
            mensagens = conversa.getConversa();
            for (Mensagem m : mensagens){
                if(m.origem.equals(this))
                    System.out.println("\t|- Voce: " + m.getTexto());
                else
                    System.out.println("\t|- " + m.origem.nome + ": " + m.getTexto());
            }
        }
        System.out.println();
    }
}