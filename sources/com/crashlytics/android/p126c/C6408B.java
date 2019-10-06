package com.crashlytics.android.p126c;

import java.io.File;

/* renamed from: com.crashlytics.android.c.B */
/* compiled from: CrashlyticsController */
class C6408B extends C6456d {
    C6408B(String s) {
        super(s);
    }

    public boolean accept(File dir, String filename) {
        return super.accept(dir, filename) && filename.endsWith(".cls");
    }
}
