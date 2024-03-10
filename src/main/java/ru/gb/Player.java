package ru.gb;


import lombok.Getter;
import org.apache.commons.math3.random.RandomDataImpl;

import java.util.List;

@Getter
public class Player {
    private int choice;
    List<Door> doorList;

    public Player(List<Door> doorList) {
        this.doorList = doorList;
    }

    public void makeFirstChoice() {
        choice = new RandomDataImpl().nextInt(0, doorList.size() - 1);
    }

    public void makeSecondChoice() {
        for (int i = 0; i < doorList.size(); i++) {
            if (i != choice && !doorList.get(i).isOpen()) {
                choice = i;
                break;
            }
        }
    }
}
