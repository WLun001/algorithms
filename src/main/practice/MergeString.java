package practice;

/**
 * Merge data from two sources connected to a network access point to create a new data packet
 * Merge strings a and b, and return a single merged string.
 * A merge operation on tow strings is described as follows:
 * - Append alternating characters from a and b.
 * - Once all of the characters in one of the strings have been merged, append the remaining characters.
 * <p>
 * Example:
 * "abc" + "stuvwx" will produce "asbtcuvwx"
 */
public class MergeString {

    static String mergeStrings(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int index = 0;
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        for (int i = 0; i < charA.length; i++) {
            index = i;
            builder.append(charA[i]);
            if (i < charB.length) builder.append(charB[i]);
        }
        if (charA.length < charB.length) {
            for (int i = index + 1; i < charB.length; i++) {
                builder.append(charB[i]);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeStrings("abc", "stuvwx"));
        System.out.println(mergeStrings("stuvwx", "abc"));

    }
}
