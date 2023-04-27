package leetcode

class SubsetsII {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val resultSet = mutableSetOf(emptyList<Int>())
        for (num in nums.sorted()) {
            val newSet = mutableSetOf<List<Int>>()
            for (set in resultSet) {
                val newList = mutableListOf<Int>()
                newList.addAll(set)
                newList.add(num)
                newSet.add(newList)
            }
            resultSet.addAll(newSet)
        }
        return resultSet.toList()
    }
}

fun main(args: Array<String>) {
    val subsetsII = SubsetsII()
//    println(subsetsII.subsetsWithDup(intArrayOf(1, 2, 2)))
//    println(subsetsII.subsetsWithDup(intArrayOf(0)))
//    println(subsetsII.subsetsWithDup(intArrayOf()))
//    println(subsetsII.subsetsWithDup(intArrayOf(1, 1, 1, 1)))
//    println(subsetsII.subsetsWithDup(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
    println(subsetsII.subsetsWithDup(intArrayOf(4, 4, 4, 1, 4)))
}