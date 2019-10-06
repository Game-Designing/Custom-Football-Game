package p019d.p143b.p144a.p147c;

/* renamed from: d.b.a.c.k */
final class C7174k {

    /* renamed from: a */
    private long f13601a;

    /* renamed from: b */
    private long f13602b;

    /* renamed from: c */
    private long f13603c;

    /* renamed from: d */
    private long f13604d;

    C7174k() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public long mo23182a() {
        return this.f13601a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23183a(long j) {
        this.f13601a += j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public long mo23184b() {
        return this.f13602b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo23185b(long j) {
        this.f13602b += j;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo23186c() {
        this.f13603c++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo23187d() {
        this.f13604d++;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public long mo23188e() {
        return this.f13603c;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public long mo23189f() {
        return this.f13604d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CacheStatsTracker{totalDownloadedBytes=");
        sb.append(this.f13601a);
        sb.append(", totalCachedBytes=");
        sb.append(this.f13602b);
        sb.append(", htmlResourceCacheSuccessCount=");
        sb.append(this.f13603c);
        sb.append(", htmlResourceCacheFailureCount=");
        sb.append(this.f13604d);
        sb.append('}');
        return sb.toString();
    }
}
