package commands;

import exceptions.CommandExecutionException;
import exceptions.RecursionDepthException;
import managers.CollectionManager;
import utility.Console;
import utility.FileConsole;
import utility.Invoker;


import java.io.IOException;


/**
 * Команда считающая и исполняющая скрипт из указанного файла
 */
public class ExecuteScript extends AbstractCommand {

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {
        try {


            String filepath = args[0];
            Console newconsole = new FileConsole(filepath);
            Invoker invoker = new Invoker();
            invoker.run(newconsole, manager);
        } catch (IOException e) {
            throw new CommandExecutionException("Файл не найден: '" + args[0] + "'", e);
        }
        catch (SecurityException e) {
            System.out.println("Недостаточно прав для доступа к файлу.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new CommandExecutionException("Отсутствуют необходимые аргументы команды", e);
        } catch (RecursionDepthException e) {
            throw new CommandExecutionException(e.getMessage(), e);
        }

    }
}
