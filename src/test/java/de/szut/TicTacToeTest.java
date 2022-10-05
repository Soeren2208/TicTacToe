package de.szut;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest
{
    private TicTacToe tictactoe;

    @BeforeEach
    public void setUp(){
        tictactoe = new TicTacToe();
    }

    @ParameterizedTest(name="x={0}, y={1}")
    @CsvSource({"-1, -3", "4, 5", "-2, 3", "-2, 4", "0, 2", "4, 2", "1, 0", "2, -3", "2, 5"})
    public void givenXOutsideBoard_WhenPlay_ThrowRunTimeException(int x, int y) {
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> this.tictactoe.play(x, y), "RuntimeException should have been thrown!");
        assertEquals("Try is outside board!", exception.getMessage());
    }

    @Test
    public void givenFieldOccupied_WhenPlay_ThrowRuntimeException(){
        this.tictactoe.play(1,1);
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> this.tictactoe.play(1, 1), "RuntimeException should have been thrown!");
        assertEquals("Field is occupied!", exception.getMessage());
    }

    @Test
    public void testgivenFirstTurnWhenNextPlayerThenX(){
        assertEquals('X', tictactoe.nextPlayer(), "Falscher Spieler!");
    }

    @Test
    public void testGivenLastTurnWasXWhenNextPlayerThenO(){
        tictactoe.play(1, 1);
        assertEquals('O', tictactoe.nextPlayer(), "Falscher Spieler!");
    }



}
