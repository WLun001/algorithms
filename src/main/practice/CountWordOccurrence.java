package practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class CountWordOccurrence {
    public static void main(String[] args) {
        ArrayList<String> wordsList = new ArrayList<>();
        wordsList.add("hello");
        wordsList.add("bye");
        wordsList.add("ciao");
        wordsList.add("ciao");
        wordsList.add("bye");
        System.out.println(wordsCountOccurrence(wordsList));
        System.out.println(findDuplicate(wordsList));
        System.out.println(wordsList.removeAll(findDuplicateV2(wordsList)));
    }

    public static <T> Map<T, Integer> wordsCountOccurrence(ArrayList<T> words) {
        return words.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));
    }

    public static <T> List<T> findDuplicate(Collection<T> c) {
        return c.stream()
                .distinct()
                .filter(i -> Collections.frequency(c, i) > 1)
                .collect(Collectors.toList());
    }

    public static List findDuplicateV2(Collection c) {
        Set unique = new HashSet();
        Set duplicate = new HashSet();
        for (Object name : c) {
            if (!unique.add(name)) duplicate.add(name);
        }
        ArrayList duplicateArr = new ArrayList();
        duplicateArr.addAll(duplicate);
        return duplicateArr;
    }
}
