package com.example.kotlin.data.structure.LinkedList

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LinkedListTest {

    private val node = CustomNode(1)

    @Test
    fun `값을 가진 노드를 생성할 수 있다`(){
        val actual = CustomNode(
            1
        )

        assertTrue(actual is CustomNode)
    }

    @Test
    fun `값과 다음 노드를 가진 노드를 생성할 수 있다`(){
        val actual = CustomNode(
            1,
            CustomNode(2)
        )

        assertTrue(actual is CustomNode)
    }

    @Test
    fun `연결 리스트 생성 시 node가 하나밖에 없다면 head 와 tail은 같다`(){
        val actual = CustomLinked()
        actual.addNode(node)

        assertTrue(actual.head == actual.tail)
        assertTrue(actual.head?.value == 1)
        assertTrue(actual.head?.next == null)
    }

    @Test
    fun `연결리스트 생성 시 node를 2개 추가한다면 head, tail은 나뉘어 진다`(){
        val actual = CustomLinked()
        val headNode = CustomNode(1)
        val tailNode = CustomNode(2)
        actual.addNode(headNode)
        actual.addNode(tailNode)

        assertTrue(actual.head?.value == 1)
        assertTrue(actual.head?.next == tailNode)
        assertTrue(actual.head?.next == actual.tail)
        assertTrue(actual.tail?.value == 2)
    }

    @Test
    fun `연결리스트 생성 시 node가 3개 추가된다면 head, nodes, tail 을 생성할 수 있다`(){
        val actual = getLinkedList()

        assertTrue(actual.head?.value == 1)
        assertTrue(actual.nodes[0].next?.value == 2)
        assertTrue(actual.tail?.value == 3)
    }

    @Test
    fun `연결리스트에 노드 추가 시 인덱스를 넘기면 해당 인덱스에 노드를 추가할 수 있다`(){
        val actual = getLinkedList()

        assertTrue(actual.head?.next?.value == 2)

        actual.addNode(CustomNode(4), 1)

        assertTrue(actual.head?.next?.value == 4)
        assertTrue(actual.head?.next?.next?.value == 2)
    }

    @Test
    fun `연결리스트에 노드 추가 시 head 인덱스를 넘기면 head 노드는 변경되어질 수 있다`(){
        val actual = getLinkedList()
        assertTrue(actual.head?.value == 1)

        actual.addNode(CustomNode(10), 0)

        assertTrue(actual.head?.value == 10)
        assertTrue(actual.head?.next?.value == 1)
    }

    @Test
    fun `연결리스트의 길이를 조회할 수 있다`(){
        val actual = getLinkedList()

        assertTrue(actual.getSize() == 3)
    }

    @Test
    fun `연결리스트에 노드 추가 시 tail 인덱스를 넘기면 tail 노드는 변경되어질 수 있다`(){
        val actual = getLinkedList()
        assertTrue(actual.tail?.value == 3)

        actual.addNode(CustomNode(4), actual.getSize()+1)

        assertTrue(actual.head?.next?.next?.next?.value == 4)
    }

    private fun getLinkedList(): CustomLinked {
        val actual = CustomLinked()
        val headNode = CustomNode(1)
        val nodes = CustomNode(2)
        val tailNode = CustomNode(3)

        actual.addNode(headNode)
        actual.addNode(nodes)
        actual.addNode(tailNode)

        return actual
    }
}