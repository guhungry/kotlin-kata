package com.guhungry.bowling

class Game {
    var rolls = IntArray(21) { 0 }
    var rollIndex = 0

    fun roll(pins: Int) {
        rolls[rollIndex++] = pins
    }

    fun score(): Int {
        var score = 0
        var frameIndex = 0

        (1..10).forEach { _ ->
            score += when {
                isStrike(frameIndex) -> 10 + strikeBonus(frameIndex)
                isSpare(frameIndex) -> 10 + spareBonus(frameIndex)
                else -> frameScore(frameIndex)
            }
            frameIndex += if (isStrike(frameIndex)) 1 else 2
        }

        return score
    }

    private fun isStrike(frameIndex: Int) = rolls[frameIndex] == 10
    private fun strikeBonus(frameIndex: Int) = rolls[frameIndex + 1] + rolls[frameIndex + 2]
    private fun isSpare(frameIndex: Int) = frameScore(frameIndex) == 10
    private fun spareBonus(frameIndex: Int) = rolls[frameIndex + 2]
    private fun frameScore(frameIndex: Int) = rolls[frameIndex] + rolls[frameIndex + 1]
}
