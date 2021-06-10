package ru.hse.cs.seminar04;

import java.util.Objects;

class Node<T> {
    // элемент лежащий в узле
    public final T element;
    // ссылка на следующий элемент
    public Node<T> next;
    // ссылка на предыдущий элемент
    public Node<T> previous;

    // Инициализация узла
    public Node(T element, Node<T> previous, Node<T> next) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Для удаления ссылок на элементы
     */
    public void dispose() {
        next = null;
        previous = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return element.equals(node.element);
    }


    @Override
    public int hashCode() {
        return Objects.hash(element);
    }


}

