package com.core.common.provider;

/**
 * 提供者抽象类
 *
 * @author admin
 * @param <T>
 */
public interface DataTaskProvider<T> {
    /**
     * 是否支持某种能力
     *
     * @param t 自定对象类型
     * @return true 支持 false 不支持
     */
    boolean applicable(T t);
}
