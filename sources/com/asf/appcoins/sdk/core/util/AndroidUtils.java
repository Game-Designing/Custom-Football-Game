package com.asf.appcoins.sdk.core.util;

import android.content.Context;
import android.content.Intent;

public class AndroidUtils {
    private AndroidUtils(Context context) {
    }

    public static boolean hasHandlerAvailable(Intent intent, Context context) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}
