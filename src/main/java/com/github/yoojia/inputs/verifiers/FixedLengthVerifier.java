package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.6.1
 */
public class FixedLengthVerifier extends SingleVerifier<Long> {

    public FixedLengthVerifier(Loader0<Long> valueLoader) {
        super(valueLoader);
    }

    public FixedLengthVerifier(long fixedValue) {
        super(fixedValue);
    }

    @Override
    protected boolean performTypedTest(Long typedInput) {
        return typedInput.longValue() == getBasedValue();
    }

    @Override
    protected Long stringToTyped(String notEmptyInput) {
        return (long)notEmptyInput.length();
    }
}
