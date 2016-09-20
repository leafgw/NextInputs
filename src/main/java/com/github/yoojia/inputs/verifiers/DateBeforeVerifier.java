package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateBeforeVerifier extends DateAfterVerifier{

    public DateBeforeVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateBeforeVerifier(String dateTimeStr) {
        super(dateTimeStr);
    }

    public DateBeforeVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    public DateBeforeVerifier(Date basedValue) {
        super(basedValue);
    }

    public DateBeforeVerifier(Loader0<String> basedDateTimeLoader, SimpleDateFormat format) {
        super(basedDateTimeLoader, format);
    }

    public DateBeforeVerifier(Loader0<String> basedDateTimeLoader) {
        super(basedDateTimeLoader);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
