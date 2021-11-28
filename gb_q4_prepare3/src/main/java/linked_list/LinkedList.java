package linked_list;

import common.ListInterface;

public class LinkedList<E> implements ListInterface<E> {

    private int size;
    private Node first;
    private Node last;

    class Node{
        E value;
        Node next;
        Node prev;

        public Node(E value, Node prev) {
            this.value = value;
            this.prev = prev;
        }
    }

    public LinkedList() {
        this.size = 0;
    }

    @Override
    public void add(E val) {
        Node newNode = new Node(val, last);
        if(last!=null){
            last.next = newNode;
        }
        last = newNode;
        if(first==null){
            first=newNode;
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getValue(getNode(index));
    }

    @Override
    public void insert(int index, E val) {
        Node node = getNode(index);
        Node newNode = new Node(val, node);
        if(node!=null) {
            newNode.next = node.next;
            node.next = newNode;
        }
        if(newNode.next==null){
            last = newNode;
        }
        if(newNode.prev==null){
            first = newNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        Node node = getNode(index);
        if(node!=null){
            if(node.prev!=null){
                node.prev.next = node.next;
            }else{
                first = node.next;
            }
            if(node.next!=null){
                node.next.prev = node.prev;
            }else{
                last = node.prev;
            }
            node=null;
        }
    }

    @Override
    public int indexOf(E val) {
        Node node = first;
        int index = 0;
        while(node!=null){
            if(val.equals(node.value)){
                return index;
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    protected E getValue(Node node){
        return (node == null) ? (null) : node.value;
    }

    protected Node getNode(int index){
        if(index>size()){
            return null;
        }
        Node node = first;
        int seek = 0;
        while(node!=null && seek < index){
            node = node.next;
            seek++;
        }
        return node;
    }

    @Override
    public void display() {
        System.out.print("{");
        Node node =first;
        while(node!=null) {
            System.out.print(node.value);
            node = node.next;
            if(node!=null){
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
