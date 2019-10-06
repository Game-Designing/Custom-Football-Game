package com.crashlytics.android.p126c;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.Na */
/* compiled from: Sha1FileIdStrategy */
class C6440Na implements C6479a {
    C6440Na() {
    }

    /* renamed from: a */
    public String mo19467a(File file) throws IOException {
        return m12501a(file.getPath());
    }

    /* renamed from: a */
    private static String m12501a(String path) throws IOException {
        InputStream data = null;
        try {
            data = new BufferedInputStream(new FileInputStream(path));
            return C13852l.m44027a(data);
        } finally {
            C13852l.m44035a((Closeable) data);
        }
    }
}
