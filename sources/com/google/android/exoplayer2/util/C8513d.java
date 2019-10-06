package com.google.android.exoplayer2.util;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.exoplayer2.util.d */
/* compiled from: lambda */
public final /* synthetic */ class C8513d implements ThreadFactory {

    /* renamed from: a */
    private final /* synthetic */ String f18807a;

    public /* synthetic */ C8513d(String str) {
        this.f18807a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return C8509F.m20448a(this.f18807a, runnable);
    }
}
