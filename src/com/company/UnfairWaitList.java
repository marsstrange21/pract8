package com.company;

public class UnfairWaitList <E> extends WaitList<E> {

    public UnfairWaitList() {
        super();
    }

    public void remove (E element){
        // components.remove(element)
        boolean removed = false;
        for(int i = 0; i < components.size(); i++){
            E el = components.remove();
            if(!removed && el.equals(element)){
                removed = true; // i--
            }else{
                components.add(el);
            }
        }
        if(removed){
            components.add(components.remove());
        }
    }

    public void moveToBack(E element) {
        int prev_size = components.size();
        remove(element);
        if (components.size() < prev_size) {
            components.add(element);
        }
    }
}
