package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.p107h.C6021f;
import com.bumptech.glide.p107h.C6026k;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.engine.G */
/* compiled from: ResourceCacheKey */
final class C6238G implements C6344g {

    /* renamed from: a */
    private static final C6021f<Class<?>, byte[]> f11023a = new C6021f<>(50);

    /* renamed from: b */
    private final C6245b f11024b;

    /* renamed from: c */
    private final C6344g f11025c;

    /* renamed from: d */
    private final C6344g f11026d;

    /* renamed from: e */
    private final int f11027e;

    /* renamed from: f */
    private final int f11028f;

    /* renamed from: g */
    private final Class<?> f11029g;

    /* renamed from: h */
    private final C6349k f11030h;

    /* renamed from: i */
    private final C6352n<?> f11031i;

    C6238G(C6245b arrayPool, C6344g sourceKey, C6344g signature, int width, int height, C6352n<?> appliedTransformation, Class<?> decodedResourceClass, C6349k options) {
        this.f11024b = arrayPool;
        this.f11025c = sourceKey;
        this.f11026d = signature;
        this.f11027e = width;
        this.f11028f = height;
        this.f11031i = appliedTransformation;
        this.f11029g = decodedResourceClass;
        this.f11030h = options;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C6238G)) {
            return false;
        }
        C6238G other = (C6238G) o;
        if (this.f11028f == other.f11028f && this.f11027e == other.f11027e && C6026k.m11286b((Object) this.f11031i, (Object) other.f11031i) && this.f11029g.equals(other.f11029g) && this.f11025c.equals(other.f11025c) && this.f11026d.equals(other.f11026d) && this.f11030h.equals(other.f11030h)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        int result = (((((this.f11025c.hashCode() * 31) + this.f11026d.hashCode()) * 31) + this.f11027e) * 31) + this.f11028f;
        C6352n<?> nVar = this.f11031i;
        if (nVar != null) {
            result = (result * 31) + nVar.hashCode();
        }
        return (((result * 31) + this.f11029g.hashCode()) * 31) + this.f11030h.hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        byte[] dimensions = (byte[]) this.f11024b.mo19130b(8, byte[].class);
        ByteBuffer.wrap(dimensions).putInt(this.f11027e).putInt(this.f11028f).array();
        this.f11026d.updateDiskCacheKey(messageDigest);
        this.f11025c.updateDiskCacheKey(messageDigest);
        messageDigest.update(dimensions);
        C6352n<?> nVar = this.f11031i;
        if (nVar != null) {
            nVar.updateDiskCacheKey(messageDigest);
        }
        this.f11030h.updateDiskCacheKey(messageDigest);
        messageDigest.update(m11900a());
        this.f11024b.put(dimensions);
    }

    /* renamed from: a */
    private byte[] m11900a() {
        byte[] result = (byte[]) f11023a.mo18812a(this.f11029g);
        if (result != null) {
            return result;
        }
        byte[] result2 = this.f11029g.getName().getBytes(C6344g.f11318a);
        f11023a.mo18818b(this.f11029g, result2);
        return result2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResourceCacheKey{sourceKey=");
        sb.append(this.f11025c);
        sb.append(", signature=");
        sb.append(this.f11026d);
        sb.append(", width=");
        sb.append(this.f11027e);
        sb.append(", height=");
        sb.append(this.f11028f);
        sb.append(", decodedResourceClass=");
        sb.append(this.f11029g);
        sb.append(", transformation='");
        sb.append(this.f11031i);
        sb.append('\'');
        sb.append(", options=");
        sb.append(this.f11030h);
        sb.append('}');
        return sb.toString();
    }
}
