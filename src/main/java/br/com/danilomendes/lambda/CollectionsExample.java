package br.com.danilomendes.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsExample {

    public static void main(String[] args) {


        List<String> listA = new ArrayList<>();
        listA.add("Strawberry");
        listA.add("Lemon");
        listA.add("Orange");
        listA.add("Apple");

        List<String> listB = new ArrayList<>();
        listB.addAll(listA);

        System.out.println("Fruits " + listA);

        java.util.Collections.sort(listA, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        System.out.println("Fruits by sort " + listA);

        System.out.println("Fruits List B = " + listB);
        listB.add("Blackberry");
        listB.add("Cherry");

        Collections.sort(listB, (a, b) -> a.compareTo(b));
        System.out.println("Fruits List B by sort = " + listB);
    }
}
