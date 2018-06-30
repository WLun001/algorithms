package practice

import java.util.*

fun main(args: Array<String>) {
    removeWhiteSpace("(1 + 2) / 20").forEach { println(message = it) }
}

data class Stacks(val operandStack: Stack<Int>, val operatorStack: Stack<Char>)

fun evaluateExpression(expression: String): Int {

    val tokens = removeWhiteSpace(expression)
    val (operandStack, operatorStack) = scanTokenIntoStacks(tokens)
    
    return 0
}

fun scanTokenIntoStacks(tokens: CharArray): Stacks {
    val operandStack = Stack<Int>()
    val operatorStack = Stack<Char>()
    for (token in tokens) {
        if (token == '+' || token == '-') {
            while (!operatorStack.empty() &&
                    (operatorStack.peek() == '+' ||
                            operatorStack.peek() == '-' ||
                            operatorStack.peek() == '*' ||
                            operatorStack.peek() == '/')) processAnOperator(operandStack, operatorStack)
            operatorStack.push(token)
        } else if (token == '*' || token == '/') {
            while (!operatorStack.empty() &&
                    (operatorStack.peek() == '*' || operatorStack.peek() == '/'))
                processAnOperator(operandStack, operatorStack)
            operatorStack.push(token)
        } else if (token == '(') operatorStack.push(token)
        else if (token == ')') {
            while (operatorStack.peek() != '(') processAnOperator(operandStack, operatorStack)
            operatorStack.push(token)
        } else operandStack.push(token.toInt())
    }

    return Stacks(operandStack, operatorStack)

}

fun processAnOperator(operandStack: Stack<Int>, operatorStack: Stack<Char>) {

}

fun removeWhiteSpace(expression: String): CharArray {
    return expression.filter { !it.isWhitespace() }.toCharArray()
}