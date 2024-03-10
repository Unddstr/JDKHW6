package ru.gb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Door {
    private boolean win;
    private boolean open;

    public Door() {
        win = false;
        open = false;
    }
}
