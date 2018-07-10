package benchmark;

import java.util.LinkedList;

public class TestLinkedListIterators {
    private static int SIZE = 10000;

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) list.add(i);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i ++) list.get(i);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        int x;
        for (int i : list) x = i;
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        final int[] z = new int[1];
        list.stream().map(y -> z[0] = y);
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
