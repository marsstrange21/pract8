package com.company;

import java.util.Collection;

public interface IWaitList <E>{
    void add(E el); // add element

    E remove();
    boolean contains(E el);
    boolean containsAll(Collection<E> coll);
    boolean isEmpty();
}
