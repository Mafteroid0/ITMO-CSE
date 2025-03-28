package commands;

import managers.CollectionManager;

/**
 *  Команда завершающая программу
 */
public class Exit extends AbstractCommand {
    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args){
        System.exit(0);
    }
}
