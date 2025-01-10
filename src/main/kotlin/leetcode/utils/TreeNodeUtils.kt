package leetcode.utils

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun List<Int?>.toTreeNode(): TreeNode? {
    fun buildTreeNode(node: TreeNode, index: Int) {
        val leftIndex = index * 2 + 1
        if (leftIndex >= size) return
        val leftValue = this[leftIndex]
        if (leftValue != null) {
            val leftNode = TreeNode(leftValue)
            node.left = leftNode
            buildTreeNode(leftNode, leftIndex)
        }

        val rightIndex = index * 2 + 2
        if (rightIndex >= size) return
        val rightValue = this[rightIndex]
        if (rightValue != null) {
            val rightNode = TreeNode(rightValue)
            node.right = rightNode
            buildTreeNode(rightNode, rightIndex)
        }
    }

    return first()?.let{
        val node = TreeNode(it)
        buildTreeNode(node, 0)
        node
    }
}