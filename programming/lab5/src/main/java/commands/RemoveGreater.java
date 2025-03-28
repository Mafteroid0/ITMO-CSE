package commands;

import models.StudyGroup;
import managers.AskManager;
import managers.CollectionManager;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Команда удаляющая все элементы превышающие заданный
 */
public class RemoveGreater extends AbstractCommand{

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        AskManager askmanager = new AskManager(console);
        StudyGroup newGroup = askmanager.askStudyGroup();
        Stack<StudyGroup> studyGroups = manager.getCollection();

        List<Long> removeList = new ArrayList<>();
        for (StudyGroup group : studyGroups) {
            if (newGroup.compareTo(group) < 0) {
                removeList.add(group.getId());
            }
        }
        for (Long id : removeList) {
            manager.removeById(id);
        }
        if (removeList.isEmpty()) {
            console.println("В коллекции отсутствуют элементы превышающие заданный.");
        }else {
            console.println("Успешно удалено " + removeList.size() + " элементов");
        }

    }
}
