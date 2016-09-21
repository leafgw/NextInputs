package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
 */
public abstract class TypedVerifier<T> extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return performTypedTest(stringToTyped(notEmptyInput));
    }

    protected abstract T getBasedValue();

    protected abstract T stringToTyped(String notEmptyInput);

    protected abstract boolean performTypedTest(T typedInput);
}
