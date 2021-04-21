package com.qa.util;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ge
 * @version 1.0.0
 **/
public class LogUtils {
    /**
     * 获取业务日志logger
     *
     * @return
     */
    public static Logger getBussinessLogger() {
        return LoggerFactory.getLogger(LogEnum.BUSSINESS.getCategory());
    }
    /**
     * 获取数据库日志logger
     *
     * @return
     */
    public static Logger getDBLogger() {
        return LoggerFactory.getLogger(LogEnum.DB.getCategory());
    }
    /**
     * 获取odps日志logger
     *
     * @return
     */
    public static Logger getOdpsLogger() {
        return LoggerFactory.getLogger(LogEnum.ODPS.getCategory());
    }
    /**
     * 方法耗时日志
     * @return
     */
    public static Logger getMethodLogger(){
        return LoggerFactory.getLogger(LogEnum.METHODLOG.getCategory());
    }

    @Getter
    public enum LogEnum {
        BUSSINESS("bussiness","业务相关的日志信息"),
        DB("db","需要时可以将一些比较重要的数据库查询日志输出到此处"),
        ODPS("odps","需要做数据投递的日志输出"),
        METHODLOG("method_log","方法耗时相关日志输出")
        ;

        /**
         * 日志类别
         */
        private String category;
        /**
         * 日志类别说明
         */
        private String desc;

        LogEnum(String category, String desc) {
            this.category = category;
            this.desc = desc;
        }
    }
}
