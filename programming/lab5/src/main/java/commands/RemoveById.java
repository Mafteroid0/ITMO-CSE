package commands;

import exceptions.CommandExecutionException;
import managers.CollectionManager;

/**
 * Команда удаляющая элемент из коллекции по его id
 */
public class RemoveById extends AbstractCommand{

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {
        try{
            Long id = Long.parseLong(args[0]);
            if (!manager.getIdList().contains(id)) throw new CommandExecutionException("Элемента с таким id не существует", new RuntimeException());
            manager.removeById(id);
            console.println("Элемент с ID " + id + " удален.");
        } catch (NumberFormatException e) {
            throw new CommandExecutionException("Неверно указан id. Ожидаемый формат: целое число.", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CommandExecutionException("Отсутствуют необходимые аргументы команды.", e);
        }
    }
}
