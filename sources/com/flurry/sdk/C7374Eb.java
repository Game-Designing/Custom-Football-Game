package com.flurry.sdk;

import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.flurry.sdk.Eb */
public class C7374Eb {

    /* renamed from: a */
    private static final String f14413a = C7374Eb.class.getSimpleName();
    /* access modifiers changed from: 0000 */

    /* renamed from: b */
    public WeakReference<C7531hd> f14414b;

    /* renamed from: c */
    public volatile long f14415c = 0;

    /* renamed from: d */
    public volatile long f14416d = 0;

    /* renamed from: e */
    public volatile long f14417e = -1;

    /* renamed from: f */
    public volatile long f14418f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C7452Sb<C7537id> f14419g = new C7352Ab(this);

    /* renamed from: h */
    private volatile long f14420h = 0;

    /* renamed from: i */
    private String f14421i;

    /* renamed from: j */
    private String f14422j;

    /* renamed from: k */
    private Map<String, String> f14423k;

    public C7374Eb() {
        C7462Ub.m16528a().mo23910a("com.flurry.android.sdk.FlurrySessionEvent", this.f14419g);
        this.f14423k = new C7357Bb(this);
    }

    /* renamed from: a */
    public final synchronized void mo23807a() {
        long j = C7585qd.m16785a().f15041f;
        if (j > 0) {
            this.f14418f += System.currentTimeMillis() - j;
        }
    }

    /* renamed from: b */
    public final synchronized long mo23809b() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f14416d;
        if (elapsedRealtime <= this.f14420h) {
            elapsedRealtime = this.f14420h + 1;
            this.f14420h = elapsedRealtime;
        }
        this.f14420h = elapsedRealtime;
        return this.f14420h;
    }

    /* renamed from: c */
    public final synchronized String mo23810c() {
        return this.f14421i;
    }

    /* renamed from: d */
    public final synchronized String mo23811d() {
        return this.f14422j;
    }

    /* renamed from: a */
    public final synchronized void mo23808a(String str, String str2) {
        this.f14423k.put(str, str2);
    }

    /* renamed from: e */
    public final synchronized Map<String, String> mo23812e() {
        return this.f14423k;
    }
}
