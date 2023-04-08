package ru.netology;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
public class Game {

    private HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        for (String key : players.keySet()) {
            if (!key.contains(playerName1)) {
                if (!key.contains(playerName2)) {
                    throw new NotRegisteredException(playerName1);
                }
            }
        }

        if (players.get(playerName1) > players.get(playerName2)) {
            return 1;
        }
        if (players.get(playerName1) < players.get(playerName2)) {
            return 2;
        }
        return 0;
    }
}
