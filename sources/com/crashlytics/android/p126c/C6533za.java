package com.crashlytics.android.p126c;

import android.content.Context;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: com.crashlytics.android.c.za */
/* compiled from: NativeFileUtils */
final class C6533za {
    /* renamed from: c */
    static byte[] m12810c(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            return m12807a((InputStream) fis);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e2) {
            return null;
        } finally {
            C13852l.m44035a((Closeable) fis);
        }
    }

    /* renamed from: a */
    private static byte[] m12807a(InputStream inputStream) throws IOException {
        byte[] b = new byte[Opcodes.ACC_ABSTRACT];
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(b);
            int c = read;
            if (read == -1) {
                return os.toByteArray();
            }
            os.write(b, 0, c);
        }
    }

    /* renamed from: a */
    private static File m12803a(File directory, String extension) {
        File[] listFiles;
        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(extension)) {
                return file;
            }
        }
        return null;
    }

    /* renamed from: b */
    static byte[] m12808b(File directory) {
        File file = m12803a(directory, ".dmp");
        return file == null ? new byte[0] : m12812d(file);
    }

    /* renamed from: d */
    private static byte[] m12812d(File file) {
        return m12810c(file);
    }

    /* renamed from: a */
    static byte[] m12806a(File directory, Context context) throws IOException {
        File a = m12803a(directory, ".maps");
        File file = a;
        if (a != null) {
            return m12811c(file, context);
        }
        File a2 = m12803a(directory, ".binary_libs");
        File file2 = a2;
        if (a2 != null) {
            return m12809b(file2, context);
        }
        return null;
    }

    /* renamed from: b */
    private static byte[] m12809b(File file, Context context) throws IOException {
        byte[] raw = m12810c(file);
        if (raw == null || raw.length == 0) {
            return null;
        }
        return m12804a(context, new String(raw));
    }

    /* renamed from: c */
    private static byte[] m12811c(File file, Context context) throws IOException {
        if (!file.exists()) {
            return null;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            return new C6478c(context, new C6440Na()).mo19531a(reader);
        } finally {
            C13852l.m44035a((Closeable) reader);
        }
    }

    /* renamed from: a */
    static byte[] m12805a(File directory) {
        File file = m12803a(directory, ".device_info");
        if (file == null) {
            return null;
        }
        return m12810c(file);
    }

    /* renamed from: a */
    private static byte[] m12804a(Context context, String binaryImages) throws IOException {
        return new C6478c(context, new C6440Na()).mo19532a(binaryImages);
    }
}
