package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;
import com.github.yoojia.inputs.Loader1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class PairDateTimeVerifier extends EmptyableVerifier{

    private final Loader1<Long> mBasedValueLoader;
    private final SimpleDateFormat mFormat;

    // Fixed DateTime Object
    public PairDateTimeVerifier(final Date firstValue, final Date secondValue, SimpleDateFormat format) {
        mFormat = format;
        mBasedValueLoader = new Loader1<Long>() {
            @Override
            public Long getFirstValue() {
                return firstValue.getTime();
            }

            @Override
            public Long getSecondValue() {
                return secondValue.getTime();
            }
        };
    }

    // Fixed DateTime String
    public PairDateTimeVerifier(String first, String second, SimpleDateFormat format) {
        this(parseDateTime(format, first),
                parseDateTime(format, second),
                format);
    }

    // Lazy loader: DateTime String
    public PairDateTimeVerifier(final Loader1<String> pairDateTimeLoader, final SimpleDateFormat format) {
        mFormat = format;
        mBasedValueLoader = new Loader1<Long>() {
            @Override
            public Long getFirstValue() {
                return parseDateTime(mFormat, pairDateTimeLoader.getFirstValue()).getTime();
            }

            @Override
            public Long getSecondValue() {
                return parseDateTime(mFormat, pairDateTimeLoader.getSecondValue()).getTime();
            }

        };
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final long sourceValue = mFormat.parse(notEmptyInput).getTime();
        final long firstValue = mBasedValueLoader.getFirstValue();
        final long secondValue = mBasedValueLoader.getSecondValue();
        return performTest(firstValue, secondValue, sourceValue);
    }

    protected static Date parseDateTime(SimpleDateFormat format, String source){
        try {
            return format.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean performTest(long firstValue, long secondValue, long sourceValue);

}
