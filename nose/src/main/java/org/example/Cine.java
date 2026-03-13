package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cine {

    static Queue<Espectador> cola = new LinkedList<>();
    static Random aleatorio = new Random();
    static void main(String[] args) {

        generarCola();
        System.out.println(cola);
        System.out.println("Hay " + cola.size() + " a la cola.");
        double recaudacion = 0;
        while (!cola.isEmpty()){
            if (cola.poll().getEdad() >= 18){
                recaudacion+= 3.5;
            }else if (cola.poll().getEdad()>=11){
                recaudacion+=2.5;
            }else {
                recaudacion+=1;
            }
        }
        System.out.println("La recaudacion ha sido de: " + recaudacion + " €");
    }
    public static void generarCola(){
        int num_personas = aleatorio.nextInt(251);
        for (int i = 0; i < num_personas; i++) {
            cola.offer(new Espectador(aleatorio.nextInt(97)+3));

        }
    }
}
