package VierGewinnt;

public class Connect4Game {

    public static void main(String[] args) {

        GameLogic gameLogic = new GameLogic();

        // Game Explaination
        gameLogic.gameExplanation();

        // Choose player colors
        Board board = new Board();
        board.chooseGameColor();

        // Game start
        gameLogic.startGame();

        // Draws board
        board.drawBoard();

    }
}
