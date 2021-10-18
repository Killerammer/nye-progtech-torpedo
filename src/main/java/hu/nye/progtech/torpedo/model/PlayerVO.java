package hu.nye.progtech.torpedo.model;

import java.util.Objects;

public class PlayerVO {

    private String name;

    public PlayerVO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerVO playerVO = (PlayerVO) o;
        return Objects.equals(name, playerVO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
