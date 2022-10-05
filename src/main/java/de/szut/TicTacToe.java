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
        if(isWin()){
            return lastPlayer + " is the winner";
        }
        return "No winner!";
    }

    private boolean isWin() {
        if(isHorizontalWin())
            return true;
        if(isVerticalWin())
            return true;
        if(isTopBottomDiagonalLineWin())
            return true;
        if(isBottomTopDiagonalLineWin())
            return true;
        return false;
    }

    private boolean isHorizontalWin(){
        for(int i =0; i < SIZE; i++){
            if(board[0][i] + board[1][i] + board[2][i] == lastPlayer * 3){
                return true;
            }
        }
        return false;
    }

    private boolean isVerticalWin(){
        for(int i =0; i < SIZE; i++){
            if(board[i][0] + board[i][1] + board[i][2] == lastPlayer * 3){
                return true;
            }
        }
        return false;
    }

    private boolean isTopBottomDiagonalLineWin(){
        if(board[0][0] + board[1][1] + board[2][2] == this.lastPlayer*3){
            return true;
        }
        return false;
    }

    private boolean isBottomTopDiagonalLineWin(){
        if(board[0][2] + board[1][1] + board[2][0] == this.lastPlayer*3){
            return true;
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
