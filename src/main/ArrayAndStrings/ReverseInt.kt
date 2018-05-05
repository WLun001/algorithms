package ArrayAndStrings

import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerValueTypeConstructor

/*
Given a 32-bit signed integer, reverseInt digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.*/

fun reverseInt(x: Int): Int {
    return when {
        x > 0 -> x.toString().reversed().toInt()
        else -> Integer.parseInt("-".plus(x.toString().substring(1).reversed()))
    }
}