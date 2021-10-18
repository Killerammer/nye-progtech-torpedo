package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.PlayerVO;
import hu.nye.progtech.torpedo.model.ShipPosVO;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your player name: ");
        PlayerVO player = new PlayerVO(scanner.nextLine());
        System.out.println("Greetings " + player.getName() + "!");


        System.out.println("Now please enter your ships positions:");
        System.out.println("X: ");
        int x = scanner.nextInt();
        System.out.println("Y: ");
        int y = scanner.nextInt();

        //TODO FIX the position setter algorithm

        /*
        ShipPosVO ship = new ShipPosVO(new int[10][10]);
        ship.setPos(x,y);
        System.out.println("Position: "+ Arrays.deepToString(ship.getPos()));
         */
    }
}
