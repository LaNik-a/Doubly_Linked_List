package ru.hse.cs.seminar04;

public class Main<T> extends LinkedList<T> {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("Размер двусвязного списка: " + list.getSize());
        System.out.println("Третий элемент списка--> " + list.getElement(2));
        list.remove(2);
        System.out.println("Третий элемент списка после удаления--> " + list.getElement(2));
        System.out.println("Размер двусвязного списка после удаления: " + list.getSize());
    }


}
