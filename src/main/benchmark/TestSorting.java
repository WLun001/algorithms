package benchmark;

import java.util.*;

public class TestSorting {

    public static void main(String[] args) {

        final int N = 9000000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        Collections.shuffle(list);
        long startTime =  System.currentTimeMillis();
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        long stopTime = System.currentTimeMillis();
        long time0 = stopTime - startTime;


        long startTime1 =  System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        linkedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(o2, o1);
            }
        });
        long time1 = System.currentTimeMillis() - startTime1;

        long startTime2 =  System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(o2, o1);
            }
        });
        long time2 = System.currentTimeMillis() - startTime2;

        System.out.println("TreeSet sort: " + time0);
        System.out.println("LinkedList sort: " + time1);
        System.out.println("ArrayList sort: " + time2);


    }
}
