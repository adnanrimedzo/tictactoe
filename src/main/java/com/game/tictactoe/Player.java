package com.game.tictactoe;

public abstract class Player {

    protected String playerSign;
    protected int playerOrder;
    protected PlayerType playerType;

    public enum PlayerType {
        HUMAN,
        AI
    }

    public Player setPlayerSign(String sign) {
        this.playerSign = sign;
        return this;
    }

    public Player setPlayerOrder(int order) {
        this.playerOrder = order;
        return this;
    }

    public Player setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
        return this;
    }

    public Move getMove(Board board) {
        switch (playerType) {
            case HUMAN:
                return getMoveFromHuman(board);
            default:
                return getMoveFromAI(board);
        }
    }

    public abstract Move getMoveFromAI(Board board);

    public abstract Move getMoveFromHuman(Board board);

}
