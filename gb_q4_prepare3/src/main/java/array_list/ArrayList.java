package array_list;

import common.ListInterface;
import linked_list.LinkedList;

import java.util.Arrays;

public class ArrayList<E> implements ListInterface<E> {

    private static final int DEFAULT_CAPACITY = 8;

    private E[] data;
    private int size;

    private int calcNewLength() {
        return size == 0 ? DEFAULT_CAPACITY : size * 2;
    }

    public ArrayList(int size) {
        this.data = (E[])new Object[size];
        this.size = 0;
    }

    public ArrayList(E[] data) {
        this.data = Arrays.copyOf(data, data.length);
        this.size = data.length;
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void add(E val) {
        if(data.length==size){
            this.data = Arrays.copyOf(data, calcNewLength());
        }
        data[size++]=val;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    @Override
    public void insert(int index, E val) {
        checkIndex(index);
        if(size == data.length) {
            this.data = Arrays.copyOf(data, calcNewLength());
        }
        int pointer = size;
        while(index<pointer) {
            data[pointer] = data[pointer-1];
            pointer--;
        }
        data[index] = val;
        size++;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if(size==0){
            return;
        }
        while(index<size-1) {
            data[index] = data[index+1];
            index++;
        }
        size--;
    }

    @Override
    public int indexOf(E val) {
        int pointer = 0;
        while(pointer<size) {
            if(data[pointer].equals(val)){
                return pointer;
            }
            pointer++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public void display() {
        System.out.print("{");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);
            if(i<size-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

}
