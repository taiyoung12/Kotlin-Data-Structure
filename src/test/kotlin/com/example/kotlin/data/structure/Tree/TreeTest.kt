package com.example.kotlin.data.structure.Tree

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.assertTrue


class TreeTest {

    @Test
    fun `노드를 생성할 수 있다`(){
        val node = CustomTreeNode(1)

        assert(node.value == 1)
    }

    @Test
    fun `노드는 자식노드를 가질 수 있다`(){
        val node = CustomTreeNode(1)
        node.addLeftNode(CustomTreeNode(2))
        node.addRightNode(CustomTreeNode(3))

        assertTrue { node.leftNode?.value == 2 }
        assertTrue { node.rightNode?.value == 3 }
    }

    @Test
    fun `트리를 생성할 수 있다`(){
        assertDoesNotThrow {
            CustomTree()
        }
    }

    @Test
    fun `트리는 루트 노드를 가질 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        assertTrue{ tree.root.value == 1 }
    }

    @Test
    fun `루트 노드의 왼쪽 자식 노드를 삽입할 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        tree.insert(2)

        assertTrue { tree.root.leftNode?.value == 2 }
    }

    @Test
    fun `루트 노드의 왼쪽, 오른쪽 자식 노드를 삽입할 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        tree.insert(2)
        tree.insert(3)

        assertTrue { tree.root.leftNode?.value == 2 }
        assertTrue { tree.root.rightNode?.value == 3 }
    }

    @Test
    fun `트리의 뎁스가 2인 경우 왼쪽 자식 노드를 삽입할 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        tree.insert(2)
        tree.insert(3)
        tree.insert(4)

        assertTrue { tree.root.leftNode?.leftNode?.value == 4 }
    }

    @Test
    fun `트리의 뎁스가 2인 경우 왼쪽 자식 노드에 자식 노드를 삽입할 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        tree.insert(2)
        tree.insert(3)
        tree.insert(4)
        tree.insert(5)

        assertTrue { tree.root.leftNode?.leftNode?.value == 4 }
        assertTrue { tree.root.leftNode?.rightNode?.value == 5 }
    }

    @Test
    fun `트리의 뎁스가 2인 경우 오른쪽 자식 노드에 자식 노드를 삽입할 수 있다`(){
        val tree = CustomTree(CustomTreeNode(1))

        tree.insert(2)
        tree.insert(3)
        tree.insert(4)
        tree.insert(5)
        tree.insert(6)
        tree.insert(7)

        assertTrue { tree.root.rightNode?.leftNode?.value == 6 }
        assertTrue { tree.root.rightNode?.rightNode?.value == 7 }
    }
}