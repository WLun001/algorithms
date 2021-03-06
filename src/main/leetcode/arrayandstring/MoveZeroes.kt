package leetcode.arrayandstring

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//Note:
//You must do this in-place without making a copy of the array.
//Minimize the total number of operations.

fun moveZeroes(nums: IntArray): IntArray {
    val zeroIndex = ArrayList<Int>()
    val arr = nums.toMutableList()
    arr.sort()
    arr.forEachIndexed { index, i ->
        if (i == 0) {
            zeroIndex.add(index)
        }
    }
    for (i in zeroIndex) {
        val zero = arr[0]
        arr.remove(0)
        arr.add(zero)
    }
    return arr.toIntArray()
}