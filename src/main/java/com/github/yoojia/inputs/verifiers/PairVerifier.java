package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.PairAdapter;
import com.github.yoojia.inputs.EmptyableVerifier;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class PairVerifier<T> extends EmptyableVerifier {

    private final PairAdapter<T> mAdapter;

    public PairVerifier(PairAdapter<T> adapter) {
        mAdapter = adapter;
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final T value = mAdapter.inputToTyped(notEmptyInput);
        return mAdapter.perform(value,
                mAdapter.getFirst(),
                mAdapter.getSecond());
    }
}
