package com.google.android.exoplayer2.p182a;

import android.support.p001v7.widget.LinearLayoutManager;

/* renamed from: com.google.android.exoplayer2.a.a */
/* compiled from: Buffer */
public abstract class C8102a {

    /* renamed from: a */
    private int f16532a;

    /* renamed from: a */
    public void mo25020a() {
        this.f16532a = 0;
    }

    /* renamed from: b */
    public final boolean mo25022b() {
        return mo25023b(LinearLayoutManager.INVALID_OFFSET);
    }

    /* renamed from: c */
    public final boolean mo25025c() {
        return mo25023b(4);
    }

    /* renamed from: d */
    public final boolean mo25026d() {
        return mo25023b(1);
    }

    /* renamed from: c */
    public final void mo25024c(int flags) {
        this.f16532a = flags;
    }

    /* renamed from: a */
    public final void mo25021a(int flag) {
        this.f16532a |= flag;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo25023b(int flag) {
        return (this.f16532a & flag) == flag;
    }
}
