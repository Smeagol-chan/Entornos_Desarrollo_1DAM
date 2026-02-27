package org.example.mutxastore_manager.objetos;
import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Cliente
{
    private static int totalClientes = 0;

    private int id;
    private String nombre;
    private String apelllidos;
    private String email;
    private LocalDate fecha_registro;

    public Cliente(String nombre, String apelllidos, String email)
    {
        this.nombre = nombre;
        this.apelllidos = apelllidos;
        this.email = email;
        setFecha_registro();
        setId();
    }

    private void setId() {
        id = ++totalClientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApelllidos(String apelllidos) {
        this.apelllidos = apelllidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setFecha_registro() {
        fecha_registro = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Id: " + id +
                ", Nombre: " + nombre +
                ", Apelllidos: " + apelllidos +
                ", Email: " + email +
                ", Fecha de registro: " + fecha_registro;
    }
}
