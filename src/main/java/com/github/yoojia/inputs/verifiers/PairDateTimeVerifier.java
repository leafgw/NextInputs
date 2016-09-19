package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class PairDateTimeVerifier extends EmptyableVerifier{

    private final long mFirstValue;
    private final long mSecondValue;
    private final SimpleDateFormat mFormat;

    public PairDateTimeVerifier(String first, String second, SimpleDateFormat format) {
        mFormat = format;
        try {
            mFirstValue = format.parse(first).getTime();
            mSecondValue = format.parse(second).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final long sourceValue = mFormat.parse(notEmptyInput).getTime();
        return performTest(mFirstValue, mSecondValue, sourceValue);
    }

    protected abstract boolean performTest(long firstValue, long secondValue, long sourceValue);

}
