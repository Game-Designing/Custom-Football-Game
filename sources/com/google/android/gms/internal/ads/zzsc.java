package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

public final class zzsc extends zzsb {

    /* renamed from: c */
    private final int f29303c;

    /* renamed from: d */
    private final Map<String, List<String>> f29304d;

    public zzsc(int i, Map<String, List<String>> map, zzry zzry) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), zzry, 1);
        this.f29303c = i;
        this.f29304d = map;
    }
}
