package org.example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BancoServiceTest {

    @Mock
    private RepositorioBanco repositorio;

    @InjectMocks
    private BancoService bancoService;

    @InjectMocks
    @Spy
    private BancoService spyBancoService;

    @Test
    public void obtenerSaldo()
    {
        double resultado;
        when(repositorio.obtenerSaldo("Eric")).thenReturn(1.50);

        resultado = bancoService.obtenerSaldo("Eric");

        assertEquals(1.50, resultado);
    }

    @Test
    public void actualizarSaldo()
    {

    }
}