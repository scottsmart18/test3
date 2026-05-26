package com.davidniu.oop;

public interface TimeService {
    /**
     * 获取当前时间
     *
     * @return 当前时间的字符串表示
     */
    String getCurrentTime();

    /**
     * 获取当前时间戳
     *
     * @return 当前时间戳
     */
    long getCurrentTimestamp();

    /**
     * 获取当前日期
     *
     * @return 当前日期的字符串表示
     */
    String getCurrentDate();
}
