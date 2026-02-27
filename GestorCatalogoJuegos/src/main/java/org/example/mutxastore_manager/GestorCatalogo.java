package org.example.mutxastore_manager;

import org.example.FuncionesComunes;
import org.example.mutxastore_manager.enums.Plataformas;
import org.example.mutxastore_manager.excepciones.IllegalAnnoLanzamientoException;
import org.example.mutxastore_manager.excepciones.JuegoDuplicadoException;
import org.example.mutxastore_manager.objetos.Videojuego;

import java.util.ArrayList;

public class GestorCatalogo
{

    public static ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();

    private static void mostrarSelectorPlataforma()
    {
        System.out.println("\n=== Modificar Videojuego ===\n");
        System.out.println("¿Qué juego quieres modificar?\n");
        System.out.println("\t- PC");
        System.out.println("\t- PS");
        System.out.println("\t- XBOX");
        System.out.println("\t- SWITCH");
        System.out.println("\n=======================\n");
        System.out.print("> ");
    }

    private static void mostarJuegosPorPlataforma(Plataformas plataforma)
    {
        System.out.println("\n=== Juegos en "+ plataforma +" ===\n");

        for(Videojuego videojuego : listaVideojuegos)
            if(videojuego.getPlataforma() == plataforma)
                System.out.println("\t["+ videojuego +"]");
    }

    private static void mostrarListaCompletaJuegos()
    {
        int contador = 1;
        for(Videojuego videojuego : listaVideojuegos)
            System.out.println("\t"+ contador++ +"--> ["+ videojuego +"]");
    }

    private static void mostrarJuegosParaEliminar()
    {
        System.out.println("\n=== Eliminar Videojuego ===\n");
        System.out.println("¿Qué juego quieres eliminar?\n");

        mostrarListaCompletaJuegos();

        System.out.println("\n=======================\n");
        System.out.print("> ");
    }

    private static void eliminarJuego(int posicionJuego)
    {
        listaVideojuegos.remove(listaVideojuegos.get(posicionJuego));
    }

    private static void mostrarJuegosParaModficar()
    {
        System.out.println("\n=== Modificar Videojuego ===\n");
        System.out.println("¿Qué juego quieres modificar?\n");

        mostrarListaCompletaJuegos();

        System.out.println("\n=======================\n");
        System.out.print("> ");
    }

    private static void mostrarAtributosJuego()
    {
        System.out.println("\n=== Modificar Videojuego. Selección de Atributo ===\n");
        System.out.println("¿Qué atributo quieres modificar?\n");
        System.out.println("\t- Nombre");
        System.out.println("\t- Plataforma");
        System.out.println("\t- Género");
        System.out.println("\t- Lanzamiento");
        System.out.println("\t- Precio");
        System.out.println("\t- Stock");
        System.out.println("\n=======================\n");
        System.out.print("> ");
    }

    private static void modificarJuego(int posicionJuego, String atributo)
    {
        Videojuego juegoModificado = listaVideojuegos.get(posicionJuego);

        switch(atributo)
        {
            case "nombre":
                System.out.print("Nuevo nombre: ");
                String nombre = FuncionesComunes.solicitarString();
                juegoModificado.setTitulo(nombre);
                juegoModificado.coincidenciaEnCatalogo(listaVideojuegos);
                listaVideojuegos.get(posicionJuego).setTitulo(nombre);
                break;

            case "plataforma":
                System.out.print("Nueva plataforma: ");
                Plataformas plataforma = Plataformas.valueOf(FuncionesComunes.solicitarString());
                juegoModificado.setPlataforma(plataforma);
                juegoModificado.coincidenciaEnCatalogo(listaVideojuegos);
                listaVideojuegos.get(posicionJuego).setPlataforma(plataforma);
                break;

            case "genero":
            case "género":
                System.out.print("Nuevo género: ");
                String genero = FuncionesComunes.solicitarString();
                juegoModificado.setGenero(genero);
                juegoModificado.coincidenciaEnCatalogo(listaVideojuegos);
                listaVideojuegos.get(posicionJuego).setGenero(genero);
                break;

            case "lanzamiento":
                System.out.print("Nuevo año de lanzamiento: ");
                int annoLanzamiento = (int) FuncionesComunes.solicitudPositivosNumero();
                juegoModificado.setAnnoLanzamiento(annoLanzamiento);
                juegoModificado.coincidenciaEnCatalogo(listaVideojuegos);
                listaVideojuegos.get(posicionJuego).setAnnoLanzamiento(annoLanzamiento);
                break;

            case "precio":
                System.out.print("Nuevo precio: ");
                double precio = FuncionesComunes.solicitudPositivosNumero();
                juegoModificado.setPrecio(precio);
                juegoModificado.coincidenciaEnCatalogo(listaVideojuegos);
                listaVideojuegos.get(posicionJuego).setPrecio(precio);
                break;

            case "stock":
                System.out.print("Nuevo stock: ");
                int stock = (int) FuncionesComunes.solicitudPositivosNumero();
                listaVideojuegos.get(posicionJuego).setStock(stock);
                break;

            default:
                System.out.println("Atributo inválido.");
                break;
        }
    }

