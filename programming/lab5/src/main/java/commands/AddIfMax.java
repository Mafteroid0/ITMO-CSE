package commands;

import models.StudyGroup;
import managers.AskManager;
import managers.CollectionManager;

import java.util.Collections;

/**
 * Команда добавляющая элемент
 */
public class AddIfMax extends AbstractCommand {

    /**
     * Исполнение команды
     * @param manager Менеджер коллекции
     * @param args Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args){
        AskManager askmanager = new AskManager(console);
        StudyGroup studyGroup = askmanager.askStudyGroup();
        if (studyGroup.compareTo(Collections.max(manager.getCollection())) > 0) {
            studyGroup.setId(manager.getPerfectId());
            manager.addElement(studyGroup);
            console.println("Объект успешно добавлен в коллекцию.");
        } else {
            console.println("Новый объект не превышает значение максимального.");
        }

    }
}
