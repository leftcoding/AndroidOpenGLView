package android.xrj.opengl.util;

import android.content.Context;

/**
 * Create by LingYan on 2018-08-27
 */

public class DisplayUtil {
    public static int getWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}
