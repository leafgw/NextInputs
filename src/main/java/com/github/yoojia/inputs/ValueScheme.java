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
     * @param fixedLength 最小长度
     * @return Scheme
     */
    public static Scheme MinLength(final int fixedLength) {
        return new Scheme(new MinLengthVerifier(fixedLength)).msg("输入内容至少{0}个字符");
    }

    /**
     * 输入内容不能小于最小长度
     * @param lengthLoader 最小长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme MinLength(Loader0<Long> lengthLoader) {
        return new Scheme(new MinLengthVerifier(lengthLoader)).msg("输入内容至少{0}个字符");
    }

    /**
     * 输入内容不能大于最大长度
     * @param fixedLength 最大长度数值延迟加载器
     * @return Scheme
     */
    public static Scheme MaxLength(final int fixedLength) {
        return new Scheme(new MaxLengthVerifier(fixedLength)).msg("输入内容最多{0}个字符");
    }

    /**
     * 输入内容不能大于最大长度
     * @param lengthLoader 最大长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme MaxLength(final Loader0<Long> lengthLoader) {
        return new Scheme(new MaxLengthVerifier(lengthLoader)).msg("输入内容最多{0}个字符");
    }

    /**
     * 输入内容在长度范围内
     * @param fixedMinLength 最小长度
     * @param fixedMaxLength 最大长度
     * @return Scheme
     */
    public static Scheme RangeLength(final int fixedMinLength, final int fixedMaxLength) {
        return new Scheme(new RangeLengthVerifier(fixedMinLength, fixedMaxLength)).msg("输入内容字符数量必须在[{0},{1}]之间");
    }

    /**
     * 输入内容在长度范围内
     * @param lengthLoader 最小、最大长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme RangeLength(Loader1<Long> lengthLoader) {
        return new Scheme(new RangeLengthVerifier(lengthLoader)).msg("输入内容字符数量必须在[{0},{1}]之间");
    }

    /**
     * 限制内容为固定长度
     * @param fixedLength 固定长度
     * @return Scheme
     */
    public static Scheme FixedLength(final int fixedLength) {
        return new Scheme(new FixedLengthVerifier(fixedLength)).msg("输入内容固定长度为{0}");
    }

    /**
     * 限制内容为固定长度
     * @param lengthLoader 固定长度数值延迟加载器
     * @return Scheme
     * @since 1.7
     */
    public static Scheme FixedLength(final Loader0<Long> lengthLoader) {
        return new Scheme(new FixedLengthVerifier(lengthLoader)).msg("输入内容固定长度为{0}");
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMin 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final int fixedMin) {
        return PairTest(new MinValueAdapter(fixedMin)).msg("输入数值最小为：" + fixedMin);
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMin 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final long fixedMin) {
        return PairTest(new MinValueAdapter(fixedMin)).msg("输入数值最小为：" + fixedMin);
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMin 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final float fixedMin) {
        return PairTest(new MinValueAdapter(fixedMin)).msg("输入数值最小为：" + fixedMin);
    }

    /**
     * 输入数值不能小于最小值
     * @param fixedMin 最小值
     * @return Scheme
     */
    public static Scheme MinValue(final double fixedMin) {
        return PairTest(new MinValueAdapter(fixedMin)).msg("输入数值最小为：" + fixedMin);
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final int fixedMax) {
        return PairTest(new MaxValueVerifier(fixedMax)).msg("输入数值最大为：" + fixedMax);
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final long fixedMax) {
        return PairTest(new MaxValueVerifier(fixedMax)).msg("输入数值最大为：" + fixedMax);
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final float fixedMax) {
        return PairTest(new MaxValueVerifier(fixedMax)).msg("输入数值最大为：" + fixedMax);
    }

    /**
     * 输入数值不能大于最大值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme MaxValue(final double fixedMax) {
        return PairTest(new MaxValueVerifier(fixedMax)).msg("输入数值最大为：" + fixedMax);
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMin 最小值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final int fixedMin, final int fixedMax) {
        return PairTest(new RangeValueAdapter(fixedMin, fixedMax)).msg("输入数值大小必须在[" + fixedMin + "," + fixedMax + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMin 最小值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final long fixedMin, final long fixedMax) {
        return PairTest(new RangeValueAdapter(fixedMin, fixedMax)).msg("输入数值大小必须在[" + fixedMin + "," + fixedMax + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMin 最小值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final float fixedMin, final float fixedMax) {
        return PairTest(new RangeValueAdapter(fixedMin, fixedMax)).msg("输入数值大小必须在[" + fixedMin + "," + fixedMax + "]之间");
    }

    /**
     * 输入数值必须在最值区间
     * @param fixedMin 最小值
     * @param fixedMax 最大值
     * @return Scheme
     */
    public static Scheme RangeValue(final double fixedMin, final double fixedMax) {
        return PairTest(new RangeValueAdapter(fixedMin, fixedMax)).msg("输入数值大小必须在[" + fixedMin + "," + fixedMax + "]之间");
    }

    /**
     * 输入内容与加载器的内容相同
     * @param lazyLoader 相同内容延迟加载器
     * @return Scheme
     */
    public static Scheme EqualsTo(final Loader0<String> lazyLoader){
        return new Scheme(new EqualsVerifier(lazyLoader)).msg("输入内容与要求不一致");
    }

    /**
     * 输入内容必须与指定内容相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme EqualsTo(final String fixedValue) {
        return new Scheme(new EqualsVerifier(fixedValue)).msg("输入内容与要求不一致");
    }

    /**
     * 输入内容必须与加载器的内容不相同
     * @param lazyLoader 加载器
     * @return Scheme
     */
    public static Scheme NotEquals(final Loader0<String> lazyLoader){
        return new Scheme(new NotEqualsVerifier(lazyLoader)).msg("输入内容不能与要求的相同");
    }

    /**
     * 输入内容必须与指定内容不相同
     * @param fixedValue 指定内容
     * @return Scheme
     */
    public static Scheme NotEquals(final String fixedValue) {
        return new Scheme(new NotEqualsVerifier(fixedValue)).msg("输入内容不能与要求的相同");
    }
    
//    public static <T> Scheme PairTest(final PairAdapter<T> bridge) {
//        return new Scheme(new PairVerifier<>(bridge));
//    }

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

    public static Scheme DateBefore(final Date basedDate, final SimpleDateFormat format){
        return new Scheme(new DateBeforeVerifier(basedDate, format)).msg("设定的日期必须在" + basedDate + "之前");
    }

    public static Scheme DateBefore(final Date basedDate){
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
