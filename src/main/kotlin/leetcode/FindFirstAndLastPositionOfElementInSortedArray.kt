package leetcode

class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val anchorIndex = binarySearch(nums, 0, nums.size - 1, target)

        var leftIndex = anchorIndex
        var leftIndexResult: Int
        do {
            leftIndexResult = leftIndex
            leftIndex = binarySearch(nums, 0, leftIndex - 1, target)
        } while (leftIndex != -1)

        var rightIndex = anchorIndex
        var rightIndexResult: Int
        do {
            rightIndexResult = rightIndex
            rightIndex = binarySearch(nums, rightIndex + 1, nums.size - 1, target)
        } while (rightIndex != -1)

        return intArrayOf(leftIndexResult, rightIndexResult)
    }

    private fun binarySearch(nums: IntArray, start: Int, end: Int, target: Int): Int {
        var currentStart: Int = start
        var currentEnd: Int = end
        while (currentStart > -1 && currentEnd < nums.size && currentStart <= currentEnd) {
            val currentIndex = (currentStart + currentEnd) / 2
            val currentValue = nums[currentIndex]
            when {
                currentValue == target -> return currentIndex
                currentValue < target -> currentStart = currentIndex + 1
                else -> currentEnd = currentIndex - 1 // currentValue > target
            }
        }
        return -1
    }
}

fun main() {
    val search = FindFirstAndLastPositionOfElementInSortedArray()
    println(
        "1: " + search.searchRange(
            intArrayOf(5, 7, 7, 8, 8, 10),
            8
        ).toList().toString()
    )
    println(
        "2: " + search.searchRange(
            intArrayOf(5, 7, 7, 8, 8, 10),
            6
        ).toList().toString()
    )
    println(
        "3: " + search.searchRange(
            intArrayOf(0, 0, 0, 0, 0, 8),
            8
        ).toList().toString()
    )
    println(
        "4: " + search.searchRange(
            intArrayOf(),
            8
        ).toList().toString()
    )
    println(
        "5: " + search.searchRange(
            intArrayOf(8, 8, 8, 8, 8, 8, 8, 8, 8),
            8
        ).toList().toString()
    )
    println(
        "6: " + search.searchRange(
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0),
            8
        ).toList().toString()
    )
}