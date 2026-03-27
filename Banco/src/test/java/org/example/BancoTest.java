package org.example;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.Assert.assertEquals;

public class BancoTest {

    @BeforeEach
    public void inicializarCuenta()
    {
        Banco.cuentasBancarias.put("Eric", 1.50);
    }

    @ParameterizedTest
    @CsvSource({
            "Eric, Existe la cuenta",
            "OwO, No existe la cuenta"
    })
    public void depositar(String cuenta, String resultadoEsperado)
    {
        String resultado;
        try
        {
            Banco.depositar(cuenta, 5);
            resultado = "Existe la cuenta";
        }
        catch(CuentaNoExisteException e)
        {
            resultado = "No existe la cuenta";
        }

        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Eric, 1, Retirada exitosa",
            "OwO, 1, No existe la cuenta",
            "Eric, 100, Fondos insuficientes"
    })
    public void retirar(String cuenta, double monto, String resultadoEsperado)
    {
        String resultado;
        try
        {
            Banco.retirar(cuenta, monto);
            resultado = "Retirada exitosa";
        }
        catch(CuentaNoExisteException e)
        {
            resultado = "No existe la cuenta";
        }
        catch(SaldoInsuficienteException e)
        {
            resultado = "Fondos insuficientes";
        }

        assertEquals(resultadoEsperado, resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "Eric, 1.5",
            "OwO, No existe la cuenta"
    })
    public void consultarSaldo(String cuenta, String resultadoEsperado)
    {
        String resultado;
        try
        {
            Banco.consultarSaldo(cuenta);
            resultado = String.valueOf(Banco.cuentasBancarias.get(cuenta));
        }
        catch(CuentaNoExisteException e)
        {
            resultado = "No existe la cuenta";
        }

        assertEquals(resultadoEsperado, resultado);
    }
}