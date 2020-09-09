package com.guhungry.bowling

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BowlingGameTest {
    private lateinit var sut: Game

    @BeforeEach
    fun setup() {
        sut = Game()
    }

    private fun rollMany(times: Int, pins: Int) {
        repeat(times) {
            sut.roll(pins)
        }
    }

    private fun rollSpare() {
        sut.roll(5)
        sut.roll(5)
    }

    private fun rollStrike() {
        sut.roll(10)
    }

    @Test
    fun gutterGame_Score0() {
        rollMany(20, 0)

        assertThat(sut.score(), equalTo(0))
    }

    @Test
    fun allOnes_Score20() {
        rollMany(20, 1)

        assertThat(sut.score(), equalTo(20))
    }

    @Test
    fun oneSpare_Score16() {
        rollSpare()
        sut.roll(3)
        rollMany(17, 0)

        assertThat(sut.score(), equalTo(16))
    }

    @Test
    fun oneStrike_Score26() {
        rollStrike()
        sut.roll(5)
        sut.roll(3)
        rollMany(16, 0)

        assertThat(sut.score(), equalTo(26))
    }

    @Test
    fun perfectGame_Score300() {
        rollMany(12, 10)

        assertThat(sut.score(), equalTo(300))
    }
}