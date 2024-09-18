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

    fun addNode(node: CustomNode, index: Int) {
        when(index){
            0 -> {
                _nodes.add(0, node)
                _nodes[0].next = _nodes[1]
                addHead()
            }
            else -> {
                if(index > _nodes.size){
                   addNode(node)
                }else{
                    _nodes.add(index, node)
                    _nodes[index-1].next = _nodes[index]
                    _nodes[index].next = _nodes[index + 1]
                }
            }
        }
    }

    fun getSize(): Int{
        return nodes.size
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
