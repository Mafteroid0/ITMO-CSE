package models;

import utility.Validatable;

/**
 * Класс семестра
 */
public enum Semester implements Validatable {
    FOURTH,
    FIFTH,
    SIXTH,
    SEVENTH,
    EIGHTH;

    @Override
    public boolean isValid() {
        return true;
    }
}
