package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalWithParameterizedTest {

    private final String food;
    private final List<String> expected;

    public AnimalWithParameterizedTest(String food, List<String> expected) {
        this.food = food;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void verifyGetFoodWithParameterized() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(food);
        assertEquals(actual, expected);
    }

}