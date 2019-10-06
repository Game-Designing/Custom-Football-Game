package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;

@TargetApi(24)
public class zzaxw extends zzaxv {
    /* renamed from: a */
    public final boolean mo30253a(Activity activity, Configuration configuration) {
        int i;
        if (!((Boolean) zzyt.m31536e().mo29599a(zzacu.f23966Ld)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23978Nd)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzyt.m31532a();
        int a = zzazt.m26302a((Context) activity, configuration.screenHeightDp);
        int a2 = zzazt.m26302a((Context) activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzk.zzlg();
        DisplayMetrics a3 = zzaxi.m26100a(windowManager);
        int i2 = a3.heightPixels;
        int i3 = a3.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i = 0;
        }
        double d = (double) activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d);
        int round = ((int) Math.round(d + 0.5d)) * ((Integer) zzyt.m31536e().mo29599a(zzacu.f23960Kd)).intValue();
        if (!(m26201a(i2, a + i, round) && m26201a(i3, a2, round))) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m26201a(int i, int i2, int i3) {
        return Math.abs(i - i2) <= i3;
    }
}
