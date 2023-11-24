package connect4;

public class Board {
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
                cells[row][column] = new Cell();
            }
        }
    }

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
        return stringBuilder.toString();
    }

}
