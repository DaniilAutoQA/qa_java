package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(Parameterized.class)
public class FelineTest {

    private final int food;
    private final int expected;

    public FelineTest(int food, int expected) {
        this.food = food;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {-2147483648, -2147483648},
                {3, 3},
                {2147483647, 2147483647},
        };
    }

    @Test
    public void shouldGetPredatorList() throws Exception {
        Feline feline = spy(new Feline());
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        verify(feline).getFood("Хищник");
        assertEquals(actual, expected);
    }

    @Test
    public void shouldGetFamily() {
        Feline feline = new Feline();
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void shouldGetKittensWithOutArgument() {
        Feline feline = new Feline();
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }

    @Test
    public void shouldGetKittensWithArgument() {
        Feline feline = new Feline();
        int actual = feline.getKittens(food);
        assertEquals(actual, expected);
    }
}