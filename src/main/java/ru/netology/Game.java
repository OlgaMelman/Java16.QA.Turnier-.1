package ru.netology;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Game {

    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (!player.matches(playerName1)) {
                if (!player.matches(playerName2)) {
                    throw new NotRegisteredException(playerName1);
                }
            }

            if (player.matches(playerName1)) {
                player1 = player;
            }
            if (player.matches(playerName2)) {
                player2 = player;
            }
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.

                getStrength()) {
            return 2;
        }
        return 0;
    }
}
