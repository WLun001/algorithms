package ArrayAndStrings
//Given nums = [1,1,2],
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//It doesn't matter what you leave beyond the returned length.

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 1, 2)
    println("""size: ${removeDuplicates(nums)}""")
    nums.forEach { it -> print(it.toString().plus(" ")) }
}

fun removeDuplicates(nums: IntArray): Int {
    val num2 = nums.toMutableList()
    for (i in nums.indices) {
        if (i > 0) {
            if (nums[i] == nums[i - 1]) {
                num2.remove(i)
            }
        }
    }
    num2.forEach { it -> print(it.toString().plus(" ")) }
    println()
    return num2.size
}
