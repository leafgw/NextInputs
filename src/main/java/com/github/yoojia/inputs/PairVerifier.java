package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.7
 */
public abstract class PairVerifier<T> extends TypedVerifier<T> {

    private final Loader2A<T> mValueLoader;

    public PairVerifier(Loader2A<T> valueLoader) {
        mValueLoader = valueLoader;
    }

    public PairVerifier(final T fixedFirstValue, final T fixedSecondValue) {
        this(new Loader2A<T>() {
            @Override
            public T getFirstValue() {
                return fixedFirstValue;
            }

            @Override
            public T getSecondValue() {
                return fixedSecondValue;
            }
        });
    }

    final public T getBenchmarkValueA(){
        return mValueLoader.getFirstValue();
    }

    final public T getBenchmarkValueB(){
        return mValueLoader.getSecondValue();
    }

}
