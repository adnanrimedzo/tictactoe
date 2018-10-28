package com.game.tictactoe;

public class Move {
    int dimX;
    int dimY;
    String cellChar;

    public Move(int dimX, int dimY, String cellChar) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.cellChar = cellChar;
    }

}
