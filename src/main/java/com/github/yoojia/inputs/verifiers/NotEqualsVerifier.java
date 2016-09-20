package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class NotEqualsVerifier extends EqualsVerifier {

    public NotEqualsVerifier(Loader0<String> valueLoader) {
        super(valueLoader);
    }

    public NotEqualsVerifier(String fixedValue) {
        super(fixedValue);
    }

    @Override
    protected boolean performTypedTest(String typedInput) {
        return !super.performTypedTest(typedInput);
    }

}
