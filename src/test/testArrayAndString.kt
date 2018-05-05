package test

import main.ArrayAndStrings.removeDuplicates
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestArrayAndString {
    @Test
    fun testRemoveDuplicate() {
        val arr = intArrayOf(1, 1, 2)
        val arr2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(2, removeDuplicates(arr))
        assertEquals(5, removeDuplicates(arr2))
    }
}

