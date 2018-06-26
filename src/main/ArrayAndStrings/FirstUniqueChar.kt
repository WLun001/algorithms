package ArrayAndStrings

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/

fun firstUniqueChar(s: String): Int {
    val s2 = s.map { it }.map { it to 1 }.groupBy({ it.first }, { it.second })
            .map { it.key to it.value.sum() }.first { it.second == 1 }
    return s.indexOf(s2.first)
}
