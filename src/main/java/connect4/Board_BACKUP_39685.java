package connect4;

public class Board {
<<<<<<< HEAD
    public static final String HEADER_LINE1 = "\nCurrent Board: \n\n";
    public static final String DILIMINTER = "|";
    public static final String LINE = DILIMINTER + "-----------------------------------------|\n";
    public static final String HEADER_LINE2 = DILIMINTER + "  1  |  2  |  3  |  4  |  5  |  6  |  7  |\n";
    private Cell[][] cells;
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;

    public Board() {
        initBoard();
    }

    private void initBoard() {
        this.cells = new Cell[ROWS][COLUMNS];
        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
=======
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
>>>>>>> SEG-24
                cells[row][column] = new Cell();
            }
        }
    }

<<<<<<< HEAD
    public String displayBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_LINE1);
        stringBuilder.append(HEADER_LINE2);
        for (int row = 0; row < ROWS; row++) {
            stringBuilder.append(LINE);
            for (int column = 0; column < COLUMNS; column++) {
                stringBuilder.append(DILIMINTER + "  " + cells[row][column].token.value + "  ");
            }
            stringBuilder.append(DILIMINTER).append("\n");
        }
        stringBuilder.append(LINE);
=======
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

>>>>>>> SEG-24
        return stringBuilder.toString();
    }

}
