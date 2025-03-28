package managers;

import models.*;
import utility.Console;
import utility.State;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;


/**
 * Менеджер, отвечающий за создание новых объектов построчно
 */
public class AskManager {
    private static State currentState;
    Console console;
    public AskManager(Console console) {
        this.console = console;
    }


    /**
     * Создание нового экземпляра StudyGroup
     * @return Объект StudyGroup
     */
    public StudyGroup askStudyGroup(){
        StudyGroup studyGroup = new StudyGroup();
        String line;
        currentState = State.ENTER_NAME;
        while (currentState != State.COMPLETED){
            switch (currentState){
                case ENTER_NAME:
                    console.print("Введите имя: ");
                    line = console.nextLine();
                    if (line != null && !line.isEmpty()) {
                        studyGroup.setName(line);
                        studyGroup.setCoordinates(askCoordinates());
                        currentState = State.ENTER_STUDCOUNT;
                    } else {
                        sendValidationError();
                    }
                    break;

                case ENTER_STUDCOUNT:
                    console.print("Введите количество студентов: ");
                    line = console.nextLine();
                    if (line.isEmpty()) {
                        studyGroup.setStudentsCount(null);
                        currentState = State.ENTER_SHOULDBEEXPELLED;
                    } else{
                    try{
                        long studCount = Long.parseLong(line);

                        if (studCount > 0) {
                            studyGroup.setStudentsCount(studCount);
                            currentState = State.ENTER_SHOULDBEEXPELLED;
                        } else {
                            sendValidationError();
                        } } catch (NumberFormatException e) {
                        sendValidationError();
                    }}
                    break;


                case ENTER_SHOULDBEEXPELLED:
                    console.print("Введите значение поля shouldbeexpelled: ");

                    line = console.nextLine();
                    try{
                        int shouldbeexpelled = Integer.parseInt(line);

                    if (shouldbeexpelled > 0) {
                        studyGroup.setShouldBeExpelled(shouldbeexpelled);
                        currentState = State.ENTER_AVGMARK;
                    } else {
                        sendValidationError();
                    }} catch (NumberFormatException e){
                        sendValidationError();
                    }
                    break;

                case ENTER_AVGMARK:
                    console.print("Введите значение поля avgmark: ");

                    line = console.nextLine();
                    try {
                        long avgMark = Long.parseLong(line);
                        if (avgMark > 0) {
                            studyGroup.setAverageMark(avgMark);
                            currentState = State.ENTER_SEMESTER;
                        } else {
                            sendValidationError();
                        }
                    } catch (NumberFormatException e) {
                        sendValidationError();
                    }
                    break;

                case ENTER_SEMESTER:
                    console.print("Введите значение поля semester: [FOURTH | FIFTH | SIXTH | SEVENTH | EIGHTH] ");
                    Semester semester;
                    line = console.nextLine().trim().toUpperCase();
                    try {
                        semester = Semester.valueOf(line);
                        if (semester.isValid()) {
                            studyGroup.setSemesterEnum(semester);
                            studyGroup.setGroupAdmin(askPerson());
                            console.println("Ввёл админа");
                            currentState = State.VALIDATING;
                        } else sendValidationError();
                    } catch (NullPointerException | IllegalArgumentException e) {
                        sendValidationError();
                    }
                    break;

                case VALIDATING:
                    studyGroup.setId(1L);
//                    studyGroup.setId(CollectionManager.getPerfectId());
                    studyGroup.setCreationDate(new Date());
                    if (studyGroup.isValid()){
                        currentState = State.COMPLETED;
                    } else {
                        console.print("тут должен быть вывод");
                        console.print(studyGroup);
                        sendValidationError();
                        currentState = State.ENTER_NAME;
                    }
                    break;

            }
        }


        return studyGroup;
    }

