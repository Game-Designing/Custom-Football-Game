package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

public final class zzto {

    /* renamed from: a */
    private final Handler f29418a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final zztn f29419b;

    public zzto(Handler handler, zztn zztn) {
        Handler handler2;
        if (zztn != null) {
            zzsk.m31078a(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.f29418a = handler2;
        this.f29419b = zztn;
    }

    /* renamed from: a */
    public final void mo32240a(zznc zznc) {
        if (this.f29419b != null) {
            this.f29418a.post(new C9394dt(this, zznc));
        }
    }

    /* renamed from: a */
    public final void mo32241a(String str, long j, long j2) {
        if (this.f29419b != null) {
            Handler handler = this.f29418a;
            C9416et etVar = new C9416et(this, str, j, j2);
            handler.post(etVar);
        }
    }

    /* renamed from: a */
    public final void mo32239a(zzlh zzlh) {
        if (this.f29419b != null) {
            this.f29418a.post(new C9438ft(this, zzlh));
        }
    }

    /* renamed from: a */
    public final void mo32237a(int i, long j) {
        if (this.f29419b != null) {
            this.f29418a.post(new C9460gt(this, i, j));
        }
    }

    /* renamed from: a */
    public final void mo32236a(int i, int i2, int i3, float f) {
        if (this.f29419b != null) {
            Handler handler = this.f29418a;
            C9482ht htVar = new C9482ht(this, i, i2, i3, f);
            handler.post(htVar);
        }
    }

    /* renamed from: a */
    public final void mo32238a(Surface surface) {
        if (this.f29419b != null) {
            this.f29418a.post(new C9504it(this, surface));
        }
    }

    /* renamed from: b */
    public final void mo32242b(zznc zznc) {
        if (this.f29419b != null) {
            this.f29418a.post(new C9526jt(this, zznc));
        }
    }
}
