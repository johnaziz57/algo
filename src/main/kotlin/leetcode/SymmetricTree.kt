package leetcode

import leetcode.utils.ListNode
import leetcode.utils.TreeNode
import leetcode.utils.toTreeNode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root?.left == null && root?.right == null) return true
        if (root.left == null || root.right == null) return false

        val leftTreeStack = mutableListOf(root.left)
        val rightTreeStack = mutableListOf(root.right)

        while (leftTreeStack.isNotEmpty() && rightTreeStack.isNotEmpty()) {
            val left = leftTreeStack.removeAt(0)
            val right = rightTreeStack.removeAt(0)

            if (left == right && left == null) continue

            if (left?.`val` != right?.`val`) return false

            leftTreeStack.add(left?.left)
            leftTreeStack.add(left?.right)

            rightTreeStack.add(right?.right)
            rightTreeStack.add(right?.left)
        }


        return true
    }

    private fun leftTraverse(left: TreeNode?): List<Int?> {
        left ?: return listOf(null)
        val value = mutableListOf<Int?>()
        value.addAll(leftTraverse(left.left))
        value.add(left.`val`)
        value.addAll(leftTraverse(left.right))
        return value
    }

    private fun rightTraverse(right: TreeNode?): List<Int?> {
        right ?: return listOf(null)
        val value = mutableListOf<Int?>()
        value.addAll(rightTraverse(right.right))
        value.add(right.`val`)
        value.addAll(rightTraverse(right.left))
        return value
    }
}

fun main(args: Array<String>) {
    val solution = SymmetricTree()
    val tree = listOf(1, 2, 2, 3, 4, 4, 3).toTreeNode()
    println(solution.isSymmetric(tree))
    val tree2= listOf(1,2,2,null,3,null,3).toTreeNode()
    println(solution.isSymmetric(tree2))
    val tree3 = listOf(1, 2, 2, 2, null, 2).toTreeNode()
    println(solution.isSymmetric(tree3))
}