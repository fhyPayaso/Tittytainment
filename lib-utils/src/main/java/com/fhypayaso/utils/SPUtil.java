package com.fhypayaso.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 11:31 AM
#   @Description   : 缓存工具类
# ====================================================*/
public final class SPUtil {

    private static final String SP_FILE_NAME = "sp_name_tittyment";

    private SPUtil() {
    }

    public static void putString(Context context, String key, String value) {
        put(SP_FILE_NAME, context, key, value);
    }

    public static String getString(Context context, String key) {
        return getString(context, key, "");
    }

    public static String getString(Context context, String key, String defaultStr) {
        return (String) get(SP_FILE_NAME, context, key, defaultStr);
    }


    private static void put(String fileName, Context context, String key, Object object) {

        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        editor.apply();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     */
    private static Object get(String fileName, Context context, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        }

        return null;
    }


}
