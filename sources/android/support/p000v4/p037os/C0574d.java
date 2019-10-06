package android.support.p000v4.p037os;

import android.os.Build.VERSION;
import android.os.Trace;

/* renamed from: android.support.v4.os.d */
/* compiled from: TraceCompat */
public final class C0574d {
    /* renamed from: a */
    public static void m2755a(String sectionName) {
        if (VERSION.SDK_INT >= 18) {
            Trace.beginSection(sectionName);
        }
    }

    /* renamed from: a */
    public static void m2754a() {
        if (VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
