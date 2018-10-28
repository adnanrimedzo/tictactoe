package com.game.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToePlayer extends Player {
    @Override
    public Move getMoveFromAI(Board board) {
        Random rand = new Random();
        int x = rand.nextInt(board.getBoardTable().length);
        int y = rand.nextInt(board.getBoardTable().length);
        Move move = new Move(x, y, playerSign);
        if (checkMove(move, board)) {
            return move;
        } else {
            return getMoveFromAI(board);
        }
    }

    @Override
    public Move getMoveFromHuman(Board board) {
        board.printTable();
        System.out.println(String.format("Player %d enter your move like as '3,2'", playerOrder));
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] xy = line.split(",");

        if (xy != null && xy.length == 2) {
            try {
                Move move = new Move(Integer.parseInt(xy[0])
                        , Integer.parseInt(xy[1])
                        , this.playerSign);
                if (checkMove(move, board)) {
                    return move;
                } else {
                    System.out.println(String.format("Player %d invalid input", playerOrder));
                    return getMoveFromHuman(board);
                }
            } catch (Exception e) {
                System.out.println(String.format("Player %d invalid input", playerOrder));
                return getMoveFromHuman(board);
            }
        } else {
            System.out.println(String.format("Player %d invalid input", playerOrder));
            return getMoveFromHuman(board);
        }
    }

    private boolean checkMove(Move move, Board board) {
        int boardDim = board.getBoardTable().length;
        if (move.dimX > 0 && move.dimX <= boardDim)
            if (move.dimY > 0 && move.dimY <= boardDim)
                if (board.getBoardTable()[move.dimX - 1][move.dimY - 1].equals(board.getBoardInit())) {
                    return true;
                }

        return false;
    }
}
