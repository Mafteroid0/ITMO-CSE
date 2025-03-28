package utility;

/**
 * Интерфейс определяющий функционал консоли
 */
public interface Console {
    /**
     * Выводит obj в консоль
     * @param obj объект для печати
     */
    void print(Object obj);

    /**
     * Выводит obj в консоль с переносом строки
     * @param obj объект для печати
     */
    void println(Object obj);

    /**
     * Получает следующую строку из консоли
     * @return следующую строку в консоли
     */
    String nextLine();

    /**
     * Проверка на наличие следующей строки в консоли
     * @return true если есть следующая строка в консоли
     */
    boolean hasNextLine();

}
