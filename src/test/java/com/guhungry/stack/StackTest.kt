package com.guhungry.stack

import com.guhungry.stack.Stack.*
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StackTest {
    var sut: Stack? = null

    @BeforeEach
    fun setup() {
        sut = Stack.make(2)
    }

    @AfterEach
    fun teardown () {
        sut = null
    }

    @Test
    fun newlyCreatedStack_ShouldBeEmpty() {
        assertThat(sut!!.isEmpty(), equalTo(true))
        assertThat(sut!!.getSize(), equalTo(0))
    }

    @Test
    fun push1_ShouldHaveSize1() {
        sut!!.push(1)

        assertThat(sut!!.getSize(), equalTo(1))
        assertThat(sut!!.isEmpty(), equalTo(false))
    }

    @Test
    fun push1ThenPop_ShouldHaveSize0() {
        sut!!.push(1)
        sut!!.pop()

        assertThat(sut!!.getSize(), equalTo(0))
        assertThat(sut!!.isEmpty(), equalTo(true))
    }

    @Test
    fun whenPushPassLimit_ShouldThrowOverflow() {
        assertThrows<Overflow> {
            sut!!.push(1)
            sut!!.push(1)
            sut!!.push(1)
        }
    }

    @Test
    fun popWhenEmpty_ShouldThrowUnderflow() {
        assertThrows<Underflow> {
            sut!!.pop()
        }
    }

    @Test
    fun whenPush1And2ThenPop_ShouldHaveSize1() {
        sut!!.push(1)
        sut!!.push(1)
        sut!!.pop()

        assertThat(sut!!.getSize(), equalTo(1))
        assertThat(sut!!.isEmpty(), equalTo(false))
    }

    @Test
    fun whenPush1ThenPop_ValueIs1() {
        sut!!.push(1)

        assertThat(sut!!.pop(), equalTo(1))
    }

    @Test
    fun whenPush1And2_Then2And1IsPopped() {
        sut!!.push(1)
        sut!!.push(2)

        assertThat(sut!!.pop(), equalTo(2))
        assertThat(sut!!.pop(), equalTo(1))
    }

    @Test
    fun createWithNegativeSize_ShouldThrowInvalidCapacity() {
        assertThrows<IllegalCapacity> {
            sut = Stack.make(-1)
        }
    }

    @Test
    fun zeroSizeAnyPush_ShouldThrowOverflow() {
        sut = Stack.make(0)

        assertThrows<Overflow> {
            sut!!.push(1)
        }
    }

    @Test
    fun zeroSizeAnyPop_ShouldThrowUnderflow() {
        sut = Stack.make(0)

        assertThrows<Underflow> {
            sut!!.pop()
        }
    }

    @Test
    fun push1_1IsTop() {
        sut!!.push(1)

        assertThat(sut!!.top(), equalTo(1))
    }

    @Test
    fun whenEmptyThenPop_ShouldThrowEmpty() {
        assertThrows<Empty> {
            sut!!.top()
        }
    }

    @Test
    fun zeroSizeAnyPop_ShouldThrowEmpty() {
        sut = Companion.make(0)

        assertThrows<Empty> {
            sut!!.top()
        }
    }

    @Test
    fun push1And2_Find1And2() {
        sut!!.push(1)
        sut!!.push(2)

        assertThat(sut!!.find(1), equalTo(1))
        assertThat(sut!!.find(2), equalTo(0))
    }

    @Test
    fun push1AndFind2_ShouldReturnNull() {
        sut!!.push(1)

        assertThat(sut!!.find(2), nullValue())
    }

    @Test
    fun zeroSizeAnyFind_ShouldReturnNull() {
        sut = Stack.make(0)

        assertThat(sut!!.find(2), nullValue())
    }
}