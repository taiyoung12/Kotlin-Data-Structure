package com.example.kotlin.data.structure.Stack

import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test
import kotlin.test.assertTrue

class StackTest {

    @Test
    fun `Stack을 생성할 수 있다`(){
        assertDoesNotThrow { CustomStack<Any>() }
    }

    @Test
    fun `Stack에 데이터를 push할 수 있다`(){
        val stack = CustomStack<Int>()
        stack.push(1)

        assertTrue(stack.size() == 1)
    }

    @Test
    fun `Stack에 데이터를 2개 이상 push할 수 있다`(){
        val stack = CustomStack<Int>()
        stack.push(1)
        stack.push(2)

        assertTrue(stack.size() == 2)
    }

    @Test
    fun `Stack에서 데이터를 pop할 수 있다`(){
        val stack = getStack(listOf(1))
        stack.pop()

        assertTrue(stack.size() == 0)
    }

    @Test
    fun `후입선출 방식으로 pop할 수 있다`(){
        val stack = getStack(listOf(1, 2,3))

        assertTrue { stack.pop() == 3}
        assertTrue { stack.size() == 2 }
    }

    @Test
    fun `peek을 통해 Stack의 가장 위의 데이터를 확인할 수 있다`() {
        val stack = getStack(listOf(1, 2, 3))

        assertTrue { stack.peek() == 3 }
    }

    @Test
    fun `Stack에서 임의의 인덱스로 데이터를 조회할 수 있다`(){
        val stack = getStack(listOf(1, 2, 3))

        assertTrue { stack.indexOf(1) == 2 }
    }

    @Test
    fun `Stack 사이즈 이상으로 pop 한다면 null을 리턴할 수 있다`(){
        val stack = getStack(listOf(1, 2, 3))

        stack.pop()
        stack.pop()
        stack.pop()

        assertTrue{ stack.pop() == null }
    }

    @Test
    fun `Stack이 비어있을 때 peek 호출 시 null을 리턴할 수 있다`(){
        val stack = CustomStack<Int>()

        assertTrue{ stack.peek() == null }
    }

    private fun <T> getStack(values: List<T>): CustomStack<T> {
        val stack = CustomStack<T>()
        values.forEach { stack.push(it) }
        return stack
    }
}