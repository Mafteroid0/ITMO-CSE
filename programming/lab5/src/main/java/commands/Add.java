package commands;

import models.StudyGroup;
import managers.AskManager;
import managers.CollectionManager;

/**
 * Команда добавляющая элемент в коллекцию
 */
public class Add extends AbstractCommand{


    /**
     * Исполнение команды
     * @param manager Менеджер коллекции
     * @param args Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        AskManager askmanager = new AskManager(console);
        StudyGroup studyGroup = askmanager.askStudyGroup();
        studyGroup.setId(manager.getPerfectId());
        manager.addElement(studyGroup);
        console.println("Объект успешно добавлен в коллекцию.");

    }

}
