package com.smaato.soma.p261j.p262a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.smaato.soma.j.a.h */
/* compiled from: DiskLruCacheUtil */
public final class C12460h {

    /* renamed from: a */
    static final Charset f38906a = Charset.forName("US-ASCII");

    /* renamed from: b */
    static final Charset f38907b = Charset.forName("UTF-8");

    /* renamed from: a */
    static void m40986a(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            int length = files.length;
            int i = 0;
            while (i < length) {
                File file = files[i];
                if (file.isDirectory()) {
                    m40986a(file);
                }
                if (file.delete()) {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("failed to delete file: ");
                    sb.append(file);
                    throw new IOException(sb.toString());
                }
            }
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("not a readable directory: ");
        sb2.append(dir);
        throw new IOException(sb2.toString());
    }

    /* renamed from: a */
    static void m40985a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException rethrown) {
                throw rethrown;
            } catch (Exception e) {
            }
        }
    }
}
