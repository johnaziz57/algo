package leetcode

class LRUCache(private val capacity: Int) {
    data class Input(val key: Int, val value: Int)
    private val map = HashMap<Int, Input>(capacity)
    private val linkedSet = LinkedHashSet<Int>(capacity)

    fun get(key: Int): Int {
        val value = map[key] ?: return -1
        linkedSet.remove(key)
        linkedSet.add(key)
        return value.value
    }

    fun put(key: Int, value: Int) {
        if (capacity == map.size && capacity > 0 && map.contains(key).not()) {
            val smallestItem = linkedSet.first()
            map.remove(smallestItem)
            linkedSet.remove(smallestItem)
        }
        map[key] = Input(key, value)
        linkedSet.remove(key)
        linkedSet.add(key)
    }
}

fun main(args: Array<String>) {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.get(1)
    cache.put(3, 3)
    cache.get(2)
    cache.put(4, 4)
    cache.get(1)
    cache.get(3)
    cache.get(4)
}