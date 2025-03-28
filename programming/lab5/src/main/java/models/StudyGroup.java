package models;

import utility.Validatable;


import java.util.Date;

/**
 * Класс учебной группы
 */
public class StudyGroup implements Validatable, Comparable<StudyGroup>{
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long studentsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Integer shouldBeExpelled; //Значение поля должно быть больше 0, Поле не может быть null
    private Long averageMark; //Значение поля должно быть больше 0, Поле не может быть null
    private Semester semesterEnum; //Поле не может быть null
    private Person groupAdmin; //Поле может быть null

    public StudyGroup() {}

    public StudyGroup(Long id, String name, Coordinates coordinates, Date creationDate, Long studentsCount, Integer shouldBeExpelled, Long averageMark, Semester semesterEnum, Person groupAdmin) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount = studentsCount;
        this.shouldBeExpelled = shouldBeExpelled;
        this.averageMark = averageMark;
        this.semesterEnum = semesterEnum;
        this.groupAdmin = groupAdmin;
    }

    @Override
    public int compareTo(StudyGroup o) {
        int comparison = this.studentsCount.compareTo(o.studentsCount);
        if (comparison != 0) return comparison;

        comparison = this.shouldBeExpelled.compareTo(o.shouldBeExpelled);
        if (comparison != 0) return comparison;

        comparison = this.averageMark.compareTo(o.averageMark);
        if (comparison != 0) return comparison;

        comparison = this.groupAdmin.getBirthday().compareTo(o.groupAdmin.getBirthday());
        if (comparison != 0) return comparison;

        return this.id.compareTo(o.id);


    }

    /**
     * Проверка валидации всех полей
     * @return true если все поля валидны
     */
    public boolean isValid() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null || !coordinates.isValid()) return false;
        if (creationDate == null) return false;
        if (studentsCount != null && studentsCount <= 0) return false;
        if (shouldBeExpelled <= 0) return false;
        if (averageMark <= 0) return false;
        return semesterEnum != null;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }
    public void setStudentsCount(Long studentsCount) {
        this.studentsCount = studentsCount;
    }
    public void setShouldBeExpelled(Integer shouldBeExpelled) {
        this.shouldBeExpelled = shouldBeExpelled;
    }
    public void setAverageMark(Long averageMark) {
        this.averageMark = averageMark;
    }
    public void setSemesterEnum(Semester semesterEnum) {
        this.semesterEnum = semesterEnum;
    }
    public void setGroupAdmin(Person groupAdmin) {
        this.groupAdmin = groupAdmin;
    }


    public Long getId() {
        return this.id;
    }

    public Person getGroupAdmin() {
        return groupAdmin;
    }

    public Semester getSemesterEnum() {
        return semesterEnum;
    }

    public Long getAverageMark() {
        return averageMark;
    }

    public Integer getShouldBeExpelled() {
        return shouldBeExpelled;
    }

    public Long getStudentsCount() {
        return studentsCount;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StudyGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.toString() +
                ", creationDate=" + creationDate +
                ", studentsCount=" + studentsCount +
                ", shouldBeExpelled=" + shouldBeExpelled +
                ", averageMark=" + averageMark +
                ", semesterEnum=" + semesterEnum +
                ", groupAdmin=" + groupAdmin.toString() +
                '}';
    }
}