package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.C8128l.C8129a;

/* renamed from: com.google.android.exoplayer2.audio.b */
/* compiled from: lambda */
public final /* synthetic */ class C8116b implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C8129a f16642a;

    /* renamed from: b */
    private final /* synthetic */ String f16643b;

    /* renamed from: c */
    private final /* synthetic */ long f16644c;

    /* renamed from: d */
    private final /* synthetic */ long f16645d;

    public /* synthetic */ C8116b(C8129a aVar, String str, long j, long j2) {
        this.f16642a = aVar;
        this.f16643b = str;
        this.f16644c = j;
        this.f16645d = j2;
    }

    public final void run() {
        this.f16642a.mo25109b(this.f16643b, this.f16644c, this.f16645d);
    }
}
