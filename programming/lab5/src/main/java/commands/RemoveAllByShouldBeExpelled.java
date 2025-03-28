package commands;

import exceptions.CommandExecutionException;
import models.StudyGroup;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Команда удаляющая из коллекции все элементы со значением shouldBeExpelled эквивалентному данному
 */
public class RemoveAllByShouldBeExpelled extends AbstractCommand {
    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {

        try{
            Integer shouldBeExpelled = Integer.parseInt(args[0]);
            Stack<StudyGroup> studyGroups = manager.getCollection();

            List<Long> removeList = new ArrayList<>();

            for (StudyGroup group : studyGroups) {
                if (group.getShouldBeExpelled().equals(shouldBeExpelled)) removeList.add(group.getId());
            }

            for (Long id : removeList) {
                manager.removeById(id);
            }

            if (removeList.isEmpty()) {
                console.println("В коллекции отсутствуют элементы элементы, значение поля shouldBeExpelled которых эквивалентно заданному");
            }else {
                console.println("Успешно удалено " + removeList.size() + " элементов");
            }

        } catch (NumberFormatException e) {
            throw new CommandExecutionException("Неверно указано поле shouldBeExpelled. Ожидаемый формат: целое число.", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CommandExecutionException("Отсутствуют необходимые аргументы команды.", e);
        }
    }
}
