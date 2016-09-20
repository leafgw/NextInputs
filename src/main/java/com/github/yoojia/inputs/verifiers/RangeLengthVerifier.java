package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1;
import com.github.yoojia.inputs.PairVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeLengthVerifier extends PairVerifier<Long> {

    public RangeLengthVerifier(Loader1<Long> valueLoader) {
        super(valueLoader);
    }

    public RangeLengthVerifier(long fixedFirstValue, long fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue);
    }

    @Override
    protected boolean performTestValue(Long typedInput) {
        final long minLength  = getFirstBasedValue();
        final long maxLength  = getSecondBasedValue();
        return minLength <= typedInput && typedInput <= maxLength;
    }

    @Override
    protected Long stringToTyped(String notEmptyInput) {
        return (long)notEmptyInput.length();
    }
}
