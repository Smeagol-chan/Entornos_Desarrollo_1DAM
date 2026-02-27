package org.example.mutxastore_manager.excepciones;

public class IllegalAnnoLanzamientoException extends RuntimeException {
    public IllegalAnnoLanzamientoException() {
        super("El año de lanzamiento no es válido.");
    }
}
