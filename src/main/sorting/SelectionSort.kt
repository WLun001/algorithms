package sorting

fun main(args: Array<String>) {
    val list = intArrayOf(2, 3, 2, 5, 6, 1, -2, 3, 14, 12)
    selectionSort(list).forEach { println(it) }
}

fun selectionSort(arr: IntArray): IntArray {
    val arrList = arr.copyOf()
    for (i in 0 until arrList.size) {
        var currentMin = arrList[i]
        var currentMinIndex = i
        for (j in i + 1 until arrList.size) {
            if (arrList[j] < currentMin) {
                currentMin = arrList[j]
                currentMinIndex = j
            }
        }
        if (currentMinIndex != i) {
            arrList[currentMinIndex] = arrList[i]
            arrList[i] = currentMin
        }
    }
    return arrList
}