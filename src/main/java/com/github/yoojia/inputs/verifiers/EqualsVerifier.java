package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0Ex;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class EqualsVerifier extends SingleVerifier<String> {

    public EqualsVerifier(Loader0<String> valueLoader) {
        super(valueLoader);
    }

    public EqualsVerifier(String fixedValue) {
        super(fixedValue);
    }

    @Override
    protected String stringToTyped(String notEmptyInput) {
        return notEmptyInput;
    }

    @Override
    protected boolean performTypedTest(String typedInput) {
        return typedInput.equals(getBasedValue());
    }
}
