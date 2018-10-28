package com.game.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BoardTest {

    private Board board;

    public BoardTest() {
        board = Mockito.mock(
                Board.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @BeforeEach
    public void setUp() {
        board.createBoard(5, 5, ".");
    }

    @Test
    public void createBoard() {
        String[][] test = new String[][]{{".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."}};
        for (int i = 0; i < test.length; i++) {
            Assertions.assertArrayEquals(board.getBoardTable()[i], test[i]);
        }
    }

    @Test
    public void getBoardTable() {
        String[][] test = new String[][]{{".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."}};
        for (int i = 0; i < test.length; i++) {
            Assertions.assertArrayEquals(board.getBoardTable()[i], test[i]);
        }
    }

    @Test
    public void setBoardCell() {
        String[][] test = new String[][]{{".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", "x", ".", ".", "."},
                {".", ".", ".", ".", "."},
                {".", ".", ".", ".", "."}};
        board.setBoardCell(2, 1, "x");
        for (int i = 0; i < test.length; i++) {
            Assertions.assertArrayEquals(board.getBoardTable()[i], test[i]);
        }
    }

    @Test
    public void getBoardInit() {
        Assertions.assertEquals(board.getBoardInit(), ".");
    }

    @Test
    public void printTable() {
    }

    @Test
    public void isBoardFull() {
        Assertions.assertFalse(board.isBoardFull());
        for (int i = 0; i < board.getBoardTable().length; i++) {
            for (int j = 0; j < board.getBoardTable().length; j++) {
                board.setBoardCell(i, j, "x");
            }
        }
        Assertions.assertTrue(board.isBoardFull());
    }
}