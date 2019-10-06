package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.C8128l.C8129a;

/* renamed from: com.google.android.exoplayer2.audio.f */
/* compiled from: lambda */
public final /* synthetic */ class C8120f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C8129a f16652a;

    /* renamed from: b */
    private final /* synthetic */ int f16653b;

    /* renamed from: c */
    private final /* synthetic */ long f16654c;

    /* renamed from: d */
    private final /* synthetic */ long f16655d;

    public /* synthetic */ C8120f(C8129a aVar, int i, long j, long j2) {
        this.f16652a = aVar;
        this.f16653b = i;
        this.f16654c = j;
        this.f16655d = j2;
    }

    public final void run() {
        this.f16652a.mo25106b(this.f16653b, this.f16654c, this.f16655d);
    }
}
