package com.codurance.kata.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FooTest {
    @Test
    public void shouldReturnTrue() {
        Foo sut = new Foo();

        assertTrue(sut.execute());
    }
}
