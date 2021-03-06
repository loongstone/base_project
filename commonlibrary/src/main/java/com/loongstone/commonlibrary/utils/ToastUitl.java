package com.loongstone.commonlibrary.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loongstone.commonlibrary.R;
import com.loongstone.commonlibrary.base.app.BaseApplication;

import static com.loongstone.commonlibrary.base.app.AppConfig.APP_DEBUG;


/**
 * Toast统一管理类
 */
public class ToastUitl {

    private static Toast toast;
    private static Toast toast2;
    private static View view ;
    public static void showDebug(String message) {
        if(APP_DEBUG){
            initToast(message, Toast.LENGTH_SHORT).show();
        }
    }

    private static Toast initToast(CharSequence message, int duration) {
        if (toast == null) {
            view=LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.toast_common, null);
            toast = new Toast(BaseApplication.getAppContext());
            TextView textView = view.findViewById(R.id.toast_message);
            textView.setText(message);
            toast.setDuration(duration);
            toast.setView(view);
        } else {
            toast.cancel();
            toast=null;
            initToast(message,duration);
        }
        return toast;
    }


    /**
     * 短时间显示Toast
     *
     * @param message
     */
    public static void showShort(CharSequence message) {
        initToast(message, Toast.LENGTH_SHORT).show();
    }
    /**
     * 短时间显示Toast
     *
     * @param strResId
     */
    public static void showShort(int strResId) {
//		Toast.makeText(context, strResId, Toast.LENGTH_SHORT).show();
        initToast(BaseApplication.getAppContext().getResources().getText(strResId), Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param message
     */
    public static void showLong(CharSequence message) {
        initToast(message, Toast.LENGTH_LONG).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param strResId
     */
    public static void showLong(int strResId) {
        initToast(BaseApplication.getAppContext().getResources().getText(strResId), Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message
     * @param duration
     */
    public static void show(CharSequence message, int duration) {
        initToast(message, duration).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context
     * @param strResId
     * @param duration
     */
    public static void show(Context context, int strResId, int duration) {
        initToast(context.getResources().getText(strResId), duration).show();
    }

    /**
     * 显示有image的toast
     *
     * @param tvStr
     * @param imageResource
     * @return
     */
    public static Toast showToastWithImg(final String tvStr, final int imageResource) {
        if (toast2 == null) {
            toast2 = new Toast(BaseApplication.getAppContext());
        }
        View view = LayoutInflater.from(BaseApplication.getAppContext()).inflate(R.layout.toast_custom, null);
        TextView tv = view.findViewById(R.id.toast_custom_tv);
        tv.setText(TextUtils.isEmpty(tvStr) ? "" : tvStr);
        ImageView iv = view.findViewById(R.id.toast_custom_iv);
        if (imageResource > 0) {
            iv.setVisibility(View.VISIBLE);
            iv.setImageResource(imageResource);
        } else {
            iv.setVisibility(View.GONE);
        }
        toast2.setView(view);
        toast2.setGravity(Gravity.CENTER, 0, 0);
        toast2.show();
        return toast2;

    }
}
