package commands;

import models.StudyGroup;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Команда выводящая Значения поля averageMark всех элементов в порядке убывания:
 */
public class PrintFieldDescendingAverageMark extends AbstractCommand{
    /**
     * @param manager Менеджер коллекции
     * @param args    Аргументы командной строки
     */
    @Override
    public void execute(CollectionManager manager, String[] args) {
        List<Long> avgMarksList = new ArrayList<>();
        for (StudyGroup studyGroup : manager.getCollection()){
            avgMarksList.add(studyGroup.getAverageMark());
        }
        if (avgMarksList.isEmpty()){
            console.println("В коллекции отсутствуют элементы. Используйте add чтобы создать новый.");
        }else {
            Collections.sort(avgMarksList);
            Collections.reverse(avgMarksList);
            console.println("Значения поля averageMark всех элементов в порядке убывания: " + avgMarksList);
        }
    }
}
