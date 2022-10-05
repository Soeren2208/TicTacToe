package de.szut;

public class TicTacToe
{
    private Character[][] board = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setField(x, y);
    }

    private void setField(int x, int y) {
        if(isFieldOccupied(board[x - 1][y - 1])){
            throw new RuntimeException("Field is occupied!");
        }
        else{
            board[x -1][y -1] = 'X';
        }
    }

    private boolean isFieldOccupied(Character character) {
        return character != '0';
    }

    private void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("Try is outside board!");
        }
    }

    public char nextPlayer() {
        return 'X';
    }
}
