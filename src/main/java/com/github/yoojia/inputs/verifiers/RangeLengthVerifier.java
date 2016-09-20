package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class RangeLengthVerifier extends com.github.yoojia.inputs.PairVerifier<Long> {

    public RangeLengthVerifier(Loader1<Long> valueLoader) {
        super(valueLoader);
    }

    public RangeLengthVerifier(long fixedFirstValue, long fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue);
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final int length = notEmptyInput.length();
        final long minLength  = getFirstBasedValue();
        final long maxLength  = getSecondBasedValue();
        return maxLength <= length && length <= maxLength;
    }
}
