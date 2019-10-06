package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

/* renamed from: com.crashlytics.android.c.v */
/* compiled from: CrashlyticsController */
class C6524v implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ Set f11711a;

    /* renamed from: b */
    final /* synthetic */ C6452U f11712b;

    C6524v(C6452U this$0, Set set) {
        this.f11712b = this$0;
        this.f11711a = set;
    }

    public boolean accept(File dir, String filename) {
        if (filename.length() < 35) {
            return false;
        }
        return this.f11711a.contains(filename.substring(0, 35));
    }
}
