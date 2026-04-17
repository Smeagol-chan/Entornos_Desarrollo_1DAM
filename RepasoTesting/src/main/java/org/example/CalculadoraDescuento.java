package org.example;

public class CalculadoraDescuento
{
    public double calcularPrecioFinal(double precioBase, int porcentajeDescuento, boolean clienteVip)
    {
        if(precioBase < 0)
        {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        if(porcentajeDescuento < 0 || porcentajeDescuento > 50)
        {
            throw new IllegalArgumentException("Descuento inválido");
        }

        double precioFinal = precioBase - (precioBase * porcentajeDescuento / 100.0);

        if(clienteVip)
        {
            precioFinal = precioFinal - 5;
        }

        if(precioFinal < 0)
        {
            precioFinal = 0;
        }

        return precioFinal;
    }
}
