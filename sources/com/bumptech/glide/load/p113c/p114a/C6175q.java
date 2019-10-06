package com.bumptech.glide.load.p113c.p114a;

import android.annotation.TargetApi;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.C6060b;
import java.io.File;

/* renamed from: com.bumptech.glide.load.c.a.q */
/* compiled from: HardwareConfigState */
final class C6175q {

    /* renamed from: a */
    private static final File f10894a = new File("/proc/self/fd");

    /* renamed from: b */
    private static volatile C6175q f10895b;

    /* renamed from: c */
    private volatile int f10896c;

    /* renamed from: d */
    private volatile boolean f10897d = true;

    /* renamed from: a */
    static C6175q m11704a() {
        if (f10895b == null) {
            synchronized (C6175q.class) {
                if (f10895b == null) {
                    f10895b = new C6175q();
                }
            }
        }
        return f10895b;
    }

    private C6175q() {
    }

    /* access modifiers changed from: 0000 */
    @TargetApi(26)
    /* renamed from: a */
    public boolean mo19002a(int targetWidth, int targetHeight, Options optionsWithScaling, C6060b decodeFormat, boolean isHardwareConfigAllowed, boolean isExifOrientationRequired) {
        if (!isHardwareConfigAllowed || VERSION.SDK_INT < 26 || decodeFormat == C6060b.PREFER_ARGB_8888_DISALLOW_HARDWARE || isExifOrientationRequired) {
            return false;
        }
        boolean result = targetWidth >= 128 && targetHeight >= 128 && m11705b();
        if (result) {
            optionsWithScaling.inPreferredConfig = Config.HARDWARE;
            optionsWithScaling.inMutable = false;
        }
        return result;
    }

    /* renamed from: b */
    private synchronized boolean m11705b() {
        int i = this.f10896c + 1;
        this.f10896c = i;
        if (i >= 50) {
            boolean z = false;
            this.f10896c = 0;
            int currentFds = f10894a.list().length;
            if (currentFds < 700) {
                z = true;
            }
            this.f10897d = z;
            if (!this.f10897d && Log.isLoggable("Downsampler", 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                sb.append(currentFds);
                sb.append(", limit ");
                sb.append(700);
                Log.w("Downsampler", sb.toString());
            }
        }
        return this.f10897d;
    }
}
