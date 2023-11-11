package connect4;

public class Connect4Game {

    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private boolean gameActive = false;

    public Connect4Game(){
        board = new Board();
        player1 = new Player("Berni", Token.VALUE_X);
        player2 = new Player("Niklas", Token.VALUE_O);
        currentPlayer = player1;
        gameActive = true;
    }

    public boolean isGameActive() {
        return gameActive;
    }

 public boolean placeToken(int column){
     if (board.placeToken(currentPlayer.token, column)) {
         // check win
         changePlayer();
         return true;
     }
     return false;
 }

    public String getCurrentBoard() {
        return board.generateBoard();
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
    }

    /*public void run(){
        Player currentPlayer = player1;
        Boolean gameActive = true;

        // Main Game Loop
        while (gameActive) {

            //UI
            Output.displayMessage("\n" + currentPlayer.name + ", bitte gib die nächste Spalte ein, in die du deinen Token platzieren willst: ");
            int playerMove = currentPlayer.getNextMoveColumn();
            while (!testBoard.placeToken(currentPlayer.token, playerMove)) {
                Output.displayMessage("\nDie angegebene Spalte ist leider bereits voll. Bitte versuche es erneut: ");
                playerMove = currentPlayer.getNextMoveColumn();
            }
            System.out.println(testBoard.displayBoard());
            currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
        }

    }
*/



    }


