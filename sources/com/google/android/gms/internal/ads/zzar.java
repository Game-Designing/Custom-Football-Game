package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzar {

    /* renamed from: a */
    private final int f24595a;

    /* renamed from: b */
    private final List<zzl> f24596b;

    /* renamed from: c */
    private final int f24597c;

    /* renamed from: d */
    private final InputStream f24598d;

    public zzar(int i, List<zzl> list) {
        this(i, list, -1, null);
    }

    public zzar(int i, List<zzl> list, int i2, InputStream inputStream) {
        this.f24595a = i;
        this.f24596b = list;
        this.f24597c = i2;
        this.f24598d = inputStream;
    }

    /* renamed from: c */
    public final int mo30010c() {
        return this.f24595a;
    }

    /* renamed from: d */
    public final List<zzl> mo30011d() {
        return Collections.unmodifiableList(this.f24596b);
    }

    /* renamed from: b */
    public final int mo30009b() {
        return this.f24597c;
    }

    /* renamed from: a */
    public final InputStream mo30008a() {
        return this.f24598d;
    }
}
