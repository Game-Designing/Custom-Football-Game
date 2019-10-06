package com.crashlytics.android.p126c;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.crashlytics.android.c.f */
/* compiled from: ClsFileOutputStream */
class C6485f implements FilenameFilter {
    C6485f() {
    }

    public boolean accept(File dir, String filename) {
        return filename.endsWith(".cls_temp");
    }
}
