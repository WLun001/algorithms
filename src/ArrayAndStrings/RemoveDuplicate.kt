package ArrayAndStrings

//Given nums = [1,1,2],
//Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//It doesn't matter what you leave beyond the returned length.

//Given nums = [0,0,1,1,1,2,2,3,3,4],
//Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
//It doesn't matter what values are set beyond the returned length.

fun main(args: Array<String>) {
    val nums = intArrayOf(1, 1, 2)
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    start(nums); start(nums2)
}

fun start(nums: IntArray) {
    println("""size: ${removeDuplicates(nums)}""")
    nums.forEach { it -> print(it.toString().plus(" ")) }
}

fun removeDuplicates(nums: IntArray): Int {
    val num2 = nums.toMutableList()
    println(num2.size)
    for (i in nums.indices) if (i > 0 && nums[i] == nums[i - 1]) {
        println("removing ".plus(i))
        num2.remove(nums[i])
    }
    num2.forEach { it -> print(it.toString().plus(" ")) }
    println()
    return num2.size
}
