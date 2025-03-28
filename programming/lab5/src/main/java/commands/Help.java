package commands;

import managers.CollectionManager;

/**
 * Команда для вывода списка команд
 */
public class Help extends AbstractCommand {

    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        console.println("""
                help : вывести справку по доступным командам
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
                add {element} : добавить новый элемент в коллекцию
                update id {element} : обновить значение элемента коллекции, id которого равен заданному
                remove_by_id id : удалить элемент из коллекции по его id
                clear : очистить коллекцию
                save : сохранить коллекцию в файл
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                exit : завершить программу (без сохранения в файл)
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
                shuffle : перемешать элементы коллекции в случайном порядке
                remove_greater {element} : удалить из коллекции все элементы, превышающие заданный
                remove_all_by_should_be_expelled shouldBeExpelled : удалить из коллекции все элементы, значение поля shouldBeExpelled которого эквивалентно заданному
                count_less_than_semester_enum semesterEnum : вывести количество элементов, значение поля semesterEnum которых меньше заданного
                print_field_descending_average_mark : вывести значения поля averageMark всех элементов в порядке убывания""");



    }
}