    private static Videojuego annadirVideojuego()
    {
        System.out.println("\n=== Añadir Videojuego ===\n");
        System.out.print("Nombre: ");
        String titulo = FuncionesComunes.solicitarString();

        System.out.print("Plataforma: ");
        Plataformas plataforma = Plataformas.valueOf(FuncionesComunes.solicitarString());

        System.out.print("Género: ");
        String genero = FuncionesComunes.solicitarString();

        System.out.print("Año de lanzamiento: ");
        int annoLanzamiento = (int) FuncionesComunes.solicitudPositivosNumero();
        FuncionesComunes.key.nextLine();

        System.out.print("Precio: ");
        double precio = FuncionesComunes.solicitudPositivosNumero();
        FuncionesComunes.key.nextLine();

        System.out.print("Stock: ");
        int stock = (int) FuncionesComunes.solicitudPositivosNumero();
        FuncionesComunes.key.nextLine();

        Videojuego videojuego = new Videojuego(titulo, plataforma, genero, annoLanzamiento, precio, stock);
        videojuego.coincidenciaEnCatalogo(listaVideojuegos);

        return videojuego;
    }

    private static void mostrarMenuPrincipal()
    {
        System.out.println("\n=== Menú Principal ===\n");
        System.out.println("\t[1]. Añadir nuevo videojuego");
        System.out.println("\t[2]. Modificar información existente");
        System.out.println("\t[3]. Eliminar videojuego");
        System.out.println("\t[4]. Consultar videojuegos por plataforma");
        System.out.println("\t[X]. Salir");
        System.out.println("\n=======================\n");
        System.out.print("> ");
    }

    public static void menuPrincipal()
    {
        boolean vuelta = true;
        do
        {
            mostrarMenuPrincipal();
            switch(FuncionesComunes.solicitudChar())
            {
                case '1':
                    try
                    {
                        listaVideojuegos.add(annadirVideojuego());
                    }
                    catch(JuegoDuplicadoException e)
                    {
                        System.out.println("El juego ya está presente en la lista.");
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println("La plataforma no es válida.");
                    }
                    catch(IllegalAnnoLanzamientoException e)
                    {
                        System.out.println("El año de lanzamiento no es válido.");
                    }
                    break;

                case '2':
                    try
                    {
                        if(listaVideojuegos.isEmpty()) System.out.println("La lista está vacía.");
                        else
                        {
                            mostrarJuegosParaModficar();
                            int posicionJuego = (int) FuncionesComunes.solicitudNumero();
                            mostrarAtributosJuego();
                            String atributo = FuncionesComunes.solicitarString().toLowerCase();
                            modificarJuego(posicionJuego-1, atributo);
                        }
                    }
                    catch(JuegoDuplicadoException e)
                    {
                        System.out.println("El juego ya está presente en la lista.");
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println("La plataforma no es válida.");
                    }
                    catch(IllegalAnnoLanzamientoException e)
                    {
                        System.out.println("El año de lanzamiento no es válido.");
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case '3':
                    try
                    {
                        if(listaVideojuegos.isEmpty()) System.out.println("La lista está vacía.");
                        else
                        {
                            mostrarJuegosParaEliminar();
                            eliminarJuego((int) FuncionesComunes.solicitudPositivosNumero() - 1);
                        }
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case '4':
                    try
                    {
                        mostrarSelectorPlataforma();
                        mostarJuegosPorPlataforma(Plataformas.valueOf(FuncionesComunes.solicitarString().toUpperCase()));
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println("La plataforma no es válida.");
                    }
                    break;

                case 'X':
                case'x':
                    System.out.println("\n=== FINALIZANDO EJECICIÓN ===");
                    break;
            }
        }while(vuelta);
    }
}
