package commands;

import exceptions.CommandExecutionException;
import models.Semester;
import models.StudyGroup;
import managers.CollectionManager;

import java.util.Stack;

/**
 * Команда подсчитывающая количество элементов с semesterEnum меньшим данному
 */
public class CountLessThanSemesterEnum extends AbstractCommand{

    /**
     * Исполнение команды
     * @param manager Менеджер коллекции
     * @param args Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {

        try{
            Semester semester = Semester.valueOf(args[0].toUpperCase());
            Stack<StudyGroup> studyGroups = manager.getCollection();
            int count = 0;


            for (StudyGroup group : studyGroups) {
                if (group.getSemesterEnum().compareTo(semester) < 0) {
                    count++;
                }
            }


            if (count == 0) {
                console.println("В коллекции отсутствуют элементы элементы, значение поля semesterEnum которых эквивалентно заданному");
            }else {
                console.println("В коллекции " + count + " элементов со значением semesterEnum меньшим данному");
            }

        } catch (IllegalArgumentException e) {
            throw new CommandExecutionException("Неверно указано поле semesterEnum. Ожидаемые варианты:" +
                    " [FOURTH | FIFTH | SIXTH | SEVENTH | EIGHTH]", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CommandExecutionException("Отсутствуют необходимые аргументы команды.", e);
        }
    }
}
