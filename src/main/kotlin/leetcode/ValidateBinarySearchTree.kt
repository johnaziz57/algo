package leetcode

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return root?.let { visitNode(it).first } ?: true
    }

    private fun visitNode(treeNode: TreeNode): Triple<Boolean, Int, Int> {
        val left = treeNode.left
        var leftTriple: Triple<Boolean, Int, Int>? = null
        if (left != null) {
            leftTriple = visitNode(left)
            if (leftTriple.first.not() || leftTriple.second >= treeNode.`val` || leftTriple.third >= treeNode.`val`) {
                return Triple(false, 0, 0)
            }
        }

        val right = treeNode.right
        var rightTriple: Triple<Boolean, Int, Int>? = null
        if (right != null) {
            rightTriple = visitNode(right)
            if (rightTriple.first.not() || rightTriple.second <= treeNode.`val` || rightTriple.third <= treeNode.`val`) {
                return Triple(false, 0, 0)
            }
        }
        return Triple(true, leftTriple?.second ?: treeNode.`val`, rightTriple?.third ?: treeNode.`val`)
    }
}

  class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }
