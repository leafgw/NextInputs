package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.Loader2A;
import com.github.yoojia.inputs.Loader2B;
import com.github.yoojia.inputs.PairVerifier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
abstract class PairDateTimeVerifier extends PairVerifier<Long> {

    private final SimpleDateFormat mFormat;

    public PairDateTimeVerifier(final Loader2B<String> valueLoader, final SimpleDateFormat format) {
        super(new Loader2A<Long>() {
            @Override
            public Long getFirstValue() {
                return DateTimeKit.parse(valueLoader.getFirstValue(), format).getTime();
            }

            @Override
            public Long getSecondValue() {
                return DateTimeKit.parse(valueLoader.getSecondValue(), format).getTime();
            }
        });
        this.mFormat = format;
    }

    public PairDateTimeVerifier(final Loader2A<Date> valueLoader, SimpleDateFormat format) {
        super(new Loader2A<Long>() {
            @Override
            public Long getFirstValue() {
                return valueLoader.getFirstValue().getTime();
            }

            @Override
            public Long getSecondValue() {
                return valueLoader.getSecondValue().getTime();
            }
        });
        this.mFormat = format;
    }

    public PairDateTimeVerifier(Date fixedFirstValue, Date fixedSecondValue, SimpleDateFormat format) {
        super(fixedFirstValue.getTime(),
                fixedSecondValue.getTime());
        this.mFormat = format;
    }

    public PairDateTimeVerifier(String fixedFirstValue, String fixedSecondValue, SimpleDateFormat format) {
        super(DateTimeKit.parse(fixedFirstValue, format).getTime()
                , DateTimeKit.parse(fixedSecondValue, format).getTime());
        this.mFormat = format;
    }

    @Override
    protected Long stringToTyped(String notEmptyInput) {
        return DateTimeKit.parse(notEmptyInput, mFormat).getTime();
    }

}
