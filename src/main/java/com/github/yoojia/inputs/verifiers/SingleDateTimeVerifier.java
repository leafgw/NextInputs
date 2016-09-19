package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class SingleDateTimeVerifier extends EmptyableVerifier{

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    private final long mBasedValue;
    private final SimpleDateFormat mFormat;

    public SingleDateTimeVerifier(long basedValue, SimpleDateFormat format) {
        mBasedValue = basedValue;
        mFormat = format;
    }

    public SingleDateTimeVerifier(String dateTimeStr, SimpleDateFormat format) {
        mFormat = format;
        try{
            mBasedValue = format.parse(dateTimeStr).getTime();
        }catch (ParseException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final long sourceValue = mFormat.parse(notEmptyInput).getTime();
        return performTest(mBasedValue, sourceValue);
    }

    protected abstract boolean performTest(long basedValue, long sourceValue);
}
