package practice;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

public class MatchParantheses {
    public static void main(String[] args) {
        System.out.println(matchParentheses("[ ( d + a ) + (b + c) ]"));
        System.out.println(matchParentheses("( ( d + a ) + (b + c) ) )"));
        System.out.println(matchParentheses("( ( d + a ) + (b + c) }"));
    }

    public static boolean matchParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!Character.isAlphabetic(c)
                    && !Character.isDigit(c)
                    && !Character.isWhitespace(c)
                    && !"+-*/".contains(String.valueOf(c))){
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    if (stack.peek() == '(' && c == ')')
                        stack.pop();
                    else if (stack.peek() == '[' && c == ']')
                        stack.pop();
                    else if (stack.peek() == '{' && c == '}')
                        stack.pop();
                    else stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
