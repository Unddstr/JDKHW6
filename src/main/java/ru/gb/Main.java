package ru.gb;

import org.apache.commons.math3.random.RandomDataImpl;

import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<Door> doorList = new ArrayList<>();
    static Player player = new Player(doorList);

    static int win;
    static int loos;

    public static void main(String[] args) {
        win = 0;
        loos = 0;


        for (int i = 1; i <= 1000; i++) {
            doorList.add(new Door());
            doorList.add(new Door());
            doorList.add(new Door());

            doorList.get(random()).setWin(true);
            player.makeFirstChoice();
            openFirstDoor();
            player.makeSecondChoice();
            openSecondDoor();

            doorList.clear();
        }
        System.out.println("Win = " + win);
        System.out.println("Loos = " + loos);
    }

    private static void openSecondDoor() {
        if (doorList.get(player.getChoice()).isWin()) {
            win++;
        } else {
            loos++;
        }
    }

    private static void openFirstDoor() {
        for (int i = 0; i < doorList.size(); i++) {
            if (i != player.getChoice() && !doorList.get(i).isWin()) {
                doorList.get(i).setOpen(true);
                break;
            }
        }

    }

    public static int random() {
        return new RandomDataImpl().nextInt(0, doorList.size() - 1);
    }
}