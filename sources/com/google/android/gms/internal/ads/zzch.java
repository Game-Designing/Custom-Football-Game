package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzch extends zzcf<Integer, Object> {

    /* renamed from: b */
    public String f26608b;

    /* renamed from: c */
    public long f26609c;

    /* renamed from: d */
    public String f26610d;

    /* renamed from: e */
    public String f26611e;

    /* renamed from: f */
    public String f26612f;

    public zzch(String str) {
        this();
        mo31161b(str);
    }

    public zzch() {
        String str = "E";
        this.f26608b = str;
        this.f26609c = -1;
        this.f26610d = str;
        this.f26611e = str;
        this.f26612f = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31161b(String str) {
        HashMap a = zzcf.m28348a(str);
        if (a != null) {
            String str2 = "E";
            this.f26608b = a.get(Integer.valueOf(0)) == null ? str2 : (String) a.get(Integer.valueOf(0));
            this.f26609c = a.get(Integer.valueOf(1)) == null ? -1 : ((Long) a.get(Integer.valueOf(1))).longValue();
            this.f26610d = a.get(Integer.valueOf(2)) == null ? str2 : (String) a.get(Integer.valueOf(2));
            this.f26611e = a.get(Integer.valueOf(3)) == null ? str2 : (String) a.get(Integer.valueOf(3));
            if (a.get(Integer.valueOf(4)) != null) {
                str2 = (String) a.get(Integer.valueOf(4));
            }
            this.f26612f = str2;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final HashMap<Integer, Object> mo31140a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.f26608b);
        hashMap.put(Integer.valueOf(4), this.f26612f);
        hashMap.put(Integer.valueOf(3), this.f26611e);
        hashMap.put(Integer.valueOf(2), this.f26610d);
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f26609c));
        return hashMap;
    }
}
