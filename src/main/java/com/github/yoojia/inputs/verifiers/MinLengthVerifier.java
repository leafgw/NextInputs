package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.SingleVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.1
 */
public class MinLengthVerifier extends SingleVerifier<Long> {

    public MinLengthVerifier(Loader0<Long> valueLoader) {
        super(valueLoader);
    }

    public MinLengthVerifier(long fixedValue) {
        super(fixedValue);
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return notEmptyInput.length() >= getBasedValue();
    }
}
