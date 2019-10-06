package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache.CacheException;
import java.util.Comparator;
import java.util.TreeSet;

/* renamed from: com.google.android.exoplayer2.upstream.cache.m */
/* compiled from: LeastRecentlyUsedCacheEvictor */
public final class C8477m implements C8467c, Comparator<C8469e> {

    /* renamed from: a */
    private final long f18694a;

    /* renamed from: b */
    private final TreeSet<C8469e> f18695b = new TreeSet<>(this);

    /* renamed from: c */
    private long f18696c;

    public C8477m(long maxBytes) {
        this.f18694a = maxBytes;
    }

    /* renamed from: a */
    public void mo25958a() {
    }

    /* renamed from: a */
    public void mo25959a(Cache cache, String key, long position, long maxLength) {
        m20278a(cache, maxLength);
    }

    /* renamed from: a */
    public void mo25947a(Cache cache, C8469e span) {
        this.f18695b.add(span);
        this.f18696c += span.f18670c;
        m20278a(cache, 0);
    }

    /* renamed from: b */
    public void mo25949b(Cache cache, C8469e span) {
        this.f18695b.remove(span);
        this.f18696c -= span.f18670c;
    }

    /* renamed from: a */
    public void mo25948a(Cache cache, C8469e oldSpan, C8469e newSpan) {
        mo25949b(cache, oldSpan);
        mo25947a(cache, newSpan);
    }

    /* renamed from: a */
    public int compare(C8469e lhs, C8469e rhs) {
        long j = lhs.f18673f;
        long j2 = rhs.f18673f;
        if (j - j2 == 0) {
            return lhs.compareTo(rhs);
        }
        return j < j2 ? -1 : 1;
    }

    /* renamed from: a */
    private void m20278a(Cache cache, long requiredSpace) {
        while (this.f18696c + requiredSpace > this.f18694a && !this.f18695b.isEmpty()) {
            try {
                cache.mo25945b((C8469e) this.f18695b.first());
            } catch (CacheException e) {
            }
        }
    }
}
