package com.example.kotlin.data.structure.Tree

import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertTrue

class TreeTest {
    @Test
    fun `노드를 생성할 수 있다`(){
        assertDoesNotThrow {
            CustomTreeNode()
        }
    }
    @Test
    fun `노드는 값을 가질 수 있다`(){
        val node = CustomTreeNode(1)
        assertTrue { node.value == 1 }
    }

    @Test
    fun `노드는 자식 노드를 가질 수 있다`(){
        val node = CustomTreeNode(1)
        node.addLeft(CustomTreeNode(2))
        node.addRight(CustomTreeNode(3))

        assertTrue { node.value == 1 }
        assertTrue { node.left?.value == 2 }
        assertTrue { node.right?.value == 3 }
    }

    @Test
    fun `트리를 생성할 수 있다`(){
        assertDoesNotThrow {
            CustomTree()
        }
    }

    @Test
    fun `트리에 노드를 추가할 수 있다`(){
        val tree = CustomTree()
        val node = CustomTreeNode(1)

        tree.addNode(node)

        assertTrue {tree.size == 1}
    }

    @Test
    fun `트리의 루트노드를 가져올 수 있다`(){
        val tree = CustomTree()
        val node = CustomTreeNode(1)

        tree.addNode(node)

        assertTrue {tree.root == node}
    }

    @Test
    fun `트리에 노드가 없다면 루트노드는 null을 반활할 수 있다`(){
        val tree = CustomTree()

        assertTrue { tree.root == null }
    }

    @Test
    fun `루트노드에 자식노드를 추가할 수 있다`(){
        val tree = getTree()

        assertTrue { tree.root?.value == 1 }
        assertTrue { tree.root?.left?.value == 2 }
        assertTrue { tree.root?.right?.value == 3 }
    }

    @Test
    fun `2개 이상의 노드를 추가할 수 있다`(){
        val tree = getTree()
        tree.addNode(CustomTreeNode(4), CustomTreeNode(5), CustomTreeNode(6))

        assertTrue {tree.root?.left?.left?.value == 4}
        assertTrue {tree.root?.left?.right?.value == 5}
        assertTrue {tree.root?.right?.left?.value == 6}
    }

    private fun getTree(): CustomTree {
        val tree = CustomTree()
        val node = CustomTreeNode(1)
        tree.addNode(node)
        tree.addNode(node, CustomTreeNode(2), CustomTreeNode(3))
        return tree
    }
}