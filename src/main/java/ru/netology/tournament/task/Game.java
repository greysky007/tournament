package ru.netology.tournament.task;

import java.util.ArrayList;

public class Game {
    protected ArrayList<Player> playerList = new ArrayList<>();


    public void register(Player player) {
        playerList.add(player);

    }

    public ArrayList<Player> getItems() {

        return playerList;
    }

    public Player findByName(String name) {


        for (Player player : getItems()) {
            if (name == player.getName()) {
                return player;
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





