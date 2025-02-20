package com.cardoso.publication.exception;

public class FallbackException extends RuntimeException {

    public FallbackException(Throwable cause) {
        super("Estamos com indisponibilidade no momento, por favor tente novamente mais tarde.", cause);
    }
}
