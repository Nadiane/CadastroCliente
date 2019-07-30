package br.com.compasso.web.cadastroclientes.error;

public class CustomizacaoTipoErro {

    private String mensaemErro;

    public CustomizacaoTipoErro(String mensaemErro) {
        this.mensaemErro = mensaemErro;
    }

    public String getMensaemErro() {
        return mensaemErro;
    }
}
