package com.github.yoojia.inputs;

/**
 * 桥接两个数值(A\B)及数据转换的接口
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.1
 */
public abstract class PairAdapter<T> {

    /**
     * @return Value A
     */
    public abstract T getFirst();

    /**
     * @return Value B
     */
    public T getSecond(){
        return null;
    }

    /**
     * 将String输入转换为泛型目标类型的数值
     * @param input String input
     * @return typed value
     */
    public abstract T inputToTyped(String input);

    /**
     * @param input Input value
     * @param first Value A
     * @param second Value B
     * @return test result
     */
    public abstract boolean perform(T input, T first, T second);
}