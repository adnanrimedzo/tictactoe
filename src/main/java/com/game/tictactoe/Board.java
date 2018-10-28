package com.game.tictactoe;

import java.util.Arrays;

public abstract class Board {

    protected String[][] boardTable;
    private String boardInit = null;

    public Board createBoard(int dimX, int dimY, String init) {
        boardTable = new String[dimX][dimY];
        this.boardInit = init;
        for (int i = 0; i < boardTable.length; i++) {
            for (int j = 0; j < boardTable.length; j++) {
                boardTable[i][j] = init;
            }

        }
        return this;
    }

    public String[][] getBoardTable() {
        return boardTable;
    }

    public Board setBoardCell(int dimX, int dimY, String cellChar) {
        boardTable[dimX][dimY] = cellChar;
        return this;
    }

    public String getBoardInit() {
        return boardInit;
    }

    public Board printTable() {
        for (String[] line : boardTable) {
            for (String l : line) {
                System.out.print("|" + l);
            }
            System.out.print("|\n");
        }
        return this;
    }

    public boolean isBoardFull() {
        for (String[] line : boardTable) {
            if (Arrays.stream(line).anyMatch(c -> c.equals(boardInit))) {
                return false;
            }
        }
        return true;
    }
}
