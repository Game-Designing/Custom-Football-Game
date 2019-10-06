package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.crashlytics.android.c.L */
/* compiled from: CrashlyticsController */
class C6435L implements FilenameFilter {
    C6435L() {
    }

    public boolean accept(File dir, String filename) {
        String str = ".cls";
        return filename.length() == str.length() + 35 && filename.endsWith(str);
    }
}
