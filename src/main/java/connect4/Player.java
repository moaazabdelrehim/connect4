package connect4;

public class Player {
    public static final String WRONG_INPUT_ERROR_MESSAGE = "\nDeine Eingabe muss eine Nummer zwischen 0-6 sein. Bitte versuche es erneut: ";
    String name;
    Token token = Token.VALUE_EMPTY;

    public Player(String name, Token value) {
        this.name = name;
        this.token = value;
    }

    public String getName() {
        return name;
    }
}
