package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void setUp(){
        agenda = new Agenda();
    }

    private Evento eventoFalso(boolean valido){
        Evento evento = mock(Evento.class);
        when(evento.valido()).thenReturn(valido);
        return evento;
    }

    @Test
    void constroi(){
        assertTrue(agenda.getEventos().isEmpty());
    }

    @Test
    void adicionaValido(){
        Evento eventoValido = eventoFalso(true);
        agenda.adiciona(eventoValido);
        assertEquals(1,agenda.getEventos().size());
    }

    @Test
    void adicionaInvalido(){
        Evento eventoInvalido = eventoFalso(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> agenda.adiciona(eventoInvalido));
        assertEquals("Evento inválido!", exception.getMessage());
    }


}
