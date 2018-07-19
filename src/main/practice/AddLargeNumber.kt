package practice

import java.math.BigInteger

/**
 * Additional of large number (100 digits)
 */
fun main(args: Array<String>) {
    val number1 = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
    val number2 = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
    print(add(number1,number2))
}

fun add(num1: String, num2: String): String {
    val x = BigInteger(num1)
    val y = BigInteger(num2)
    return (x + y).toString()
}