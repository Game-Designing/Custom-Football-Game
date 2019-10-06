package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;
import p024io.realm.internal.Collection;

public final class zzbc {
    /* renamed from: a */
    public static long m26411a(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        if (j < 0) {
            return j + 4294967296L;
        }
        return j;
    }

    /* renamed from: b */
    public static int m26412b(ByteBuffer byteBuffer) {
        return (m26410a(byteBuffer.get()) << 8) + 0 + m26410a(byteBuffer.get());
    }

    /* renamed from: a */
    public static int m26410a(byte b) {
        return b < 0 ? b + Collection.MODE_EMPTY : b;
    }

    /* renamed from: c */
    public static long m26413c(ByteBuffer byteBuffer) {
        long a = (m26411a(byteBuffer) << 32) + 0;
        if (a >= 0) {
            return a + m26411a(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    /* renamed from: d */
    public static double m26414d(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & Collection.MODE_EMPTY) | ((bArr[1] << ExecutionDataWriter.BLOCK_SESSIONINFO) & Collection.MODE_EMPTY) | ((bArr[2] << 8) & Collection.MODE_EMPTY) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 65536.0d;
    }

    /* renamed from: e */
    public static double m26415e(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & Collection.MODE_EMPTY) | ((bArr[1] << ExecutionDataWriter.BLOCK_SESSIONINFO) & Collection.MODE_EMPTY) | ((bArr[2] << 8) & Collection.MODE_EMPTY) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }

    /* renamed from: f */
    public static String m26416f(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
