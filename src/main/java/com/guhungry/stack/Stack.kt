package com.guhungry.stack

import com.guhungry.stack.Stack.*
import java.lang.RuntimeException

interface Stack {
    fun getSize(): Int
    fun isEmpty(): Boolean
    fun push(element: Int)
    fun pop(): Int
    fun top(): Int
    fun find(element: Int): Int?

    class Overflow: RuntimeException()
    class Underflow : RuntimeException()
    class IllegalCapacity : RuntimeException()
    class Empty : RuntimeException()

    companion object {
        fun make(capacity: Int): Stack {
            if (capacity < 0) throw IllegalCapacity()
            if (capacity == 0) return ZeroCapacityStack()
            return BoundedStack(capacity)
        }
    }
}

private class ZeroCapacityStack : Stack {
    override fun getSize(): Int = 0
    override fun isEmpty(): Boolean = true
    override fun push(element: Int) = throw Overflow()
    override fun pop(): Int = throw Underflow()
    override fun top(): Int = throw Empty()
    override fun find(element: Int): Int? = null
}

private class BoundedStack constructor(private val capacity: Int) : Stack {
    private var stacks = arrayOfNulls<Int>(capacity)
    private var size: Int = 0

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun getSize(): Int {
        return size
    }

    override fun push(element: Int) {
        if (size == capacity) throw Overflow()
        stacks[size++] = element
    }

    override fun pop(): Int {
        if (isEmpty()) throw Underflow()
        return stacks[--size]!!
    }

    override fun top(): Int {
        if (isEmpty()) throw Empty()
        return stacks[size - 1]!!
    }

    override fun find(element: Int): Int? {
        val index = stacks.lastIndexOf(element)
        return if (index >= 0)  size - 1 -index else null
    }
}
