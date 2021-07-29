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

        whatsP1.BtnNovoGrupo("g1");
        whatsP1.BtnNovoGrupo("g2");
        
        whatsP1.BtnAdicionarParticipante("p2");
        whatsP1.BtnAdicionarParticipante("p3");
        whatsP1.BtnAdicionarParticipante("p4");
        
        printUser(whatsP1.usuario);
        printUser(whatsP2.usuario);
        printUser(whatsP3.usuario);
        printUser(whatsP4.usuario);

        System.out.println(whatsP1);

        // whatsP1.NavGrupo(whatsP1.usuario.conversas.get(0));
        // whatsP1.BtnEnviarMensagem("Hello, World!");
        // //whatsP1.BtnEnviarArquivo(new Arquivo("GIF", "Bom_dia.gif"));
        // System.out.println(whatsP1.usuario.conversas.get(0).mensagens.get(0).getMensagem());
        // whats.PBtnNovoGrupo("Nome Grupo");
        // whats.NavGrupo("g1");
        // whats.PBtnEnviarMensagem("mensagem");
        // whats.PBtnEnviarMensagem(arquivo);


    }

    public static void printUser(Usuario usuario){
        System.out.println(usuario.nome);
        String grupos = usuario.getListaGrupos();
        System.out.println(grupos);
    }
}
