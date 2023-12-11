package connect4;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    Player testPlayer;

    @BeforeEach
    void setUp() {
        testPlayer = new Player("Player1", Token.VALUE_X);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName_CorrectName() {
        assertEquals("Player1", testPlayer.getName());
    }

    @Test
    void getName_IncorrectName() {
        assertNotEquals("Player2", testPlayer.getName());
    }

}