package common;

public interface ListInterface<E> {
    void add(E val);
    E get(int index);
    void insert(int index, E val);
    void remove(int index);
    int indexOf(E val);
    int size();
    void clear();
    boolean isEmpty();
    void display();
}
