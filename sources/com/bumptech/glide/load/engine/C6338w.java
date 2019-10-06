package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.C6344g;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6352n;
import com.bumptech.glide.p107h.C6024i;
import java.security.MessageDigest;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.w */
/* compiled from: EngineKey */
class C6338w implements C6344g {

    /* renamed from: a */
    private final Object f11302a;

    /* renamed from: b */
    private final int f11303b;

    /* renamed from: c */
    private final int f11304c;

    /* renamed from: d */
    private final Class<?> f11305d;

    /* renamed from: e */
    private final Class<?> f11306e;

    /* renamed from: f */
    private final C6344g f11307f;

    /* renamed from: g */
    private final Map<Class<?>, C6352n<?>> f11308g;

    /* renamed from: h */
    private final C6349k f11309h;

    /* renamed from: i */
    private int f11310i;

    C6338w(Object model, C6344g signature, int width, int height, Map<Class<?>, C6352n<?>> transformations, Class<?> resourceClass, Class<?> transcodeClass, C6349k options) {
        C6024i.m11264a(model);
        this.f11302a = model;
        C6024i.m11265a(signature, "Signature must not be null");
        this.f11307f = signature;
        this.f11303b = width;
        this.f11304c = height;
        C6024i.m11264a(transformations);
        this.f11308g = transformations;
        C6024i.m11265a(resourceClass, "Resource class must not be null");
        this.f11305d = resourceClass;
        C6024i.m11265a(transcodeClass, "Transcode class must not be null");
        this.f11306e = transcodeClass;
        C6024i.m11264a(options);
        this.f11309h = options;
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C6338w)) {
            return false;
        }
        C6338w other = (C6338w) o;
        if (this.f11302a.equals(other.f11302a) && this.f11307f.equals(other.f11307f) && this.f11304c == other.f11304c && this.f11303b == other.f11303b && this.f11308g.equals(other.f11308g) && this.f11305d.equals(other.f11305d) && this.f11306e.equals(other.f11306e) && this.f11309h.equals(other.f11309h)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        if (this.f11310i == 0) {
            this.f11310i = this.f11302a.hashCode();
            this.f11310i = (this.f11310i * 31) + this.f11307f.hashCode();
            this.f11310i = (this.f11310i * 31) + this.f11303b;
            this.f11310i = (this.f11310i * 31) + this.f11304c;
            this.f11310i = (this.f11310i * 31) + this.f11308g.hashCode();
            this.f11310i = (this.f11310i * 31) + this.f11305d.hashCode();
            this.f11310i = (this.f11310i * 31) + this.f11306e.hashCode();
            this.f11310i = (this.f11310i * 31) + this.f11309h.hashCode();
        }
        return this.f11310i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EngineKey{model=");
        sb.append(this.f11302a);
        sb.append(", width=");
        sb.append(this.f11303b);
        sb.append(", height=");
        sb.append(this.f11304c);
        sb.append(", resourceClass=");
        sb.append(this.f11305d);
        sb.append(", transcodeClass=");
        sb.append(this.f11306e);
        sb.append(", signature=");
        sb.append(this.f11307f);
        sb.append(", hashCode=");
        sb.append(this.f11310i);
        sb.append(", transformations=");
        sb.append(this.f11308g);
        sb.append(", options=");
        sb.append(this.f11309h);
        sb.append('}');
        return sb.toString();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }
}
