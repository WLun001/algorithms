fun main(args: Array<String>) {
    val nums = intArrayOf(1,1,2)
    println("""size: ${removeDuplicates(nums)}""")
    nums.forEach {
        print(it.toString().plus(" "))
    }
}

fun removeDuplicates(nums: IntArray): Int {
    val num2 = nums.toMutableList()
    for(i in nums.indices){
        if(i > 0){
            if(nums[i] == nums[i - 1]){
                num2.remove(i)
            }
        }
    }
    num2.forEach {
        print(it.toString().plus(" "))
    }
    println()
    return num2.size
}
