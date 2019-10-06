package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzalr {
    @VisibleForTesting

    /* renamed from: a */
    private static final zzayp<zzajw> f24413a = new C8845Fa();
    @VisibleForTesting

    /* renamed from: b */
    private static final zzayp<zzajw> f24414b = new C8866Ga();

    /* renamed from: c */
    private final zzakh f24415c;

    public zzalr(Context context, zzbai zzbai, String str) {
        zzakh zzakh = new zzakh(context, zzbai, str, f24413a, f24414b);
        this.f24415c = zzakh;
    }

    /* renamed from: a */
    public final <I, O> zzalj<I, O> mo29808a(String str, zzalm<I> zzalm, zzall<O> zzall) {
        return new zzalu(this.f24415c, str, zzalm, zzall);
    }

    /* renamed from: a */
    public final zzaly mo29809a() {
        return new zzaly(this.f24415c);
    }
}
