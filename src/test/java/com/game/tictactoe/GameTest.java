package com.game.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

class GameTest {

    private Game game;
    private Player player;
    private Board board;

    public GameTest() {
        board = Mockito.mock(
                Board.class,
                Mockito.CALLS_REAL_METHODS);

        player = Mockito.mock(
                Player.class,
                Mockito.CALLS_REAL_METHODS);

        game = Mockito.mock(
                Game.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @BeforeEach
    void setUp() {
        board.createBoard(5, 5, ".");
        player.setPlayerOrder(1)
                .setPlayerSign("n")
                .setPlayerType(Player.PlayerType.HUMAN);
        game.setBoard(board);
        game.setPlayerList(new ArrayList() {{
            add(player);
        }});
    }

    @Test
    void setBoard() {
        game.setBoard(board);
        Assertions.assertEquals(game.board, board);
    }

    @Test
    void setPlayerList() {
        game.setPlayerList(new ArrayList() {{
            add(player);
        }});
        Assertions.assertEquals(game.playerList.get(0), player);
    }
}