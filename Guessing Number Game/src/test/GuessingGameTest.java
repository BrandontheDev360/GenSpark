import static org.junit.jupiter.api.Assertions.*;
import org.testng.annotations.Test;
import org.junit.jupiter.api.*;

public class GuessingGameTest {
    GuessingGame guessingGame;

    @BeforeEach
    void setUp() {
        guessingGame = new GuessingGame();
    }

    @DisplayName("Test startGame()")
    @Test
    public void startGame() {
        assertEquals("Hello! What is your name fellow traveler?\nSign your soul away here...", GuessingGame.startGame(), "startGame function failed! ERROR:" );
    }

    @AfterEach
    void tearDown() {

    }
}
