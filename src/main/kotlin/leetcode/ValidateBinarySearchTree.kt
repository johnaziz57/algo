package leetcode

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * WRONG SOLUTION
 */
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return visitTree(root)
    }

    private fun visitTree(treeNode: TreeNode?): Boolean {
        treeNode ?: return true
        treeNode.left?.let {
            val leftPair = visitLeft(it)
            if (leftPair.second.not() || leftPair.first >= treeNode.`val`) {
                return false
            }
        }

        treeNode.right?.let {
            val rightPair = visitRight(it)
            if (rightPair.second.not() || rightPair.first <=  treeNode.`val`) {
                return false
            }
        }
        return true
    }

    private fun visitLeft(treeNode: TreeNode): Pair<Int, Boolean> {
        val left = treeNode.left
        if (left != null) {
            val leftPair = visitLeft(left)
            if (leftPair.second.not() || leftPair.first >= treeNode.`val`) {
                return -1 to false
            }
        }

        val right = treeNode.right
        if (right != null) {
            val rightPair = visitRight(right)
            if (rightPair.second.not() || rightPair.first <=  treeNode.`val`) {
                return -1 to false
            }
            return rightPair
        }
        return treeNode.`val` to true
    }

    private fun visitRight(treeNode: TreeNode): Pair<Int, Boolean> {
        val right = treeNode.right
        if (right != null) {
            val rightPair = visitRight(right)
            if (rightPair.second.not() || rightPair.first <=  treeNode.`val`) {
                return -1 to false
            }
        }

        val left = treeNode.left
        if (left != null) {
            val leftPair = visitLeft(left)
            if (leftPair.second.not() || leftPair.first >= treeNode.`val`) {
                return -1 to false
            }
            return leftPair
        }

        return treeNode.`val` to true
    }
}

  class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }
