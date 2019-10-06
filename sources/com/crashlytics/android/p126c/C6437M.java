package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FileFilter;

/* renamed from: com.crashlytics.android.c.M */
/* compiled from: CrashlyticsController */
class C6437M implements FileFilter {
    C6437M() {
    }

    public boolean accept(File file) {
        return file.isDirectory() && file.getName().length() == 35;
    }
}
