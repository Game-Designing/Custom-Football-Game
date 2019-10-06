package com.crashlytics.android.p126c;

import java.io.File;
import java.util.Map;

/* renamed from: com.crashlytics.android.c.Ia */
/* compiled from: Report */
interface C6424Ia {

    /* renamed from: com.crashlytics.android.c.Ia$a */
    /* compiled from: Report */
    public enum C6425a {
        JAVA,
        NATIVE
    }

    /* renamed from: a */
    Map<String, String> mo19432a();

    /* renamed from: b */
    String mo19433b();

    File getFile();

    String getFileName();

    File[] getFiles();

    C6425a getType();

    void remove();
}
