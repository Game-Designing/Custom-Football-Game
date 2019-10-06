package com.smaato.soma.p239c.p242c;

import android.os.Handler;
import android.os.Looper;
import com.smaato.soma.interstitial.C12424n;

/* renamed from: com.smaato.soma.c.c.i */
/* compiled from: InterstitialAdDispatcher */
public class C12196i {

    /* renamed from: a */
    protected final Handler f38223a = new Handler(Looper.getMainLooper());

    /* renamed from: b */
    protected C12424n f38224b;

    /* renamed from: a */
    public void mo39481a(C12424n listener) {
        this.f38224b = listener;
    }

    /* renamed from: g */
    public C12424n mo39487g() {
        return this.f38224b;
    }

    /* renamed from: b */
    public void mo39482b() {
        this.f38223a.post(new C12190c(this));
    }

    /* renamed from: f */
    public void mo39486f() {
        this.f38223a.post(new C12191d(this));
    }

    /* renamed from: e */
    public void mo39485e() {
        this.f38223a.post(new C12192e(this));
    }

    /* renamed from: c */
    public void mo39483c() {
        this.f38223a.post(new C12193f(this));
    }

    /* renamed from: a */
    public void mo39480a() {
        this.f38223a.post(new C12194g(this));
    }

    /* renamed from: d */
    public void mo39484d() {
        this.f38223a.post(new C12195h(this));
    }
}
