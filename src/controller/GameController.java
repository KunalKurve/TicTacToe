package controller;

import models.Game;

import java.util.ArrayList;

public class GameController {

    public Game playNewGame(){
        return new Game(3, new ArrayList<>(), new ArrayList<>());
    }

}
