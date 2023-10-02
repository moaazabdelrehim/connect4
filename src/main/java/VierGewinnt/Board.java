package VierGewinnt;

public class Board {
    // initialize game board variables rows/columns for adjusting game board
    int columns = 7;
    int rows = 6;

    public void temp() {
        char[][] board = new char[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                board[row][column] = ' ';
            }
        }


        // output game board
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.print(board[row][column] + "|");
            }
            System.out.println();
        }
    }
}
