package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {

    private Data data;

    @BeforeEach
    void setUp(){
        data = new Data ();
    }

    @Test
    void constroi(){

        assertEquals(1970,data.getAno());
        assertEquals(1,data.getMes());
        assertEquals(1,data.getDia());
    }

    @Test
    void naoAtualizaMenor(){

        data.atualiza(1969,0,0);
        assertEquals(1970,data.getAno());
        assertEquals(1,data.getMes());
        assertEquals(1,data.getDia());

    }

    @Test
    void atualziaMaior(){

        data.atualiza(2024,13,32);
        assertEquals(2024,data.getAno());
        assertEquals(12,data.getMes());
        assertEquals(31,data.getDia());

    }

    @Test
    void atualzia(){

        data.atualiza(2024,9,26);
        assertEquals(2024,data.getAno());
        assertEquals(9,data.getMes());
        assertEquals(26,data.getDia());

    }

    @Test
    void comoZero(){

        assertEquals(0,data.comoInteiro());
    }

    @Test
    void comoAgora(){
        data.atualiza(2024,9,26);
        assertEquals(19978, data.comoInteiro());
    }
}
