package com.inmobi.ads;

/* renamed from: com.inmobi.ads.bm */
/* compiled from: RawAsset */
public final class C10461bm {

    /* renamed from: a */
    public final int f31823a;

    /* renamed from: b */
    public final String f31824b;

    public C10461bm(int i, String str) {
        this.f31823a = i;
        this.f31824b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10461bm)) {
            return false;
        }
        C10461bm bmVar = (C10461bm) obj;
        if (this.f31823a != bmVar.f31823a || !this.f31824b.equals(bmVar.f31824b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f31823a * 31) + this.f31824b.hashCode();
    }
}
