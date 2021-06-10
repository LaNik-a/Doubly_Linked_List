package ru.hse.cs.seminar04;

public interface MyList<T> {

    /**
     * Добавление элемента в двусвязный список
     *
     * @param item элемент для добавления
     */
    void add(T item);

    /**
     * Получить размер списка
     *
     * @return размер списка
     */
    int getSize();

    /**
     * Удаление элемента по индексу из списка
     *
     * @param index индекс удаляемого элемента
     */
    void remove(int index);

    /**
     * Получение элемента по индексу
     *
     * @param index индекс элемента
     * @return элемент списка
     */
    T getElement(int index);
}
