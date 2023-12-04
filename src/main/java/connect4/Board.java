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
    public static final int MATCH_WIN_VALUE = 4;
    Cell[][] cells;
    public static final int TOTAL_ROWS = 6;
    public static final int TOTAL_COLUMNS = 7;

    public static final int MIN_COLUMN = 0;
    public static final int MAX_COLUMN = 6;

    public static final int MIN_ROW = 0;
    public static final int MAX_ROW = 5;
    public static final int BOARD_MAX_VALUE = 42;
    public int currentBoardValue = 0;
    private int lastTokenColumn = 0;
    private int lastTokenRow = 0;


    public Board() {
        this.cells = new Cell[TOTAL_ROWS][TOTAL_COLUMNS];
        for (int row = 0; row < TOTAL_ROWS; row++) {
            for (int column = 0; column < TOTAL_COLUMNS; column++) {
                cells[row][column] = new Cell();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Boolean placeToken(Token token, int column) {

        for (int row = TOP_ROW; row >= BOTTOM_ROW; row--) {
            if (cells[row][column].token.equals(Token.VALUE_EMPTY)) {
                cells[row][column].token = token;
                lastTokenColumn = column;
                lastTokenRow = row;
                currentBoardValue++;
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

    public Boolean checkForWin() {
        Token currentToken = cells[lastTokenRow][lastTokenColumn].token;
        return checkForWinHorizontally(currentToken) || checkForWinVertically(currentToken) || checkForWinDiagonallyUp(currentToken) || checkForWinDiagonallyDown(currentToken);
    }

    public Boolean checkForDraw(){
        return currentBoardValue == BOARD_MAX_VALUE;
    }

    private Boolean checkForWinVertically(Token currentToken) {

        int matchVertically = 1;// it starts at one because the initially placed token also adds to the count

        for (int counter = 1; counter <= 3; counter++) {
            if (lastTokenRow + counter <= MAX_ROW) {
                if (cells[lastTokenRow + counter][lastTokenColumn].token.equals(currentToken)) {
                    matchVertically++;
                }
            }
            if (lastTokenRow - counter >= MIN_ROW)
                if (cells[lastTokenRow - counter][lastTokenColumn].token.equals(currentToken)) {
                    matchVertically++;
                }
        }
        return matchVertically == MATCH_WIN_VALUE;
    }

    //Todo: edge case - token in the middle
    private Boolean checkForWinHorizontally(Token currentToken) {

        int matchCountHorizontally = 1;// it starts at one because the initially placed token also adds to the count

        for (int counter = 1; counter <= 3; counter++) {
            if (lastTokenColumn + counter <= MAX_COLUMN) {
                if (cells[lastTokenRow][lastTokenColumn + counter].token.equals(currentToken)) {
                    matchCountHorizontally++;
                }
            }
            if (lastTokenColumn - counter >= MIN_COLUMN)
                if (cells[lastTokenRow][lastTokenColumn - counter].token.equals(currentToken)) {
                    matchCountHorizontally++;
                }
        }
        return matchCountHorizontally == MATCH_WIN_VALUE;
    }

    private Boolean checkForWinDiagonallyDown(Token currentToken) {

        int matchDiagonallyDown = 1;// it starts at one because the initially placed token also adds to the count

        for (int counter = 1; counter <= 3; counter++) {
            if (lastTokenRow + counter <= MAX_ROW && lastTokenColumn + counter < MAX_COLUMN) {
                if (cells[lastTokenRow + counter][lastTokenColumn + counter].token.equals(currentToken)) {
                    matchDiagonallyDown++;
                }
            }
            if (lastTokenRow - counter >= MIN_ROW && lastTokenColumn - counter > MIN_COLUMN) {
                if (cells[lastTokenRow - counter][lastTokenColumn - counter].token.equals(currentToken)) {
                    matchDiagonallyDown++;
                }
            }
        }
        return matchDiagonallyDown == MATCH_WIN_VALUE;
    }

    private Boolean checkForWinDiagonallyUp(Token currentToken) {

        int matchDiagonallyUp = 1;// it starts at one because the initially placed token also adds to the count

        for (int counter = 1; counter <= 3; counter++) {
            if (lastTokenRow + counter <= MAX_ROW && lastTokenColumn - counter > MIN_COLUMN) {
                if (cells[lastTokenRow + counter][lastTokenColumn - counter].token.equals(currentToken)) {
                    matchDiagonallyUp++;
                }
            }
            if (lastTokenRow - counter >= MIN_ROW && lastTokenColumn + counter < MAX_COLUMN) {
                if (cells[lastTokenRow - counter][lastTokenColumn + counter].token.equals(currentToken)) {
                    matchDiagonallyUp++;
                }
            }
        }
        return matchDiagonallyUp == MATCH_WIN_VALUE;
    }
}
