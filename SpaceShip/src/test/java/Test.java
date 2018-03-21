import SpaceShip.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class GameTest {
    @Test
    void shouldAlwaysBeTheSame() {
        Game game_1 = Game.getInstance();
        Game game_2 = Game.getInstance();

        assertSame(game_1, game_2);
    }
}