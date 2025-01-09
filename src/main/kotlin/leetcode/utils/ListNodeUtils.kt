package leetcode.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        print(" $`val` ")
        next?.print() ?: println()
    }
}

fun List<Int>.toListNode(): ListNode? {
    val beforeFirstNode = ListNode(0)
    var lastNode: ListNode = beforeFirstNode
    forEach {
        val newNode = ListNode(it)
        lastNode.next = newNode
        lastNode = newNode
    }
    return beforeFirstNode.next
}