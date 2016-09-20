package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader1;
import com.github.yoojia.inputs.Loader1Ex;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class RangeDateVerifier extends PairDateTimeVerifier{

    public RangeDateVerifier(Loader1Ex<String> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(Loader1Ex<String> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateVerifier(Loader1<Date> valueLoader) {
        super(valueLoader, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(Loader1<Date> valueLoader, SimpleDateFormat format) {
        super(valueLoader, format);
    }

    public RangeDateVerifier(Date fixedFirstValue, Date fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateVerifier(Date fixedFirstValue, Date fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_FORMAT);
    }

    public RangeDateVerifier(String fixedFirstValue, String fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue, fixedSecondValue, format);
    }

    public RangeDateVerifier(String fixedFirstValue, String fixedSecondValue) {
        super(fixedFirstValue, fixedSecondValue, SingleDateTimeVerifier.DATE_FORMAT);
    }

    @Override
    protected boolean performTestValue(Long typedInput) {
        return getFirstBasedValue() <= typedInput && typedInput <= getSecondBasedValue();
    }

}
