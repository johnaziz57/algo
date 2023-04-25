package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 */
class FindKPairsWithSmallestSums {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val priorityQueue = PriorityQueue<List<Int>>(Comparator { p0, p1 ->
            return@Comparator p1.sum() - p0.sum()
        })
        var i = 0
        var j = 0
        while (i < nums1.size) {
            inner@ while (j < nums2.size) {
                if (priorityQueue.size < k) {
                    priorityQueue.add(listOf(nums1[i], nums2[j]))
                    j++
                } else if (priorityQueue.peek().sum() > nums1[i] + nums2[j]) {
                    priorityQueue.poll()
                    priorityQueue.add(listOf(nums1[i], nums2[j]))
                    j++
                } else if (priorityQueue.peek().sum() <= nums1[i] + nums2[j]) {
                    break@inner
                }
            }
            i++
            j = 0
        }
        return (1..k).mapNotNull { priorityQueue.poll() }.reversed()
    }
}

fun main(args: Array<String>) {

//    val nums1 = intArrayOf(-10,-4,0,0,6)
//    val nums2 = intArrayOf(3,5,6,7,8,100)
//
//    val output = FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, 10)
//    println(output)

//    val nums1 = intArrayOf(1, 7, 11)
//    val nums2 = intArrayOf(2, 4, 6)
//
//    val output = FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, 3)
//    println(output)

    val nums1 = intArrayOf(1, 1, 2)
    val nums2 = intArrayOf(1, 2, 3)

    val output = FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, 2)
    println(output)

//    val nums1 = intArrayOf(1, 2)
//    val nums2 = intArrayOf(3)
//
//    val output = FindKPairsWithSmallestSums().kSmallestPairs(nums1, nums2, 3)
//    println(output)
}