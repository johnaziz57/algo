package leetcode


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, i ->
                map[i] = index
        }

        nums.forEachIndexed { index, i ->
            val missingNumber = target - i
            if (i == missingNumber && map[i] != index) {
                return intArrayOf(index, map[i] ?: 0)
            }
            if (i != missingNumber && map.contains(missingNumber)) {
                return intArrayOf(index, map[missingNumber] ?: 0)
            }
        }

        return intArrayOf()
    }
}
fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentToString())
    println(solution.twoSum(intArrayOf(3,2,4), 6).contentToString())
    println(solution.twoSum(intArrayOf(3,3), 6).contentToString())
}