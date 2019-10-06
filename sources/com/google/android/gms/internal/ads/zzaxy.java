package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager.LayoutParams;
import com.google.android.gms.ads.internal.zzk;
import java.util.Locale;

@TargetApi(28)
public final class zzaxy extends zzaxx {
    /* renamed from: a */
    public final void mo30250a(Activity activity) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24138nb)).booleanValue() && zzk.zzlk().mo30177i().mo30199a() == null && !activity.isInMultiWindowMode()) {
            m26205a(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new C9531kc(this, activity));
        }
    }

    /* renamed from: a */
    private static void m26205a(boolean z, Activity activity) {
        int i;
        Window window = activity.getWindow();
        LayoutParams attributes = window.getAttributes();
        int i2 = attributes.layoutInDisplayCutoutMode;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        if (i != i2) {
            attributes.layoutInDisplayCutoutMode = i;
            window.setAttributes(attributes);
        }
    }

    /* renamed from: a */
    static /* synthetic */ WindowInsets m26204a(Activity activity, View view, WindowInsets windowInsets) {
        if (zzk.zzlk().mo30177i().mo30199a() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzaxb i = zzk.zzlk().mo30177i();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                i.mo30209b(str);
            } else {
                zzk.zzlk().mo30177i().mo30209b(str);
            }
        }
        m26205a(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}
