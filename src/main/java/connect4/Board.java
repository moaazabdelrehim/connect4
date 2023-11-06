package connect4;

public class Board {
    Cell[][] cells;
    int rows = 6;
    int columns = 7;

    public Board() {
        this.cells = new Cell[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new Cell();
            }
        }
    }

    /**
     * Adds a token in the given column
     * @param token the token of the current player
     * @param column the column in which the token needs to be placed
     * @return returns true for successful placement and false if the column is already full
     */
    public Boolean placeToken(Token token, Integer column) {

        for (int row = 5; row >= 0; row--) {
            if (cells[row][column].token.equals(Token.VALUE_EMPTY)) {
                cells[row][column].token = token;
                return true;
            }
        }
        return false;
    }

    public String displayBoard() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nCurrent Board: \n\n");
        stringBuilder.append("|  0  |  1  |  2  |  3  |  4  |  5  |  6  |\n");

        for (int row = 0; row < rows; row++) {
            stringBuilder.append("|-----------------------------------------|\n");
            for (int column = 0; column < columns; column++) {
                stringBuilder.append("|  " + cells[row][column].token.getValue() + "  ");
            }
            stringBuilder.append("|\n");
        }
        stringBuilder.append("|-----------------------------------------|\n");

        return stringBuilder.toString();
    }

}
