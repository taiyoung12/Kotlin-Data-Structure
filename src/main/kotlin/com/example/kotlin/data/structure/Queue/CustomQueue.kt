package com.example.kotlin.data.structure.Queue

class CustomQueue<T> {
    private val _queue = mutableListOf<T>()

    val queue: List<T>
        get() = _queue

    fun size(): Int {
        return queue.size
    }

    fun enqueue(value: T): T {
         _queue.add(value)
        return value
    }

    fun dequeue(): T? {
        return _queue.removeAt(0)
    }

    fun peek(): T? {
        return queue[0]
    }

    fun isEmpty(): Boolean{
        return _queue.isEmpty()
    }

    fun indexOf(index: Int): T? {
        return queue[index]
    }

    fun clear() {
        _queue.clear()
    }

}
