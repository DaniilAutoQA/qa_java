package com.example;

import org.junit.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LeonAlexTest {

    @Mock
    Feline feline;

    @Test
    public void shouldBeGetFriendsList() throws Exception {
        LeonAlex leonAlex = new LeonAlex(feline);
        assertEquals(List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"), leonAlex.getFriends());
    }

    @Test
    public void shouldBeGetPlaceOfLiving() throws Exception {
        LeonAlex leonAlex = new LeonAlex(feline);
        assertEquals("Нью-Йоркский зоопарк", leonAlex.getPlaceOfLiving());
    }

    @Test
    public void shouldBeGetKittensZero() throws Exception {
        Feline feline = new Feline();
        LeonAlex leonAlex = new LeonAlex(feline);
        assertEquals(0, leonAlex.getKittens());
    }
}