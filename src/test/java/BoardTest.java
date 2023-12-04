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
        assertEquals(testBoard.getCells()[5][0].token,Token.VALUE_EMPTY);
        assertTrue(testBoard.placeToken(testTokenX, 0));
        assertEquals(Token.VALUE_X, testBoard.getCells()[5][0].token);
    }

    @Test
    void placeToken_CorrectPlacementTokenOTest() {

        Token testTokenO = Token.VALUE_O;

        // Insert Y at Column 0 and row 5
        assertEquals(testBoard.getCells()[5][0].token,Token.VALUE_EMPTY);
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
                "|  0  |  1  |  2  |  3  |  4  |  5  |  6  |\n" +
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
}