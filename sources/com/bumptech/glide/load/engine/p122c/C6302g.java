package com.bumptech.glide.load.engine.p122c;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import java.io.File;
import java.util.regex.Pattern;

/* renamed from: com.bumptech.glide.load.engine.c.g */
/* compiled from: RuntimeCompat */
final class C6302g {
    /* renamed from: a */
    static int m12092a() {
        int cpus = Runtime.getRuntime().availableProcessors();
        if (VERSION.SDK_INT < 17) {
            return Math.max(m12093b(), cpus);
        }
        return cpus;
    }

    /* renamed from: b */
    private static int m12093b() {
        String str = "GlideRuntimeCompat";
        File[] cpus = null;
        ThreadPolicy originalPolicy = StrictMode.allowThreadDiskReads();
        try {
            cpus = new File("/sys/devices/system/cpu/").listFiles(new C6301f(Pattern.compile("cpu[0-9]+")));
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(originalPolicy);
            throw th;
        }
        StrictMode.setThreadPolicy(originalPolicy);
        return Math.max(1, cpus != null ? cpus.length : 0);
    }
}
