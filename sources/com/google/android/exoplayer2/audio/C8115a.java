package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.C8128l.C8129a;

/* renamed from: com.google.android.exoplayer2.audio.a */
/* compiled from: lambda */
public final /* synthetic */ class C8115a implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C8129a f16640a;

    /* renamed from: b */
    private final /* synthetic */ Format f16641b;

    public /* synthetic */ C8115a(C8129a aVar, Format format) {
        this.f16640a = aVar;
        this.f16641b = format;
    }

    public final void run() {
        this.f16640a.mo25107b(this.f16641b);
    }
}
