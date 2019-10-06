package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public final class zzdtf {
    /* renamed from: a */
    public static <T> List<T> m30102a(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i);
    }

    /* renamed from: b */
    static <T> HashSet<T> m30103b(int i) {
        return new HashSet<>(m30105d(i));
    }

    /* renamed from: c */
    public static <K, V> LinkedHashMap<K, V> m30104c(int i) {
        return new LinkedHashMap<>(m30105d(i));
    }

    /* renamed from: d */
    private static int m30105d(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        }
        return MoPubClientPositioning.NO_REPEAT;
    }
}
