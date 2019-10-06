package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcrz implements zzcva<Object> {

    /* renamed from: a */
    private final String f27303a;

    /* renamed from: b */
    private final String f27304b;

    /* renamed from: c */
    private final zzbqe f27305c;

    /* renamed from: d */
    private final zzcyi f27306d;

    /* renamed from: e */
    private final zzcxv f27307e;

    public zzcrz(String str, String str2, zzbqe zzbqe, zzcyi zzcyi, zzcxv zzcxv) {
        this.f27303a = str;
        this.f27304b = str2;
        this.f27305c = zzbqe;
        this.f27306d = zzcyi;
        this.f27307e = zzcxv;
    }

    /* renamed from: a */
    public final zzbbh<Object> mo28586a() {
        return zzbar.m26376a(new C9606nl(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31253a(Bundle bundle) {
        this.f27305c.mo30865a(this.f27307e.f27600d);
        bundle.putBundle("quality_signals", this.f27306d.mo31307a());
        bundle.putString("seq_num", this.f27303a);
        bundle.putString("session_id", this.f27304b);
    }
}
