package leetcode
// Hint,
// if there is a road A, B, C, ... Z
// if it is not possible between point A and G, then there is no way possible
// from anywhere after A to G. i.e B -> G, C ->G, ... H -> G not possible
class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var startingIndex = 0
        while (startingIndex < gas.size) {
            if (gas[startingIndex] >= cost[startingIndex]) {
                var tank = 0
                var currentIndex = startingIndex
                while (tank + gas[currentIndex] >= cost[currentIndex]) {
                    tank = tank + gas[currentIndex] - cost[currentIndex]
                    currentIndex = (currentIndex+ 1) % gas.size

                    if (currentIndex == startingIndex) return currentIndex
                }
                if (currentIndex < startingIndex) return -1
                if (currentIndex > startingIndex) startingIndex = currentIndex
            }
            startingIndex++
        }
        return -1
    }
}

fun main() {
    println(GasStation().canCompleteCircuit(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
    println(GasStation().canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3, 4, 3)))
    println(GasStation().canCompleteCircuit(intArrayOf(1), intArrayOf(1)))
    println(GasStation().canCompleteCircuit(intArrayOf(1), intArrayOf(0)))
}