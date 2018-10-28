package com.game.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TicTacToeTest {

    private TicTacToePlayer ticTacToePlayer = new TicTacToePlayer();
    private TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();
    private TicTacToe ticTacToe = new TicTacToe();

    @BeforeEach
    void setUp() {
        ticTacToeBoard.createBoard(5, 5, ".");
        ticTacToePlayer.setPlayerOrder(1)
                .setPlayerSign("n")
                .setPlayerType(Player.PlayerType.HUMAN);
        ticTacToe.setBoard(ticTacToeBoard)
                .setPlayerList(new ArrayList() {{
                    add(ticTacToePlayer);
                }});

    }

    @Test
    void isWinnerExist_verticalCheck() {
        for (int i = 0; i < ticTacToeBoard.getBoardTable().length; i++) {
            for (int j = 0; j < 1; j++) {
                ticTacToeBoard.setBoardCell(i, j, "x");
            }
        }
        Assertions.assertTrue(ticTacToe.isWinnerExist());
    }

    @Test
    void isWinnerExist_horisontalCheck() {
        for (int i = 0; i < ticTacToeBoard.getBoardTable().length; i++) {
            for (int j = 0; j < 1; j++) {
                ticTacToeBoard.setBoardCell(j, i, "x");
            }
        }
        Assertions.assertTrue(ticTacToe.isWinnerExist());
    }

    @Test
    void isWinnerExist_diagonalCheck() {
        for (int i = 0; i < ticTacToeBoard.getBoardTable().length; i++) {
            ticTacToeBoard.setBoardCell(i, i, "x");
        }
        Assertions.assertTrue(ticTacToe.isWinnerExist());
    }

    @Test
    void isGamefinished() {
        for (int i = 0; i < ticTacToeBoard.getBoardTable().length; i++) {
            for (int j = 0; j < ticTacToeBoard.getBoardTable().length; j++) {
                ticTacToeBoard.setBoardCell(j, i, "x");
            }
        }
        Assertions.assertTrue(ticTacToe.isGamefinished());
    }
}