package org.example.mutxastore_manager.objetos;
import lombok.Getter;
import lombok.Setter;
import org.example.mutxastore_manager.enums.Plataformas;
import org.example.mutxastore_manager.excepciones.IllegalAnnoLanzamientoException;
import org.example.mutxastore_manager.excepciones.JuegoDuplicadoException;

import java.util.ArrayList;

@Getter
public class Videojuego
{
    private String titulo;
    private Plataformas plataforma;
    private String genero;
    private int annoLanzamiento;
    private double precio;
    private int stock;

    public Videojuego(String titulo, Plataformas plataforma, String genero, int annoLanzamiento, double precio, int stock)
    {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        setAnnoLanzamiento(annoLanzamiento);
        this.precio = precio;
        this.stock = stock;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setPlataforma(Plataformas plataforma) {
        this.plataforma = plataforma;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setAnnoLanzamiento(int annoLanzamiento) {
        if(annoLanzamiento < 1960 || annoLanzamiento > 2026)
            throw new IllegalAnnoLanzamientoException();
        this.annoLanzamiento = annoLanzamiento;
    }

    public void coincidenciaEnCatalogo(ArrayList<Videojuego> listaVideojuegos)
    {
        for(Videojuego videojuego : listaVideojuegos)
        {
            if(titulo.equals(videojuego.getTitulo()) &&
                    plataforma == videojuego.getPlataforma() &&
                    genero.equals(videojuego.getGenero()) &&
                    annoLanzamiento == videojuego.getAnnoLanzamiento() &&
                    precio == videojuego.getPrecio())
                throw new JuegoDuplicadoException();
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo +
                ", Plataforma: " + plataforma +
                ", Genero: " + genero +
                ", Año de lanzamiento: " + annoLanzamiento +
                ", Precio: " + precio +
                ", Stock: " + stock;
    }
}