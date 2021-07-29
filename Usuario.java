import java.util.ArrayList;
interface IUsuario {
    public void adicionadoConversa(Grupo conversa);
    public String getListaGrupos();
}

class Usuario implements IUsuario {
    public final Integer idUsuario;
    public final String nome;
    public final String numeroTelefone;
    public Arquivo foto;
    public String status;
    public ArrayList<Grupo> conversas; // mudar
    public ArrayList<String> notificacoes;

    public Usuario (String nome, String numeroTelefone){
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.conversas = new ArrayList<Grupo>();
        this.notificacoes = new ArrayList<String>();
        this.idUsuario = DadosUsuarios.getProxId();
    }

    /**
     * Chamado pela conversa, adiciona conversa a lista de conversas
     * do usuario
     * @param conversa
     */
    public void adicionadoConversa (Grupo conversa) {
        this.conversas.add(conversa);
    }

    /**
     * Retorna uma string com o nome dos grupos (conversas)
     * Formato: "nomegrupo nomegrupo nomegrupo "
     * @return string com o nome dos grupos
     */
    public String getListaGrupos () {
        String nomesGruposList = "";
        if(this.conversas != null && this.conversas.size() > 0){
            for(int i = 0; i < this.conversas.size(); i++){
                nomesGruposList += "\t|- " + conversas.get(i).nomeGrupo + "\n";
            }
        }
        return nomesGruposList;
    }

    public Grupo getGrupoPorNomeGrupo (String nomeGrupo) {
        if(this.conversas != null && this.conversas.size() > 0){
            for(Grupo grupo : this.conversas){
                if(grupo.nomeGrupo.equals(nomeGrupo)){
                    return grupo;
                }
            }
        }
        return null;
    }

    public void notifica (String notificacao) {
        this.notificacoes.add(notificacao);
    }

    public String getNotificacoes () {
        String notificacoes = "";
        if(this.notificacoes != null && this.notificacoes.size() > 0){
            for(int i = 0; i < this.notificacoes.size(); i++){
                notificacoes += "\t|- " + this.notificacoes.get(i) + "\n";
                this.notificacoes.remove(i);
            }
        }
        return notificacoes;
    }
}