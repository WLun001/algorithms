package sorting

import java.util.*

fun main(args: Array<String>) {
    val arr = intArrayOf(2,9,5,4,8,1,6)
    println("Sorted: ${Arrays.toString(insertionSort(arr))}")
}

fun insertionSort(arr: IntArray): IntArray {
    val sortedArr = arr.copyOf()
    var currentElement: Int
    var k: Int
    for (i in 1 until sortedArr.size) {
        currentElement = sortedArr[i]
        k = i - 1
        while (k >= 0 && sortedArr[k] > currentElement) {
            println("Assigning ${sortedArr[k]} to ${sortedArr[k + 1]}")
            sortedArr[k + 1] = sortedArr[k]
            k--
            println("After assignment: ${Arrays.toString(sortedArr)}")
        }
        sortedArr[k + 1] = currentElement
        println("Sorting $i: ${Arrays.toString(sortedArr)}")
        println()
    }
    return  sortedArr
}