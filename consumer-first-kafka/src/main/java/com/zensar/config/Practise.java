package com.zensar.config;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class Practise {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(90);
        al.add(80);
        al.add(70);
        al.add(60);
        al.add(50);
        al.add(50);

      Long l =   al.stream().collect(Collectors.summarizingInt(i->i)).getSum();
        System.out.println(l);
       int k= al.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
      Map<Object,Long> map =  al.stream().collect(Collectors.groupingBy(i->i,Collectors.counting()));
        System.out.println(map);
    }
}
