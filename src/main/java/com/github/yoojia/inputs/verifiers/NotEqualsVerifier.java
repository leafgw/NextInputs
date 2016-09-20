package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class NotEqualsVerifier extends SingleVerifier<String> {

    public NotEqualsVerifier(Loader0<String> valueLoader) {
        super(valueLoader);
    }

    public NotEqualsVerifier(String fixedValue) {
        super(fixedValue);
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return !notEmptyInput.equals(getBasedValue());
    }
}
