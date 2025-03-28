package utility;


import commands.*;
import exceptions.CommandExecutionException;
import exceptions.RecursionDepthException;
import managers.CollectionManager;


import java.util.HashMap;
import java.util.Map;

/**
 * Класс, вызывающий выполнение команд
 */
public class Invoker {
    Map<String, AbstractCommand> commandList = new HashMap<>();
    public static int invokersCount = 0;


    public Invoker() {
        commandList.put("help", new Help());
        commandList.put("info", new Info());
        commandList.put("show", new Show());
        commandList.put("update", new Update());
        commandList.put("execute_script", new ExecuteScript());
        commandList.put("remove_by_id", new RemoveById());
        commandList.put("clear", new Clear());
        commandList.put("exit", new Exit());
        commandList.put("save", new Save());
        commandList.put("add_if_max", new AddIfMax());
        commandList.put("shuffle", new Shuffle());
        commandList.put("remove_greater", new RemoveGreater());
        commandList.put("remove_all_by_should_be_expelled", new RemoveAllByShouldBeExpelled());
        commandList.put("count_less_than_semester_enum", new CountLessThanSemesterEnum());
        commandList.put("print_field_descending_average_mark", new PrintFieldDescendingAverageMark());
        commandList.put("add", new Add());
        incrementInvokersCount();
        if (invokersCount > 15){
            throw new RecursionDepthException("Превышена максимальная глубина рекурсии (15)");
        }
    }

    /**
     * Запуск парсинга команд и их последующее исполнение
     * @param console консоль ввода-вывода
     * @param collectionManager менеджер коллекций
     */
    public void run(Console console, CollectionManager collectionManager) {
        if (console instanceof StandartConsole) console.print("> ");
        AbstractCommand command;

        while (console.hasNextLine()) {
            String line = console.nextLine();
            if (line == null) line= "\n";
            String[] tokens = line.split(" ");
            String[] args = new String[tokens.length - 1];
            System.arraycopy(tokens, 1, args, 0, tokens.length - 1);
            command = commandList.get(tokens[0]);

            try{
                command.setConsole(console);
                command.execute(collectionManager, args);
            }
            catch (NullPointerException e){
                console.println("Неизвестная команда: " + tokens[0]);
                console.println("Используйте help для получения справки по командам");
            }
            catch (CommandExecutionException e) {
                console.println("при выполнении команды возникла ошибка " + e.getMessage());
            }

            finally {
                if (console instanceof StandartConsole) console.print("> ");
            }
        }
        if (console instanceof StandartConsole){
            console = new StandartConsole();
            System.out.println("\nДля правильного выхода из программы введите exit");
            this.run(console, collectionManager);
        } else decrementInvokersCount();
        }

    /**
     * Увеличение счетчика количества одновременно запущенных Invoker
     */
        public static void incrementInvokersCount() {
        invokersCount++;
        }

    /**
     * Уменьшение счетчика количества одновременно запущенных Invoker
     */
        public static void decrementInvokersCount() {
        invokersCount--;
        }
    }

