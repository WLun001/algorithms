package benchmark;

import java.util.*;

public class SetListPerformanceTest {
    static final int N = 50000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        Collections.shuffle(list);

        Collection<Integer> set1 = new HashSet<>(list);
        print("HashSet search", getSearchTime(set1));
        print("HashSet remove", getRemoveTime(set1));

        Collection<Integer> set2 = new LinkedHashSet<>(list);
        print("LinkedHashSet search", getSearchTime(set2));
        print("LinkedHashSet remove", getRemoveTime(set2));

        Collection<Integer> set3 = new TreeSet<>(list);
        print("TreeSet search", getSearchTime(set3));
        print("TreeSet remove", getRemoveTime(set3));

        Collection<Integer> list1 = new ArrayList<>(list);
        print("ArrayList search", getSearchTime(list1));
        print("ArrayList remove", getRemoveTime(list1));

        Collection<Integer> list2 = new LinkedList<>(list);
        print("LinkedList search", getSearchTime(list2));
        print("LinkedList remove", getRemoveTime(list2));

    }

    //TODO: add while, foreach, iterator, stream
    private static long getSearchTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            boolean contains = c.contains((int) (Math.random() * 2 * N));
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long getRemoveTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) c.remove(i);
        return System.currentTimeMillis() - startTime;
    }

    private static void print(String message, long time) {
        System.out.println(message + ": " + time + " milliseconds");
    }
}
