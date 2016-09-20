package com.github.yoojia.inputs;

/**
 * 数据懒加载器
 * @author 陈小锅 (yoojia.chen@gmail.com)
 * @since 1.7
 */
public interface Loader1<T> {

    T getFirstValue();

    T getSecondValue();

}
