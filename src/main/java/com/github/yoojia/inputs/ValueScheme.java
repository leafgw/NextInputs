package com.github.yoojia.inputs;

import com.github.yoojia.inputs.verifiers.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.4
 */
public class ValueScheme {

    public static final int PRIORITY_REQUIRED = StaticScheme.PRIORITY_REQUIRED;
    public static final int PRIORITY_GENERAL = StaticScheme.PRIORITY_GENERAL;

    /**
     * 必要项，输入内容不能为空
     * @return Scheme
     */
    public static Scheme Required(){
        return StaticScheme.Required();
    }

    /**
     * 输入内容不能小于最小长度
     * @param min 最小长度
     * @return Scheme
     */
    public static Scheme MinLength(final int min) {
        return new Scheme(new MinLengthVerifier(min)).msg("输入内容至少" + min + "个字符");
    }

    /**
     * 输入内容不能大于最大长度
     * @param max 最大长度
     * @return Scheme
     */
    public static Scheme MaxLength(final int max) {
        return new Scheme(new MaxLengthVerifier(max)).msg("输入内容最多" + max + "个字符");
    }

    /**
     * 输入内容在长度范围内
     * @param min 最小长度
     * @param max 最大长度
     * @return Scheme
     */
    public static Scheme RangeLength(final int min, final int max) {
        return new Scheme(new RangeLengthVerifier(min, max)).msg("输入内容字符数量必须在[" + min + "," + max + "]之间");
    }

    /**
     * 限制内容为固定长度
     * @param fixedLength 固定长度
     * @return Scheme
     */
    public static Scheme FixedLength(final int fixedLength) {
        return new Scheme(new FixedLengthVerifier(fixedLength)).msg("输入内容固定长度为" + fixedLength);
    }

    /**
     * 输入数值不能小于最小值
     * @param min 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final int min) {
        return PairTest(new MinValueAdapter(min)).msg("输入数值最小为：" + min);
    }

    /**
     * 输入数值不能小于最小值
     * @param min 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final long min) {
        return PairTest(new MinValueAdapter(min)).msg("输入数值最小为：" + min);
    }

    /**
     * 输入数值不能小于最小值
     * @param min 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final float min) {
        return PairTest(new MinValueAdapter(min)).msg("输入数值最小为：" + min);
    }

    /**
     * 输入数值不能小于最小值
     * @param min 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final double min) {
        return PairTest(new MinValueAdapter(min)).msg("输入数值最小为：" + min);
    }

    /**
     * 输入数值不能大于最大值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final int max) {
        return PairTest(new MaxValueAdapter(max)).msg("输入数值最大为：" + max);
    }

    /**
     * 输入数值不能大于最大值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final long max) {
        return PairTest(new MaxValueAdapter(max)).msg("输入数值最大为：" + max);
    }

    /**
     * 输入数值不能大于最大值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final float max) {
        return PairTest(new MaxValueAdapter(max)).msg("输入数值最大为：" + max);
    }

    /**
     * 输入数值不能大于最大值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final double max) {
        return PairTest(new MaxValueAdapter(max)).msg("输入数值最大为：" + max);
    }

    /**
     * 输入数值必须在最值区间
     * @param min 最小值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final int min, final int max) {
        return PairTest(new RangeValueAdapter(min, max)).msg("输入数值大小必须在[" + min + "," + max + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param min 最小值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final long min, final long max) {
        return PairTest(new RangeValueAdapter(min, max)).msg("输入数值大小必须在[" + min + "," + max + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param min 最小值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final float min, final float max) {
        return PairTest(new RangeValueAdapter(min, max)).msg("输入数值大小必须在[" + min + "," + max + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param min 最小值
     * @param max 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final double min, final double max) {
        return PairTest(new RangeValueAdapter(min, max)).msg("输入数值大小必须在[" + min + "," + max + "]之间");
    }

    /**
     * 输入内容与加载器的内容相同
     * @param lazyLoader 加载器
     * @return Scheme
     */
    public static Scheme EqualsTo(final LazyLoader<String> lazyLoader){
        return PairTest(new EqualsBridge(lazyLoader)).msg("输入内容与要求不一致");
    }

    /**
     * 输入内容必须与指定内容相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme EqualsTo(final String fixedValue) {
        return EqualsTo(new LazyLoader<String>() {
            @Override
            public String getValue() {
                return fixedValue;
            }
        });
    }

    /**
     * 输入内容必须与加载器的内容不相同
     * @param lazyLoader 加载器
     * @return Scheme
     */
    public static Scheme NotEquals(final LazyLoader<String> lazyLoader){
        return PairTest(new NotEqualsBridge(lazyLoader)).msg("输入内容不能与要求的相同");
    }

    /**
     * 输入内容必须与指定内容不相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme NotEquals(final String fixedValue) {
        return NotEquals(new LazyLoader<String>() {
            @Override
            public String getValue() {
                return fixedValue;
            }
        });
    }
    
    public static <T> Scheme PairTest(final PairAdapter<T> bridge) {
        return new Scheme(new PairVerifier<>(bridge));
    }

    // date

    public static Scheme DateAfter(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDate, format)).msg("设定的日期必须在" + basedDate + "之后");
    }

    public static Scheme DateAfter(final String basedDate){
        return new Scheme(new DateAfterVerifier(basedDate)).msg("设定的日期必须在" + basedDate + "之后");
    }

    public static Scheme DateAfter(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateAfterVerifier(basedDate, format)).msg("设定的日期必须在" + basedDate + "之后");
    }

    public static Scheme DateAfter(final Date basedDate){
        return new Scheme(new DateAfterVerifier(basedDate)).msg("设定的日期必须在" + basedDate + "之后");
    }

    public static Scheme DateBefore(final String basedDate, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDate, format)).msg("设定的日期必须在" + basedDate + "之前");
    }

    public static Scheme DateBefore(final String basedDate){
        return new Scheme(new DateBeforeVerifier(basedDate)).msg("设定的日期必须在" + basedDate + "之前");
    }
    
    // time

    public static Scheme TimeAfter(final String basedTime, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedTime, format)).msg("设定的时间必须在" + basedTime + "之后");
    }

    public static Scheme TimeAfter(final String basedTime){
        return new Scheme(new TimeAfterVerifier(basedTime)).msg("设定的时间必须在" + basedTime + "之后");
    }

    public static Scheme TimeAfter(final Date basedTime, final SimpleDateFormat format){
        return new Scheme(new TimeAfterVerifier(basedTime, format)).msg("设定的时间必须在" + basedTime + "之后");
    }

    public static Scheme TimeAfter(final Date basedTime){
        return new Scheme(new TimeAfterVerifier(basedTime)).msg("设定的时间必须在" + basedTime + "之后");
    }

    public static Scheme TimeBefore(final String basedTime, final SimpleDateFormat format){
        return new Scheme(new TimeBeforeVerifier(basedTime, format)).msg("设定的时间必须在" + basedTime + "之前");
    }

    public static Scheme TimeBefore(final String basedTime){
        return new Scheme(new TimeBeforeVerifier(basedTime)).msg("设定的时间必须在" + basedTime + "之前");
    }

    // date time

    public static Scheme DateTimeAfter(final String basedDateTime, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDateTime, format)).msg("设定的日期时间必须在" + basedDateTime + "之后");
    }

    public static Scheme DateTimeAfter(final String basedDateTime){
        return new Scheme(new DateTimeAfterVerifier(basedDateTime)).msg("设定的日期时间必须在" + basedDateTime + "之后");
    }

    public static Scheme DateTimeAfter(final Date basedDateTime, final SimpleDateFormat format){
        return new Scheme(new DateTimeAfterVerifier(basedDateTime, format)).msg("设定的日期时间必须在" + basedDateTime + "之后");
    }

    public static Scheme DateTimeAfter(final Date basedDateTime){
        return new Scheme(new DateTimeAfterVerifier(basedDateTime)).msg("设定的日期时间必须在" + basedDateTime + "之后");
    }

    public static Scheme DateTimeBefore(final String basedDateTime, final SimpleDateFormat format){
        return new Scheme(new DateTimeBeforeVerifier(basedDateTime, format)).msg("设定的日期时间必须在" + basedDateTime + "之前");
    }

    public static Scheme DateTimeBefore(final String basedDateTime){
        return new Scheme(new DateTimeBeforeVerifier(basedDateTime)).msg("设定的日期时间必须在" + basedDateTime + "之前");
    }
}
