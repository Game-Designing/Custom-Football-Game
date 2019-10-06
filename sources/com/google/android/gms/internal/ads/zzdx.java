package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdx extends zzcf<Integer, Long> {

    /* renamed from: b */
    public Long f28321b;

    /* renamed from: c */
    public Long f28322c;

    public zzdx() {
    }

    public zzdx(String str) {
        mo31708b(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo31708b(String str) {
        HashMap a = zzcf.m28348a(str);
        if (a != null) {
            this.f28321b = (Long) a.get(Integer.valueOf(0));
            this.f28322c = (Long) a.get(Integer.valueOf(1));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final HashMap<Integer, Long> mo31140a() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf(0), this.f28321b);
        hashMap.put(Integer.valueOf(1), this.f28322c);
        return hashMap;
    }
}
