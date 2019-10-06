package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@ShowFirstParty
@KeepForSdk
@Deprecated
public final class IOUtils {
    private IOUtils() {
    }

    @KeepForSdk
    /* renamed from: a */
    public static void m22102a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public static long m22099a(InputStream inputStream, OutputStream outputStream) throws IOException {
        return m22100a(inputStream, outputStream, false);
    }

    @Deprecated
    /* renamed from: a */
    private static long m22100a(InputStream inputStream, OutputStream outputStream, boolean z) throws IOException {
        return m22101a(inputStream, outputStream, z, Opcodes.ACC_ABSTRACT);
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public static long m22101a(InputStream inputStream, OutputStream outputStream, boolean z, int i) throws IOException {
        byte[] bArr = new byte[i];
        long j = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, i);
                if (read == -1) {
                    break;
                }
                j += (long) read;
                outputStream.write(bArr, 0, read);
            } finally {
                if (z) {
                    m22102a(inputStream);
                    m22102a(outputStream);
                }
            }
        }
        return j;
    }

    @KeepForSdk
    @Deprecated
    /* renamed from: a */
    public static byte[] m22103a(InputStream inputStream, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m22100a(inputStream, byteArrayOutputStream, z);
        return byteArrayOutputStream.toByteArray();
    }
}
