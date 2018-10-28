package com.game.tictactoe;

import java.util.ArrayList;

public abstract class Game {
    protected Board board;
    protected ArrayList<Player> playerList;

    public Game setBoard(Board board) {
        this.board = board;
        return this;
    }

    public Game setPlayerList(ArrayList playerList) {
        this.playerList = playerList;
        return this;
    }

    public abstract Game startGame();

    public abstract boolean isWinnerExist();

    public abstract boolean isGamefinished();
}
