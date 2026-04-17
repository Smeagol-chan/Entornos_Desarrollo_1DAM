package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraDescuentoTest
{
    CalculadoraDescuento obj;

    @BeforeEach
    void inicializarObjeto()
    {
        obj = new CalculadoraDescuento();
    }

    @AfterEach
    void eliminarObjeto()
    {
        obj = null;
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, false, 8",
            "10, 20, true, 3",
            "0, 0, true, 0"
    })
    void calcularPrecioFinalValido(double precioBase, int descuento, boolean vip, double resultadoEsperado)
    {
        assertEquals(resultadoEsperado, obj.calcularPrecioFinal(precioBase, descuento, vip));
    }

    @ParameterizedTest
    @CsvSource({
            "-2, 20, false, El precio no puede ser negativo",
            "10, -2, false, Descuento inválido",
            "10, 80, false, Descuento inválido"
    })
    void calcularPrecioFinalInvalido(double precioBase, int descuento, boolean vip, String resultadoEsperado)
    {
        Exception resultadoReal = assertThrows(RuntimeException.class, () -> obj.calcularPrecioFinal(precioBase, descuento, vip));
    }
}