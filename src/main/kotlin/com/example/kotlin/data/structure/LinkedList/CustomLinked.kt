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
        if(_nodes.size <= 1){
            addHead()
        }
        addTail(node)
    }

    fun addNode(node: CustomNode, index: Int) {
        if(index == 0){
            _nodes.add(0, node)
            _nodes[0].next = _nodes[1]
            addHead()
        }else if (index > _nodes.size) {
            addNode(node)
        }else {
            _nodes.add(index, node)
            _nodes[index-1].next = _nodes[index]
            _nodes[index].next = _nodes[index + 1]
        }
    }

    fun getSize(): Int{
        return nodes.size
    }

    fun deleteNode(index: Int) {
        if(index == 0){
            _nodes.removeAt(0)
            addHead()
        }else if(index == _nodes.size - 1){
            _nodes.removeAt(index)
            _tail = _nodes[index - 1]
        }else{
            _nodes[index - 1].next = _nodes[index + 1]
            _nodes.removeAt(index)
        }
    }

    fun getNode(index: Int): CustomNode? {
        if(!verifyIndex(index)) return null
        return _nodes[index]
    }

    fun changeNode(index: Int, value: Int): CustomNode? {
        if(!verifyIndex(index)) return null
        _nodes[index].value = value
       return _nodes[index]
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

    private fun verifyIndex(index: Int): Boolean {
        return index >= 0 && index < _nodes.size
    }
}
