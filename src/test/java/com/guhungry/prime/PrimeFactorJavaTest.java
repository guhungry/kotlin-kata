package com.guhungry.prime;

import org.hamcrest.Matcher;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrimeFactorJavaTest {
    @Test
    void primeFactor() {
        assertThat(primeFactorOf(1), isListOf());
        assertThat(primeFactorOf(2), isListOf(2));
        assertThat(primeFactorOf(3), isListOf(3));
        assertThat(primeFactorOf(4), isListOf(2, 2));
        assertThat(primeFactorOf(5), isListOf(5));
        assertThat(primeFactorOf(6), isListOf(2, 3));
        assertThat(primeFactorOf(7), isListOf(7));
        assertThat(primeFactorOf(8), isListOf(2, 2, 2));
        assertThat(primeFactorOf(9), isListOf(3, 3));
        assertThat(primeFactorOf(10), isListOf(2, 5));
        assertThat(primeFactorOf(210), isListOf(2, 3, 5, 7));
    }

    @NotNull
    private Matcher<List<Integer>> isListOf(Integer ...ints) {
        return equalTo(Arrays.asList(ints));
    }

    private List<Integer> primeFactorOf(Integer n) {
        return PrimeFactor.of(n);
    }
}
