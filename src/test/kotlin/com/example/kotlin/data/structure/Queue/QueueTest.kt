package com.example.kotlin.data.structure.Queue

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class QueueTest {

    @Test
    fun `Queue을 생성할 수 있다`() {
        assertDoesNotThrow { CustomQueue<Any>() }
    }

    @Test
    fun `Queue에 길이를 알 수 있다`() {
        val queue = CustomQueue<Int>()
        assertTrue(queue.size() == 0)
    }

    @Test
    fun `Queue에 데이터를 enqueue할 수 있다`() {
        val queue = CustomQueue<Int>()
        queue.enqueue(1)

        assertTrue(queue.size() == 1)
    }

    @Test
    fun `Queue에 데이터를 2개 이상 enqueue할 수 있다`() {
        val queue = CustomQueue<Int>()
        queue.enqueue(1)
        queue.enqueue(2)

        assertTrue(queue.size() == 2)
    }

    @Test
    fun `Queue에 데이터를 dequeue할 수 있다`(){
        val queue = getQueue(listOf(1))
        queue.dequeue()

        assertTrue(queue.size() == 0)
    }

    @Test
    fun `데이터를 선입 선출 로 dequeue 할 수 있다`(){
        val queue = CustomQueue<Int>()
        val firstValue = queue.enqueue(1)
        queue.enqueue(2)

        assertTrue(firstValue == queue.dequeue())
    }

    @Test
    fun `Queue에 데이터를 peek할 수 있다`(){
        val queue = getQueue(listOf(1, 2, 3))

        assertTrue(queue.peek() == 1)
    }

    @Test
    fun `Queue가 비었는지 확인할 수 있다`(){
        val queue = CustomQueue<Int>()
        assertTrue(queue.isEmpty())
    }

    @Test
    fun `Queue가 null이 아님을 확인할 수 있다`(){
        val queue = getQueue(listOf(1, 2, 3))
        assertFalse(queue.isEmpty())
    }

    @Test
    fun `인덱스를 통해 Queue의 값을 알 수 있다`(){
        val queue = getQueue(listOf(1, 2, 3))
        assertTrue(queue.indexOf(1) == 2)
    }

    @Test
    fun `Queue를 비울 수 있다`(){
        val queue = getQueue(listOf(1, 2, 3))
        queue.clear()
        assertTrue(queue.isEmpty())
    }

    @Test
    fun `null Queue를 비울 수 있다`(){
        val queue = CustomQueue<Int>()
        queue.clear()
        assertTrue(queue.isEmpty())
    }

    private fun getQueue(list: List<Int>): CustomQueue<Int> {
        val queue = CustomQueue<Int>()
        list.forEach { queue.enqueue(it) }
        return queue
    }
}