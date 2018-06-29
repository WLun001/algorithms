package arrayandstring

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

fun twoSum(nums: IntArray, target: Int): IntArray {
    val arr = ArrayList<Int>()
    nums.indices.forEach { i ->
        if (arr.size >= 2) return@forEach
        for (j in nums.indices) {
            if (i != j && nums[i] + nums[j] == target) with(arr) { add(i); add(j) }
        }
    }
    return arr.toIntArray()
}