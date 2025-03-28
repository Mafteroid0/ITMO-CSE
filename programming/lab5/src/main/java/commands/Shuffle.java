package commands;

import models.StudyGroup;
import managers.CollectionManager;

import java.util.Collections;
import java.util.Stack;

/**
 * Команда, перемешивающая все элементы коллекции в случайном порядка
 */
public class Shuffle extends AbstractCommand {

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        Stack<StudyGroup> studyGroups = manager.getCollection();
        Collections.shuffle(studyGroups);
        manager.setCollection(studyGroups);
    }
}
