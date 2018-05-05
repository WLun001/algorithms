package test

import ArrayAndStrings.moveZeroes
import ArrayAndStrings.plusOne
import ArrayAndStrings.twoSum
import main.ArrayAndStrings.*
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestArrayAndString {
    @Test
    fun testRemoveDuplicate() {
        val arr = intArrayOf(1, 1, 2)
        val arr2 = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        assertEquals(2, removeDuplicates(arr))
        assertEquals(5, removeDuplicates(arr2))
    }

    @Test
    fun testRotateArray() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val arr2 = intArrayOf(-1, -100, 3, 99)
        assertTrue(Arrays.equals(intArrayOf(5, 6, 7, 1, 2, 3, 4), rotate(arr, 3)))
        assertTrue(Arrays.equals(intArrayOf(3, 99, -1, -100), rotate(arr2, 2)))
    }

    @Test
    fun testContainsDuplicate() {
        val arr = intArrayOf(1, 2, 3, 1)
        val arr2 = intArrayOf(1, 2, 3, 4)
        val arr3 = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        assertEquals(true, containsDuplicate(arr))
        assertEquals(false, containsDuplicate(arr2))
        assertEquals(true, containsDuplicate(arr3))
    }

    @Test
    fun testSingleNumber() {
        val arr = intArrayOf(2, 2, 1)
        val arr2 = intArrayOf(4, 1, 2, 1, 2)
        assertEquals(1, singleNumber(arr))
        assertEquals(4, singleNumber(arr2))
    }

    @Test
    fun testIntersection() {
        val arr = intArrayOf(1, 2, 2, 1)
        val arr2 = intArrayOf(2, 2, 3)
        assertTrue(Arrays.equals(intArrayOf(2), intersect(arr, arr2)))
    }

    @Test
    fun testPlusOne() {
        val arr = intArrayOf(1, 2, 3)
        val arr2 = intArrayOf(1, 3, 9)
        val arr3 = intArrayOf(4, 3, 2, 1)
        assertTrue(Arrays.equals(intArrayOf(1, 2, 4), plusOne(arr)))
        assertTrue(Arrays.equals(intArrayOf(1, 4, 0), plusOne(arr2)))
        assertTrue(Arrays.equals(intArrayOf(4, 3, 2, 2), plusOne(arr3)))
    }

    @Test
    fun testMoveZeroes() {
        val arr = intArrayOf(0, 1, 0, 3, 12)
        val arr2 = intArrayOf(1, 20, 0, 200, 0, 1, 20, 2)
        assertTrue(Arrays.equals(intArrayOf(1, 3, 12), moveZeroes(arr)))
        assertTrue(Arrays.equals(intArrayOf(1, 1, 2, 20, 20, 200), moveZeroes(arr2)))
    }

    @Test
    fun testTwoSum() {
        val arr = intArrayOf(2, 7, 11, 15)
        assertTrue(Arrays.equals(intArrayOf(0, 1), twoSum(arr, 9)))
        assertTrue(Arrays.equals(intArrayOf(1, 3), twoSum(arr, 22)))
    }
}

