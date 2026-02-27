package org.example.mutxastore_manager.excepciones;

public class JuegoDuplicadoException extends RuntimeException {
    public JuegoDuplicadoException() {
        super("El juego ya está presente en la lista");
    }
}
