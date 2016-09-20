package com.github.yoojia.inputs;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.7
 */
public abstract class PairVerifier<T> extends EmptyableVerifier {

    private final Loader1<T> mValueLoader;

    public PairVerifier(Loader1<T> valueLoader) {
        mValueLoader = valueLoader;
    }

    public PairVerifier(final T fixedFirstValue, final T fixedSecondValue) {
        this(new Loader1<T>() {
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

    final protected T getFirstBasedValue(){
        return mValueLoader.getFirstValue();
    }

    final protected T getSecondBasedValue(){
        return mValueLoader.getSecondValue();
    }

    @Override
    final public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        return performTestValue(stringToTyped(notEmptyInput));
    }

    protected abstract boolean performTestValue(T typedInput);

    protected abstract T stringToTyped(String notEmptyInput);


}
