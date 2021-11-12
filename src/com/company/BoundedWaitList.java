package com.company;

import java.util.Collection;

public class BoundedWaitList<E> extends WaitList<E>{
    private int capacity;

    public int getCapacity() {
        return capacity;
    }

    public BoundedWaitList(int capacity) {
        super();
        if(capacity <= 0) throw new IllegalArgumentException("Вы ввели отрицательный размер");
        this.capacity = capacity;
    }

    //Overrides constructor of copies from superclass to set max capacity equal to collection's size.

    public BoundedWaitList(Collection<E> coll){
        super(coll);
        this.capacity = coll.size();
    }

    public void add(E element) {
        if(components.size() == capacity) throw new IllegalStateException("Очередь уже была заполнена");
        components.add(element);
    }

    @Override
    public String toString() {
        return "BoundedWaitList{" +
                "capacity=" + capacity +
                ", components=" + components +
                '}';
    }
}
