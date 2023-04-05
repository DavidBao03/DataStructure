package DataStructure.BookAlgrim.Chapter3.MyLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> previous;
        public Node<AnyType> next;

        public Node(AnyType data,Node<AnyType> previous,Node<AnyType> next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }
    }

    public MyLinkedList(){
        clear();
    }
    public void clear(){
        beginMarker = new Node<AnyType>(null,null,null);
        endMarker = new Node<AnyType>(null,beginMarker,null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return theSize == 0;
    }

    public boolean add(AnyType x){
        add(size(),x);
        return true;
    }

    public void add(int idx , AnyType x){
        addBefore(getNode(idx),x);
    }

    public AnyType get(int idx){
        return getNode(idx).data;
    }

    public AnyType set(int idx,AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<AnyType> p , AnyType x){
        Node<AnyType> newNode = new Node<>(x,p.previous,p);
        newNode.previous.next = newNode;
        p.previous = newNode;
        theSize++;
        modCount++;
    }

    private AnyType remove(Node<AnyType> p){
        p.next.previous = p.previous;
        p.previous.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }

    public Node<AnyType> getNode(int idx){
        Node<AnyType> p;

        if(idx < 0 || idx > size()){
            throw new IndexOutOfBoundsException();
        }

        if(idx < size()/2){
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        }else {
            p = endMarker;
            for (int i = size(); i > idx; i--) {
                p = p.previous;
            }
        }
        return p;
    }
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public Iterator<AnyType> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        public boolean hasNext(){
            return current != endMarker;
        }

        public AnyType next(){
            if(modCount != expectedModCount){
                throw new ConcurrentModificationException();
            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }

        public void remove() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            MyLinkedList.this.remove(current.previous);
            okToRemove = false;
            expectedModCount++;
        }
    }
}
