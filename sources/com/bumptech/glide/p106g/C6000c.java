package com.bumptech.glide.p106g;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.p107h.C6024i;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.g.c */
/* compiled from: ObjectKey */
public final class C6000c implements C6344g {

    /* renamed from: a */
    private final Object f10632a;

    public C6000c(Object object) {
        C6024i.m11264a(object);
        this.f10632a = object;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ObjectKey{object=");
        sb.append(this.f10632a);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6000c)) {
            return false;
        }
        return this.f10632a.equals(((C6000c) o).f10632a);
    }

    public int hashCode() {
        return this.f10632a.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f10632a.toString().getBytes(C6344g.f11318a));
    }
}
