package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeDateTimeVerifier extends PairDateTimeVerifier{

    public RangeDateTimeVerifier(String first, String second) {
        super(first, second, SingleDateTimeVerifier.DATE_TIME_FORMAT);
    }

    public RangeDateTimeVerifier(String first, String second, SimpleDateFormat format) {
        super(first, second, format);
    }

    @Override
    protected boolean performTest(long firstValue, long secondValue, long sourceValue) {
        return firstValue < sourceValue && sourceValue < secondValue;
    }
}
