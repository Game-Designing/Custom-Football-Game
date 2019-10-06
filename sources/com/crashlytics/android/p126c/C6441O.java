package com.crashlytics.android.p126c;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.crashlytics.android.c.O */
/* compiled from: CrashlyticsController */
class C6441O implements Comparator<File> {
    C6441O() {
    }

    /* renamed from: a */
    public int compare(File file1, File file2) {
        return file1.getName().compareTo(file2.getName());
    }
}
