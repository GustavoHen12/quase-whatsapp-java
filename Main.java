class Main {
    public static void main(String[] args) {        
        System.out.println("Bem vindo ao (quase) whatsapp");

        Usuario p1 = new Usuario("p1", 99239909);
        Usuario p2 = new Usuario("p2", 99239929);
        Usuario p3 = new Usuario("p3", 99239939);
        Usuario p4 = new Usuario("p4", 99239949);

        //p1 cria os grupos g1 e g2;
        p1.criaGrupo("g1");
        p1.criaGrupo("g2");
        //p3 cria o grupo g3;
        p3.criaGrupo("g3");

        //p1 inclui p2, p3 e p4 no grupo g1;
        p1.addParticipanteGrupo("g1", p2);
        p1.addParticipanteGrupo("g1", p3);
        p1.addParticipanteGrupo("g1", p4);
        //p1 inclui p2 e p3 no grupo g2;
        p1.addParticipanteGrupo("g2", p2);
        p1.addParticipanteGrupo("g2", p3);

        //p3 inclui p4 no grupo g3;
        p3.addParticipanteGrupo("g3", p4);

        //Teste usuario nao admin tenta adicionar participante
        //talvez de pra adicionar uma mensagem de erro, mas não é necessário
        p2.addParticipanteGrupo("g2", p4);

        System.out.println("Grupos");
        System.out.println("p1 => " + p1.getNomesGrupos());
        System.out.println("p2 => " + p2.getNomesGrupos());
        System.out.println("p3 => " + p3.getNomesGrupos());
        System.out.println("p4 => " + p4.getNomesGrupos());
    }
}