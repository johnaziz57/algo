package leetcode

class LRUCache2(private val capacity: Int) {

    private val map = LinkedHashMap<Int, Int>()

    fun get(key: Int): Int {
        return map[key]?.also {
            val value = map.remove(key)
            map[key] = value ?: -1
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        if (map.size == capacity && !map.contains(key)) {
            map.remove(map.entries.first().key)
        }
        map.remove(key)
        map[key] = value
    }

    fun print() {
        map.forEach{print("[${it.key} , ${it.value}]")}
        println()
    }
}

fun main(args: Array<String>) {
    val solution = LRUCache2(2)
    solution.put(1, 1)
    solution.put(2, 2)
    println( solution.get(1))
    solution.put(3, 3)
    println(solution.get(2))
    solution.put(4, 4)
    println(solution.get(1))
    println(solution.get(3))
    println(solution.get(4))
    solution.print()
}