package br.com.registerpoc.registerapipoc.exceptions;

public class AccountAlreadyApprovedException extends RuntimeException{

    public AccountAlreadyApprovedException(String message) {
        super(message);
    }
}
