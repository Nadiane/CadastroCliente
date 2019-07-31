package br.com.compasso.web.cadastroclientes.error;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecursoNaoEncontrado extends RuntimeException {

    public RecursoNaoEncontrado(String mensagem){
        super(mensagem);
    }
}
