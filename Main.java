import java.util.ArrayList;

public class Main {
    public static ArrayList<String> acoes = new ArrayList<String>();
    public static void main(String[] args) {
        Whatsapp whatsP1 = new Whatsapp();
        whatsP1.cadastrar("p1", "99239909");

        Whatsapp whatsP2 = new Whatsapp();
        whatsP2.cadastrar("p2", "99239929");

        Whatsapp whatsP3 = new Whatsapp();
        whatsP3.cadastrar("p3", "99239939");

        Whatsapp whatsP4 = new Whatsapp();
        whatsP4.cadastrar("p4", "99239949");
        
        acoes.add("p1 cria os grupos g1 e g2");
        whatsP1.BtnNovoGrupo("g1");
        whatsP1.BtnNovoGrupo("g2");
        
        acoes.add("p3 cria o grupo g3");
        whatsP3.BtnNovoGrupo("g3");

        acoes.add("p1 inclui p2, p3 e p4 no grupo g1");
        whatsP1.NavGrupo("g1");
        whatsP1.BtnAdicionarParticipante("p2");
        whatsP1.BtnAdicionarParticipante("p3");
        whatsP1.BtnAdicionarParticipante("p4");

        acoes.add("p1 inclui p2 e p3 no grupo g2");
        whatsP1.NavGrupo("g2");
        whatsP1.BtnAdicionarParticipante("p2");
        whatsP1.BtnAdicionarParticipante("p3");
   
        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        acoes.add("p3 inclui p4 no grupo g3");
        whatsP3.NavGrupo("g3");
        whatsP3.BtnAdicionarParticipante("p4");
   
        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);
        imprimeHeaderSecao(acoes);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        /************ ************ ************/
        
        acoes.add("p2 envia mensagem para g1");
        acoes.add("todos visualizam");
        whatsP2.NavGrupo("g1");
        whatsP2.BtnEnviarMensagem("Oi eu sou p2");


        whatsP1.NavGrupo("g1");
        whatsP3.NavGrupo("g1");
        whatsP4.NavGrupo("g1");

        imprimeHeaderSecao(acoes);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);
        
        /************ ************ ************/
        acoes.add("p1 envia mensagem para g1");
        whatsP1.NavGrupo("g1");
        whatsP1.BtnEnviarMensagem("Oi eu sou p1");
        whatsP1.imprimeTela();
        acoes.add("todos visualizam");
        whatsP2.NavGrupo("g1");
        whatsP3.NavGrupo("g1");
        whatsP4.NavGrupo("g1");

        imprimeHeaderSecao(acoes);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        /************ ************ ************/
        acoes.add("p2 envia mensagem para g2");
        whatsP2.NavGrupo("g2");
        whatsP2.BtnEnviarMensagem("Oi eu sou p2 !!!");
        whatsP2.imprimeTela();
        acoes.add("todos menos p3 visualizam");
        whatsP1.NavGrupo("g2");

        imprimeHeaderSecao(acoes);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);
        /************ ************ ************/

        acoes.add("p3 envia mensagem para g3");
        whatsP3.NavGrupo("g3");
        whatsP3.BtnEnviarMensagem("Essa mensagem será apagada");
        
        acoes.add("p3 envia mensagem para g2");
        whatsP3.NavGrupo("g2");
        whatsP3.BtnEnviarMensagem("Oi eu sou p3 no g2");        
        acoes.add("p2 e p1 visualizam");
        whatsP1.NavGrupo("g2");
        whatsP3.NavGrupo("g2");
        
        imprimeHeaderSecao(acoes);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);

        /************ ************ ************/
        acoes.add("p3 cancela mensagem para g3");
        whatsP3.NavGrupo("g3");
        //whatsP3.BtnCancelarEnvioMensagem();

        acoes.add("p3 envia mensagem para g3");
        whatsP3.BtnEnviarMensagem("Nova mensagem de p3");

        acoes.add("todos visualizam");
        whatsP3.NavGrupo("g3");
        whatsP4.NavGrupo("g3");

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);
        imprimeTodos(whatsP1, whatsP2, whatsP3, whatsP4);
        
    }

    private static void voltaTodosParaMenu(Whatsapp whatsP1, Whatsapp whatsP2, Whatsapp whatsP3, Whatsapp whatsP4){
        whatsP1.NavMenu();
        whatsP2.NavMenu();
        whatsP3.NavMenu();
        whatsP4.NavMenu();
    }

    private static void imprimeTodos(Whatsapp whatsP1, Whatsapp whatsP2, Whatsapp whatsP3, Whatsapp whatsP4){
        whatsP1.imprimeTela();
        whatsP2.imprimeTela();
        whatsP3.imprimeTela();
        whatsP4.imprimeTela();
    }

    private static void imprimeHeaderSecao(ArrayList<String> acoes){
        System.out.println("******************************************");
        for(int i = 0; i < acoes.size(); i++){
            if(i>0){
                System.out.print("\n");
            }
            System.out.print("*");
            imprimeCentralizado(acoes.get(i), 40);
            System.out.print("*");
        }
        System.out.println("\n******************************************");
        acoes.removeAll(acoes);
    }

    private static void imprimeCentralizado(String string, Integer colunas){
        Integer metade = (colunas - string.length()) / 2;

        for(Integer i = 0; i < metade; i++){System.out.print(" ");}
        
        System.out.print(string);

        for(Integer i = metade + string.length(); i < colunas; i++){System.out.print(" ");}
    }



}
