package com.example.kotlin.data.structure.Tree

data class CustomTreeNode(
    val value: Int = 0,
    var leftNode: CustomTreeNode? = null,
    var rightNode: CustomTreeNode? = null,
){
    fun addLeftNode(node: CustomTreeNode){
        this.leftNode = node
    }

    fun addRightNode(node: CustomTreeNode){
        this.rightNode = node
    }
}
