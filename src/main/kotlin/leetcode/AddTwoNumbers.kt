package leetcode

import leetcode.utils.ListNode

/**
 * https://leetcode.com/problems/add-two-numbers/
 */


class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var currentL1Node: ListNode? = l1
        var currentL2Node: ListNode? = l2
        val resultNode = ListNode(0)
        var currentNode = resultNode
        var carryOver = 0

        while (currentL1Node != null || currentL2Node != null || carryOver != 0) {
            val newNode = ListNode(0)
            newNode.`val` = (currentL1Node?.`val` ?: 0) + (currentL2Node?.`val` ?: 0) + carryOver
            if (newNode.`val` > 9) {
                newNode.`val` = newNode.`val` % 10
                carryOver = 1
            } else {
                carryOver = 0
            }
            currentNode.next = newNode
            currentNode = newNode
            currentL1Node = currentL1Node?.next
            currentL2Node = currentL2Node?.next
        }
        return resultNode.next
    }
}

fun main(args: Array<String>) {
    val solution = AddTwoNumbers()
    val l1_0 = ListNode(2)
    val l1_1 = ListNode(4)
    l1_0.next = l1_1
    val l1_2 = ListNode(3)
    l1_1.next = l1_2

    val l2_0 = ListNode(5)
    val l2_1 = ListNode(6)
    l2_0.next = l2_1
    val l2_2 = ListNode(4)
    l2_1.next = l2_2
    val out = solution.addTwoNumbers(l1_0, l2_0)
}