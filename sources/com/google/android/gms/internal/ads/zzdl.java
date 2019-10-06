package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdl extends zzcf<Integer, Long> {

    /* renamed from: b */
    public long f27952b;

    /* renamed from: c */
    public long f27953c;

    public zzdl() {
        this.f27952b = -1;
        this.f27953c = -1;
    }

    public zzdl(String str) {
        this();
        mo31527b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final HashMap<Integer, Long> mo31140a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), Long.valueOf(this.f27952b));
        hashMap.put(Integer.valueOf(1), Long.valueOf(this.f27953c));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31527b(String str) {
        HashMap a = zzcf.m28348a(str);
        if (a != null) {
            this.f27952b = ((Long) a.get(Integer.valueOf(0))).longValue();
            this.f27953c = ((Long) a.get(Integer.valueOf(1))).longValue();
        }
    }
}
