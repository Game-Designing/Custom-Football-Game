package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

public final class zzjy extends zzjx {

    /* renamed from: b */
    private final int f28728b;

    /* renamed from: c */
    private final Map<String, List<String>> f28729c;

    public zzjy(int i, Map<String, List<String>> map, zzjq zzjq) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), zzjq);
        this.f28728b = i;
        this.f28729c = map;
    }
}
