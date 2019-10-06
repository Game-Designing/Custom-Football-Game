package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;

/* renamed from: com.google.android.exoplayer2.upstream.cache.j */
/* compiled from: ContentMetadataInternal */
final class C8474j {
    /* renamed from: a */
    public static long m20257a(C8473i contentMetadata) {
        return contentMetadata.mo25989a("exo_len", -1);
    }

    /* renamed from: a */
    public static void m20259a(C8475k mutations, long length) {
        mutations.mo25992a("exo_len", length);
    }

    /* renamed from: b */
    public static Uri m20261b(C8473i contentMetadata) {
        String redirectedUri = contentMetadata.mo25990a("exo_redir", (String) null);
        if (redirectedUri == null) {
            return null;
        }
        return Uri.parse(redirectedUri);
    }

    /* renamed from: a */
    public static void m20260a(C8475k mutations, Uri uri) {
        mutations.mo25993a("exo_redir", uri.toString());
    }

    /* renamed from: a */
    public static void m20258a(C8475k mutations) {
        mutations.mo25991a("exo_redir");
    }
}
