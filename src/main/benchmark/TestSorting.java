package benchmark;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class TestSorting {

    public static void main(String[] args) {

        final int N = 1000000;
        List<Integer> list = new ArrayList<>();
        List<Box> list2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
            list2.add(new Box(i));
        }

        Collections.shuffle(list);
        Collections.shuffle(list2);

        long startTime = System.currentTimeMillis();
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        long stopTime = System.currentTimeMillis();
        long time0 = stopTime - startTime;

        long startTime1 = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        linkedList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(o2, o1);
            }
        });
        long time1 = System.currentTimeMillis() - startTime1;

        long startTime2 = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>(list);
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Double.compare(o2, o1);
            }
        });
        long time2 = System.currentTimeMillis() - startTime2;

        long startTime0 = System.currentTimeMillis();
        TreeSet<Box> treeSet2 = new TreeSet<>(list2);
        long stopTime0 = System.currentTimeMillis();
        long time01 = stopTime0 - startTime0;

        long startTime11 = System.currentTimeMillis();
        LinkedList<Box> linkedList2 = new LinkedList<>(list2);
        linkedList2.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getName(), o1.getName());
            }
        });
        long time11 = System.currentTimeMillis() - startTime11;

        long startTime22 = System.currentTimeMillis();
        ArrayList<Box> arrayList2 = new ArrayList<>(list2);
        arrayList2.sort(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                return Double.compare(o2.getName(), o1.getName());
            }
        });
        long time22 = System.currentTimeMillis() - startTime22;

        System.out.println("TreeSet sort: " + time0);
        System.out.println("TreeSet sort with custom object: " + time01);
        System.out.println("LinkedList sort: " + time1);
        System.out.println("LinkedList sort with custom object: " + time11);
        System.out.println("ArrayList sort: " + time2);
        System.out.println("ArrayList sort with custom object: " + time22);


    }

    static class Box implements Comparable<Box> {
        private int name;
        private int id;

        public Box(int name) {
            this.name = name;
            this.id = name * 100;
        }

        public int getName() {
            return name;
        }

        @Override
        public int compareTo(Box o) {
            return Double.compare(o.getName(), this.getName());
        }
    }

}
