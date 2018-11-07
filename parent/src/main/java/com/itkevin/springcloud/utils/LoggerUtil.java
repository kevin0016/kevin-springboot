package com.itkevin.springcloud.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 获取logger的工具
 */
public class LoggerUtil {

	/**
	 * 请求访问日期
	 */
	public static final String hitLogger = "hitlogger";
	
	/**
	 * 异常日志
	 */
	public static final String exceptLogger = "exceptLogger";
	
	/**
	 * 获取一个logger
	 * @param loggerName - logger名字
	 * @return Logger
	 */
	public static Logger getLogger(String loggerName) {
		return LoggerFactory.getLogger(loggerName);
	}
	
}
