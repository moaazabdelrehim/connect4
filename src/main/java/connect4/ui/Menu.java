package connect4.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MenuEntry<T> {
    protected MenuEntry(String k, String t, T r) {
        key = k;
        text = t;
        element = r;
    }

    protected String key;
    protected String text;
    protected T element;
}

public class Menu<T> {

    private static final String NEW_LINE = "\n";
    public static final String STAR_DELIMITER = "*";
    public static final String GREATER_THAN_SIGN = ">";
    public static final String ERROR_READING_FROM_CMD_MESSAGE = "Error reading from cmd:";
    public static final String EXIT_MESSAGE = "Exit with Ctrl C";
    public static final String WRONG_INPUT_MESSAGE = "Wrong input";

    private String titel;

    private final List<MenuEntry<T>> menuEintraege;

    Menu(String title) {
        menuEintraege = new ArrayList<>();
        this.setTitle(title);
    }

    public void setTitle(String title) {
        this.titel = title;
    }

    public String getTitle() {
        return titel;
    }

    void insert(String key, String text, T element) {
        menuEintraege.add(new MenuEntry<>(key, text, element));
    }

    T exec() {
        System.out.println(NEW_LINE + NEW_LINE + titel);
        for (int i = 0; i < titel.length(); i++)
            System.out.print(STAR_DELIMITER);

        System.out.print(NEW_LINE);
        menuEintraege.forEach(m -> System.out.println(m.key + ")\t" + m.text));
        System.out.print(NEW_LINE);

        BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
        do {
            String value = "\0";
            System.out.print(GREATER_THAN_SIGN);
            try {
                value = inReader.readLine();
            } catch (IOException e) {
                System.out.println(ERROR_READING_FROM_CMD_MESSAGE + e);
                System.out.println(NEW_LINE);
                System.out.println(EXIT_MESSAGE);
            }
            if (value.length() > 0) {
                for (MenuEntry<T> m : menuEintraege)
                    if (m.key.trim().equalsIgnoreCase(value.trim()))
                        return m.element;

            }
            System.out.println(WRONG_INPUT_MESSAGE);
        } while (true);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
