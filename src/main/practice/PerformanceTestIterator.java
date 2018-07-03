package practice;

import java.util.ArrayList;
import java.util.Iterator;

public class PerformanceTestIterator {
    private static int SIZE = 10000;
    public static void main(String[] args) {
        ArrayList<Integer> obj = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) obj.add(i);

        long startTime = System.nanoTime();
        for (int i = 0; i < obj.size(); i++) {
            int anObj = obj.get(i);
            if (anObj % 2 == 0)
                System.out.println(anObj);
        }
        long stopTime = System.nanoTime();
        double time0 = (stopTime - startTime) / 1000000000.0;

        startTime = System.nanoTime();
        for (int anObj : obj) {
            if (anObj % 2 == 0)
                System.out.println(anObj);
        }
        stopTime = System.nanoTime();
        double time1 = (stopTime - startTime) / 1000000000.0;

        startTime = System.nanoTime();
        Iterator<Integer> iterable = obj.iterator();
        while (iterable.hasNext()) {
            int i = iterable.next();
            if (i % 2 == 0)
                System.out.println(iterable.next());
        }
        stopTime = System.nanoTime();
        double time2 = (stopTime - startTime) / 1000000000.0;

        //using lambda
        startTime = System.nanoTime();
        obj.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
        stopTime = System.nanoTime();
        double time3 = (stopTime - startTime) / 1000000000.0;

        startTime = System.nanoTime();
        obj.parallelStream().filter(i -> i % 2 == 0).forEach(System.out::println);
        stopTime = System.nanoTime();
        double time4 = (stopTime - startTime) / 1000000000.0;

        System.out.println("For loop: " + time0);
        System.out.println("For each: " + time1);
        System.out.println("Iterator: " + time2);
        System.out.println("Stream foreach: " + time3);
        System.out.println("Parallel stream Foreach: " + time4);
    }
}
