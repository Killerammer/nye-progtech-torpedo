package hu.nye.progtech.torpedo.model;

import java.util.Arrays;

public class ShipPosVO {

    private int pos[][];

    public ShipPosVO(int[][] pos) {
        this.pos = pos;
    }

    public int[][] getPos() {
        return pos;
    }

    //TODO Fix the position setter

    public void setPos(int[][] pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipPosVO shipPosVO = (ShipPosVO) o;
        return Arrays.equals(pos, shipPosVO.pos);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(pos);
    }

    @Override
    public String toString() {
        return "ShipPosVO{" +
                "pos=" + Arrays.deepToString(pos) +
                '}';
    }
}
