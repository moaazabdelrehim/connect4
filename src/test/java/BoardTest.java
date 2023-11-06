import connect4.Board;

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

    @org.junit.jupiter.api.Test
    void displayBoardEmptyTest() {

        String expectedBoard = "\n" +
                "Current Board: \n" +
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

        String actualBoard = testBoard.displayBoard();
        assertEquals(expectedBoard, actualBoard);

    }
}