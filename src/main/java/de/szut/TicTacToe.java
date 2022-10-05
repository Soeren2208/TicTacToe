package de.szut;

public class TicTacToe
{
    private Character[][] board = {{'0', '0', '0'}, {'0', '0', '0'}, {'0', '0', '0'}};
    private char lastPlayer = 'O';
    private static final int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        this.lastPlayer = nextPlayer();
        setField(x, y, this.lastPlayer);
        for(int i =0; i < 3; i++){
            if(isWin()){
                return lastPlayer + " is the winner";
            }
        }
        return "No winner!";
    }

    private boolean isWin() {
        int playerTotal = lastPlayer * 3;
        for(int i =0; i < SIZE; i++){
            if(board[0][i] + board[1][i] + board[2][i] == playerTotal){
                return true;
            }
            else if(playerTotal == (board[i][0] + board[i][1] + board[i][2])){
                return true;
            }
        }
        return false;

    }


    private void setField(int x, int y, char lastPlayer) {
        if(isFieldOccupied(board[x - 1][y - 1])){
            throw new RuntimeException("Field is occupied!");
        }
        else{
            board[x -1][y -1] = lastPlayer;
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
        if(this.lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}
