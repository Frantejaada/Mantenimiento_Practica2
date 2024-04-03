package org.mps.deque;
//Hecho por Francisco Javier Tejada Martín

import java.util.Comparator;

public class DoubleLinkedList<T> implements DoubleLinkedQueue<T> {

    private LinkedNode<T> first;
    private LinkedNode<T> last;
    private int size;

    public DoubleLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void prepend(T value) {
        size++;
        LinkedNode<T> node = new LinkedNode<T>(value, null, first);
        if (size == 2){
            this.last.setPrevious(node);
            node.setNext(last);
        }
        if (size == 1) this.last = node;
        if (size > 2)  this.first.setPrevious(node);
        this.first = node;
    }

    @Override
    public void append(T value) {
        size ++;
        LinkedNode<T> node = new LinkedNode<T>(value, last, null);
        if (size == 2){
            first.setNext(node);
            node.setPrevious(first);
        }
        if (size == 1) this.first = node;
        if (size > 2) this.last.setNext(node);
        this.last = node;
    }

    @Override
    public void deleteFirst() {
        if (first == null) throw new DoubleLinkedQueueException("Doesn't exist the first element");
        this.first = first.getNext();
        if (size == 1){
            this.last = null;
        }
        if (first != null)
            first.setPrevious(null);
        size--;
    }

    @Override
    public void deleteLast() {
        if (last == null) throw new DoubleLinkedQueueException("Doesn't exist the last element");
        this.last = last.getPrevious();
        if (size == 1){
            this.first = null;
        }
        if (last != null) {
            last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        if (first == null) throw new DoubleLinkedQueueException("Doesn't exist the first element");
        return first.getItem();
    }

    @Override
    public T last() {
        if (last == null) throw new DoubleLinkedQueueException("Doesn't exist the last element");
        return last.getItem();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index){
        if(index >= this.size) throw new IndexOutOfBoundsException();

        LinkedNode<T> currentNode = this.first;
        for (int i = 0; i < index; i++)
        {
            currentNode = currentNode.getNext();
        }
        return currentNode.getItem();
    }

    @Override
    public boolean contains(T value){
        LinkedNode<T> currentNode = this.first;
        for (int i = 0; i < this.size; i++)
        {
            if (currentNode.getItem() == value)
                return true;
            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public void remove(T value){
        LinkedNode<T> currentNode = this.first;
        LinkedNode<T> previousNode = this.first.getPrevious();
        boolean found = true;
        for (int i = 0; i < this.size && found; i++)
        {
            if (currentNode.getItem() == value)
            {
                if (i == 0)
                {
                    this.first = first.getNext();
                    this.first.setPrevious(null);
                }
                else if (i == size - 1)
                {
                    this.last = last.getPrevious();
                    this.last.setNext(null);
                }
                else {
                    previousNode.setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(previousNode);
                }
                found = false;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator){
        for (LinkedNode<T> i = this.first; i != null; i = i.getNext()) {
            for (LinkedNode<T> j = this.first; j.getNext() != null; j = j.getNext()) {
                if (comparator.compare(j.getItem(), j.getNext().getItem()) > 0) {
                    T temp = j.getItem();
                    j.setItem(j.getNext().getItem());
                    j.getNext().setItem(temp);
                }
            }
        }
    }

}
