package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdw extends zzcf<Integer, Object> {

    /* renamed from: b */
    public Long f28318b;

    /* renamed from: c */
    public Boolean f28319c;

    /* renamed from: d */
    public Boolean f28320d;

    public zzdw() {
    }

    public zzdw(String str) {
        mo31707b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31707b(String str) {
        HashMap a = zzcf.m28348a(str);
        if (a != null) {
            this.f28318b = (Long) a.get(Integer.valueOf(0));
            this.f28319c = (Boolean) a.get(Integer.valueOf(1));
            this.f28320d = (Boolean) a.get(Integer.valueOf(2));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final HashMap<Integer, Object> mo31140a() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.f28318b);
        hashMap.put(Integer.valueOf(1), this.f28319c);
        hashMap.put(Integer.valueOf(2), this.f28320d);
        return hashMap;
    }
}
