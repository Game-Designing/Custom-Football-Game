package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

public class zzdss extends zzdsu implements zzbd {

    /* renamed from: j */
    private zzbe f28266j;

    /* renamed from: k */
    private String f28267k;

    /* renamed from: l */
    private boolean f28268l;

    /* renamed from: m */
    private long f28269m;

    public zzdss(String str) {
        this.f28267k = str;
    }

    /* renamed from: a */
    public final void mo30419a(zzbe zzbe) {
        this.f28266j = zzbe;
    }

    public final String getType() {
        return this.f28267k;
    }

    /* renamed from: a */
    public final void mo30420a(zzdsw zzdsw, ByteBuffer byteBuffer, long j, zzba zzba) throws IOException {
        this.f28269m = zzdsw.position() - ((long) byteBuffer.remaining());
        this.f28268l = byteBuffer.remaining() == 16;
        mo31684a(zzdsw, j, zzba);
    }

    /* renamed from: a */
    public final void mo31684a(zzdsw zzdsw, long j, zzba zzba) throws IOException {
        this.f28275d = zzdsw;
        this.f28277f = zzdsw.position();
        this.f28278g = this.f28277f - ((long) ((this.f28268l || 8 + j >= 4294967296L) ? 16 : 8));
        zzdsw.mo29175g(zzdsw.position() + j);
        this.f28279h = zzdsw.position();
        this.f28274c = zzba;
    }
}
