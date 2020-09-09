package com.guhungry.bowling

class Game {
    private val rolls = IntArray(21) { 0 }
    private var rollIndex = 0

    fun roll(pins: Int) {
        rolls[rollIndex++] = pins
    }

    fun score(): Int {
        var score = 0
        var firstInFrame = 0

        repeat(10) {
            score += when {
                isStrike(firstInFrame) -> 10 + strikeBonus(firstInFrame)
                isSpare(firstInFrame) -> 10 + spareBonus(firstInFrame)
                else -> frameScore(firstInFrame)
            }

            firstInFrame += if (isStrike(firstInFrame)) 1 else 2
        }

        return score
    }

    private fun isStrike(firstInFrame: Int) = rolls[firstInFrame] == 10
    private fun strikeBonus(firstInFrame: Int) = rolls[firstInFrame + 1] + rolls[firstInFrame + 2]
    private fun isSpare(firstInFrame: Int) = frameScore(firstInFrame) == 10
    private fun spareBonus(firstInFrame: Int) = rolls[firstInFrame + 2]
    private fun frameScore(firstInFrame: Int) = rolls[firstInFrame] + rolls[firstInFrame + 1]
}
