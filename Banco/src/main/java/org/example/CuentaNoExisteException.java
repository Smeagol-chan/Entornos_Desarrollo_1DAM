package org.example;

public class CuentaNoExisteException extends RuntimeException {
    public CuentaNoExisteException() {
        super("La cuenta no existe.");
    }
}
