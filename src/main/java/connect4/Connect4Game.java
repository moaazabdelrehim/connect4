package connect4;

public class Connect4Game {

    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private boolean gameActive = false;

    public Connect4Game() {
        board = new Board();
        player1 = new Player("Player 1", Token.VALUE_X);
        player2 = new Player("Player 2", Token.VALUE_O);
        currentPlayer = player1;
        gameActive = true;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setNameForPlayer1(String name) {
        player1.name = name;
    }

    public void setNameForPlayer2(String name) {
        player2.name = name;
    }

    public boolean isGameActive() {
        return gameActive;
    }

    public boolean placeToken(int column) {
        return board.placeToken(currentPlayer.token, column);
    }

    public String getCurrentBoard() {
        return board.generateBoard();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
    }

    public Boolean checkWin() {
        return board.checkForWin();
    }

    public Boolean checkDraw() {
        return board.checkForDraw();
    }

}


