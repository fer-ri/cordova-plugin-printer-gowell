package com.RT_Printer.BluetoothPrinter.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateString 
{
	public static String getFileName() 
	{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date(System.currentTimeMillis()));
        return date;
    }

    public static String getDateEN() 
    {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = format1.format(new Date(System.currentTimeMillis()));
        return date1;// 2012-10-03 23:41:31
    }
}
