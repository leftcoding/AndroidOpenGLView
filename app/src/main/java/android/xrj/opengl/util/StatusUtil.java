package android.xrj.opengl.util;

import android.content.Context;

/**
 * Create by LingYan on 2018-08-27
 */

public class StatusUtil {
    public static int getStatusHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return context.getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }
}
