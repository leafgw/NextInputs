package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

/**
 * @author YOOJIA CHEN (yoojiachen@gmail.com)
 * @since 1.6.1
 */
public class FixedLengthVerifier extends EmptyableVerifier {

    private final int mLength;

    public FixedLengthVerifier(int mLength) {
        this.mLength = mLength;
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return notEmptyInput.length() == mLength;
    }
}
