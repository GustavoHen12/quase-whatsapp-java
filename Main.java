public class Main {
    public static void main(String[] args) {
        Whatsapp whatsP1 = new Whatsapp();
        whatsP1.cadastrar("p1", "99239909");

        Whatsapp whatsP2 = new Whatsapp();
        whatsP2.cadastrar("p2", "99239929");

        Whatsapp whatsP3 = new Whatsapp();
        whatsP3.cadastrar("p3", "99239939");

        Whatsapp whatsP4 = new Whatsapp();
        whatsP4.cadastrar("p4", "99239949");
        
        // – p1 cria os grupos g1 e g2;
        whatsP1.BtnNovoGrupo("g1");
        whatsP1.BtnNovoGrupo("g2");
        // – p3 cria o grupo g3;
        whatsP3.BtnNovoGrupo("g3");

        // – p1 inclui p2, p3 e p4 no grupo g1;
        whatsP1.NavGrupo("g1");
        whatsP1.BtnAdicionarParticipante("p2");
        whatsP1.BtnAdicionarParticipante("p3");
        whatsP1.BtnAdicionarParticipante("p4");

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        // – p1 inclui p2 e p3 no grupo g2;
        whatsP1.NavGrupo("g2");
        whatsP1.BtnAdicionarParticipante("p2");
        whatsP1.BtnAdicionarParticipante("p3");
   
        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        // – p3 inclui p4 no grupo g3;
        whatsP3.NavGrupo("g3");
        whatsP3.BtnAdicionarParticipante("p4");
   
        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        // – p2 envia mensagem para g1;
        whatsP2.NavGrupo("g1");
        whatsP2.BtnEnviarMensagem("Oi eu sou p2");
        // (todos visualizam)
        whatsP1.NavGrupo("g1");
        whatsP3.NavGrupo("g1");
        whatsP4.NavGrupo("g1");

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);
        
        // – p1 envia mensagem para g1;
        whatsP2.NavGrupo("g1");
        whatsP2.BtnEnviarMensagem("Oi eu sou p1");
        // (todos visualizam)
        whatsP2.NavGrupo("g1");
        whatsP3.NavGrupo("g1");
        whatsP4.NavGrupo("g1");

        // – p2 envia mensagem para g2;
        whatsP2.NavGrupo("g2");
        whatsP2.BtnEnviarMensagem("Oi eu sou p2 !!!");
        // (todos menos p3 visualizam)
        whatsP1.NavGrupo("g2");

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        // – p3 envia mensagem para g3;
        whatsP3.NavGrupo("g3");
        whatsP3.BtnEnviarMensagem("Essa mensagem será apagada");
        
        // – p3 envia mensagem para g2;
        whatsP3.NavGrupo("g2");
        whatsP3.BtnEnviarMensagem("Oi eu sou p3 no g2");        
        // (p2 e p1 visualizam)
        whatsP1.NavGrupo("g2");
        whatsP3.NavGrupo("g2");
        
        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);

        // – p3 cancela mensagem para g3)
        whatsP3.NavGrupo("g3");
        whatsP3.BtnCancelarEnvioMensagem();

        // – p3 envia mensagem para g3;
        whatsP3.BtnEnviarMensagem("Nova mensagem de p3");

        // (todos visualizam)
        whatsP3.NavGrupo("g3");
        whatsP4.NavGrupo("g3");

        voltaTodosParaMenu(whatsP1, whatsP2, whatsP3, whatsP4);
    }

    public static void voltaTodosParaMenu(Whatsapp whatsP1, Whatsapp whatsP2, Whatsapp whatsP3, Whatsapp whatsP4){
        whatsP1.NavMenu();
        whatsP2.NavMenu();
        whatsP3.NavMenu();
        whatsP4.NavMenu();
    }
}
