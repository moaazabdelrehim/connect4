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

    public String displayBoard() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\nCurrent Board: \n\n");

        stringBuilder.append("|  1    2    3    4    5    6   7  |\n");

        for (int row = 0; row < rows; row++) {
            stringBuilder.append("|----------------------------------|\n");
            for (int column = 0; column <columns; column++) {
                stringBuilder.append("| " + cells[row][column].token.value);
            }
            stringBuilder.append("|");
            stringBuilder.append("\n");
        }
        stringBuilder.append("|----------------------------------|\n");
        return stringBuilder.toString();
    }

}
