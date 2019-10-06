package com.inmobi.rendering.p226a;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.inmobi.rendering.a.a */
/* compiled from: Click */
public final class C10736a {

    /* renamed from: a */
    int f32791a;

    /* renamed from: b */
    public String f32792b;

    /* renamed from: c */
    public Map<String, String> f32793c;

    /* renamed from: d */
    long f32794d;

    /* renamed from: e */
    long f32795e;

    /* renamed from: f */
    int f32796f;

    /* renamed from: g */
    AtomicBoolean f32797g;

    /* renamed from: h */
    boolean f32798h;

    /* renamed from: i */
    boolean f32799i;

    C10736a(String str, boolean z, boolean z2, int i) {
        this(new Random().nextInt() & MoPubClientPositioning.NO_REPEAT, str, new HashMap(), z, z2, i, System.currentTimeMillis(), System.currentTimeMillis());
    }

    C10736a(String str, Map<String, String> map, boolean z, int i) {
        this(new Random().nextInt() & MoPubClientPositioning.NO_REPEAT, str, map, z, false, i, System.currentTimeMillis(), System.currentTimeMillis());
    }

    C10736a(int i, String str, Map<String, String> map, boolean z, boolean z2, int i2, long j, long j2) {
        this.f32791a = i;
        this.f32792b = str;
        this.f32793c = map;
        this.f32794d = j;
        this.f32795e = j2;
        this.f32796f = i2;
        this.f32797g = new AtomicBoolean(false);
        this.f32799i = z;
        this.f32798h = z2;
    }

    /* renamed from: a */
    public final boolean mo34651a(long j) {
        return System.currentTimeMillis() - this.f32795e > j * 1000;
    }
}
