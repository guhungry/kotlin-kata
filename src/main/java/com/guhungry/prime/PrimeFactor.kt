package com.guhungry.prime

fun Int.primeFactors(): IntArray {
    val factors = arrayListOf<Int>()
    var n = this
    val max = kotlin.math.sqrt(n.toDouble()).toInt()
    for (divisor in 2 .. max)
        while (n % divisor == 0) {
            factors.add(divisor)
            n /= divisor
        }
    if (n > 1) factors.add(n)
    return factors.toIntArray()
}