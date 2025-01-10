package leetcode

import kotlin.math.pow

class PrisonCellsAfterNDays {
    fun prisonAfterNDays(cells: IntArray, n: Int): IntArray {
        val set = linkedSetOf<Int>()
        val record = mutableListOf<IntArray>()
        var currentCells = cells
        var i = 0
        while (i < n && !set.contains(hashValue(currentCells))) {
            set.add(hashValue(currentCells))
            val newCells = IntArray(cells.size)
            newCells[0] = 0
            newCells[cells.size - 1] = 0
            for (j in 1..<currentCells.size - 1) {
                if (currentCells[j - 1] == currentCells[j + 1]) {
                    newCells[j] = 1
                } else {
                    newCells[j] = 0
                }
            }
            record.add(newCells)
            currentCells = newCells
            i++
        }
        if (i == n) {
            return currentCells
        }
        val beforeCycleSize = set.indexOf(hashValue(currentCells))
        val cycleSize = set.size - beforeCycleSize
        val index = beforeCycleSize + ((n - beforeCycleSize -1) % cycleSize)
        return record[index]
    }


    private fun hashValue(cells: IntArray): Int {
        return cells.foldIndexed(0) {index, acc, it -> acc + it * 2.0.pow(index).toInt() }
    }
}

fun main(args: Array<String>) {
    val solution = PrisonCellsAfterNDays()
//    println(solution.prisonAfterNDays(intArrayOf(1,0,0,1,0,0,1,0), 1000000000).contentToString())
    println(solution.prisonAfterNDays(intArrayOf(0,0,0,1,1,0,1,0), 574).contentToString())

}