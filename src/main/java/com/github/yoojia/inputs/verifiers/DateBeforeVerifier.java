package com.github.yoojia.inputs.verifiers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class DateBeforeVerifier extends DateAfterVerifier{

    public DateBeforeVerifier(String dateTimeStr){
        super(dateTimeStr);
    }

    public DateBeforeVerifier(String dateTimeStr, SimpleDateFormat format) {
        super(dateTimeStr, format);
    }

    public DateBeforeVerifier(Date basedValue) {
        super(basedValue);
    }

    public DateBeforeVerifier(Date basedValue, SimpleDateFormat format) {
        super(basedValue, format);
    }

    @Override
    protected boolean performTest(long basedValue, long sourceValue) {
        return basedValue > sourceValue;
    }
}
