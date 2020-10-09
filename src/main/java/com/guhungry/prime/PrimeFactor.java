package com.guhungry.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactor {
    public static List<Integer> of(int n) {
        List<Integer> factors = new ArrayList<Integer>();
        int max = (int)Math.sqrt(n);
        for (int divisor = 2; n > 1 && divisor <= max; divisor += divisor > 2 ? 2 : 1)
            for (; n % divisor == 0; n /= divisor)
                factors.add(divisor);
        if (n > 1) factors.add(n);
        return factors;
    }
}
