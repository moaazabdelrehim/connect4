package VierGewinnt;

// needed for player assignment
import java.util.Scanner;

public class Connect4Game {

    public static void main(String[] args) {

        GameLogic gameLogic = new GameLogic();

        // Game Explaination
        gameLogic.gameExplaination();

        // Choose player colors
        Board board = new Board();
        board.chooseGameColor();

        // Game start
        gameLogic.startGame();

        // Draws board
        board.drawBoard();

    }
}
