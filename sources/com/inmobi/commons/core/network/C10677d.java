package com.inmobi.commons.core.network;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/* renamed from: com.inmobi.commons.core.network.d */
/* compiled from: NetworkResponse */
public class C10677d {

    /* renamed from: e */
    private static final String f32589e = C10677d.class.getSimpleName();

    /* renamed from: a */
    public byte[] f32590a;

    /* renamed from: b */
    public NetworkError f32591b;

    /* renamed from: c */
    public int f32592c;

    /* renamed from: d */
    public Map<String, List<String>> f32593d;

    /* renamed from: f */
    private String f32594f;

    /* renamed from: a */
    public final boolean mo34510a() {
        return this.f32591b != null;
    }

    /* renamed from: b */
    public final String mo34511b() {
        if (this.f32594f == null) {
            this.f32594f = m35056a(this.f32590a);
        }
        return this.f32594f;
    }

    /* renamed from: a */
    public static String m35056a(byte[] bArr) {
        String str = "";
        if (bArr == null || bArr.length == 0) {
            return str;
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

    /* renamed from: b */
    public final void mo34512b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            this.f32590a = new byte[0];
            return;
        }
        this.f32590a = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f32590a, 0, bArr.length);
    }

    /* renamed from: c */
    public final long mo34513c() {
        try {
            if (this.f32594f != null) {
                return ((long) this.f32594f.length()) + 0;
            }
            return 0;
        } catch (Exception e) {
            new StringBuilder("SDK encountered unexpected error in computing response size; ").append(e.getMessage());
            return 0;
        }
    }
}
