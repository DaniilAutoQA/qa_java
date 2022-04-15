package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


@RunWith(Parameterized.class)
public class LionTest {

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    Feline feline = mock(Feline.class);
    private final String sex;
    private final boolean expected;

    public LionTest(String sex, boolean expected) {
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

    @Test
    public void shouldGetKittensCount() throws Exception {
        Lion leon = new Lion(feline, "Самец");
        leon.getKittens();
        verify(feline).getKittens();
    }


    @Test(expected = Exception.class)
    public void shouldHaveManeException() throws Exception {
        Lion leon = new Lion(feline, "Саsdfмка");
        leon.doesHaveMane();
    }

    @Test
    public void shouldGetPredatorList() throws Exception {
        Lion leon = new Lion(feline, "Самец");
        leon.getFood();
        verify(feline).eatMeat();
    }
}