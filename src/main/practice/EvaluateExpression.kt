package practice

import java.util.*

fun main(args: Array<String>) {
    println(evaluateExpression("(1+2) * 3"))
    println(evaluateExpression("(1+2) / 3"))
    println(evaluateExpression("3 * ( 1 + 2 + 3)"))
}

data class Stacks(val operandStack: Stack<Int>, val operatorStack: Stack<Char>)


/**
 * evaluate expression in 2 phases.
 * - Phase 1: [scan token][scanTokenIntoStacks].
 * - Phase 2: [clear stack][clearStacks].
 *
 * @param expression maths expression
 * @return the answer of the maths expression
 */
fun evaluateExpression(expression: String): Int {
    val tokens = removeWhiteSpace(expression)
    val (operandStack, operatorStack) = scanTokenIntoStacks(tokens)
    return clearStacks(operandStack, operatorStack)
}

/**
 * Phase 1: Scanning the expression
 * - 1.1 If the extracted item is an operand, push it to operandStack.
 * - 1.2 If the extracted item is + or - operator, process all the operators at the top of operatorStack and push the extracted operator to operatorStack.
 * - 1.3 If the extracted item is * or / operator, process all the * or / operators at the top of operatorStack and push the extracted operator to operatorStack.
 * - 1.4 If the extracted item is ( symbol, push it to operatorStack.
 * - 1.5 If the extracted item is ) symbol, repeatedly process the operators from the top of operatorStack until seeing the ( symbol on the stack.
 *
 * @param tokens expression in CharArray
 * @return [Stacks.operandStack] and [Stacks.operatorStack]
 */
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

/**
 * Phase 2: Clearing the stacks
 * - Repeatedly process the operators from the top of operatorStack until operatorStack is empty
 * @param operandStack
 * @param operatorStack
 * @return final answer of the expression
 */
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