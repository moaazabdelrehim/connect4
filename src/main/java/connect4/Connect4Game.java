package connect4;

public class Connect4Game {

    private Board board;
    private Player player1;
    private Player player2;

    private Player currentPlayer;

    private boolean gameActive = false;

    public Connect4Game(){
        board = new Board();
        player1 = new Player("Berni", Token.VALUE_X);
        player2 = new Player("Niklas", Token.VALUE_O);
        currentPlayer = player1;
        gameActive = true;
    }

    public Connect4Game(String name1, String name2){
        board = new Board();
        player1 = new Player(name1, Token.VALUE_X);
        player2 = new Player(name2, Token.VALUE_O);
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


