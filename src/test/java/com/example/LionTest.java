package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void shouldGetKittensCount() throws Exception {
        Lion leon = new Lion(feline, "Самец");
        int expected = 1;
        when(feline.getKittens()).thenReturn(1);
        assertEquals(expected, leon.getKittens());
    }


    @Test(expected = Exception.class)
    public void shouldHaveManeException() throws Exception {
        Lion leon = new Lion(feline, "Саsdfмка");
        leon.doesHaveMane();
    }

    @Test
    public void shouldGetPredatorList() throws Exception {
        Lion leon = new Lion(feline, "Самец");
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(leon.getFood(), expected);
    }
}