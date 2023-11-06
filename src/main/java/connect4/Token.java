package connect4;

public enum Token {
    VALUE_X("X"),
    VALUE_O("O"),
    VALUE_EMPTY(" ");

    private final String value;

    Token(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}

