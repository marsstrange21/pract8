package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class WaitList <E> implements IWaitList<E>{
    protected ConcurrentLinkedQueue<E> components;

    public WaitList() {
        components = new ConcurrentLinkedQueue<>();
    }

    public WaitList(Collection<E> collection) {
        components = new ConcurrentLinkedQueue<>(collection);
    }

    @Override
    public String toString() {
        return "WaitList{" +
                "components=" + components +
                '}';
    }

    @Override
    public void add(E el) {
        components.add(el);
    }

    @Override
    public E remove() {
        if(isEmpty())
            throw new IllegalStateException("Невозможно удалить элемент из пустой очереди");
        return components.remove();
    }

    @Override
    public boolean contains(E el) {
        boolean result = false;
        for (int i = 0; i < components.size(); i++) {
            E new_el = components.remove();
            if (new_el.equals(el))
                result = true;
            components.add(new_el);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection coll) {
        ArrayList<E> al = new ArrayList<>(coll);
        for(int i = 0; i < coll.size(); i++){
            boolean res = false;
            for(int j = 0; j < components.size(); j++){
                E el = components.remove();
                if(el.equals(al.get(i))) res = true;
                components.add(el);
            }
            if(!res) return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return components.isEmpty();
    }
}
