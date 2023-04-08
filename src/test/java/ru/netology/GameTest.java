package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Olya", 15);
    Player player2 = new Player(2, "Tolya", 25);
    Player player3 = new Player(3, "Vova", 25);

    @Test
    public void shouldThrowOnlyFirstPlayer() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Vova");
        });
    }

    @Test
    public void shouldThrowOnlySecondPlayer() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vova", "Tolya");
        });
    }

    @Test
    public void shouldThrowNoPlayers() {

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Vova", "Sveta");
        });
    }

    @Test
    public void shouldFindMoreStrengthPlayerTwo() {
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Olya", "Tolya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMoreStrengthPlayerOne() {

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Tolya", "Olya");

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindMoreStrengthPlayerIfEqual() {

        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Tolya", "Vova");

        Assertions.assertEquals(expected, actual);
    }
}
