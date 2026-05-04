package models;

import models.enums.PlayerType;

public class HumanPlayer extends Player{

    private int age;

    public HumanPlayer(int playerId, String name, Symbol symbol, int age) {
        super(playerId, name, symbol, PlayerType.HUMAN);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
