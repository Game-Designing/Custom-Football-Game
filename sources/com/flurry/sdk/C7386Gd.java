package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* renamed from: com.flurry.sdk.Gd */
public final class C7386Gd {

    /* renamed from: a */
    private static SimpleDateFormat f14467a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    /* renamed from: b */
    String f14468b;

    /* renamed from: c */
    long f14469c;

    public C7386Gd(String str, long j) {
        this.f14468b = str;
        this.f14469c = j;
    }

    /* renamed from: a */
    public final byte[] mo23824a() {
        Throwable th;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeLong(this.f14469c);
                dataOutputStream2.writeUTF(this.f14468b);
                dataOutputStream2.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C7354Ad.m16261a((Closeable) dataOutputStream2);
                return byteArray;
            } catch (IOException e) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr = new byte[0];
                    C7354Ad.m16261a((Closeable) dataOutputStream);
                    return bArr;
                } catch (Throwable th2) {
                    dataOutputStream2 = dataOutputStream;
                    th = th2;
                    C7354Ad.m16261a((Closeable) dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                C7354Ad.m16261a((Closeable) dataOutputStream2);
                throw th;
            }
        } catch (IOException e2) {
            byte[] bArr2 = new byte[0];
            C7354Ad.m16261a((Closeable) dataOutputStream);
            return bArr2;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f14467a.format(Long.valueOf(this.f14469c)));
        sb.append(": ");
        sb.append(this.f14468b);
        sb.append("\n");
        return sb.toString();
    }
}
