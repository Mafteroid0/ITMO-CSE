package commands;

import exceptions.CommandExecutionException;
import models.StudyGroup;
import managers.CollectionManager;

import java.util.Stack;

/**
 * Команда сохраняющая коллекцию в файл
 */
public class Save extends AbstractCommand {

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {
        Stack<StudyGroup> studyGroupList = manager.getCollection();
        try {
            manager.saveCollection(studyGroupList);
        } catch (Exception e) {
            throw new CommandExecutionException("Не удаётся сохранить коллекцию.", e);

        }



    }
}
