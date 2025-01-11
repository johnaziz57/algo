package leetcode.utils

// if converted this to class those three nodes will be different in the hash map
//    val node3 = Node(3)
//    val node2 = Node(3, node3, node3)
//    val node1 = Node(3, node2, node3)
// if this class stays data class, with only one `val` in the constructor,
// those three nodes will be the same in the hash map
//    val node3 = Node(3)
//    val node2 = Node(3, node3, node3)
//    val node1 = Node(3, node2, node3)
data class Node(var `val`: Int, var next: Node? = null, var random: Node? = null)