# TicTacToe Game

TicTacToe Game Main features

 1. Player
    --  3 player plays this game, one of them is computer.
 2. Configuration
    --  Board size and players symbols are configurable wih tictactoe.properties.

## Setup

In order to setup, maven4 and jdk8 are required.

 1. Built project and run tests (at same directory with pom.xml)
    `mvn package`
 2. Run application (at target file), do not forget to copy tictactoe.properties file to same folder
    `java -jar tictactoe-1.0-SNAPSHOT.jar`    
 

## Usage
There are three choses;

 1. Players enter the cell number like as "3,4"

## Structure

1. There are three abstract components;
   
   -- Game, Player, Board
   
   These components are common for all board games.
   All board games like chess, player plays the game on board according to game rules.
   Due to that, in this project, Player object represents player (human,AI), Board object hold board specs and states and Game object executes game and rules.
   
   -- TicTacToe classes derived as an board game.    
    





