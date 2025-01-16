package buildSrc.build

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BinaryTree {
    var root: TreeNode? = null

    fun insert(value: Int) {
        root = insertRec(root, value) // e: [UNRESOLVED_REFERENCE] Unresolved reference 'insertRec'.
    }



}