package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.LazyLoader;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.1
 */
public class NotEqualsBridge extends EqualsBridge {

    public NotEqualsBridge(LazyLoader<String> lazyLoader) {
        super(lazyLoader);
    }

    @Override
    public boolean perform(String input, String first, String second) {
        return ! input.equals(first);
    }
}