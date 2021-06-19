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
        this.conversas = new ArrayList<>();
    }
}
