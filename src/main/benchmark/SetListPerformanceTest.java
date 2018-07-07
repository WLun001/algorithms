package benchmark;

import java.util.*;
import java.util.stream.IntStream;

public class SetListPerformanceTest {
    static final int N = 50000;

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        Collections.shuffle(list);

        Collection<Integer> set1 = new HashSet<>(list);
        print("HashSet search WHILE", getSearchTime(set1, LoopType.WHILE));
        print("HashSet search FOR", getSearchTime(set1, LoopType.FOR));
        print("HashSet search STREAM_FOREACH", getSearchTime(set1, LoopType.STREAM_FOREACH));
        print("HashSet search STREAM_FOREACH_ORDERED", getSearchTime(set1, LoopType.STREAM_FOREACH_ORDERED));

        print("HashSet remove WHILE", getRemoveTime(set1, LoopType.WHILE));
        print("HashSet remove FOR", getRemoveTime(set1, LoopType.FOR));
        print("HashSet remove STREAM_FOREACH", getRemoveTime(set1, LoopType.STREAM_FOREACH));
        print("HashSet remove STREAM_FOREACH_ORDERED", getRemoveTime(set1, LoopType.STREAM_FOREACH_ORDERED));

        Collection<Integer> set2 = new LinkedHashSet<>(list);
        print("LinkedHashSet search WHILE", getSearchTime(set2, LoopType.WHILE));
        print("LinkedHashSet search FOR", getSearchTime(set2, LoopType.FOR));
        print("LinkedHashSet search STREAM_FOREACH", getSearchTime(set2, LoopType.STREAM_FOREACH));
        print("LinkedHashSet search STREAM_FOREACH_ORDERED", getSearchTime(set2, LoopType.STREAM_FOREACH_ORDERED));

        print("LinkedHashSet remove WHILE", getRemoveTime(set2, LoopType.WHILE));
        print("LinkedHashSet remove FOR", getRemoveTime(set2, LoopType.FOR));
        print("LinkedHashSet remove STREAM_FOREACH", getRemoveTime(set2, LoopType.STREAM_FOREACH));
        print("LinkedHashSet remove STREAM_FOREACH_ORDERED", getRemoveTime(set2, LoopType.STREAM_FOREACH_ORDERED));

        Collection<Integer> set3 = new TreeSet<>(list);
        print("TreeSet search WHILE", getSearchTime(set3, LoopType.WHILE));
        print("TreeSet search FOR", getSearchTime(set3, LoopType.FOR));
        print("TreeSet search STREAM_FOREACH", getSearchTime(set3, LoopType.STREAM_FOREACH));
        print("TreeSet search STREAM_FOREACH_ORDERED", getSearchTime(set3, LoopType.STREAM_FOREACH_ORDERED));

        print("TreeSet remove WHILE", getRemoveTime(set3, LoopType.WHILE));
        print("TreeSet remove FOR", getRemoveTime(set3, LoopType.FOR));
        print("TreeSet remove STREAM_FOREACH", getRemoveTime(set3, LoopType.STREAM_FOREACH));
        print("TreeSet remove STREAM_FOREACH_ORDERED", getRemoveTime(set3, LoopType.STREAM_FOREACH_ORDERED));

        Collection<Integer> list1 = new ArrayList<>(list);
        print("ArrayList search WHILE", getSearchTime(list1, LoopType.WHILE));
        print("ArrayList search FOR", getSearchTime(list1, LoopType.FOR));
        print("ArrayList search STREAM_FOREACH", getSearchTime(list1, LoopType.STREAM_FOREACH));
        print("ArrayList search STREAM_FOREACH_ORDERED", getSearchTime(list1, LoopType.STREAM_FOREACH_ORDERED));

        print("ArrayList remove WHILE", getRemoveTime(list1, LoopType.WHILE));
        print("ArrayList remove FOR", getRemoveTime(list1, LoopType.FOR));
        print("ArrayList remove STREAM_FOREACH", getRemoveTime(list1, LoopType.STREAM_FOREACH));
        print("ArrayList remove STREAM_FOREACH_ORDERED", getRemoveTime(list1, LoopType.STREAM_FOREACH_ORDERED));

        Collection<Integer> list2 = new LinkedList<>(list);
        print("LinkedList search WHILE", getSearchTime(list2, LoopType.WHILE));
        print("LinkedList search FOR", getSearchTime(list2, LoopType.FOR));
        print("LinkedList search STREAM_FOREACH", getSearchTime(list2, LoopType.STREAM_FOREACH));
        print("LinkedList search STREAM_FOREACH_ORDERED", getSearchTime(list2, LoopType.STREAM_FOREACH_ORDERED));

        print("LinkedList remove WHILE", getRemoveTime(list2, LoopType.WHILE));
        print("LinkedList remove FOR", getRemoveTime(list2, LoopType.FOR));
        print("LinkedList remove STREAM_FOREACH", getRemoveTime(list2, LoopType.STREAM_FOREACH));
        print("LinkedList remove STREAM_FOREACH_ORDERED", getRemoveTime(list2, LoopType.STREAM_FOREACH_ORDERED));
    }

    private static long getSearchTime(Collection<Integer> c, LoopType loopType) {
        long startTime = System.currentTimeMillis();
        switch (loopType) {
            case WHILE:
                int j = 0;
                while (j < N) {
                    boolean contains = c.contains((int) (Math.random() * 2 * N));
                    j++;
                }
                break;
            case FOR:
                for (int i = 0; i < N; i++) {
                    boolean contains = c.contains((int) (Math.random() * 2 * N));
                }
                break;
            case STREAM_FOREACH:
                IntStream.range(0, N).forEach(i -> {
                    boolean contains = c.contains((int) (Math.random() * 2 * N));
                });
                break;
            case STREAM_FOREACH_ORDERED:
                IntStream.range(0, N).forEachOrdered(i -> {
                    boolean contains = c.contains((int) (Math.random() * 2 * N));
                });
                break;
        }
        return System.currentTimeMillis() - startTime;
    }

    private static long getRemoveTime(Collection<Integer> c, LoopType loopType) {
        long startTime = System.currentTimeMillis();
        switch (loopType) {
            case WHILE:
                int i = 0;
                while (i < N) {
                    c.remove(i);
                    i++;
                }
                break;
            case FOR:
                for (int j = 0; j < N; j++) c.remove(j);
                break;
            case STREAM_FOREACH:
                IntStream.range(0, N).forEach(c::remove);
                break;
            case STREAM_FOREACH_ORDERED:
                IntStream.range(0, N).forEachOrdered(c::remove);
                break;
        }
        return System.currentTimeMillis() - startTime;
    }

    private static void print(String message, long time) {
        System.out.println(message + ": " + time + " milliseconds");
    }

    enum LoopType {WHILE, FOR, STREAM_FOREACH, STREAM_FOREACH_ORDERED}
}
