package org.example;


public class PresidenteApp {
    static void main(String[] args) {
        Presidente trump = new Presidente("Donald trump", "EEUU");
        System.out.println(trump.hashCode());
        Presidente milei = new Presidente("Donald trump", "EEUU");
        System.out.println(milei.hashCode());

        if (trump.equals(milei)){
            System.out.println("Son iguales");
        }
    }
}
