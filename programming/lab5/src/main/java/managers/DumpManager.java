package managers;

import models.*;
import utility.Console;
import utility.FileConsole;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * Менеджер, отвечающий за загрузку/сохранение коллекции в файл
 */
class DumpManager {
    private String filePath;
    private Console console;

    public DumpManager(){
        try {
            this.filePath = System.getenv("DATA_PATH");
            this.console = new FileConsole(filePath);
        }
        catch (SecurityException |FileNotFoundException e) {
            System.out.println("Недостаточно прав для доступа к файлу.");
        }
        catch (Exception e) {
            if (filePath == null) System.out.println("Пожалуйста, укажите в переменную окружения DATA_PATH " +
                    "путь до файла с коллекцией");
            else {
                System.out.println("Не удаётся найти файл "+ filePath +". Проверьте правильность данных.");
            }

        }

    }


    /**
     * Загрузка коллекции из файла
     * @return коллекция экземпляров класса StudyGroup
     */
    public Stack<StudyGroup> loadCollection(){
        Stack<StudyGroup> studyGroups = new Stack<>();

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        boolean is_save = true;
        try {
            console.nextLine();
            while (console.hasNextLine()) {
                try {
                    String line = console.nextLine();
                    String[] classFields = line.split(", ");

                    Long id = Long.parseLong(classFields[0]);
                    String name = classFields[1];
                    Coordinates coordinates = new Coordinates(Integer.parseInt(classFields[2]),
                            Integer.parseInt(classFields[3]));
                    Date date = isoFormat.parse(classFields[4]);
                    Long studentscount;
                    if (Objects.equals(classFields[5], "null")) { studentscount = null;}
                    else { studentscount = Long.parseLong(classFields[5]);}
                    Integer shouldBeExpelled = Integer.parseInt(classFields[6]);
                    Long avgMark = Long.parseLong(classFields[7]);
                    Semester semester = Semester.valueOf(classFields[8]);
                    String adminName = classFields[9];
                    LocalDateTime bday = LocalDateTime.parse(classFields[10], DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    Color eyecolor;
                    if (Objects.equals(classFields[11], "null")) {eyecolor = null;}
                    else {eyecolor = Color.valueOf(classFields[11]);}

                    Color hairColor = Color.valueOf(classFields[12]);
                    Country nationality;
                    if (Objects.equals(classFields[13], "null")) { nationality = null;}
                    else { nationality = Country.valueOf(classFields[13]);}
                    StudyGroup sg = new StudyGroup(id, name, coordinates, date, studentscount, shouldBeExpelled, avgMark, semester,
                            new Person(adminName, bday, eyecolor, hairColor, nationality));
                    if (sg.isValid()) studyGroups.add(sg);
                    else is_save = false;}
                    catch (ArrayIndexOutOfBoundsException | ParseException | IllegalArgumentException |
                           DateTimeParseException e) {
                        is_save = false;
                    }
            }
            if (is_save) System.out.println("Коллекция успешно загружена");
            else System.out.println("Некоторые элементы коллекции не были загружены");
        }
        catch (SecurityException e) {
            System.out.println("Недостаточно прав для записи в файл.");
        }
        catch (NullPointerException e) {
            System.out.println("Коллекция не была загружена.");
        }
        catch (Exception e) {
            System.out.println("Похоже что файл неправильно сохранён или повреждён. Коллекция не была загружена.");
            return new Stack<>();
        }

        return studyGroups;
    }

    /**
     * Сохранение коллекции в файл
     * @param studyGroups коллекция экземпляров класса StudyGroup
     */
    public void saveCollection(Stack<StudyGroup> studyGroups){

        try (PrintWriter writer = new PrintWriter(filePath)){
        writer.println("id, name, coordinates.x, coordinates.y, creationDate, studentsCount, " +
                "shouldBeExpelled, averageMark, semesterEnum, groupAdmin.name," +
                "groupAdmin.birthday, groupAdmin.eyeColor, groupAdmin.hairColor, groupAdmin.nationality");
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        isoFormat.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
        for (StudyGroup studyGroup : studyGroups) {

            String[] row = new String[] {
                    studyGroup.getId().toString(),
                    studyGroup.getName(),
                    studyGroup.getCoordinates().getX().toString(),
                    String.valueOf(studyGroup.getCoordinates().getY()),
                    isoFormat.format(studyGroup.getCreationDate()),
                    Objects.toString(studyGroup.getStudentsCount(), "null"),
                    studyGroup.getShouldBeExpelled().toString(),
                    studyGroup.getAverageMark().toString(),
                    studyGroup.getSemesterEnum().toString(),
                    studyGroup.getGroupAdmin() != null ? studyGroup.getGroupAdmin().getName() : "null",
                    studyGroup.getGroupAdmin() != null ? studyGroup.getGroupAdmin().getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) : "null",
                    Objects.toString(studyGroup.getGroupAdmin() != null ? studyGroup.getGroupAdmin().getEyeColor() : null, "null"),
                    Objects.toString(studyGroup.getGroupAdmin() != null ? studyGroup.getGroupAdmin().getHairColor() : null, "null"),
                    Objects.toString(studyGroup.getGroupAdmin() != null ? studyGroup.getGroupAdmin().getNationality() : null, "null")
            };
            writer.println(String.join(", ", row));
        }

        System.out.println("Данные успешно записаны в файл " + filePath);

    } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}



