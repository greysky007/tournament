package ru.netology.tournament.task;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    protected HashMap<String, Player> map = new HashMap<>();


    public void register(Player player) {
        map.put(player.getName(), player);

    }


    public Player findByName(String name) {
        for (String key : map.keySet()) {
            if (key == name) {

                return map.get(key);

            }
        }
        throw new NotRegisteredException("Element with id: " + name + " not found");
    }


    public int round(String playerName1, String playerName2) {
        Player first = findByName(playerName1);
        Player second = findByName(playerName2);

        int result = 0;
        if (first.getStrength() == second.getStrength()) {
            result = 0;
        }
        if (first.getStrength() > second.getStrength()) {
            result = 1;
        }
        if (first.getStrength() < second.getStrength()) {
            result = 2;
        }
        return result;
    }
}





