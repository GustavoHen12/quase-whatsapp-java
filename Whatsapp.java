import java.util.ArrayList;

class Whatsapp {
       Usuario usuario;
       Grupo grupoAtual; //Se null -> esta no menu

       CommandCriarGrupo criarGrupoCmd;
       CommandAdicionarParticipante adicionarParticipanteCmd;

       public void cadastrar(String nome, String telefone) {
              CriadorUsuario criadorUsuario = new CriadorUsuario();
              this.usuario = criadorUsuario.criaUsuario(nome, telefone);

              this.criarGrupoCmd = new CommandCriarGrupo(this.usuario);
              this.adicionarParticipanteCmd = new CommandAdicionarParticipante(this.usuario);
       }

       public void NavMenu(){
              grupoAtual = null;

              System.out.println("--------------------------");
              System.out.println("|          MENU          |");
              System.out.println("--------------------------");
              System.out.println("| Usuário: " + usuario.nome);
              System.out.println("| Telefone: " + usuario.numeroTelefone);
              System.out.println("--------------------------");
              System.out.println("| GRUPOS                 |");

              ArrayList<Grupo> grupos;
              grupos = usuario.getListaGrupos();
              for (Grupo g : grupos){
                     System.out.println("\t|- " + g.getNomeGrupo());
              }
              System.out.println();

       }

       public void NavGrupo(String nomeGrupo){
              grupoAtual = null;
              if(usuario.conversas != null && usuario.conversas.size() > 0){
                     for(int i = 0; i < usuario.conversas.size(); i++){
                            if(usuario.conversas.get(i).nomeGrupo.equals(nomeGrupo)){
                                   grupoAtual = usuario.conversas.get(i);
                            }
                     }
              }
              if(grupoAtual == null){
                     System.out.println("GRUPO NAO ENCONTRADO, RETORNANDO PARA O MENU ...");
                     NavMenu();
              }

              System.out.println("--------------------------");
              System.out.println("Usuário: " + usuario.nome);
              System.out.println("Telefone: " + usuario.numeroTelefone);
              System.out.println("--------------------------");

              System.out.println("[" + grupoAtual.getNomeGrupo() + "]");
              ArrayList<Mensagem> mensagens;
              mensagens = grupoAtual.getConversa();
              for (Mensagem m : mensagens){
                     if(m.origem.equals(this))
                            System.out.println("\t|- Voce: " + m.getTexto());
                     else
                            System.out.println("\t|- " + m.origem.nome + ": " + m.getTexto());
              }
              System.out.println();

       }


       private CommandEnviarMensagem enviarMensagemCmd = new CommandEnviarMensagem(this.usuario);
       public void BtnEnviarMensagem(String mensagem){
              this.grupoAtual = usuario.getGrupoPorNomeGrupo("g1");
              if(this.grupoAtual != null){       
                     this.enviarMensagemCmd.mensagem = mensagem;
                     this.enviarMensagemCmd.grupo = this.grupoAtual;
                     this.enviarMensagemCmd.executar();
              }
       }


       private CommandEnviarArquivo enviarArquivoCmd;
//       public void BtnEnviarArquivo(TipoArquivo arquivo){
//              if(grupoAtual != null){
//                     enviarArquivoCmd.arquivo = arquivo;
//                     enviarArquivoCmd.grupo = grupoAtual;
//                     enviarArquivoCmd.executar();
//              }
//       }


       // private CommandCancelarEnvioMensagem cancelarEnvioCmd;
       // public void BtnCancelarEnvioMensagem(){
       //        if(grupoAtual != null){
       //               cancelarEnvioCmd.executar();
       //        }
       // }


       public void BtnNovoGrupo(String nomeGrupo){
              this.criarGrupoCmd.nomeGrupo = nomeGrupo;
              this.criarGrupoCmd.executar();
       }

       public void BtnAdicionarParticipante(String nomeParticipante){
              this.grupoAtual = usuario.getGrupoPorNomeGrupo("g1");
              if(this.grupoAtual != null){
                     this.adicionarParticipanteCmd.grupo = this.grupoAtual;
                     this.adicionarParticipanteCmd.nomeParticipante = nomeParticipante;
                     this.adicionarParticipanteCmd.executar();
              }
       }
}
