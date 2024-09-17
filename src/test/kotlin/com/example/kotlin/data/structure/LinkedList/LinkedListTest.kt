package com.example.kotlin.data.structure.LinkedList

import com.example.kotlin.data.structure.LinkedList.CustomLinked
import com.example.kotlin.data.structure.LinkedList.CustomNode
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
        val actual = CustomLinked()
        val headNode = CustomNode(1)
        val nodes = CustomNode(2)
        val tailNode = CustomNode(3)

        actual.addNode(headNode)
        actual.addNode(nodes)
        actual.addNode(tailNode)

        assertTrue(actual.head?.value == 1)
        assertTrue(actual.head?.next == nodes)
        assertTrue(actual.nodes[0].next?.value == 2)
        assertTrue(actual.nodes[0].next?.next == tailNode)
        assertTrue(actual.tail?.value == 3)
    }

}