package com.example.kotlin.data.structure.LinkedList

class CustomLinked {
    private var _head: CustomNode? = null
    private val _nodes = mutableListOf<CustomNode>()
    private var _tail: CustomNode? = null
    val nodes: List<CustomNode> = _nodes
    val head: CustomNode?
        get() = _head
    val tail: CustomNode?
        get() = _tail


    fun addNode(node: CustomNode) {
        _nodes.add(node)
        addHead()
        addTail(node)
    }

    private fun addTail(node: CustomNode) {
        if(_nodes.size == 2) {
            _head?.next = node
        }
        _tail?.next = node
        _tail = _nodes[_nodes.size - 1]
    }

    private fun addHead() {
        _head = _nodes[0]
    }
}
