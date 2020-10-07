package com.guhungry.prime

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class PrimeFactorTest {
    @Test
    fun `prime factors`() {
        assertThat(1.primeFactors(), equalTo(intArrayOf()))
        assertThat(2.primeFactors(), equalTo(intArrayOf(2)))
        assertThat(3.primeFactors(), equalTo(intArrayOf(3)))
        assertThat(4.primeFactors(), equalTo(intArrayOf(2, 2)))
        assertThat(5.primeFactors(), equalTo(intArrayOf(5)))
        assertThat(6.primeFactors(), equalTo(intArrayOf(2, 3)))
        assertThat(7.primeFactors(), equalTo(intArrayOf(7)))
        assertThat(8.primeFactors(), equalTo(intArrayOf(2, 2, 2)))
        assertThat(9.primeFactors(), equalTo(intArrayOf(3, 3)))
        assertThat(10.primeFactors(), equalTo(intArrayOf(2, 5)))
        assertThat((2 * 3 * 3 * 5 * 11 * 17).primeFactors(), equalTo(intArrayOf(2, 3, 3, 5, 11, 17)))
    }
}