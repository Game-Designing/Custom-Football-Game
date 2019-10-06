package com.inmobi.ads.cache;

import com.inmobi.ads.C10461bm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.inmobi.ads.cache.b */
/* compiled from: AdAssetBatch */
public final class C10515b {

    /* renamed from: a */
    public List<C10513a> f32065a = new ArrayList();

    /* renamed from: b */
    Set<C10461bm> f32066b;

    /* renamed from: c */
    Set<String> f32067c = new HashSet();

    /* renamed from: d */
    int f32068d;

    /* renamed from: e */
    int f32069e;

    /* renamed from: f */
    public String f32070f;

    /* renamed from: g */
    public String f32071g;

    /* renamed from: h */
    public String f32072h;

    /* renamed from: i */
    private String f32073i;

    /* renamed from: j */
    private final WeakReference<C10519f> f32074j;

    public C10515b(String str, String str2, Set<C10461bm> set, C10519f fVar) {
        this.f32073i = str;
        this.f32070f = str2;
        this.f32066b = set;
        this.f32074j = new WeakReference<>(fVar);
    }

    public C10515b(String str, Set<C10461bm> set, C10519f fVar, String str2) {
        this.f32073i = str;
        this.f32072h = str2;
        this.f32066b = set;
        this.f32074j = new WeakReference<>(fVar);
    }

    /* renamed from: a */
    public final C10519f mo34241a() {
        return (C10519f) this.f32074j.get();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AdAssetBatch{mRawAssets=");
        sb.append(this.f32066b);
        sb.append(", mBatchDownloadSuccessCount=");
        sb.append(this.f32068d);
        sb.append(", mBatchDownloadFailureCount=");
        sb.append(this.f32069e);
        sb.append('}');
        return sb.toString();
    }
}
