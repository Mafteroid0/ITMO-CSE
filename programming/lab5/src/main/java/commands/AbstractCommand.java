package commands;

import exceptions.CommandExecutionException;
import managers.CollectionManager;
import utility.Console;


/**
 * Абстрактный класс исполняемой команды
 * @author daniilcelikov
 */
public abstract class AbstractCommand {
    Console console;

    /**
     * Исполнение команды
     * @param manager Менеджер коллекции
     * @param args Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    public abstract void execute(CollectionManager manager, String[] args) throws CommandExecutionException;

    /**
     * Установка консоли
     * @param console консоль ввода-вывода
     */
    public void setConsole(Console console){
        this.console = console;
    }

}
