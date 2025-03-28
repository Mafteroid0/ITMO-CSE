package commands;

import models.StudyGroup;
import managers.CollectionManager;

import java.util.Stack;

/**
 * Команда, выводящая строковое представление всей коллекции
 */
public class Show extends AbstractCommand{

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        Stack<StudyGroup> studyGroups = manager.getCollection();
        for (StudyGroup studygroup : studyGroups) {
            console.println(studygroup);
        }
    }
}
