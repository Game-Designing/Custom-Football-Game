package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.C8398s.C8399a;
import com.google.android.exoplayer2.source.C8398s.C8401b;
import com.google.android.exoplayer2.source.C8398s.C8402c;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.c */
/* compiled from: lambda */
public final /* synthetic */ class C8372c implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C8399a f18171a;

    /* renamed from: b */
    private final /* synthetic */ C8398s f18172b;

    /* renamed from: c */
    private final /* synthetic */ C8401b f18173c;

    /* renamed from: d */
    private final /* synthetic */ C8402c f18174d;

    /* renamed from: e */
    private final /* synthetic */ IOException f18175e;

    /* renamed from: f */
    private final /* synthetic */ boolean f18176f;

    public /* synthetic */ C8372c(C8399a aVar, C8398s sVar, C8401b bVar, C8402c cVar, IOException iOException, boolean z) {
        this.f18171a = aVar;
        this.f18172b = sVar;
        this.f18173c = bVar;
        this.f18174d = cVar;
        this.f18175e = iOException;
        this.f18176f = z;
    }

    public final void run() {
        this.f18171a.mo25743a(this.f18172b, this.f18173c, this.f18174d, this.f18175e, this.f18176f);
    }
}
