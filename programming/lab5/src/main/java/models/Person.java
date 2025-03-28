package models;

import utility.Validatable;

import java.time.LocalDateTime;

/**
 * Класс человека
 */
public class Person implements Validatable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле не может быть null
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле может быть null

    public Person() {}

    public Person(String name, LocalDateTime birthday, Color eyeColor, Color hairColor, Country nationality) {
        this.name = name;
        this.birthday = birthday;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }

    /**
     * Проверка валидации всех полей
     * @return true если все поля валидны
     */
    public boolean isValid(){
        if (name == null) return false;
        if (birthday == null) return false;
        return hairColor != null;

    }

    public void setName(String name){
        this.name = name;
    }
    public void setBirthday(java.time.LocalDateTime birthday){
        this.birthday = birthday;
    }
    public void setEyeColor(Color eyeColor){
        this.eyeColor = eyeColor;
    }
    public void setHairColor(Color hairColor){
        this.hairColor = hairColor;
    }
    public void setNationality(Country nationality){
        this.nationality = nationality;
    }
    public String getName(){
        return name;
    }
    public java.time.LocalDateTime getBirthday(){
        return birthday;
    }
    public Color getEyeColor(){
        return eyeColor;
    }
    public Color getHairColor(){
        return hairColor;
    }
    public Country getNationality(){
        return nationality;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }
}
