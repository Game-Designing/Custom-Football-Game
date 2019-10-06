package com.flurry.sdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.flurry.sdk.pa */
public final class C7575pa {

    /* renamed from: a */
    private int f14983a;

    /* renamed from: b */
    private long f14984b;

    /* renamed from: c */
    public String f14985c;

    /* renamed from: d */
    private String f14986d;

    /* renamed from: e */
    private String f14987e;

    /* renamed from: f */
    private Throwable f14988f;

    /* renamed from: g */
    private Map<String, String> f14989g = new HashMap();

    /* renamed from: h */
    private Map<String, String> f14990h = new HashMap();

    /* renamed from: i */
    private List<C7386Gd> f14991i = new ArrayList();

    /* renamed from: j */
    public String f14992j;

    /* renamed from: k */
    public String f14993k;

    public C7575pa(int i, long j, String str, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        this.f14983a = i;
        this.f14984b = j;
        this.f14985c = str;
        this.f14986d = str2;
        this.f14987e = str3;
        this.f14988f = th;
        if (map != null) {
            this.f14989g = map;
        }
        if (map2 != null) {
            this.f14990h = map2;
        }
    }

    /* renamed from: a */
    public final byte[] mo23985a() {
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.f14983a);
                dataOutputStream2.writeLong(this.f14984b);
                dataOutputStream2.writeUTF(this.f14985c);
                dataOutputStream2.writeUTF(this.f14986d);
                dataOutputStream2.writeUTF(this.f14987e);
                dataOutputStream2.writeShort(this.f14989g.size());
                for (Entry entry : this.f14989g.entrySet()) {
                    dataOutputStream2.writeUTF((String) entry.getKey());
                    dataOutputStream2.writeUTF((String) entry.getValue());
                }
                dataOutputStream2.writeShort(this.f14990h.size());
                for (Entry entry2 : this.f14990h.entrySet()) {
                    dataOutputStream2.writeUTF((String) entry2.getKey());
                    dataOutputStream2.writeUTF((String) entry2.getValue());
                }
                if (this.f14988f != null) {
                    if ("uncaught".equals(this.f14985c)) {
                        dataOutputStream2.writeByte(3);
                    } else {
                        dataOutputStream2.writeByte(2);
                    }
                    dataOutputStream2.writeByte(2);
                    StringBuilder sb = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (StackTraceElement append : this.f14988f.getStackTrace()) {
                        sb.append(append);
                        sb.append(property);
                    }
                    if (this.f14988f.getCause() != null) {
                        sb.append(property);
                        sb.append("Caused by: ");
                        for (StackTraceElement append2 : this.f14988f.getCause().getStackTrace()) {
                            sb.append(append2);
                            sb.append(property);
                        }
                    }
                    byte[] bytes = sb.toString().getBytes();
                    dataOutputStream2.writeInt(bytes.length);
                    dataOutputStream2.write(bytes);
                } else if (mo23986b()) {
                    dataOutputStream2.writeByte(3);
                    if (TextUtils.isEmpty(this.f14993k)) {
                        dataOutputStream2.writeByte(0);
                    } else {
                        dataOutputStream2.writeByte(3);
                        byte[] bytes2 = this.f14993k.getBytes();
                        dataOutputStream2.writeInt(bytes2.length);
                        dataOutputStream2.write(bytes2);
                    }
                } else {
                    dataOutputStream2.writeByte(1);
                    dataOutputStream2.writeByte(0);
                }
                if (TextUtils.isEmpty(this.f14992j)) {
                    dataOutputStream2.writeByte(0);
                } else {
                    dataOutputStream2.writeByte(1);
                    byte[] bytes3 = this.f14992j.getBytes();
                    dataOutputStream2.writeInt(bytes3.length);
                    dataOutputStream2.write(bytes3);
                }
                dataOutputStream2.writeShort(C7392Hd.m16367b());
                if (this.f14991i != null) {
                    dataOutputStream2.writeShort(this.f14991i.size());
                    for (C7386Gd a : this.f14991i) {
                        dataOutputStream2.write(a.mo23824a());
                    }
                } else {
                    dataOutputStream2.writeShort(0);
                }
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C7354Ad.m16261a((Closeable) dataOutputStream2);
            } catch (IOException e) {
                dataOutputStream = dataOutputStream2;
                try {
                    bArr = new byte[0];
                    C7354Ad.m16261a((Closeable) dataOutputStream);
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream2 = dataOutputStream;
                    C7354Ad.m16261a((Closeable) dataOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                C7354Ad.m16261a((Closeable) dataOutputStream2);
                throw th;
            }
        } catch (IOException e2) {
            bArr = new byte[0];
            C7354Ad.m16261a((Closeable) dataOutputStream);
            return bArr;
        }
        return bArr;
    }

    /* renamed from: a */
    public final void mo23984a(List<C7386Gd> list) {
        if (list != null) {
            this.f14991i = list;
        }
    }

    /* renamed from: b */
    public final boolean mo23986b() {
        return "native".equals(this.f14985c);
    }
}
