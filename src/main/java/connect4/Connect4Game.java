package connect4;

public class Connect4Game {

    public static void main(String[] args) {

        Board testBoard = new Board();

        Player player1 = new Player("Berni", Token.VALUE_X);
        Player player2 = new Player("Niklas", Token.VALUE_O);
        Player currentPlayer = player1;

        Boolean gameActive = true;

        // Main Game Loop
        while (gameActive) {

            System.out.print("\n" + currentPlayer.name + ", bitte gib die nächste Spalte ein, in die du deinen Token platzieren willst: ");
            int playerMove = currentPlayer.getNextMoveColumn();
            while (!testBoard.placeToken(currentPlayer.token, playerMove)) {
                System.out.print("\nDie angegebene Spalte ist leider bereits voll. Bitte versuche es erneut: ");
                playerMove = currentPlayer.getNextMoveColumn();
            }
            System.out.println(testBoard.displayBoard());
            currentPlayer = (currentPlayer.equals(player1)) ? player2 : player1;
        }

    }
}
