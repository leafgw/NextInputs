package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.PairAdapter;
import com.github.yoojia.inputs.LazyLoader;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class EqualsBridge extends PairAdapter<String> {

    private final LazyLoader<String> mStringLazyLoader;

    public EqualsBridge(LazyLoader<String> lazyLoader) {
        this.mStringLazyLoader = lazyLoader;
    }

    @Override
    public String getFirst() {
        return mStringLazyLoader.getValue();
    }

    @Override
    public String getSecond() {
        return mStringLazyLoader.getValue();
    }

    @Override
    public String inputToTyped(String input) {
        return input;
    }

    @Override
    public boolean perform(String input, String first, String second) {
        return input.equals(first);
    }
}
