package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.8
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

    protected T getBasedValue(){
        return mValueLoader.getValue();
    }

    protected abstract boolean performTypedTest(T typedInput);
}
