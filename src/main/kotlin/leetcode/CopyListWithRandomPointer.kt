package leetcode

import leetcode.utils.Node

class CopyListWithRandomPointer {
    fun copyRandomList(node: Node?): Node? {
        node ?: return null

        val oldList = mutableListOf<Node>()

        var currentNode = node
        while(currentNode != null) {
            oldList.add(currentNode)
            currentNode = currentNode.next
        }

        val newList = Array(oldList.size) {Node(0)}
        for (i in oldList.indices) {
            newList[i].`val` = oldList[i].`val`
            newList[i].next = if (i + 1 < newList.size) newList[i + 1] else null
            newList[i].random = newList[getDistanceFromEnd(oldList[i])]
        }

        return newList.firstOrNull()
    }

    private fun getDistanceFromEnd(node: Node?): Int {
        node ?: return 0
        var currentNode = node
        var i = 0
        while(currentNode != null) {
            currentNode = currentNode.next
            i++
        }
        return i
    }
}

fun main(args: Array<String>) {
    val solution = CopyListWithRandomPointer()
    val node3 = Node(3)
    val node2 = Node(3, node3, node3)
    val node1 = Node(3, node2, node3)


    val map = hashMapOf(node1 to 1, node2 to 2, node3 to 3)
    val set = mutableSetOf(node1, node2, node3)
    println(set.size)
    println(map.size)
}