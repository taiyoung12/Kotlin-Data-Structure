package com.example.kotlin.data.structure.Stack

class CustomStack<T> {
    private val _stack = mutableListOf<T>()
    val stack: List<T>
        get() = _stack

    fun push(value: T) {
        _stack.add(value)
    }

    fun pop(): T? {
        if (_stack.isEmpty()) {
            return null
        }
        return _stack.removeAt(_stack.size - 1)
    }

    fun peek(): T? {
        if (_stack.isEmpty()) {
            return null
        }
        return _stack[_stack.size - 1]
    }

    fun indexOf(index : Int): T {
        return _stack[index]
    }

    fun size(): Int {
        return stack.size
    }
}
