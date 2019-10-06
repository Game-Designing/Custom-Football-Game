package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzbmn implements zzo, zzbrw, zzbrx, zzue {

    /* renamed from: a */
    private final zzbmg f25548a;

    /* renamed from: b */
    private final zzbml f25549b;

    /* renamed from: c */
    private final Set<zzbgz> f25550c = new HashSet();

    /* renamed from: d */
    private final zzamd<JSONObject, JSONObject> f25551d;

    /* renamed from: e */
    private final Executor f25552e;

    /* renamed from: f */
    private final Clock f25553f;

    /* renamed from: g */
    private final AtomicBoolean f25554g = new AtomicBoolean(false);

    /* renamed from: h */
    private final zzbmp f25555h = new zzbmp();

    /* renamed from: i */
    private boolean f25556i = false;

    /* renamed from: j */
    private WeakReference<Object> f25557j = new WeakReference<>(this);

    public zzbmn(zzaly zzaly, zzbml zzbml, Executor executor, zzbmg zzbmg, Clock clock) {
        this.f25548a = zzbmg;
        zzaln<JSONObject> zzaln = zzalo.f24411b;
        this.f25551d = zzaly.mo29810a("google.afma.activeView.handleUpdate", zzaln, zzaln);
        this.f25549b = zzbml;
        this.f25552e = executor;
        this.f25553f = clock;
    }

    /* renamed from: C */
    public final synchronized void mo30740C() {
        if (!(this.f25557j.get() != null)) {
            mo30741D();
        } else if (!this.f25556i && this.f25554g.get()) {
            try {
                this.f25555h.f25561d = this.f25553f.mo27934a();
                JSONObject a = this.f25549b.mo28177a(this.f25555h);
                for (zzbgz rf : this.f25550c) {
                    this.f25552e.execute(new C9101Rf(rf, a));
                }
                zzbao.m26374b(this.f25551d.mo26658a(a), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzawz.m26002e("Failed to call ActiveViewJS", e);
            }
        }
    }

    /* renamed from: E */
    private final void m27256E() {
        for (zzbgz b : this.f25550c) {
            this.f25548a.mo30738b(b);
        }
        this.f25548a.mo30735a();
    }

    /* renamed from: D */
    public final synchronized void mo30741D() {
        m27256E();
        this.f25556i = true;
    }

    /* renamed from: a */
    public final synchronized void mo30742a(zzbgz zzbgz) {
        this.f25550c.add(zzbgz);
        this.f25548a.mo30736a(zzbgz);
    }

    /* renamed from: a */
    public final void mo30743a(Object obj) {
        this.f25557j = new WeakReference<>(obj);
    }

    /* renamed from: a */
    public final synchronized void mo28694a(zzud zzud) {
        this.f25555h.f25558a = zzud.f29465m;
        this.f25555h.f25563f = zzud;
        mo30740C();
    }

    /* renamed from: b */
    public final synchronized void mo29183b(Context context) {
        this.f25555h.f25559b = true;
        mo30740C();
    }

    /* renamed from: d */
    public final synchronized void mo29185d(Context context) {
        this.f25555h.f25559b = false;
        mo30740C();
    }

    /* renamed from: c */
    public final synchronized void mo29184c(Context context) {
        this.f25555h.f25562e = "u";
        mo30740C();
        m27256E();
        this.f25556i = true;
    }

    public final void zzsz() {
    }

    public final synchronized void onPause() {
        this.f25555h.f25559b = true;
        mo30740C();
    }

    public final synchronized void onResume() {
        this.f25555h.f25559b = false;
        mo30740C();
    }

    public final void zzta() {
    }

    public final synchronized void onAdImpression() {
        if (this.f25554g.compareAndSet(false, true)) {
            this.f25548a.mo30737a(this);
            mo30740C();
        }
    }
}
