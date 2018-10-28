package com.game.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PlayerTest {

    private Player player;
    private Board board;

    public PlayerTest() {
        board = Mockito.mock(
                Board.class,
                Mockito.CALLS_REAL_METHODS);

        player = Mockito.mock(
                Player.class,
                Mockito.CALLS_REAL_METHODS);
    }

    @BeforeEach
    void setUp() {
        board.createBoard(5, 5, ".");
        player.setPlayerOrder(1)
                .setPlayerSign("n")
                .setPlayerType(Player.PlayerType.HUMAN);
    }

    @Test
    void setPlayerSign() {
        player.setPlayerSign("k");
        Assertions.assertEquals(player.playerSign, "k");
    }

    @Test
    void setPlayerOrder() {
        player.setPlayerOrder(3);
        Assertions.assertEquals(player.playerOrder, 3);
    }

    @Test
    void setPlayerType() {
        player.setPlayerType(Player.PlayerType.AI);
        Assertions.assertEquals(player.playerType, Player.PlayerType.AI);
    }
}