package com.example.kotlin.data.structure.Tree

data class CustomTreeNode(
    val value: Int = 0,
    var left: CustomTreeNode? = null,
    var right: CustomTreeNode? = null
)
