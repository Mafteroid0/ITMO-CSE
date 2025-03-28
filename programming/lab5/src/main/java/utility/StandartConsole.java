package utility;

import java.util.Scanner;

/**
 * Стандартная консоль ввода-вывода
 */
public class StandartConsole implements Console {
    Scanner scanner = new Scanner(System.in);

    /** Выводит obj в консоль
     * @param obj объект для печати
     */
    @Override
    public void print(Object obj) {
        System.out.print(obj);
    }

    /** Выводит obj в консоль с переносом строки
     * @param obj объект для печати
     */
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }

    /**
     * @return следующую строку из консоли
     */
    @Override
    public String nextLine() {

        //if (scanner.nextLine().isEmpty()) return null;
        return scanner.nextLine();
    }

    /**
     * @return true если еще есть строки в консоли
     */
    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }
}