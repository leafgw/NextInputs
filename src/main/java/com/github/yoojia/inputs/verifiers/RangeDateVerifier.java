package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1;

import java.text.SimpleDateFormat;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeDateVerifier extends PairDateTimeVerifier{

    public RangeDateVerifier(String first, String second)  {
        super(first, second, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(String first, String second, SimpleDateFormat format) {
        super(first, second, format);
    }

    public RangeDateVerifier(Loader1<String> pairDateTimeLoader) {
        super(pairDateTimeLoader, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(Loader1<String> pairDateTimeLoader, SimpleDateFormat format) {
        super(pairDateTimeLoader, format);
    }

    @Override
    protected boolean performTest(long firstValue, long secondValue, long sourceValue) {
        return firstValue < sourceValue && sourceValue < secondValue;
    }
}
