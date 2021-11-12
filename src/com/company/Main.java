package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Mars");
        al.add("Venera");

        WaitList<String> wl = new WaitList<>();
        wl.add("Earth");
        wl.add("Mars");
        wl.add("Venera");
        System.out.println(wl);
        System.out.println(wl.remove());
        System.out.println(wl);
        System.out.println(wl.isEmpty());
        System.out.println(wl.contains("Earth"));
        System.out.println(wl.containsAll(al));

        System.out.println();

        BoundedWaitList<String> bwl = new BoundedWaitList<>(3);
        bwl.add("a");
        bwl.add("b");
        bwl.add("c");
        System.out.println(bwl);
        try{
            bwl.add("d");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(bwl);
        System.out.println(bwl.getCapacity());

        System.out.println();
        bwl = new BoundedWaitList<String>(al);
        System.out.println(bwl.getCapacity());
        try{
            bwl.add("d");
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println();

        UnfairWaitList<String> uwl = new UnfairWaitList<>();
        uwl.add("vasya");
        uwl.add("petya");
        uwl.add("marina");
        uwl.add("ola");
        uwl.add("katya");
        uwl.add("ola");
        uwl.add("sasha");
        System.out.println(uwl);
        uwl.remove("ola");
        System.out.println(uwl);
        uwl.moveToBack("vasya");
        System.out.println(uwl);
    }
}
