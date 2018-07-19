package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ReverseText {
    public static void main(String[] args) {
        System.out.println(reserveText(getUserInput()));
    }

    private static String getUserInput() {
        System.out.println("Enter a text to reverse");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static String reserveText(String text) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text.toCharArray()) queue.offer(c);
        System.out.println("queue: " + queue);
        while (queue.size() > 0) stack.push(queue.remove());
        System.out.println("stack: " + stack);
        while (stack.size() > 0) stringBuilder.append(stack.pop());
        return stringBuilder.toString();
    }
}
