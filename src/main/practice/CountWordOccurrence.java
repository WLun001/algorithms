package practice;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;

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

    }

    public static Map<String, Integer> wordsCountOccurrence(ArrayList<String> words) {

        return words.stream().collect(groupingBy(Function.identity(), summingInt(e -> 1)));

    }
}
