package com.google.android.exoplayer2.util;

import android.annotation.TargetApi;
import android.os.Trace;

/* renamed from: com.google.android.exoplayer2.util.E */
/* compiled from: TraceUtil */
public final class C8507E {
    /* renamed from: a */
    public static void m20417a(String sectionName) {
        if (C8509F.f18793a >= 18) {
            m20419b(sectionName);
        }
    }

    /* renamed from: a */
    public static void m20416a() {
        if (C8509F.f18793a >= 18) {
            m20418b();
        }
    }

    @TargetApi(18)
    /* renamed from: b */
    private static void m20419b(String sectionName) {
        Trace.beginSection(sectionName);
    }

    @TargetApi(18)
    /* renamed from: b */
    private static void m20418b() {
        Trace.endSection();
    }
}
