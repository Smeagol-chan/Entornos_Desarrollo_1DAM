package org.example;
import java.util.HashMap;

public class BancoService implements RepositorioBanco
{
    private static HashMap<String, Double> cuentasBancarias = new HashMap<>();

    @Override
    public double obtenerSaldo(String cuenta)
    {
        if(!cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else return cuentasBancarias.get(cuenta);
    }

    @Override
    public void actualizarSaldo(String cuenta, double nuevoSaldo)
    {
        if(!cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else cuentasBancarias.put(cuenta, nuevoSaldo);
    }
}