package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class AppTest {

    @Test
    void  suma(){
        Assertions.assertEquals(5, Calculadora.suma(3, 2));

    }
    @Test
    void resta(){
        Assertions.assertEquals(1, Calculadora.resta(3, 2));
    }

    @Test
    void multiplicacion(){
        Assertions.assertEquals(6, Calculadora.multiplicacion(3, 2));

    }

    @Test
    void division(){
        Assertions.assertEquals(5, Calculadora.division(10, 2));

    }



}
