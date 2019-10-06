package com.bumptech.glide.load.p109a.p110a;

import android.net.Uri;
import com.vungle.warren.model.Advertisement;

/* renamed from: com.bumptech.glide.load.a.a.b */
/* compiled from: MediaStoreUtil */
public final class C6034b {
    /* renamed from: b */
    public static boolean m11319b(Uri uri) {
        if (uri != null) {
            if ("content".equals(uri.getScheme())) {
                if ("media".equals(uri.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m11321d(Uri uri) {
        return uri.getPathSegments().contains(Advertisement.KEY_VIDEO);
    }

    /* renamed from: c */
    public static boolean m11320c(Uri uri) {
        return m11319b(uri) && m11321d(uri);
    }

    /* renamed from: a */
    public static boolean m11318a(Uri uri) {
        return m11319b(uri) && !m11321d(uri);
    }

    /* renamed from: a */
    public static boolean m11317a(int width, int height) {
        return width != Integer.MIN_VALUE && height != Integer.MIN_VALUE && width <= 512 && height <= 384;
    }
}
