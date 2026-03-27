package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Banco
{
    public static HashMap<String, Double> cuentasBancarias = new HashMap<>();

    public static void depositar(String cuenta, double monto)
    {
        if(!cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else cuentasBancarias.put(cuenta, cuentasBancarias.get(cuenta)+monto);
    }

    public static void retirar(String cuenta, double monto)
    {
        if(!cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else if(cuentasBancarias.get(cuenta) < monto) throw new SaldoInsuficienteException();
        else cuentasBancarias.put(cuenta, cuentasBancarias.get(cuenta)-monto);
    }

    public static void consultarSaldo(String cuenta)
    {
        if(!cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else System.out.println("Saldo: "+ cuentasBancarias.get(cuenta) +" €");
    }

    public static List<Integer> haye = new ArrayList<>();

    public static List<Integer> getHaye()
    {
        return Collections.unmodifiableList(haye);
    }

    static void main() {
        List<Integer> aukhwd = getHaye();
        aukhwd.add(3);
    }
}
