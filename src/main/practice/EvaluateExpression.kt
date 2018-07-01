package practice

import java.util.*

fun main(args: Array<String>) {
    println(evaluateExpression("(1+2) * 3"))
    println(evaluateExpression("(1+2) / 3"))
    println(evaluateExpression("3 * ( 1 + 2 + 3)"))
}

data class Stacks(val operandStack: Stack<Int>, val operatorStack: Stack<Char>)

fun evaluateExpression(expression: String): Int {
    val tokens = removeWhiteSpace(expression)
    val (operandStack, operatorStack) = scanTokenIntoStacks(tokens)
    return clearStacks(operandStack, operatorStack)
}

fun scanTokenIntoStacks(tokens: CharArray): Stacks {
    val operandStack = Stack<Int>()
    val operatorStack = Stack<Char>()
    for (token in tokens) {
        if (token == '+' || token == '-') {
            while (!operatorStack.isEmpty() &&
                    (operatorStack.peek() == '+' ||
                            operatorStack.peek() == '-' ||
                            operatorStack.peek() == '*' ||
                            operatorStack.peek() == '/')) processAnOperator(operandStack, operatorStack)
            operatorStack.push(token)
        } else if (token == '*' || token == '/') {
            while (!operatorStack.isEmpty() &&
                    (operatorStack.peek() == '*' || operatorStack.peek() == '/'))
                processAnOperator(operandStack, operatorStack)
            operatorStack.push(token)
        } else if (token == '(') operatorStack.push(token)
        else if (token == ')') {
            while (operatorStack.peek() != '(') processAnOperator(operandStack, operatorStack)
            operatorStack.pop()
        } else {
            operandStack.push(token.toString().toInt()) // if token.toInt() will return its ASCII code
        }
    }
    return Stacks(operandStack, operatorStack)
}

fun clearStacks(operandStack: Stack<Int>, operatorStack: Stack<Char>): Int {
    while (true) {
        if (operatorStack.empty()) break
        else processAnOperator(operandStack, operatorStack)
    }
    return operandStack.pop()
}

fun processAnOperator(operandStack: Stack<Int>, operatorStack: Stack<Char>) {
    val operator = operatorStack.pop()
    val operand1 = operandStack.pop()
    val operand2 = operandStack.pop()
    when (operator) {
        '+' -> operandStack.push(operand2 + operand1)
        '-' -> operandStack.push(operand2 - operand1)
        '*' -> operandStack.push(operand2 * operand1)
        '/' -> operandStack.push(operand2 / operand1)
    }
}

fun removeWhiteSpace(expression: String): CharArray {
    return expression.filter { !it.isWhitespace() }.toCharArray()
}