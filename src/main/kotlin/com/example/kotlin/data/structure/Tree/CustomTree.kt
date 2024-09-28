package com.example.kotlin.data.structure.Tree

class CustomTree {
    private val _nodes = mutableListOf<CustomTreeNode>()
    val nodes: List<CustomTreeNode> = _nodes
    val size: Int
        get() = _nodes.size

    val root: CustomTreeNode?
        get() = _nodes.firstOrNull()

    fun addNode(node: CustomTreeNode) {
        _nodes.add(node)
    }

    fun addNode(node: CustomTreeNode, leftNode: CustomTreeNode, rightNode: CustomTreeNode) {
        node.addLeft(leftNode)
        node.addRight(rightNode)
    }
}
