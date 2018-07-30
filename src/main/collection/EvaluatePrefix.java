package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EvaluatePrefix {
    public static void main(String[] args) {
        System.out.println(
                evaluatePrefix(
                        scanExpressionToQueue(
                                removeWhiteSpace("– + * 9 + 2 8 * + 4 8 6 3"))) + "");

//        System.out.println(evaluatePrefix(removeWhiteSpace("– + * 9 + 2 8 * + 4 8 6 3")) + "");

    }

    public static Queue<String> scanExpressionToQueue(char[] expression) {
        Queue<String> prefixQ = new LinkedList<>();
        for (char c : expression) prefixQ.offer(String.valueOf(c));
        return prefixQ;
    }

    public static char[] removeWhiteSpace(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (!Character.isWhitespace(c)) stringBuilder.append(c);
        }
        return stringBuilder.toString().toCharArray();
    }

    public static boolean isOperand(String item) {
        return Character.isDigit(item.toCharArray()[0]);
    }

    public static int evaluatePrefix(Queue<String> queue) {
        Queue<String> prefixQ = queue;
        Queue<String> tempQ = new LinkedList<>();

        while (prefixQ.size() > 1) {
            while (!prefixQ.isEmpty()) {
                String item = prefixQ.remove();
                if (isOperand(item)) tempQ.offer(item);
                else {
                    if (!isOperand(prefixQ.element())) tempQ.offer(prefixQ.element());
                    else {
                        String e = prefixQ.remove();
                        if (!isOperand(prefixQ.element())) tempQ.offer(e);
                    }
                }
            }
        }
        return 0;
    }

//    public static boolean isOperator(String item) {
//        return "+-*/".contains(item);
//    }

//    public static int performCalculation(char operand1, char operand2, char operator) {
//        int op1 = Integer.parseInt(Character.toString(operand1));
//        int op2 = Integer.parseInt(Character.toString(operand2));
//        int result = 0;
//        switch (operator) {
//            case '+':
//                result = op2 + op1;
//                break;
//            case '-':
//                result = op2 - op1;
//                break;
//            case '*':
//                result = op2 * op1;
//                break;
//            case '/':
//                result = op2 / op1;
//                break;
//        }
//        return result;
//    }

//    public static int evaluatePrefix(char[] expression) {
//        ArrayList<Integer> list = new ArrayList<>();
//        char op1, op2, operator;
//        for (int i = 1; i < expression.length - 1; i++) {
//            op1 = expression[i];
//            op2 = expression[i + 1];
//            operator = expression[i - 1];
//            if (Character.isDigit(op1)  && Character.isDigit(op2) && isOperator(Character.toString(operator))) {
//                list.add(performCalculation(op1, op2, operator));
//            }
//        }
//        return (int) list.stream().mapToInt(i -> i).average().getAsDouble();
//    }

}
