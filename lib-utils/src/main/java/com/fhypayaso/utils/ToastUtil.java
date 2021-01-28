package com.fhypayaso.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/* ====================================================
#
#   @Author        : fhyPayaso
#   @Email         : 401619823@qq.com
#   @Date          : 1/25/21 11:35 AM
#   @Description   : 
# ====================================================*/
public class ToastUtil {


    private static Toast sToast;


    private ToastUtil() {

    }

    @SuppressWarnings("all")
    public static void showToast(Context context, final String msg) {

        if (sToast == null) {
            sToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }

        ThreadUtil.runOnNewThread(new Runnable() {
            @Override
            public void run() {
                sToast.show();
            }
        });
    }

    @SuppressWarnings("all")
    public static void showToast(Context context, @StringRes final int resId) {

        if (sToast == null) {
            sToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(resId);
        }

        ThreadUtil.runOnNewThread(new Runnable() {
            @Override
            public void run() {
                sToast.show();
            }
        });
    }


    public static void showToast(Context context, String msg, int... errorCode) {

        StringBuilder stringBuilder = new StringBuilder(msg);
        for (int anErrorCode : errorCode) {
            stringBuilder.append("-");
            stringBuilder.append(anErrorCode);
        }
        showToast(context, stringBuilder.toString());
    }


    public static void showToast(Context context, @StringRes int resId, int... errorCode) {

        String msg = context.getResources().getString(resId);
        StringBuilder stringBuilder = new StringBuilder(msg);
        for (int anErrorCode : errorCode) {
            stringBuilder.append("-");
            stringBuilder.append(anErrorCode);
        }
        showToast(context, stringBuilder.toString());
    }

    /**
     * 取消toast
     */
    public static void cancelToast() {
        if (sToast != null) {
            sToast.cancel();
            sToast = null;
        }
    }
}