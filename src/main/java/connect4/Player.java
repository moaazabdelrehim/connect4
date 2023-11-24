package connect4;

import java.util.Scanner;

public class Player {
    public static final String WRONG_INPUT_ERROR_MESSAGE = "\nDeine Eingabe muss eine Nummer zwischen 0-6 sein. Bitte versuche es erneut: ";
    final String name;
    Token token = Token.VALUE_EMPTY;


    public Player(String name, Token value) {
        this.name = name;
        this.token = value;

    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return this.token.getValue();
    }

    public Integer getNextMoveColumn() {

        boolean newInputNeeded = true;
        int currentColumn = -1;
        Scanner scan = new Scanner(System.in);

        while (newInputNeeded) {

            // check if input is number
            while (!scan.hasNextInt()) {
                System.out.print(WRONG_INPUT_ERROR_MESSAGE);
                scan.nextLine();
            }

            // check if input matches columns
            currentColumn = scan.nextInt();
            if (currentColumn < 0 || currentColumn > 6) {
                System.out.print(WRONG_INPUT_ERROR_MESSAGE);
                scan = new Scanner(System.in);
            } else {
                newInputNeeded = false;
            }
        }
        return currentColumn;
    }
}
