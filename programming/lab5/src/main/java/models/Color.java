package models;

import utility.Validatable;


/**
 * Класс цвета
 */
public enum Color implements Validatable {
    RED,
    BLACK,
    BLUE,
    YELLOW,
    WHITE;

    public boolean isValid() {
        return true;
    }
}
