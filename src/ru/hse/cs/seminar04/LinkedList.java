package ru.hse.cs.seminar04;

import java.util.Optional;

class LinkedList<T> implements MyList<T> {

    // размер списка
    private int size;
    // узел начала двусвязного списка
    private Node<T> head;
    // узел конца двусвязного списка
    private Node<T> tail;

    @Override
    public void add(T item) {
        if (size == 0) {
            // создаем первый узел без ссылок на другие так как их еще нет
            head = new Node<>(item, null, null);
            // когда 1 элемент он и хвост и голова!
            tail = head;
            size++;
            return;
        }
        // создаем элемент в конце двусвязного списка, он последний поэтому нет ссылки на следующий узел
        // а ссылка на предыдущий это бывший хвост
        Node<T> newNode = new Node<>(item, tail, null);
        // ссылка на следующий элемент бывшего хвоста это добавленный в конец элемент
        tail.next = newNode;
        // теперь хвост только что добавленный в конец элемент
        tail = newNode;
        size++;
    }

    /**
     * Получение узла по индексу
     *
     * @param index индекс узла
     * @return возвращает узел
     * @throws IndexOutOfBoundsException узла по такому индексу не существует
     */
    private Node<T> getNode(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // ссылка на голову
        Node<T> currentNode = head;
        // пробегаем все узлы по ссылкам до нужного индекса
        for (int i = 0; i < index; ++i) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        // получили нужный узел по индексу
        Node<T> removedNode = getNode(index);
        // если 1 элемент в списке
        if (size == 1) {
            head = null;
            tail = null;
            // удаляем голову
        } else if (removedNode == head) {
            // следующий элемент после бывшей головы становится головой
            head = head.next;
            // у головы нет ссылки на предыдущий элемент
            head.previous = null;
            // удаляем хвост
        } else if (removedNode == tail) {
            // хвостом становится предыдущий элемент бывшего хвоста
            tail = tail.previous;
            // у хвоста нет ссылки на следующий элемент
            tail.next = null;
            // удаляем элемент между головой и хвостом
        } else {
            // ссылка на предыдущий элемент удаляемого узла
            Node<T> previousNode = removedNode.previous;
            // ссылка на следующий элемент удаляемого узла
            Node<T> nextNode = removedNode.next;
            // предыдущий элемент удаляемого узла, теперь для него следующий элемент это следующий для удаляемого
            previousNode.next = nextNode;
            // предыдущий для следующего у удаляемого это предыдущий у удаляемого
            nextNode.previous = previousNode;
        }
        // удаление найденного узла по индексу
        removedNode.dispose();
        size--;
    }

    @Override
    public T getElement(int index) {
        // нашли узел по индексу
        Node<T> node = getNode(index);
        // взяли элемент в узле
        return node.element;
    }

    @Override
    public int getSize() {
        return size;
    }
}

