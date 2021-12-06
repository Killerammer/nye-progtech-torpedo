package hu.nye.progtech.torpedo.service;

public class ShipValidator {

    private final boolean[][] map;

    private final int columnNumber;
    private final int rowNumber;

    public ShipValidator(boolean[][] map, int rowNumber, int columnNumber) {
        this.map = map;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public boolean bottomLeft() {
        if (map[rowNumber + 1][columnNumber - 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean upperLeft() {
        if (map[rowNumber - 1][columnNumber - 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean left() {
        if (map[rowNumber][columnNumber - 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean bottomRight() {
        if (map[rowNumber + 1][columnNumber + 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean upperRight() {
        if (map[rowNumber - 1][columnNumber + 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean right() {
        if (map[rowNumber][columnNumber + 1]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean up() {
        if (map[rowNumber - 1][columnNumber]) {
            return false;
        } else {
            return true;
        }
    }

    public boolean down() {
        if (map[rowNumber + 1][columnNumber]) {
            return false;
        } else {
            return true;
        }
    }
}
