package com.game.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToePlayerTest {

    private TicTacToePlayer ticTacToePlayer = new TicTacToePlayer();
    private TicTacToeBoard ticTacToeBoard = new TicTacToeBoard();

    @BeforeEach
    void setUp() {
        ticTacToeBoard.createBoard(5, 5, ".");
        ticTacToePlayer.setPlayerOrder(1)
                .setPlayerSign("n")
                .setPlayerType(Player.PlayerType.HUMAN);

    }

    @Test
    void getMoveFromAI() {
        for (int i = 0; i < ticTacToeBoard.getBoardTable().length; i++) {
            for (int j = 0; j < ticTacToeBoard.getBoardTable().length; j++) {
                if (i == 2 && j == 3) {
                } else {
                    ticTacToeBoard.setBoardCell(i, j, "x");
                }
            }
        }
        Move move = ticTacToePlayer.getMoveFromAI(ticTacToeBoard);
        Move test = new Move(3, 4, ticTacToePlayer.playerSign);
        Assertions.assertEquals(move.dimX, test.dimX);
        Assertions.assertEquals(move.dimY, test.dimY);
    }

    @Test
    void getMoveFromHuman() {
    }
}