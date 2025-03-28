package commands;

import exceptions.CommandExecutionException;
import exceptions.WrongIdException;
import models.StudyGroup;
import managers.AskManager;
import managers.CollectionManager;


/**
 * Команда, обновляющая элемент по его id
 */
public class Update extends AbstractCommand{

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     * @throws CommandExecutionException ошибка при выполнении команды
     */
    @Override
    public void execute(CollectionManager manager, String[] args) throws CommandExecutionException {
        AskManager askManager = new AskManager(console);

        try{
            Long id = Long.parseLong(args[0]);
            if (!manager.getIdList().contains(id)) throw new CommandExecutionException("Элемента с таким id не существует",
                    new RuntimeException());
            java.util.Date date = manager.getById(id).getCreationDate();
            manager.removeById(id);
            StudyGroup newGroup = askManager.askStudyGroup();
            newGroup.setId(id);
            newGroup.setCreationDate(date);

        } catch (NumberFormatException e) {
            throw new CommandExecutionException("Неверно указан id. Ожидаемый формат: целое число.", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CommandExecutionException("Отсутствуют необходимые аргументы команды.", e);
        } catch (WrongIdException e){
            throw new CommandExecutionException(e.getMessage(), e);
        }

    }
}
