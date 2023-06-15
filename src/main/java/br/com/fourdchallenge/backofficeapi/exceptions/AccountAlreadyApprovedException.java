package br.com.fourdchallenge.backofficeapi.exceptions;

public class AccountAlreadyApprovedException extends RuntimeException{

    public AccountAlreadyApprovedException(String message) {
        super(message);
    }
}
