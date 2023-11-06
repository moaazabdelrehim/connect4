package connect4;

public class Connect4Game {

    public static void main(String[] args) {

        Board testBoard = new Board();

        Player player1 = new Player("Berni", Token.VALUE_X);

        testBoard.placeToken(player1.token, 3);

        String board = testBoard.displayBoard();

        System.out.println(board);

    }
}
