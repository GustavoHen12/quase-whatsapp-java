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
              System.out.println("| NOTIFICACOES           |");
              System.out.println(usuario.getNotificacoes());
              System.out.println("| GRUPOS                 |");
              System.out.println(usuario.getListaGrupos());
              System.out.println();

       }

       public void NavGrupo(String nomeGrupo){
              grupoAtual = usuario.getGrupoPorNomeGrupo(nomeGrupo);

              System.out.println("--------------------------");
              System.out.println("|          GRUPO         |");
              System.out.println("--------------------------");
              System.out.println("| Usuário: " + usuario.nome);
              System.out.println("| Telefone: " + usuario.numeroTelefone);
              System.out.println("--------------------------");
              System.out.println("[" + grupoAtual.getNomeGrupo() + "]");
              ArrayList<Mensagem> mensagens;
              mensagens = grupoAtual.getMensagens();
              for (Mensagem m : mensagens){
                     if(m.emissor.equals(this))
                            System.out.println("\t|- Voce: " + m.getTexto());
                     else
                            System.out.println("\t|- " + m.emissor.nome + ": " + m.getTexto());
              }
              System.out.println();

              grupoAtual.notificaParticipantes(usuario);
       }


       private CommandEnviarMensagem enviarMensagemCmd = new CommandEnviarMensagem(this.usuario);
       public void BtnEnviarMensagem(String mensagem){
              if(this.grupoAtual != null){       
                     this.enviarMensagemCmd.mensagem = mensagem;
                     this.enviarMensagemCmd.grupo = this.grupoAtual;
                     this.enviarMensagemCmd.executar();
              }
       }


       private CommandEnviarArquivo enviarArquivoCmd = new CommandEnviarArquivo(this.usuario);
       public void BtnEnviarArquivo(TipoArquivo arquivo){
              if(grupoAtual != null){
                     enviarArquivoCmd.arquivo = arquivo;
                     enviarArquivoCmd.grupo = grupoAtual;
                     enviarArquivoCmd.executar();
              }
       }


       private CommandCancelarEnvioMensagem cancelarEnvioCmd = new CommandCancelarEnvioMensagem(this.usuario);
       public void BtnCancelarEnvioMensagem(){
              if(grupoAtual != null){
                     cancelarEnvioCmd.executar();
              }
       }


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