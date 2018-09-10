package sorting

fun main(args: Array<String>) {
    val list = intArrayOf(2, 3, 2, 5, 6, 1, -2, 3, 14, 12)
    bubbleSort(list).forEach { println(it) }
}

fun bubbleSort(arr: IntArray): IntArray {
    val arrList = arr.copyOf()
    val iterable = arrList.size
    var i = 1
    var needRepeat = true
    while (i < iterable && needRepeat) {
        needRepeat = false
        for (j in 0 until iterable - i) {
            if (arrList[j] > arrList[j + 1]) {
                val temp = arrList[j]
                arrList[j] = arrList[j + 1]
                arrList[j + 1] = temp
                needRepeat = true
            }
        }
        i++
    }
    return arrList
}