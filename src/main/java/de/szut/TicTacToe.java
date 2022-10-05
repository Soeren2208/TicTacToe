package de.szut;

public class TicTacToe
{
    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
    }

    private void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("Try is outside board!");
        }
    }

}
