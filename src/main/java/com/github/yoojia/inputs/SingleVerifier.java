package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.7
 */
public abstract class SingleVerifier<T> extends TypedVerifier<T> {

    private final Loader0<T> mValueLoader;

    public SingleVerifier(Loader0<T> valueLoader) {
        mValueLoader = valueLoader;
    }

    public SingleVerifier(final T fixedValue) {
        mValueLoader = new Loader0<T>() {
            @Override
            public T getValue() {
                return fixedValue;
            }
        };
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return performTypedTest(stringToTyped(notEmptyInput));
    }

    protected T getBasedValue(){
        return mValueLoader.getValue();
    }

    protected abstract T stringToTyped(String notEmptyInput);

    protected abstract boolean performTypedTest(T typedInput);
}
