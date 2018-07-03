package practice;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class DisplayWords {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("animal");
        words.add("cat");
        words.add("bat");
        words.add("azure");

        System.out.println(Arrays.toString(duplicateAscending(words)));
        System.out.println(Arrays.toString(nonDuplicateAscending(words)));
    }

    /**
     * Displaying words in ascending alphabetical order, allow duplicates
     * @param words list of words
     * @return array of sorted words
     */
    public static String[] duplicateAscending(ArrayList<String> words) {
        String[] arrayWords = words.toArray(new String[0]);
        Arrays.sort(arrayWords);
        return arrayWords;
    }

    /**
     * Displaying words in ascending alphabetical order, doesn't allow duplicates
     * @param words list of words
     * @return array of sorted words
     */
    public static String[] nonDuplicateAscending(ArrayList<String> words) {
        TreeSet<String> treeSetWords = new TreeSet<>(words);
        return treeSetWords.toArray(new String[0]);
    }
}
