package com.crashlytics.android.p126c;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.crashlytics.android.c.N */
/* compiled from: CrashlyticsController */
class C6439N implements Comparator<File> {
    C6439N() {
    }

    /* renamed from: a */
    public int compare(File file1, File file2) {
        return file2.getName().compareTo(file1.getName());
    }
}
