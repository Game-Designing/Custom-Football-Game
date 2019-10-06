package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzeg extends zzcf<Integer, Long> {

    /* renamed from: b */
    public Long f28355b;

    /* renamed from: c */
    public Long f28356c;

    /* renamed from: d */
    public Long f28357d;

    /* renamed from: e */
    public Long f28358e;

    public zzeg() {
    }

    public zzeg(String str) {
        mo31729b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31729b(String str) {
        HashMap a = zzcf.m28348a(str);
        if (a != null) {
            this.f28355b = (Long) a.get(Integer.valueOf(0));
            this.f28356c = (Long) a.get(Integer.valueOf(1));
            this.f28357d = (Long) a.get(Integer.valueOf(2));
            this.f28358e = (Long) a.get(Integer.valueOf(3));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final HashMap<Integer, Long> mo31140a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.f28355b);
        hashMap.put(Integer.valueOf(1), this.f28356c);
        hashMap.put(Integer.valueOf(2), this.f28357d);
        hashMap.put(Integer.valueOf(3), this.f28358e);
        return hashMap;
    }
}
