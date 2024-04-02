class Node(var data: Char, var left: Node? = null, var right: Node? = null)

fun preorder(node: Node?) {
    if (node != null) {
        print(node.data)
        preorder(node.left)
        preorder(node.right)
    }
}

fun inorder(node: Node?) {
    if (node != null) {
        inorder(node.left)
        print(node.data)
        inorder(node.right)
    }
}

fun postorder(node: Node?) {
    if (node != null) {
        postorder(node.left)
        postorder(node.right)
        print(node.data)
    }
}

fun main() {
    val n = readln().toInt()
    val tree = mutableMapOf<Char, Node>()

    repeat(n) {
        val (parent, left, right) = readln().split(" ")
        if (!tree.containsKey(parent[0])) {
            tree[parent[0]] = Node(parent[0])
        }
        if (left != ".") {
            if (!tree.containsKey(left[0])) {
                tree[left[0]] = Node(left[0])
            }
            tree[parent[0]]!!.left = tree[left[0]]
        }
        if (right != ".") {
            if (!tree.containsKey(right[0])) {
                tree[right[0]] = Node(right[0])
            }
            tree[parent[0]]!!.right = tree[right[0]]
        }
    }

    val root = tree.values.first()
    preorder(root)
    println()
    inorder(root)
    println()
    postorder(root)
}