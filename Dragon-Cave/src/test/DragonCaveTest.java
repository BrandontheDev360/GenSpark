import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class DragonCaveTest {
    DragonCave dragonCave;

    @BeforeEach
    void setUp() {
        dragonCave = new DragonCave();
    }

    @Test
    public void startGame() {
        assertEquals("You are in a land full of dragons.\nIn front of you, you see two caves.\nIn one cave, the dragon is friendly and will share his treasure with you.\nThe other dragon is greedy and hungry and will eat you on sight.\nWhich Cave will you go in (0 , 1, 2)", DragonCave.startGame(), "You did something wrong!" );
    }

    @Test
    public void playerInput() {
        assertAll("Different Player Inputs",
            () -> assertEquals("You entered cave 1 and have been eaten by the dragon!\nWould you want to play again? (yes or no)", DragonCave.playerInput(1), "Wrong Input"),
            () -> assertEquals("You entered cave 2 and have found treasure!\nWould you want to play again? (yes or no)", DragonCave.playerInput(2), "Wrong Input"),
            () -> assertEquals("You exited the cave.\nWould you want to play again? (yes or no)", DragonCave.playerInput(0), "Wrong Input"));
    }

    @AfterEach
    void tearDown() {

    }

}
