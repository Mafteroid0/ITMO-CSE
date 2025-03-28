package commands;

import models.StudyGroup;
import managers.CollectionManager;

import java.util.Stack;

/**
 * Команда выводящая информацию о коллекции
 */
public class Info extends AbstractCommand{

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        Stack<StudyGroup> studyGroups = manager.getCollection();
        console.println("Информация о коллекции");
        console.println("Тип: " + studyGroups.getClass().getName());
        console.println("кол-во элементов: " + studyGroups.size());
        console.println("Дата инициалищзации: " + manager.getInitializationDate());
        console.println("Хеш код: " + studyGroups.hashCode());

    }
}
