package com.game.tictactoe;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class TicTacToe extends Game {

    public TicTacToe() {
        Properties prop = new Properties();

        try(InputStream input = new FileInputStream("tictactoe.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }

        int boardDim = Integer.parseInt(prop.getProperty("board"));
        int boardDimMax = Integer.parseInt(prop.getProperty("boardMax"));
        int boardDimMin = Integer.parseInt(prop.getProperty("boardMin"));

        if(boardDim < boardDimMin || boardDim>boardDimMax){
            System.out.println("Invalid board size!!");
            throw new RuntimeException("Invalid board size!!");
        }

        String boardInit = prop.getProperty("boardinit");

        String playerAI = prop.getProperty("playerai");
        String player1 = prop.getProperty("player1");
        String player2 = prop.getProperty("player2");

        if(playerAI.length()>1 || player1.length()>1 || player2.length()>1){
            System.out.println("Invalid Player character!!");
            throw new RuntimeException("Invalid Player character!!");
        }

        this.setBoard(new TicTacToeBoard().createBoard(boardDim, boardDim, boardInit));

        this.playerList = new ArrayList() {{
            add(new TicTacToePlayer()
                    .setPlayerType(Player.PlayerType.AI)
                    .setPlayerSign(playerAI).setPlayerOrder(1));
            add(new TicTacToePlayer()
                    .setPlayerType(Player.PlayerType.HUMAN)
                    .setPlayerSign(player1).setPlayerOrder(2));
            add(new TicTacToePlayer()
                    .setPlayerType(Player.PlayerType.HUMAN)
                    .setPlayerSign(player2).setPlayerOrder(3));
        }};

    }

    @Override
    public Game startGame() {

        int currentPlayerNum = 0;
        Player currentPlayer = playerList.get(currentPlayerNum);

        while (true) {
            if (isGamefinished()) {
                System.out.println("Board is full. Game Over");
                return this;
            } else {
                Move move = currentPlayer.getMove(board);
                board.setBoardCell(move.dimX - 1, move.dimY - 1, move.cellChar);
            }

            if (isWinnerExist()) {
                System.out.println(String.format("Winner!!! Player %d has won the game.", currentPlayer.playerOrder));
                return this;
            }

            currentPlayerNum = (currentPlayerNum + 1) % 3;
            currentPlayer = playerList.get(currentPlayerNum);
        }
    }

    @Override
    public boolean isWinnerExist() {
        return isHorizontalWinner() || isVerticalWinner() || isDiagonalWinner();
    }

    private boolean isHorizontalWinner() {
        for (String[] line : board.getBoardTable()) {
            if (Arrays.stream(line).distinct().count() == 1
                    && !Arrays.stream(line).anyMatch(x -> x.equals(board.getBoardInit()))) {
                return true;
            }
        }

        return false;
    }

    private boolean isVerticalWinner() {
        for (int i = 0; i < board.getBoardTable().length - 1; i++) {
            for (int j = 0; j < board.getBoardTable().length - 1; j++) {
                if (board.getBoardTable()[j][i].equals(board.getBoardTable()[j + 1][i])) {
                    if (j == board.getBoardTable().length - 2
                            && !board.getBoardTable()[j][i].equals(board.getBoardInit())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean isDiagonalWinner() {
        for (int i = 0; i < board.getBoardTable().length - 1; i++) {
            if (board.getBoardTable()[i][i].equals(board.getBoardTable()[i + 1][i + 1])) {
                if (i == board.getBoardTable().length - 2
                        && !board.getBoardTable()[i][i].equals(board.getBoardInit())) {
                    return true;
                }
            } else {
                break;
            }
        }

        return false;
    }

    @Override
    public boolean isGamefinished() {
        return board.isBoardFull();
    }
}
