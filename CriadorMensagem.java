interface ICriadorMensagem{
    public Mensagem createMensagem(Usuario emissor);
}


class CriadorMensagemTexto implements ICriadorMensagem{
    public Mensagem createMensagem(Usuario emissor){
        return new MensagemTexto(emissor);
    }
}

class CriadorMensagemArquivo implements ICriadorMensagem{
    public Mensagem createMensagem(Usuario emissor){
        return new MensagemArquivo(emissor);
    }
}
