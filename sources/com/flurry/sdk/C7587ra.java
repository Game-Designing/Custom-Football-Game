package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.ra */
public final class C7587ra {

    /* renamed from: a */
    private final Map<String, String> f15048a = new HashMap();

    /* renamed from: b */
    private int f15049b;

    /* renamed from: c */
    public String f15050c;

    /* renamed from: d */
    private long f15051d;

    /* renamed from: e */
    public boolean f15052e;

    /* renamed from: f */
    public boolean f15053f;

    /* renamed from: g */
    public long f15054g;

    public C7587ra(int i, String str, Map<String, String> map, long j, boolean z) {
        this.f15049b = i;
        this.f15050c = str;
        if (map != null) {
            this.f15048a.putAll(map);
        }
        this.f15051d = j;
        this.f15052e = z;
        this.f15053f = !this.f15052e;
    }

    /* renamed from: a */
    public final void mo24010a(long j) {
        this.f15053f = true;
        this.f15054g = j - this.f15051d;
        StringBuilder sb = new StringBuilder("Ended event '");
        sb.append(this.f15050c);
        sb.append("' (");
        sb.append(this.f15051d);
        sb.append(") after ");
        sb.append(this.f15054g);
        sb.append("ms");
        C7513ec.m16639a(3, "FlurryAgent", sb.toString());
    }

    /* renamed from: a */
    public final synchronized void mo24011a(Map<String, String> map) {
        if (map != null) {
            this.f15048a.putAll(map);
        }
    }

    /* renamed from: a */
    public final synchronized Map<String, String> mo24009a() {
        return new HashMap(this.f15048a);
    }

    /* renamed from: b */
    public final synchronized void mo24012b(Map<String, String> map) {
        this.f15048a.clear();
        if (map != null) {
            this.f15048a.putAll(map);
        }
    }

    /* renamed from: b */
    public final synchronized byte[] mo24013b() {
        Throwable th;
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.f15049b);
                dataOutputStream2.writeUTF(this.f15050c);
                dataOutputStream2.writeShort(this.f15048a.size());
                for (Entry entry : this.f15048a.entrySet()) {
                    dataOutputStream2.writeUTF(C7354Ad.m16265b((String) entry.getKey()));
                    dataOutputStream2.writeUTF(C7354Ad.m16265b((String) entry.getValue()));
                }
                dataOutputStream2.writeLong(this.f15051d);
                dataOutputStream2.writeLong(this.f15054g);
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C7354Ad.m16261a((Closeable) dataOutputStream2);
            } catch (IOException e) {
                dataOutputStream = dataOutputStream2;
                try {
                    byte[] bArr2 = new byte[0];
                    C7354Ad.m16261a((Closeable) dataOutputStream);
                    bArr = bArr2;
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
            byte[] bArr22 = new byte[0];
            C7354Ad.m16261a((Closeable) dataOutputStream);
            bArr = bArr22;
            return bArr;
        }
        return bArr;
    }
}
