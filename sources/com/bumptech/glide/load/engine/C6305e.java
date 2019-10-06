package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6344g;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.e */
/* compiled from: DataCacheKey */
final class C6305e implements C6344g {

    /* renamed from: a */
    private final C6344g f11167a;

    /* renamed from: b */
    private final C6344g f11168b;

    C6305e(C6344g sourceKey, C6344g signature) {
        this.f11167a = sourceKey;
        this.f11168b = signature;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C6305e)) {
            return false;
        }
        C6305e other = (C6305e) o;
        if (this.f11167a.equals(other.f11167a) && this.f11168b.equals(other.f11168b)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f11167a.hashCode() * 31) + this.f11168b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DataCacheKey{sourceKey=");
        sb.append(this.f11167a);
        sb.append(", signature=");
        sb.append(this.f11168b);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f11167a.updateDiskCacheKey(messageDigest);
        this.f11168b.updateDiskCacheKey(messageDigest);
    }
}
