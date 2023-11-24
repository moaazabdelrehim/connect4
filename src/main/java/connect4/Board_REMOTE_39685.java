package connect4;

public class Board {
    public static final String MESSAGE_CURRENT_GAME_STATUS = "\nDerzeitiger Spielstand: \n\n";
    public static final String BOARD_HEADER = "|  0  |  1  |  2  |  3  |  4  |  5  |  6  |\n";
    public static final String BOARD_DIVIDER = "|-----------------------------------------|\n";
    public static final String BOARD_LEFT_DELIMITER = "|  ";
    public static final String BOARD_RIGHT_SPACER = "  ";
    public static final String BOARD_RIGHT_DELIMITER = "|\n";
    public static final int TOP_ROW = 5;
    public static final int BOTTOM_ROW = 0;
    Cell[][] cells;
    int TOTAL_ROWS = 6;
    int TOTAL_COLUMNS = 7;

    public Board() {
        this.cells = new Cell[TOTAL_ROWS][TOTAL_COLUMNS];
        for (int row = 0; row < TOTAL_ROWS; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
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
    public Boolean placeToken(Token token, int column) {

        for (int row = TOP_ROW; row >= BOTTOM_ROW; row--) {
            if (cells[row][column].token.equals(Token.VALUE_EMPTY)) {
                cells[row][column].token = token;
                return true;
            }
        }
        return false;
    }

    public String generateBoard() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MESSAGE_CURRENT_GAME_STATUS);
        stringBuilder.append(BOARD_HEADER);

        for (int row = 0; row < TOTAL_ROWS; row++) {
            stringBuilder.append(BOARD_DIVIDER);
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                stringBuilder.append(BOARD_LEFT_DELIMITER + cells[row][column].token.getValue() + BOARD_RIGHT_SPACER);
            }
            stringBuilder.append(BOARD_RIGHT_DELIMITER);
        }
        stringBuilder.append(BOARD_DIVIDER);

        return stringBuilder.toString();
    }

}
