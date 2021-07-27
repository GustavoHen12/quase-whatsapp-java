package trabalho;

import trabalho.grupo.command.CriarGrupoCommand;
import trabalho.usuario.CriadorUsuario;
import trabalho.usuario.Usuario;

public class Whatsapp {
       Usuario usuario;
       CriarGrupoCommand criarGrupoCmd;

       public void cadastrar(String nome, String telefone) {
              CriadorUsuario criadorUsuario = new CriadorUsuario();
              usuario = criadorUsuario.criaUsuario(nome, telefone);

              criarGrupoCmd = new CriarGrupoCommand(usuario, null);
       }

       public void BtnNovoGrupo(String nomeGrupo){
              criarGrupoCmd.nomeGrupo = nomeGrupo;
              criarGrupoCmd.executar();
       }

       // public void BtnAdicionarParticipante(String nomeParticipante){
       //        criarGrupoCmd.nomeGrupo = nomeGrupo;
       //        criarGrupoCmd.executar();
       // }


        /**
         *  - Usuario usuario;
         *  - String estadoAtual;
         *  - Grupo grupoAtual;
         * 
         *  - private EnviarMensagemCommand enviarMensagemCmd;
         *  - private CancelarEnvioMensagemCommand cancelarEnvioCmd;
         * 
         *  + public NavMenu();
                usuario.grupos();

         *  + public NavGrupo("Nome grupo");
                usuario.grupo.getMensagens();

         *  + private constroiMenu();
         *  + private constroiConversaGrupo();
         *  
         *  + public BtnNovoGrupo("Nome grupo");
                grupo comand

         *  + public PBtnAdicionarParticipante("Nome Usuario");
         *  + public PBtnEnviarMensagem("mensagem");
                EnviarMensagemCommand.execute(mensagem, grupoAtual);
         *  + public PBtnEnviarMensagem(Arquivo);
         *  + public PBtnCancelarEnvioMensagem(); 
         */
}