    /**
     * Создание нового экземпляра Coordinates
     * @return Объект Coordinates
     */
    Coordinates askCoordinates(){
        String line;
        currentState = State.ENTER_XCOORD;
        Coordinates coordinates = new Coordinates();
        while (currentState != State.COMPLETED){
            switch (currentState){

            case ENTER_XCOORD:
                console.print("Введите значение координаты x: ");
                line = console.nextLine();
                try{
                    int xcoord = Integer.parseInt(line);
                if (xcoord > 0) {
                    coordinates.setX(xcoord);
                    currentState = State.ENTER_YCOORD;
                } else {
                    sendValidationError();
                    } } catch (NumberFormatException e) {
                    sendValidationError();
                }
                break;

            case ENTER_YCOORD:
                console.print("Введите значение координаты y: ");
                line = console.nextLine();
                try {
                    int ycoord = Integer.parseInt(line);

                if (ycoord > 0) {
                    coordinates.setY(ycoord);
                    currentState = State.VALIDATING;

                } else {
                    sendValidationError();
                }} catch (NumberFormatException e) {
                    sendValidationError();
                }
                break;

            case VALIDATING:
                if (coordinates.isValid()) {
                    currentState = State.COMPLETED;

                } else {
                    sendValidationError();
                    currentState = State.ENTER_XCOORD;
                }
                break;

            }}
        return coordinates;

    }

    /**
     * Создание нового экземпляра Person
     * @return Объект Person
     */
    Person askPerson(){
        String line;
        Color eyecolor;
        Color haircolor;
        Country country;
        currentState = State.ENTER_NAME;
        Person person = new Person();
        while (currentState != State.COMPLETED){
            switch (currentState){

                case ENTER_NAME:
                    console.print("Введите имя: ");
                    line = console.nextLine();
                    if (line != null && !line.isEmpty()) {
                        person.setName(line);
                        currentState = State.ENTER_BDAY;
                    } else {
                        sendValidationError();
                    }
                    break;

                case ENTER_BDAY:
                    console.print("Введите день рождения в формате yyyy-mm-ddThh:mm:ss : ");
                    line = console.nextLine();
                    try {
                        LocalDateTime parsedDate = LocalDateTime.parse(line, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                        person.setBirthday(parsedDate);
                        currentState = State.ENTER_EYECOLOR;
                    } catch (DateTimeParseException e) {
                        sendValidationError();
                    }
                    break;

                case ENTER_EYECOLOR:
                    console.print("Введите цвет глаз: [RED | BLACK | BLUE | YELLOW ] ");

                    line = console.nextLine().trim().toUpperCase();
                    if (line.isEmpty()){
                        person.setEyeColor(null);
                        currentState = State.ENTER_HAIRCOLOR;
                }else{
                    try {
                        eyecolor = Color.valueOf(line);
                        if (eyecolor.isValid()) {
                            person.setEyeColor(eyecolor);
                            currentState = State.ENTER_HAIRCOLOR;
                        } else sendValidationError();
                    } catch (NullPointerException | IllegalArgumentException e) {
                        sendValidationError();
                    }}
                    break;

                case ENTER_HAIRCOLOR:
                    console.print("Введите цвет волос: [RED | BLUE | WHITE] ");

                    line = console.nextLine().trim().toUpperCase();
                    try {
                        haircolor = Color.valueOf(line);
                        if (haircolor.isValid()) {
                            person.setHairColor(haircolor);
                            currentState = State.ENTER_COUNTRY;
                        } else sendValidationError();
                    } catch (NullPointerException | IllegalArgumentException e) {
                        sendValidationError();
                    }
                    break;

                case ENTER_COUNTRY:
                    console.print("Введите страну: [UNITED_KINGDOM | GERMANY | VATICAN | NORTH_KOREA | JAPAN] ");
                    line = console.nextLine().trim().toUpperCase();
                    if (line.isEmpty()){
                        person.setNationality(null);
                        currentState = State.VALIDATING;
                    }
                    else {
                    try {
                        country = Country.valueOf(line);
                        if (country.isValid()) {
                            person.setNationality(country);
                            currentState = State.VALIDATING;
                        } else sendValidationError();
                    } catch (NullPointerException | IllegalArgumentException e) {
                        sendValidationError();
                    }}
                    break;

                case VALIDATING:
                    if (person.isValid()) {
                        currentState = State.COMPLETED;

                    } else {
                        sendValidationError();
                        currentState = State.ENTER_NAME;
                    }
                    break;

            }}
        return person;


    }

    /**
     * Функция для оповещения о неверно введённых данных
     */
    private void sendValidationError(){
        console.println("Ошибка валидации. " + currentState.describe());
    }
}
