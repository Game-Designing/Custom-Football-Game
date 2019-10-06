package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import com.google.android.exoplayer2.util.C8514e;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.TreeSet;

/* renamed from: com.google.android.exoplayer2.upstream.cache.g */
/* compiled from: CachedContent */
final class C8471g {

    /* renamed from: a */
    public final int f18675a;

    /* renamed from: b */
    public final String f18676b;

    /* renamed from: c */
    private final TreeSet<C8480p> f18677c = new TreeSet<>();

    /* renamed from: d */
    private C8476l f18678d = C8476l.f18691a;

    /* renamed from: e */
    private boolean f18679e;

    /* renamed from: a */
    public static C8471g m20225a(int version, DataInputStream input) throws IOException {
        C8471g cachedContent = new C8471g(input.readInt(), input.readUTF());
        if (version < 2) {
            long length = input.readLong();
            C8475k mutations = new C8475k();
            C8474j.m20259a(mutations, length);
            cachedContent.mo25971a(mutations);
        } else {
            cachedContent.f18678d = C8476l.m20268a(input);
        }
        return cachedContent;
    }

    public C8471g(int id, String key) {
        this.f18675a = id;
        this.f18676b = key;
    }

    /* renamed from: a */
    public void mo25968a(DataOutputStream output) throws IOException {
        output.writeInt(this.f18675a);
        output.writeUTF(this.f18676b);
        this.f18678d.mo25997a(output);
    }

    /* renamed from: a */
    public C8473i mo25965a() {
        return this.f18678d;
    }

    /* renamed from: a */
    public boolean mo25971a(C8475k mutations) {
        C8476l oldMetadata = this.f18678d;
        this.f18678d = this.f18678d.mo25996a(mutations);
        return !this.f18678d.equals(oldMetadata);
    }

    /* renamed from: d */
    public boolean mo25975d() {
        return this.f18679e;
    }

    /* renamed from: a */
    public void mo25969a(boolean locked) {
        this.f18679e = locked;
    }

    /* renamed from: a */
    public void mo25967a(C8480p span) {
        this.f18677c.add(span);
    }

    /* renamed from: b */
    public TreeSet<C8480p> mo25973b() {
        return this.f18677c;
    }

    /* renamed from: a */
    public C8480p mo25966a(long position) {
        C8480p pVar;
        C8480p lookupSpan = C8480p.m20310a(this.f18676b, position);
        C8480p floorSpan = (C8480p) this.f18677c.floor(lookupSpan);
        if (floorSpan != null && floorSpan.f18669b + floorSpan.f18670c > position) {
            return floorSpan;
        }
        C8480p ceilSpan = (C8480p) this.f18677c.ceiling(lookupSpan);
        if (ceilSpan == null) {
            pVar = C8480p.m20313b(this.f18676b, position);
        } else {
            pVar = C8480p.m20311a(this.f18676b, position, ceilSpan.f18669b - position);
        }
        return pVar;
    }

    /* renamed from: b */
    public C8480p mo25972b(C8480p cacheSpan) throws CacheException {
        C8480p newCacheSpan = cacheSpan.mo26003a(this.f18675a);
        if (cacheSpan.f18672e.renameTo(newCacheSpan.f18672e)) {
            C8514e.m20490b(this.f18677c.remove(cacheSpan));
            this.f18677c.add(newCacheSpan);
            return newCacheSpan;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Renaming of ");
        sb.append(cacheSpan.f18672e);
        sb.append(" to ");
        sb.append(newCacheSpan.f18672e);
        sb.append(" failed.");
        throw new CacheException(sb.toString());
    }

    /* renamed from: c */
    public boolean mo25974c() {
        return this.f18677c.isEmpty();
    }

    /* renamed from: a */
    public boolean mo25970a(C8469e span) {
        if (!this.f18677c.remove(span)) {
            return false;
        }
        span.f18672e.delete();
        return true;
    }

    /* renamed from: a */
    public int mo25964a(int version) {
        int result = (this.f18675a * 31) + this.f18676b.hashCode();
        if (version >= 2) {
            return (result * 31) + this.f18678d.hashCode();
        }
        long length = C8474j.m20257a((C8473i) this.f18678d);
        return (result * 31) + ((int) ((length >>> 32) ^ length));
    }

    public int hashCode() {
        return (mo25964a((int) MoPubClientPositioning.NO_REPEAT) * 31) + this.f18677c.hashCode();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        C8471g that = (C8471g) o;
        if (this.f18675a != that.f18675a || !this.f18676b.equals(that.f18676b) || !this.f18677c.equals(that.f18677c) || !this.f18678d.equals(that.f18678d)) {
            z = false;
        }
        return z;
    }
}
