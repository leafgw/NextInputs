package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;
import com.github.yoojia.inputs.Loader0;
import com.github.yoojia.inputs.Loader0;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class SingleDateTimeVerifier extends EmptyableVerifier{

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    private final Loader0<Long> mBasedValueLoader;
    private final SimpleDateFormat mFormat;

    // Fixed DateTime Object
    public SingleDateTimeVerifier(final Date basedValue, SimpleDateFormat format) {
        mFormat = format;
        final long baseValue = basedValue.getTime();
        mBasedValueLoader = new Loader0<Long>() {
            @Override public Long getValue() {
                return baseValue;
            }
        };
    }

    // Fixed DateTime String
    public SingleDateTimeVerifier(final String dateTimeStr, final SimpleDateFormat format) {
        mFormat = format;
        mBasedValueLoader = new Loader0<Long>() {
            @Override
            public Long getValue() {
                try{
                    return format.parse(dateTimeStr).getTime();
                }catch (ParseException e){
                    throw new RuntimeException(e);
                }
            }
        };
    }

    // Lazy loader: DateTime String
    public SingleDateTimeVerifier(final Loader0<String> basedDateTimeLoader, final SimpleDateFormat format) {
        mFormat = format;
        mBasedValueLoader = new Loader0<Long>() {
            @Override
            public Long getValue() {
                try{
                    return format.parse(basedDateTimeLoader.getValue()).getTime();
                }catch (ParseException e){
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final long sourceValue = mFormat.parse(notEmptyInput).getTime();
        final long basedValue = mBasedValueLoader.getValue();
        return performTest(basedValue, sourceValue);
    }

    protected abstract boolean performTest(long basedValue, long sourceValue);
}
