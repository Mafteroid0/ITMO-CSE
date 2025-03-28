package utility;

/**
 * Состояние программы в момент выполнения
 */
public enum State {
    ENTER_NAME("Строка не должна быть пустой."),
    ENTER_XCOORD("Параметр должен принимать целочисленное значение."),
    ENTER_YCOORD("Параметр должен принимать целочисленное значение."),
    ENTER_STUDCOUNT("Параметр должен принимать целочисленное значение больше нуля."),
    ENTER_SHOULDBEEXPELLED("Параметр должен принимать целочисленное значение больше нуля."),
    ENTER_AVGMARK("Параметр должен принимать целочисленное значение больше нуля."),
    ENTER_SEMESTER("Параметр должен принимать определённое значение, введённое текстом [FOURTH | FIFTH | SIXTH | SEVENTH | EIGHTH]"),
    ENTER_PERSONNAME("Строка не должна быть пустой."),
    ENTER_BDAY("Параметр должен принимать значение в виде строки в формате yyyy-mm-ddThh:mm:ss"),
    ENTER_EYECOLOR("Параметр должен принимать определённое значение, введённое текстом [RED | BLACK | BLUE | YELLOW ]"),
    ENTER_HAIRCOLOR("Параметр должен принимать определённое значение, введённое текстом [RED | BLUE | WHITE]"),
    ENTER_COUNTRY("Параметр должен принимать определённое значение, введённое текстом [UNITED_KINGDOM | GERMANY | VATICAN | NORTH_KOREA | JAPAN]"),
    VALIDATING("Повторите ввод полей."),
    COMPLETED("Этот текст никогда не появится :3");
    private final String description;

    State(String description) {
        this.description = description;
    }

    /**
     * @return описание требований на текущем шаге выполнения команды
     */
    public String describe() {
        return description;
    }
}
