package org.example;

public class BancoService implements RepositorioBanco
{
    @Override
    public double obtenerSaldo(String cuenta)
    {
        if(!Banco.cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else return Banco.cuentasBancarias.get(cuenta);
    }

    @Override
    public void actualizarSaldo(String cuenta, double nuevoSaldo)
    {
        if(!Banco.cuentasBancarias.containsKey(cuenta)) throw new CuentaNoExisteException();
        else Banco.cuentasBancarias.put(cuenta, nuevoSaldo);
    }
}
