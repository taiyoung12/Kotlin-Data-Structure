package com.example.kotlin.data.structure.Tree

class CustomTree(
    val root: CustomTreeNode = CustomTreeNode()
) {
    fun insert(value: Int) {
        insertRecursively(root, value)
    }

    fun getNode(): CustomTreeNode? {
        while (root){

        }
    }

    private fun insertRecursively(node: CustomTreeNode, value: Int) {
        if (node.leftNode == null) {
            node.addLeftNode(CustomTreeNode(value))
        } else if (node.rightNode == null) {
            node.addRightNode(CustomTreeNode(value))
        } else {
            val leftNode = node.leftNode
            val rightNode = node.rightNode
            if(leftNode?.leftNode != null && leftNode.rightNode != null){
                insertRecursively(rightNode!!, value)
            } else {
                insertRecursively(leftNode!!, value)
            }
        }
    }
}
