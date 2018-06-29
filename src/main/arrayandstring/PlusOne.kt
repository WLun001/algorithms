package arrayandstring

/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/

fun plusOne(digits: IntArray): IntArray {
    when {
        digits[digits.lastIndex] != 9 -> digits[digits.lastIndex] = digits[digits.lastIndex] + 1
        else -> {
            digits[digits.lastIndex - 1] = digits[digits.lastIndex - 1] + 1
            digits[digits.lastIndex] = 0
        }
    }
    return digits
}