package org.example;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest
{
    @ParameterizedTest
    @CsvSource({
            "10, 5, 15",
            "5, 10, 15",
            "5, 5, 10",
            "10, -5, 5",
            "-10, 5, -5",
            "-5, -10, -15",
            "-10, -5, -15",
            "-5, -5, -10",
            "5, 0, 5",
            "-5, 0, -5",
            "0, 5, 5",
            "0, -5, -5",
            "0, 0, 0"
    })
    void suma(int num1, int num2, int resultado)
    {
        Calculadora calculadora = new Calculadora(num1, num2);

        assertEquals(resultado, calculadora.suma());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 5",
            "5, 10, -5",
            "5, 5, 0",
            "10, -5, 15",
            "-10, 5, -15",
            "-5, -10, 5",
            "-10, -5, -5",
            "-5, -5, 0",
            "5, 0, 5",
            "-5, 0, -5",
            "0, 5, -5",
            "0, -5, 5",
            "0, 0, 0"
    })
    void resta(int num1, int num2, int resultado)
    {
        Calculadora calculadora = new Calculadora(num1, num2);

        assertEquals(resultado, calculadora.resta());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 50",
            "5, 10, 50",
            "5, 5, 25",
            "10, -5, -50",
            "-10, 5, -50",
            "-5, -10, 50",
            "-10, -5, 50",
            "-5, -5, 25",
            "5, 0, 0",
            "-5, 0, 0",
            "0, 5, 0",
            "0, -5, 0",
            "0, 0, 0"
    })
    void multiplica(int num1, int num2, int resultado)
    {
        Calculadora calculadora = new Calculadora(num1, num2);

        assertEquals(resultado, calculadora.multiplica());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 5, 2",
            "5, 10, 0.5",
            "5, 5, 1",
            "10, -5, -2",
            "-10, 5, -2",
            "-5, -10, 0.5",
            "-10, -5, 2",
            "-5, -5, 1",
            "5, 0, -12",
            "-5, 0, -12",
            "0, 5, 0",
            "0, -5, 0",
            "0, 0, -12"
    })
    void divide(int num1, int num2, double resultado)
    {
        Calculadora calculadora = new Calculadora(num1, num2);

        assertEquals(resultado, calculadora.divide());
    }
}