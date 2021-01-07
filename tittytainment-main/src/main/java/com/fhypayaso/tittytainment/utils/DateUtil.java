package com.fhypayaso.tittytainment.utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 2021/1/2 2:30 上午
#   @Description   : 
# ====================================================*/
public class DateUtil {

    public static final String FORMAT_SLASH = "yyyy/MM/dd";

    public static final String FORMAT_ACROSS = "yyyy-MM-dd";

    private DateUtil() {

    }

    public static Date formatSlashStr2Date(String formatStr) {
        return formatStr2Date(FORMAT_SLASH, formatStr);
    }

    public static Date formatStr2Date(String formatType, String formatStr) {

        if(StringUtils.isEmpty(formatStr)) {
            return null;
        }


        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);//注意月份是MM
            Date date = simpleDateFormat.parse(formatStr);
//            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


            return date;
        } catch (ParseException e) {

            return new Date(System.currentTimeMillis());
        }
    }


}
