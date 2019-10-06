package com.crashlytics.android.p126c;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;

/* renamed from: com.crashlytics.android.c.w */
/* compiled from: CrashlyticsController */
class C6526w implements Callable<Boolean> {

    /* renamed from: a */
    final /* synthetic */ C6482da f11715a;

    /* renamed from: b */
    final /* synthetic */ C6452U f11716b;

    C6526w(C6452U this$0, C6482da daVar) {
        this.f11716b = this$0;
        this.f11715a = daVar;
    }

    public Boolean call() throws Exception {
        TreeSet<File> timestampedNativeDirectories = this.f11715a.f11644a;
        String previousSessionId = this.f11716b.m12573p();
        if (previousSessionId != null && !timestampedNativeDirectories.isEmpty()) {
            File latestDir = (File) timestampedNativeDirectories.first();
            if (latestDir != null) {
                C6452U u = this.f11716b;
                u.m12514a(u.f11573j.mo3307i(), latestDir, previousSessionId);
            }
        }
        this.f11716b.m12535a((Set<File>) timestampedNativeDirectories);
        return Boolean.TRUE;
    }
}
