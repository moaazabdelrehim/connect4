package connect4;
import com.sun.jdi.Value;
import javax.print.DocFlavor;

public class Player {
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
}
