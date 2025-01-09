package leetcode

import leetcode.utils.ListNode
import leetcode.utils.toListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val beforeFirst = ListNode(0)
        var lastNode = beforeFirst
        var list1Pointer = list1
        var list2Pointer = list2
        while(list1Pointer != null && list2Pointer != null) {
            if (list1Pointer.`val` < list2Pointer.`val`) {
                lastNode.next = list1Pointer
                lastNode = list1Pointer
                list1Pointer = list1Pointer.next
            } else {
                lastNode.next = list2Pointer
                lastNode = list2Pointer
                list2Pointer = list2Pointer.next
            }

        }
        if (list1Pointer != null) {
            lastNode.next = list1Pointer
        }
        if (list2Pointer != null) {
            lastNode.next = list2Pointer
        }
        return beforeFirst.next
    }
}

fun main(args: Array<String>) {
    val solution = MergeTwoSortedLists()
    solution.mergeTwoLists(listOf(1, 2, 4).toListNode(), listOf(1, 3, 4).toListNode())?.print()
    solution.mergeTwoLists(listOf<Int>().toListNode(), listOf<Int>().toListNode())?.print()
    solution.mergeTwoLists(listOf<Int>().toListNode(), listOf(0).toListNode())?.print()
}