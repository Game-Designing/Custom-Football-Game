package com.google.android.gms.internal.ads;

import android.os.Handler;

public final class zzma {

    /* renamed from: a */
    private final Handler f28842a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zzlz f28843b;

    public zzma(Handler handler, zzlz zzlz) {
        Handler handler2;
        if (zzlz != null) {
            zzsk.m31078a(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.f28842a = handler2;
        this.f28843b = zzlz;
    }

    /* renamed from: a */
    public final void mo31976a(zznc zznc) {
        if (this.f28843b != null) {
            this.f28842a.post(new C8841Er(this, zznc));
        }
    }

    /* renamed from: a */
    public final void mo31977a(String str, long j, long j2) {
        if (this.f28843b != null) {
            Handler handler = this.f28842a;
            C8862Fr fr = new C8862Fr(this, str, j, j2);
            handler.post(fr);
        }
    }

    /* renamed from: a */
    public final void mo31975a(zzlh zzlh) {
        if (this.f28843b != null) {
            this.f28842a.post(new C8883Gr(this, zzlh));
        }
    }

    /* renamed from: a */
    public final void mo31974a(int i, long j, long j2) {
        if (this.f28843b != null) {
            Handler handler = this.f28842a;
            C8904Hr hr = new C8904Hr(this, i, j, j2);
            handler.post(hr);
        }
    }

    /* renamed from: b */
    public final void mo31978b(zznc zznc) {
        if (this.f28843b != null) {
            this.f28842a.post(new C8925Ir(this, zznc));
        }
    }

    /* renamed from: a */
    public final void mo31973a(int i) {
        if (this.f28843b != null) {
            this.f28842a.post(new C8946Jr(this, i));
        }
    }
}
