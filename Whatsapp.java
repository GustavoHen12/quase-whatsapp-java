import java.util.ArrayList;

class Whatsapp {
       Usuario usuario;
       Grupo grupoAtual; //Se null -> esta no menu

       private CommandCriarGrupo criarGrupoCmd;
       private CommandAdicionarParticipante adicionarParticipanteCmd;
       private CommandEnviarMensagem enviarMensagemCmd;
       private CommandEnviarArquivo enviarArquivoCmd;

       public void cadastrar(String nome, String telefone) {
              CriadorUsuario criadorUsuario = new CriadorUsuario();
              this.usuario = criadorUsuario.criaUsuario(nome, telefone);

              this.criarGrupoCmd = new CommandCriarGrupo(this.usuario);
              this.adicionarParticipanteCmd = new CommandAdicionarParticipante(this.usuario);
              this.enviarMensagemCmd = new CommandEnviarMensagem(this.usuario);
              this.enviarArquivoCmd = new CommandEnviarArquivo(this.usuario);
       }

       public void printMenu(){
              System.out.println("--------------------------");
              System.out.println("|          MENU          |");
              System.out.println("--------------------------");
              System.out.println("| Usuário: " + usuario.nome);
              System.out.println("| Telefone: " + usuario.numeroTelefone);
              System.out.println("--------------------------");
              System.out.println("| NOTIFICACOES           |");
              System.out.println(usuario.getNotificacoes());
              System.out.println("| GRUPOS                 |");
              System.out.println(usuario.getListaGrupos());
              System.out.println();
       }

       public void printGrupo(){
              System.out.println("--------------------------");
              System.out.println("|          GRUPO         |");
              System.out.println("--------------------------");
              System.out.println("| Usuário: " + usuario.nome);
              System.out.println("| Telefone: " + usuario.numeroTelefone);
              System.out.println("--------------------------");
              System.out.println("[" + grupoAtual.nomeGrupo + "]");
              ArrayList<Mensagem> mensagens;
              mensagens = grupoAtual.getMensagens();
              for (Mensagem m : mensagens){
                     if(m.emissor.equals(this))
                            System.out.println("\t|- Voce: " + m.getMensagem());
                     else
                            System.out.println("\t|- " + m.emissor.nome + ": " + m.getMensagem());
              }
              System.out.println();
       }

       public void imprimeTela(){
              if (grupoAtual == null){
                     printMenu();
              }
              else{
                     printGrupo();
              }
       }

       public void NavMenu(){
              grupoAtual = null;
       }

       public void NavGrupo(String nomeGrupo){
              grupoAtual = usuario.getGrupoPorNomeGrupo(nomeGrupo);
              grupoAtual.notificaParticipantes(usuario);
       }


       
       public void BtnEnviarMensagem(String mensagem){
              if(this.grupoAtual != null){       
                     this.enviarMensagemCmd.mensagem = mensagem;
                     this.enviarMensagemCmd.grupo = this.grupoAtual;
                     this.enviarMensagemCmd.executar();
              }
       }


      
       public void BtnEnviarArquivo(Arquivo arquivo){
              if(grupoAtual != null){
                     enviarArquivoCmd.arquivo = arquivo;
                     enviarArquivoCmd.grupo = grupoAtual;
                     enviarArquivoCmd.executar();
              }
       }


//       private CommandCancelarEnvioMensagem cancelarEnvioCmd;
//       public void BtnCancelarEnvioMensagem(){
//              if(grupoAtual != null){
//                     enviarArquivoCmd.arquivo = arquivo;
//                     enviarArquivoCmd.grupo = grupoAtual;
//                     enviarArquivoCmd.executar();
//              }
//       }

       public void BtnNovoGrupo(String nomeGrupo){
              this.criarGrupoCmd.nomeGrupo = nomeGrupo;
              this.criarGrupoCmd.executar();
       }

       public void BtnAdicionarParticipante(String nomeParticipante){
              if(this.grupoAtual != null){
                     this.adicionarParticipanteCmd.grupo = this.grupoAtual;
                     this.adicionarParticipanteCmd.nomeParticipante = nomeParticipante;
                     this.adicionarParticipanteCmd.executar();
              }
       }
}