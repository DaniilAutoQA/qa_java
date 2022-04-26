package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionWithParameterizedTest {

    private final String sex;
    private final boolean expected;

    public LionWithParameterizedTest(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void verifyDoesHaveManeWithParameterized() throws Exception {
        Feline feline = new Feline();
        Lion leon = new Lion(feline, sex);
        leon.doesHaveMane();
        assertEquals(leon.doesHaveMane(), expected);
    }
}