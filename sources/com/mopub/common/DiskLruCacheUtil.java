package com.mopub.common;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class DiskLruCacheUtil {

    /* renamed from: a */
    static final Charset f34312a = Charset.forName("US-ASCII");

    /* renamed from: b */
    static final Charset f34313b = Charset.forName("UTF-8");

    private DiskLruCacheUtil() {
    }

    /* renamed from: a */
    static String m37001a(Reader reader) throws IOException {
        try {
            StringWriter writer = new StringWriter();
            char[] buffer = new char[Opcodes.ACC_ABSTRACT];
            while (true) {
                int read = reader.read(buffer);
                int count = read;
                if (read == -1) {
                    return writer.toString();
                }
                writer.write(buffer, 0, count);
            }
        } finally {
            reader.close();
        }
    }

    /* renamed from: a */
    static void m37003a(File dir) throws IOException {
        File[] files = dir.listFiles();
        if (files != null) {
            int length = files.length;
            int i = 0;
            while (i < length) {
                File file = files[i];
                if (file.isDirectory()) {
                    m37003a(file);
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
    static void m37002a(Closeable closeable) {
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
