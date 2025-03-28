package managers;

import exceptions.WrongIdException;
import models.StudyGroup;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Менеджер, отвечающий за управление коллекцией
 */
public class CollectionManager { // Receiver (исполнитель)

    LocalDateTime initializationDate = LocalDateTime.now();
    DumpManager dumpManager;
    java.util.Stack<StudyGroup> studyGroups;

    public CollectionManager() {
        this.dumpManager = new DumpManager();
        studyGroups=dumpManager.loadCollection();
    }

    /**
     * Сохранение коллекции
     * @param studyGroups коллекция экземпляров класса StudyGroup
     */
    public void saveCollection(Stack<StudyGroup> studyGroups) {
        dumpManager.saveCollection(studyGroups);
    }

    /**
     * Добавление нового элемента в коллекцию
     * @param element экземпляр класса StudyGroup
     */
    public void addElement(StudyGroup element) {
        studyGroups.add(element);
    }

    /**
     * Геттер Коллекции экземпляров класса StudyGroup
     * @return коллекция экземпляров класса StudyGroup
     */
    public Stack<StudyGroup> getCollection() {
        return studyGroups;
    }

    /** Сеттер коллекции экземпляров класса StudyGroup
     * @param studyGroups коллекция экземпляров класса StudyGroup
     */
    public void setCollection(Stack<StudyGroup> studyGroups) {
        this.studyGroups = studyGroups;
    }

    /**
     * Получение времени инициализации коллекции
     * @return время инициализации коллекции
     */
    public LocalDateTime getInitializationDate() {
        return initializationDate;
    }

    /**
     * Получение экземпляра класса StudyGroup из коллекции по его id
     * @param id id элемента
     * @return экземпляр класса StudyGroup
     * @throws WrongIdException Неверно указанный id
     */
    public StudyGroup getById(Long id) throws WrongIdException {
        for (StudyGroup studyGroup : studyGroups) {
            if (studyGroup.getId().equals(id)) {
                return studyGroup;
            }
        }
        throw new WrongIdException("Элемента с таким id не существует");
    }

    /** Удаление экземпляра класса StudyGroup из коллекции по его id
     * @param id id элемента
     */
    public void removeById(Long id){

        for (int i = 0; i < studyGroups.size(); i++) {
            StudyGroup group = studyGroups.get(i);
            if (group.getId().equals(id)) {
                studyGroups.remove(i);

                break;
            }
    }}

    /** Получение Списка id всех экземпляров класса StudyGroup из коллекции
     * @return Список id всех экземпляров класса StudyGroup из коллекции
     */
    public List<Long> getIdList(){
        List<Long> idList = new ArrayList<>();
        for(StudyGroup studyGroup : studyGroups){
            idList.add(studyGroup.getId());
        }
        return idList;
    }

    /**
     * Получение самого оптимального id для нового экземпляра класса StudyGroup
     * @return Идеальный id для нового экземпляра класса StudyGroup
     */
    public Long getPerfectId(){
        List<Long> ids = getIdList();
        if (!ids.isEmpty()) {
            for (Long i = 1L; i <= Collections.max(ids)+1; i++) {
                if (!ids.contains(i)) {
                    return i;
                }
            }
        }
        return 1L;
    }
}
