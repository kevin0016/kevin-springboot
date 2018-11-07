package com.itkevin.springcloud.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FULL = "yyyy-MM-ddHH:mm:ss";

	public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";

	public static final String DATE_FORMAT_COMPACT = "yyyyMMdd";

	public static final String DATE_FORMAT_COMPACTFULL = "yyyyMMddHHmmss";

	public static final String DATE_FORMAT_FULL_MSEL = "yyyyMMddHHmmssSSSS";

	public static final String DATE_YEAR_MONTH = "yyyyMM";

	public static final String DATE_FORMAT_FULL_MSE = "yyyyMMddHHmmssSSS";

	/**
	 * 获取系统当前日期
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 得到当前日期
	 * 
	 * @return String 当前日期 yyyy-MM-dd HH:mm:ss格式
	 * @author kevin
	 */
	public static String getCurDateTime() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		// String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前日期
	 * 
	 * @return String 当前日期 yyyyMMddHHmmss格式
	 * @author kevin
	 */
	public static String getCurDateTime1() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_COMPACTFULL);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到当前日期YYYYMM格式
	 * 
	 * @return String 当前日期 yyyyMM格式
	 * @author kevin
	 */
	public static String getCurDateYYYYMM() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());

		DateFormat sdf = new SimpleDateFormat(DATE_YEAR_MONTH);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 得到下个月日期YYYYMM格式
	 * 
	 * @return String 当前日期 yyyyMM格式
	 * @author kevin
	 */
	public static String getNextMonthDateYYYYMM() {
		Calendar cal = Calendar.getInstance(TimeZone.getDefault());
		cal.add(Calendar.MONTH, 1);
		DateFormat sdf = new SimpleDateFormat(DATE_YEAR_MONTH);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(cal.getTime()));
	}

	/**
	 * 得到当前日期
	 * 
	 * @return String 当前日期 yyyyMMdd格式
	 * @author kevin
	 */
	public static String getCurDateYYYYMMDD() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());

		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_COMPACT);
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 是否是今天
	 * 
	 * @param strDate
	 * yyyy-MM-dd
	 * @return
	 */
	public static boolean isCurrentDay(String strDate) {
		boolean bRet = false;
		try {
			Calendar now = Calendar.getInstance(TimeZone.getDefault());
			// String DATE_FORMAT = "yyyy-MM-dd";
			DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SHORT);
			sdf.setTimeZone(TimeZone.getDefault());
			Date date1 = sdf.parse(strDate);
			String strDate1 = sdf.format(date1);
			String strDate2 = sdf.format(now.getTime());
			bRet = strDate1.equalsIgnoreCase(strDate2);
		}
		catch(ParseException e) {
			e.printStackTrace();

		}
		return bRet;
	}

	/**
	 * 是否是今天
	 * 
	 * @param strDate
	 * yyyy-MM-dd
	 * @return
	 */
	public static boolean isCurrentDay(Date dt) {
		boolean bRet = false;
		Calendar now = Calendar.getInstance(TimeZone.getDefault());

		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_SHORT);
		sdf.setTimeZone(TimeZone.getDefault());
		String strDate1 = sdf.format(dt);
		String strDate2 = sdf.format(now.getTime());
		bRet = strDate1.equalsIgnoreCase(strDate2);
		return bRet;
	}

	/**
	 * 获取几小时后的时间
	 * 
	 * @param hour
	 * 小时
	 * @param format
	 * hh:mm:ss
	 * @return HH:MM:SS
	 */
	public static String getAfterDateTime(int hour, String format) {
		long lTime = new Date().getTime() + hour * 60 * 60 * 1000;
		Calendar calendar = new GregorianCalendar();
		Date date_now = new Date(lTime);
		calendar.setTime(date_now);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = calendar.getTime();
		return sdf.format(date);
	}
	/**
	 * 获取几天后的时间
	 *
	 * @param hour
	 * 小时
	 * @param format
	 * hh:mm:ss
	 * @return HH:MM:SS
	 */
	public static String getAfterDateDay(int day, String format) {
		long lTime = new Date().getTime() + day * 24 * 60 * 60 * 1000;
		Calendar calendar = new GregorianCalendar();
		Date date_now = new Date(lTime);
		calendar.setTime(date_now);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = calendar.getTime();
		return sdf.format(date);
	}

	/**
	 * 得到当前日期
	 *
	 * @param format日期格式
	 * @return String 当前日期 format日期格式
	 * @author kevin
	 */
	public static String getCurDateTime(String format) {
		try {
			Calendar now = Calendar.getInstance(TimeZone.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(now.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(); // 如果无法转化，则返回默认格式的时间。
		}
	}

	/**
	 * 得到时间戳
	 *
	 * @param null
	 * @return String 当前日期时间戳(yyyyMMddHHmmssSSSS)
	 * @author kevin
	 */
	public static String getTimeStamp() {
		try {
			Calendar now = Calendar.getInstance(TimeZone.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL_MSEL);
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(now.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(); // 如果无法转化，则返回默认格式的时间。
		}
	}

	/**
	 * 日期转字符串
	 *
	 * @return String
	 * @author kevin
	 */
	public static String parseDateToString(Date thedate, String format) {
		DateFormat df = new SimpleDateFormat(format);
		if(thedate != null) {
			return df.format(thedate.getTime());
		}
		return null;
	}

	// parseDateToString(Date thedate, String format)的重载方法
	public static String parseDateToString(Date thedate) {
		// String format = "yyyy-MM-dd";
		return parseDateToString(thedate, DATE_FORMAT_FULL);
	}

	/**
	 * 字符串转日期
	 *
	 * @return Date
	 * @author kevin
	 */
	public static Date parseStringToDate(String thedate, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		Date dd1 = null;
		try {
			dd1 = sdf.parse(thedate);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return dd1;
	}

	/**
	 * 由String型日期转成format形式String
	 *
	 * @param format1原先格式
	 * @param format2转化格式
	 * @return String
	 * @author kevin
	 */
	public static String changeFormatDateString(String format1, String format2, String strDate) {
		if(strDate == null)
			return "";
		if(strDate.length() >= format1.length() && format1.length() >= format2.length()) {
			return parseDateToString(parseStringToDate(strDate, format1), format2);
		}
		return strDate;
	}

	// 得到当前日期的前一天时间 yyyymmdd
	public static String beforeNDaysDate(String format) {
		Date dNow = new Date(); // 当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); // 得到日历
		calendar.setTime(dNow);// 把当前时间赋给日历
		calendar.add(Calendar.DAY_OF_MONTH, -1); // 设置为前一天
		dBefore = calendar.getTime(); // 得到前一天的时间
		SimpleDateFormat sdf = new SimpleDateFormat(format); // 设置时间格式
		String timed = sdf.format(dBefore); // 格式化前一天
		return timed;
	}

	/**
	 * 获得N个月后的日期
	 *
	 * theDate 日期
	 *
	 * int month 月数
	 *
	 * format 格式
	 *
	 */
	public static String afterNMonthDate(String theDate, int month, String format) {

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		Date dd1 = null;
		try {
			dd1 = sdf.parse(theDate);
			cal.setTime(dd1);
			cal.add(Calendar.MONTH, month);
			sdf.setTimeZone(TimeZone.getDefault());
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		return (sdf.format(cal.getTime()));
	}

	/**
	 * 得到N天后的日期
	 *
	 * @param theDate 某日期
	 * 格式 yyyy-MM-dd
	 * @param nDayNum
	 * N天
	 * @return String N天后的日期
	 * @author kevin
	 */
	/**
	 *
	 * @param nowDate 某日期
	 * @param nDayNum N天
	 * @return Date N天后的日期
	 */
	public static Date afterNDaysDate(Date nowDate,Integer nDayNum){
		String date = parseDateToString(nowDate);
		String daysDate = afterNDaysDate(date, nDayNum+"", DATE_FORMAT_FULL);
		return parseStringToDate(daysDate,DATE_FORMAT_FULL);
	}

	/**
	 * 得到N天后的日期
	 *
	 * @param theDate 某日期
	 * 格式 yyyy-MM-dd
	 * @param nDayNum
	 * N天
	 * @return String N天后的日期
	 * @author kevin
	 */
	public static String afterNDaysDate(String theDate, String nDayNum, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date dd1 = sdf.parse(theDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dd1);
			cal.add(Calendar.DAY_OF_YEAR, Integer.parseInt(nDayNum));
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(cal.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(format); // 如果无法转化，则返回默认格式的时间。
		}
	}

	/**
	 * 得到N小时后的日期
	 *
	 * @param theDate某日期
	 * 格式传入传出格式都是 format格式
	 * @param nDayNum
	 * N小时
	 * @return String N小时后的日期
	 * @author kevin
	 */
	public static String afterNHoursDate(String theDate, String nHourNum, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date dd1 = sdf.parse(theDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dd1);
			cal.add(Calendar.HOUR_OF_DAY, Integer.parseInt(nHourNum));
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(cal.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(format); // 如果无法转化，则返回默认格式的时间。
		}
	}

	/**
	 * 得到N分钟后的日期
	 *
	 * @param theDate某日期
	 * 格式 yyyy-MM-dd
	 * @param nDayNum
	 * N分钟
	 * @return String N分钟后的日期
	 * @author kevin
	 */
	public static String afterNMinsDate(String theDate, String nMinNum, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date dd1 = sdf.parse(theDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dd1);
			cal.add(Calendar.MINUTE, Integer.parseInt(nMinNum));
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(cal.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(format); // 如果无法转化，则返回默认格式的时间。
		}
	}

	/**
	 * 得到N秒后的日期
	 *
	 * @param theDate某日期
	 * 格式 yyyy-MM-dd
	 * @param nDayNum
	 * N分钟
	 * @return String N分钟后的日期
	 * @author kevin
	 */
	public static String afterNSecondsDate(String theDate, String nMinNum, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date dd1 = sdf.parse(theDate);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dd1);
			cal.add(Calendar.SECOND, Integer.parseInt(nMinNum));
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(cal.getTime()));
		}
		catch(Exception e) {
			return getCurDateTime(format); // 如果无法转化，则返回默认格式的时间。
		}
	}

	public static Date afterNSecondsDate( Integer NSeconds) {
		return parseStringToDate(afterNSecondsDate(parseDateToString(new Date()),NSeconds+"",DATE_FORMAT_FULL),DATE_FORMAT_FULL);
	}
	/**
	 *
	 * @Author lianzhifei
	 * 2015年9月16日
	 * afterNSecondsDate
	 * 方法描述: 获取N秒之后的时间
	 * 逻辑描述:
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date afterNSecondsDate(Date date,int time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL);
		String curDate = parseDateToString(date);
		Date dt = sdf.parse(curDate);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.SECOND, time);
		Date dt1 = rightNow.getTime();
		return dt1;
	}

	// 比较两个字符串格式日期大小,带格式的日期
	public static boolean isBefore(String strdat1, String strdat2, String format) {
		try {
			Date dat1 = parseStringToDate(strdat1, format);
			Date dat2 = parseStringToDate(strdat2, format);
			return dat1.before(dat2);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// 比较两个字符串格式日期大小,带格式的日期,返回int
	public static long isBefore_int(String strdat1, String strdat2, String format) {
		long result = 0;
		try {
			Date dat1 = parseStringToDate(strdat1, format);
			Date dat2 = parseStringToDate(strdat2, format);
			return dat2.getTime() - dat1.getTime();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 比较两个字符串格式日期大小,默认转换格式:yyyy-MM-dd
	public static boolean isBefore(String strdat1, String strdat2) {
		// String format = "yyyy-MM-dd";
		return isBefore(strdat1, strdat2, DATE_FORMAT_SHORT);
	}

	/**
	 * 获取休息时间
	 *
	 * @param strTime
	 * strTime=" 3:00:00"; 需要休息的时间，注意有空格
	 * @return 需要休息的时间
	 * @throws ParseException
	 */
	public static long getSleepTime(String strTime) throws ParseException {
		long p = 1;
		long l_date = System.currentTimeMillis();
		Date date_now = new Date(l_date);
		SimpleDateFormat fmt = new SimpleDateFormat(DATE_FORMAT_SHORT);
		String strDate = fmt.format(date_now) + strTime;
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT_FULL);
		if(date_now.before(df.parse(strDate)))
			p = (df.parse(strDate)).getTime() - l_date;
		else {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date_now);
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			Date date = calendar.getTime();
			strDate = fmt.format(date) + strTime;
			p = (df.parse(strDate)).getTime() - l_date;
		}
		return p;
	}

	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getHourMinute(String fullTime) {
		return fullTime.substring(11, 16);
	}

	// 得到日期数组中最小日期
	public static String getMinDateOfArray(String dateArray[]) {
		String dateTmp = "";
		if(dateArray != null) {
			dateTmp = dateArray[0];
			for(int i = 1; i < dateArray.length; i++) {
				if(isBefore(dateArray[i], dateTmp, DATE_FORMAT_SHORT)) {
					dateTmp = dateArray[i];
				}
			}
		}
		return dateTmp;
	}

	// 得到日期数组中最大日期
	public static String getMaxDateOfArray(String dateArray[]) {
		String dateTmp = "";
		if(dateArray != null) {
			dateTmp = dateArray[0];
			for(int i = 1; i < dateArray.length; i++) {
				if(isBefore(dateTmp, dateArray[i], DATE_FORMAT_SHORT)) {
					dateTmp = dateArray[i];
				}
			}
		}
		return dateTmp;
	}

	public static boolean hasNextDayInArray(String dateArray[], String dateTmp) {
		int index = 0;
		if(dateArray != null) {
			Arrays.sort(dateArray);
			for(int i = 0; i < dateArray.length; i++) {
				if(dateArray[i].equals(dateTmp)) {
					index = i;
				}
			}
			System.out.println(index);
			return index + 1 != dateArray.length;
		}
		return false;
	}

	public static boolean hasPreviousDayInArray(String dateArray[], String dateTmp) {
		int index = 0;
		if(dateArray != null) {
			Arrays.sort(dateArray);
			for(int i = 0; i < dateArray.length; i++) {
				if(dateArray[i].equals(dateTmp)) {
					index = i;
				}
			}
			return index != 0;
		}
		return false;
	}

	/*
	 * 得到上一个月或者下一个月的日期
	 */
	public static String getDayafterMonth(String theDate, int month, String formatStr) {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date dat1 = parseStringToDate(theDate, formatStr);
		now.setTime(dat1);
		sdf.setTimeZone(TimeZone.getDefault());
		now.add(Calendar.MONTH, month);
		return sdf.format(now.getTime());
	}

	/**
	 * <p>
	 * 获取当前系统时间的小时数
	 * </p>
	 * 
	 * @return
	 */
	public static int getCurrentHour() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * <p>
	 * 获取当前系统时间的分钟数
	 * </p>
	 * 
	 * @return
	 */
	public static int getCurrentMinutes() {
		Calendar calendar = new GregorianCalendar();
		return calendar.get(Calendar.MINUTE);
	}

	public static Date getFristDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}

	public static Date getLastDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MINUTE, 0);
		return calendar.getTime();
	}

	/**
	 * 将秒转换为小时分秒等
	 * 
	 * @param sec
	 * @return
	 */
	public String changeTime(int sec) {
		String temp = "";
		if(sec < 60) {
			temp = "" + sec + "秒";
		}
		else if(sec < 3600) {
			temp = "" + sec / 60 + "分" + sec % 60 + "秒";
		}
		else {
			temp = "" + sec / 3600 + "小时" + (sec % 3600) / 60 + "分" + sec % 60 + "秒";
		}
		return temp;
	}

	/**
	 * 
	 * 方法描述:
	 * 从这里开始注释
	 * @param 入参
	 * @return
	 * 作者：weiwencong
	 * 日期：2015 2015年8月6日
	 */
	public static String getFormateDate(String date) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL);
		Date da = parseStringToDate(date, DATE_FORMAT_FULL);
		now.setTime(da);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 
	 * 方法描述:
	 * 报表展示结束日期
	 * @return
	 * 作者：weiwencong
	 * 日期：2015 2015年8月6日
	 */
	public static String getEndDate() {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		sdf.setTimeZone(TimeZone.getDefault());
		return (sdf.format(now.getTime()));
	}

	/**
	 * 
	 * 方法描述:
	 * 报表展示开始日期
	 * @return
	 * 作者：weiwencong
	 * 日期：2015 2015年8月6日
	 */
	public static String getStartDate(String end) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL);
		Date date = parseStringToDate(end, DATE_FORMAT_FULL);
		now.setTime(date);
		now.add(Calendar.MONTH, -1);
		return (sdf.format(now.getTime()));
	}

	/**
	 * 
	 * 方法描述:
	 * 计算两个日期相差天数
	 * @param end 结束日期
	 * @param start 开始日期
	 * @return
	 * 作者：weiwencong
	 * 日期：2015 2015年8月6日
	 */
	public static int getSubDays(String end, String start) {
		Calendar now = Calendar.getInstance(TimeZone.getDefault());
		Date startDate = parseStringToDate(start, DATE_FORMAT_FULL);
		Date endDate = parseStringToDate(end, DATE_FORMAT_FULL);
		now.setTime(startDate);
		long s = now.getTimeInMillis();
		now.setTime(endDate);
		long e = now.getTimeInMillis();
		Long days = (e - s) / (24 * 3600000);
		return days.intValue();
	}

	
	public static String getTimeDiff(Date time1, Date time2) throws Exception {
		long l = time1.getTime() - time2.getTime();
		String returnStr = "";
		long day = l / (24 * 60 * 60 * 1000);
		if (day > 0) {
			returnStr += (day + "天");
		}
		long hour = (l / (60 * 60 * 1000) - day * 24);
		if (hour > 0) {
			returnStr += (hour + "小时");
		}
		long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
		if (min > 0) {
			returnStr += (min + "分");
		}
		long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		if (s > 0) {
			returnStr += (s + "秒");
		}
		return returnStr;
	}


	/**
	 * 得到时间戳
	 *
	 * @param null
	 * @return String 当前日期时间戳(yyyyMMddHHmmssSSS)
	 * @author kevin
	 */
	public static String getTimeStamp1() {
		try {
			Calendar now = Calendar.getInstance(TimeZone.getDefault());
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_FULL_MSE);
			sdf.setTimeZone(TimeZone.getDefault());
			return (sdf.format(now.getTime()));
		} catch (Exception e) {
			return getCurDateTime(); // 如果无法转化，则返回默认格式的时间。
		}
	}


	//得到本月的第一天
	public  static String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat firstDay= new SimpleDateFormat("yyyy-MM-dd");
		return  firstDay.format(calendar.getTime());
	}

	//得到本月的最后一天
	public static String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH,
				calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		SimpleDateFormat lastDay= new SimpleDateFormat("yyyy-MM-dd");
		return  lastDay.format(calendar.getTime());
	}

	public static void main(String args[]) throws ParseException {
//		Date t = DateUtil.parseStringToDate("2012-12-20 10:30:12", DateUtil.DATE_FORMAT_FULL);
//		System.out.println(t);
//		System.out.println(parseDateToString(t));
//		// System.out.println(getStartDate("2015-03-06 00:00:00"));
//		System.out.println(afterNDaysDate("2015-03-06 00:00:00", "0", DATE_FORMAT_FULL));
		// System.out.println(getSubDays("2015-03-06 00:00:00","2016-02-05 00:00:00"));
//		Date date = new Date();
//		System.out.println(date.compareTo(afterNSecondsDate(date,-60)));
//
//		System.out.println(System.nanoTime());
//		System.out.println(new Date().getTime());
		System.out.println(isBefore("2012-12-20 10:30:13", "2012-12-20 10:30:14",DATE_FORMAT_FULL));
	}
}