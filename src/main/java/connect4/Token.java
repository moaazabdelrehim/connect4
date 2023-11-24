package connect4;

public enum Token {
    VALUE_X(TokenConstants.PLAYER_ONE_SYMBOL),
    VALUE_O(TokenConstants.PLAYER_TWO_SYMBOL),
    VALUE_EMPTY(TokenConstants.SPACE);
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

    private static class TokenConstants {
        public static final String PLAYER_ONE_SYMBOL = "X";
        public static final String PLAYER_TWO_SYMBOL = "O";
        public static final String SPACE = " ";

    }
}

