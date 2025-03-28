package models;

import utility.Validatable;


/**
 * Класс страны
 */
public enum Country implements Validatable{
    UNITED_KINGDOM,
    GERMANY,
    VATICAN,
    NORTH_KOREA,
    JAPAN;


    @Override
    public boolean isValid() {
        return true;
    }
}