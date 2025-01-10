package leetcode

import java.util.TreeMap

class KthLargestElementInArray {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val tree = TreeMap<Int, Int>()
        nums.forEach {
            tree[it] = (tree[it] ?: 0) + 1
        }

        var i = 0
        while (i < k) {
            val lastEntry = tree.pollLastEntry()
            if (lastEntry.value + i >= k) {
                return lastEntry.key
            } else {
                i += lastEntry.value
            }
        }
        return 0
    }
}

fun main(args: Array<String>) {
    val solution = KthLargestElementInArray()
    println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    println(solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    println(solution.findKthLargest(intArrayOf(-1, -1, -1, -1, -1), 4))
    println(solution.findKthLargest(intArrayOf(1, 2, 2), 3))
    println(solution.findKthLargest(intArrayOf(-1, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0), 4))
    println(solution.findKthLargest(intArrayOf(-1, -2, 0, 0), 1))
}