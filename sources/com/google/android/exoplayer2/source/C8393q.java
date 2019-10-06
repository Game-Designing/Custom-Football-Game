package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8096B;
import com.google.android.exoplayer2.source.C8409w.C8410a;
import com.google.android.exoplayer2.trackselection.C8432h;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.q */
/* compiled from: MediaPeriod */
public interface C8393q extends C8409w {

    /* renamed from: com.google.android.exoplayer2.source.q$a */
    /* compiled from: MediaPeriod */
    public interface C8394a extends C8410a<C8393q> {
        /* renamed from: a */
        void mo25488a(C8393q qVar);
    }

    /* renamed from: a */
    long mo25681a();

    /* renamed from: a */
    long mo25682a(long j);

    /* renamed from: a */
    long mo25683a(long j, C8096B b);

    /* renamed from: a */
    long mo25684a(C8432h[] hVarArr, boolean[] zArr, C8408v[] vVarArr, boolean[] zArr2, long j);

    /* renamed from: a */
    void mo25685a(long j, boolean z);

    /* renamed from: a */
    void mo25686a(C8394a aVar, long j);

    /* renamed from: b */
    long mo25687b();

    /* renamed from: b */
    boolean mo25689b(long j);

    /* renamed from: c */
    void mo25690c() throws IOException;

    /* renamed from: c */
    void mo25691c(long j);

    /* renamed from: d */
    TrackGroupArray mo25692d();

    /* renamed from: e */
    long mo25693e();
}
