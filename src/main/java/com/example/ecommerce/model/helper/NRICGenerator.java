package com.example.ecommerce.model.helper;

import org.springframework.stereotype.Component;

@Component
public class NRICGenerator {
    private static final char[] NRIC_PREFIX = new char[]{'S', 'T', 'F', 'G'};
    private static final char[] NRIC_SUFFIX = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String getRandomNRIC() {
        int prefixIndex = (int) ((Math.random() * NRIC_PREFIX.length));
        int suffixIndex = (int) ((Math.random() * NRIC_SUFFIX.length));
        return NRIC_PREFIX[prefixIndex] + String.format("%019d", System.currentTimeMillis()).substring(12, 19) + NRIC_SUFFIX[suffixIndex];
    }
}