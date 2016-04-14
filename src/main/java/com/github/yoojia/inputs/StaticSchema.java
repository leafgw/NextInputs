package com.github.yoojia.inputs;

import com.github.yoojia.inputs.impl.*;

/**
 * @author 陈小锅 (yoojia.chen@gmail.com)
 */
public class StaticSchema {

    public static final int PRIORITY_REQUIRED = -1024;
    public static final int PRIORITY_GENERAL = 0;

    /**
     * 必要项，输入内容不能为空
     * @return Schema
     */
    public static Schema Required(){
        return new Schema(new NotEmptyVerifier()).msg("此为必填项目").priority(PRIORITY_REQUIRED);
    }

    /**
     * 输入内容不能为空值：空格，制表符等
     * @return Schema
     */
    public static Schema NotBlank(){
        return new Schema(new NotBlankVerifier()).msg("请输入非空内容");
    }

    /**
     * 输入内容只能是数字
     * @return Schema
     */
    public static Schema Digits(){
        return new Schema(new DigitsVerifier()).msg("请输入数字");
    }

    /**
     * 电子邮件地址
     * @return Schema
     */
    public static Schema Email(){
        return new Schema(new EmailVerifier()).msg("请输入有效的邮件地址");
    }

    /**
     * IPV4地址
     * @return Schema
     */
    public static Schema IPv4(){
        return new Schema(new IPv4Verifier()).msg("请输入有效的IP地址");
    }

    /**
     * 域名地址
     * @return Schema
     */
    public static Schema Host(){
        return new Schema(new HostVerifier()).msg("请输入有效的域名地址");
    }

    /**
     * URL地址
     * @return Schema
     */
    public static Schema URL(){
        return new Schema(new URLVerifier()).msg("请输入有效的网址");
    }

    /**
     * 数值
     * @return Schema
     */
    public static Schema Numeric(){
        return new Schema(new NumericVerifier()).msg("请输入有效的数值");
    }

    /**
     * 银行卡号
     * @return Schema
     */
    public static Schema BlankCard(){
        return new Schema(new BlankCardVerifier()).msg("请输入有效的银行卡/信用卡号码");
    }

    /**
     * 身份证号
     * @return Schema
     */
    public static Schema ChineseIDCard(){
        return new Schema(new IDCardVerifier()).msg("请输入有效的身份证号");
    }

    /**
     * 手机号
     * @return Schema
     */
    public static Schema ChineseMobile(){
        return new Schema(new MobileVerifier()).msg("请输入有效的手机号");
    }

    /**
     * 为True状态
     * @return Schema
     */
    public static Schema IsTrue(){
        return new Schema(new BoolVerifier(true)).msg("当前项必须为True");
    }

    /**
     * 为False状态
     * @return Schema
     */
    public static Schema IsFalse(){
        return new Schema(new BoolVerifier(false)).msg("当前项必须为False");
    }

}
