package hu.nye.progtech.torpedo.model;

public class Player {

    private String name;
    private int winCounter;

    public Player(String name, int winCounter) {
        this.name = name;
        this.winCounter = winCounter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(int winCounter) {
        this.winCounter = winCounter;
    }
}
