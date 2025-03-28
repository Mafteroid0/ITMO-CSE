package models;

/**
 * Класс координат
 */
public class Coordinates {
    private Integer x; //Поле не может быть null
    private int y;
    public Coordinates() {}
    public Coordinates(Integer x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isValid() {
        return x != null;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Integer getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}