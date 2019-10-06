package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.C8489j;

/* renamed from: com.google.android.exoplayer2.upstream.cache.f */
/* compiled from: CacheUtil */
public final class C8470f {

    /* renamed from: a */
    public static final C8468d f18674a = C8464a.f18644a;

    /* renamed from: a */
    public static String m20223a(Uri uri) {
        return uri.toString();
    }

    /* renamed from: a */
    public static String m20224a(C8489j dataSpec) {
        String str = dataSpec.f18721h;
        return str != null ? str : m20223a(dataSpec.f18714a);
    }
}
