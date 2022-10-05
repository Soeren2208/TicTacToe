package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest
{
    private TicTacToe tictactoe;

    @BeforeEach
    public void setUp(){
        tictactoe = new TicTacToe();
    }

    @Test
    public void givenXOutsideBoard_WhenPlay_ThrowRunTimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> this.tictactoe.play(5, 2), "RuntimeException should have been thrown!");
        assertEquals("Try is outside board!", exception.getMessage());
    }

    @Test
    public void givenYOutsideBoard_WhenPlay_ThrowRunTimeException() {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> this.tictactoe.play(2, 5), "RuntimeException should have been thrown!");
        assertEquals("Try is outside board!", exception.getMessage());
    }

}
