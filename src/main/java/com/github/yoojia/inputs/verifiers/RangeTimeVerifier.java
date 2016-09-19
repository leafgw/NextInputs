package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeTimeVerifier extends PairDateTimeVerifier{

    public RangeTimeVerifier(String first, String second) {
        super(first, second, SingleDateTimeVerifier.TIME_FORMAT);
    }

    public RangeTimeVerifier(String first, String second, SimpleDateFormat format) {
        super(first, second, format);
    }

    @Override
    protected boolean performTest(long firstValue, long secondValue, long sourceValue) {
        return firstValue < sourceValue && sourceValue < secondValue;
    }
}
