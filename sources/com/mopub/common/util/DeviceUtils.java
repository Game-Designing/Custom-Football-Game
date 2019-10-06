package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.support.p000v4.content.C0510b;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.io.File;
import java.net.SocketException;

public class DeviceUtils {

    public enum ForceOrientation {
        FORCE_PORTRAIT("portrait"),
        FORCE_LANDSCAPE("landscape"),
        DEVICE_ORIENTATION("device"),
        UNDEFINED("");
        

        /* renamed from: b */
        private final String f34585b;

        private ForceOrientation(String key) {
            this.f34585b = key;
        }

        public static ForceOrientation getForceOrientation(String key) {
            ForceOrientation[] values;
            for (ForceOrientation orientation : values()) {
                if (orientation.f34585b.equalsIgnoreCase(key)) {
                    return orientation;
                }
            }
            return UNDEFINED;
        }
    }

    @Deprecated
    /* renamed from: com.mopub.common.util.DeviceUtils$IP */
    public enum C11285IP {
        IPv4,
        IPv6
    }

    private DeviceUtils() {
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null || !isPermissionGranted(context, "android.permission.INTERNET")) {
            return false;
        }
        if (!isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (NullPointerException e) {
            return false;
        }
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        long memoryClass = (long) activityManager.getMemoryClass();
        try {
            if (Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                memoryClass = (long) ((Integer) new MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
            }
        } catch (Exception e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to reflectively determine large heap size.");
        }
        return (int) Math.min(31457280, (memoryClass / 8) * 1024 * 1024);
    }

    public static long diskCacheSizeBytes(File dir, long minSize) {
        long size = minSize;
        try {
            StatFs statFs = new StatFs(dir.getAbsolutePath());
            size = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(size, 104857600), 31457280);
    }

    public static long diskCacheSizeBytes(File dir) {
        return diskCacheSizeBytes(dir, 31457280);
    }

    public static int getScreenOrientation(Activity activity) {
        return m37187a(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    /* renamed from: a */
    static int m37187a(int rotation, int orientation) {
        if (1 == orientation) {
            return (rotation == 1 || rotation == 2) ? 9 : 1;
        }
        if (2 != orientation) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unknown screen orientation. Defaulting to portrait.");
            return 9;
        } else if (rotation == 2 || rotation == 3) {
            return 8;
        } else {
            return 0;
        }
    }

    public static void lockOrientation(Activity activity, CreativeOrientation creativeOrientation) {
        int requestedOrientation;
        if (NoThrow.checkNotNull(creativeOrientation) && NoThrow.checkNotNull(activity)) {
            int currentOrientation = m37187a(((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
            if (CreativeOrientation.PORTRAIT == creativeOrientation) {
                if (9 == currentOrientation) {
                    requestedOrientation = 9;
                } else {
                    requestedOrientation = 1;
                }
            } else if (CreativeOrientation.LANDSCAPE != creativeOrientation) {
                return;
            } else {
                if (8 == currentOrientation) {
                    requestedOrientation = 8;
                } else {
                    requestedOrientation = 0;
                }
            }
            activity.setRequestedOrientation(requestedOrientation);
        }
    }

    @TargetApi(17)
    public static Point getDeviceDimensions(Context context) {
        Integer bestWidthPixels = null;
        Integer bestHeightPixels = null;
        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            Point screenSize = new Point();
            display.getRealSize(screenSize);
            bestWidthPixels = Integer.valueOf(screenSize.x);
            bestHeightPixels = Integer.valueOf(screenSize.y);
        } else {
            try {
                bestWidthPixels = (Integer) new MethodBuilder(display, "getRawWidth").execute();
                bestHeightPixels = (Integer) new MethodBuilder(display, "getRawHeight").execute();
            } catch (Exception e) {
                MoPubLog.log(SdkLogEvent.CUSTOM, "Display#getRawWidth/Height failed.", e);
            }
        }
        if (bestWidthPixels == null || bestHeightPixels == null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            bestWidthPixels = Integer.valueOf(displayMetrics.widthPixels);
            bestHeightPixels = Integer.valueOf(displayMetrics.heightPixels);
        }
        return new Point(bestWidthPixels.intValue(), bestHeightPixels.intValue());
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(permission);
        boolean z = false;
        try {
            if (C0510b.m2565a(context, permission) == 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    @Deprecated
    public static String getIpAddress(C11285IP ip) throws SocketException {
        return null;
    }

    @Deprecated
    public static String getHashedUdid(Context context) {
        return null;
    }
}
