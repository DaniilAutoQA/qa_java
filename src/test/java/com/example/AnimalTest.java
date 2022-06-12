package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;


public class AnimalTest {


    @Test
    public void shouldExceptionFromGetFood() {
        Animal animal = new Animal();
        try {
            animal.getFood("sdfsdf");
            Assert.fail("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        } catch (Exception thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void getFamily() {
       Animal animal = new Animal();
       assertEquals(("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи"), animal.getFamily());
    }
}