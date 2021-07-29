class Whatsapp {
       Usuario usuario;
       Grupo grupoAtual; //Se null -> esta no menu

       public void NavMenu(){
              grupoAtual = null;
              //pega usuario e printa todos os grupos dele;
              //usuario.grupos();
       }

       public void NavGrupo(Grupo grupo){
              grupoAtual = grupo;
       //       usuario.grupo.getMensagens();
       }


       private CommandEnviarMensagem enviarMensagemCmd = new CommandEnviarMensagem(this.usuario);
       public void BtnEnviarMensagem(String mensagem){
              if(grupoAtual != null){       
                     enviarMensagemCmd.mensagem = mensagem;
                     enviarMensagemCmd.grupo = grupoAtual;
                     enviarMensagemCmd.executar();
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


       private CommandCancelarEnvioMensagem cancelarEnvioCmd;
       public void BtnCancelarEnvioMensagem(){
              if(grupoAtual != null){
                     cancelarEnvioCmd.executar();
              }
       }


       CommandCriarGrupo criarGrupoCmd;
       public void cadastrar(String nome, String telefone) {
              CriadorUsuario criadorUsuario = new CriadorUsuario();
              usuario = criadorUsuario.criaUsuario(nome, telefone);

              criarGrupoCmd = new CommandCriarGrupo(usuario, null);
       }

       public void BtnNovoGrupo(String nomeGrupo){
              criarGrupoCmd.nomeGrupo = nomeGrupo;
              criarGrupoCmd.executar();
       }



       CommandAdicionarParticipante adicionarParticipanteCmd;
       public void BtnAdicionarParticipante(String nomeParticipante){
              if(grupoAtual != null){
                     adicionarParticipanteCmd.grupo = grupoAtual;
                     adicionarParticipanteCmd.nomeParticipante = nomeParticipante;
                     adicionarParticipanteCmd.executar();
              }
       }
}
