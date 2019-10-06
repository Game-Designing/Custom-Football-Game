package com.mopub.nativeads;

import com.google.android.exoplayer2.upstream.C8487i;
import com.google.android.exoplayer2.upstream.C8487i.C8488a;
import com.google.android.exoplayer2.upstream.C8494n;
import com.google.android.exoplayer2.upstream.cache.C8465b;
import com.google.android.exoplayer2.upstream.cache.Cache;

/* renamed from: com.mopub.nativeads.wa */
/* compiled from: NativeVideoController */
class C11653wa implements C8488a {

    /* renamed from: a */
    final /* synthetic */ NativeVideoController f36254a;

    C11653wa(NativeVideoController this$0) {
        this.f36254a = this$0;
    }

    public C8487i createDataSource() {
        C8487i dataSource = new C8494n("exo_demo", null);
        Cache cache = C11541L.m38197a(this.f36254a.f35958b);
        if (cache != null) {
            return new C8465b(cache, dataSource);
        }
        return dataSource;
    }
}
