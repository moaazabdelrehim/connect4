import connect4.Board;
import connect4.Token;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    Board testBoard;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        testBoard = new Board();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void placeToken_CorrectPlacementTokenXTest() {

        Token testTokenX = Token.VALUE_X;

        // Insert X at Column 0 and row 5
        assertEquals(testBoard.getCells()[5][0].token, Token.VALUE_EMPTY);
        assertTrue(testBoard.placeToken(testTokenX, 0));
        assertEquals(Token.VALUE_X, testBoard.getCells()[5][0].token);
    }

    @Test
    void placeToken_CorrectPlacementTokenOTest() {

        Token testTokenO = Token.VALUE_O;

        // Insert Y at Column 0 and row 5
        assertEquals(testBoard.getCells()[5][0].token, Token.VALUE_EMPTY);
        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertEquals(Token.VALUE_O, testBoard.getCells()[5][0].token);
    }

    @Test
    void placeToken_FullColumnTest() {

        Token testTokenO = Token.VALUE_O;

        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertTrue(testBoard.placeToken(testTokenO, 0));
        assertTrue(testBoard.placeToken(testTokenO, 0));

        assertFalse(testBoard.placeToken(testTokenO, 0));
    }

    @Test
    void displayBoardEmptyTest() {

        // Auslagern in ein Textfile
        String expectedBoard = "\n" +
                "Derzeitiger Spielstand: \n" +
                "\n" +
                "|  1  |  2  |  3  |  4  |  5  |  6  |  7  |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n" +
                "|     |     |     |     |     |     |     |\n" +
                "|-----------------------------------------|\n";

        String actualBoard = testBoard.generateBoard();
        assertEquals(expectedBoard, actualBoard);

    }

    @Test
    void checkForWin_Vertically() {
        Token testTokenO = Token.VALUE_O;
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenO, 0);
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_Horizontally() {
        Token testTokenO = Token.VALUE_O;
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenO, 3);
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_DiagonallyUp() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 3);
        System.out.println("checkForWin_DiagonallyUp: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_DiagonallyDown() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenO, 3);
        System.out.println("checkForWin_DiagonallyDown: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_FiveInARowHorizontally() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenX, 4);

        testBoard.placeToken(testTokenX, 2);

        System.out.println("checkForWin_FiveInARowHorizontally: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_NoWinner_Case1() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 5);
        System.out.println("checkForWin_NoWinner_Case1: " + testBoard.generateBoard());
        assertFalse(testBoard.checkForWin());
    }

    @Test
    void checkForWin_NoWinner_Case2() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 2);
        System.out.println("checkForWin_NoWinner_Case2: " + testBoard.generateBoard());
        assertFalse(testBoard.checkForWin());
    }

    @Test
    void checkForWin_XWins() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenX, 2);

        System.out.println("checkForWin_XWins: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForWin_OWins() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 5);

        System.out.println("checkForWin_OWins: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForWin());
    }

    @Test
    void checkForDraw() {
        Token testTokenO = Token.VALUE_O;
        Token testTokenX = Token.VALUE_X;
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenX, 0);
        testBoard.placeToken(testTokenO, 0);

        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenX, 1);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenO, 1);
        testBoard.placeToken(testTokenX, 1);

        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenX, 2);
        testBoard.placeToken(testTokenO, 2);

        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenO, 3);
        testBoard.placeToken(testTokenX, 3);

        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 4);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenX, 4);
        testBoard.placeToken(testTokenO, 4);

        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenX, 5);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenO, 5);
        testBoard.placeToken(testTokenX, 5);

        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenX, 6);
        testBoard.placeToken(testTokenO, 6);

        System.out.println("checkForDraw: " + testBoard.generateBoard());
        assertTrue(testBoard.checkForDraw());
    }

}