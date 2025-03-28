package commands;

import managers.CollectionManager;

import java.util.Stack;

/**
 * Команда для очистки коллекции
 */
public class Clear extends AbstractCommand {
    /**
     * Исполнение команды
     * @param manager Менеджер коллекции
     * @param args Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args){
        manager.setCollection(new Stack<>());
        console.println("Коллекция успешно очищена");
    }
}
