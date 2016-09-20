package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader0;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateAfterVerifier extends SingleDateTimeVerifier {

    public DateAfterVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateAfterVerifier(String dateTimeStr) {
        super(dateTimeStr, DATE_FORMAT);
    }

    public DateAfterVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    public DateAfterVerifier(Date basedValue) {
        super(basedValue, DATE_FORMAT);
    }

    public DateAfterVerifier(Loader0<String> basedDateTimeLoader, SimpleDateFormat format) {
        super(basedDateTimeLoader, format);
    }

    public DateAfterVerifier(Loader0<String> basedDateTimeLoader) {
        super(basedDateTimeLoader, DATE_FORMAT);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue < sourceValue;
    }
}
