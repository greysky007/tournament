import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.tournament.task.Game;
import ru.netology.tournament.task.NotRegisteredException;
import ru.netology.tournament.task.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GameTest {
    Game manager = new Game();

    Player player1 = new Player(12, "Vasya", 100);
    Player player2 = new Player(110, "Petya", 5);
    Player player3 = new Player(76, "Olya", 34);
    Player player4 = new Player(1, "Nadya", 34);
    Player player5 = new Player(3, "Lera", 15);

    @BeforeEach
    public void setup() {
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);
        manager.register(player5);
    }



    @Test
    public void shouldFindByName() {

        Player expected = player1;
        Player actual = manager.findByName("Vasya");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldRoundWhenFirstWin() {

        int expected = 1;
        int actual = manager.round("Vasya", "Petya");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRoundWhenSecondWin() {

        int expected = 2;
        int actual = manager.round("Petya", "Olya");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRoundWhenDraw() {

        int expected = 0;
        int actual = manager.round("Olya", "Nadya");
        Assertions.assertEquals(expected, actual);
    }



    @Test
    public void shouldNotRegistered() {


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Vika", "Vasya");
        });

    }
}

