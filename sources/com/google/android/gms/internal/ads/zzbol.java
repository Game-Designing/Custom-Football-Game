package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzbol extends zzbnf {

    /* renamed from: f */
    private final zzaga f25667f;

    /* renamed from: g */
    private final Runnable f25668g;

    /* renamed from: h */
    private final Executor f25669h;

    public zzbol(zzaga zzaga, Runnable runnable, Executor executor) {
        this.f25667f = zzaga;
        this.f25668g = runnable;
        this.f25669h = executor;
    }

    /* renamed from: c */
    public final void mo28633c() {
        this.f25669h.execute(new C9293_f(this, new C9273Zf(new AtomicReference(this.f25668g))));
    }

    /* renamed from: g */
    public final View mo28635g() {
        return null;
    }

    /* renamed from: a */
    public final void mo28632a(ViewGroup viewGroup, zzyd zzyd) {
    }

    /* renamed from: f */
    public final zzaar mo28634f() {
        return null;
    }

    /* renamed from: h */
    public final zzcxn mo28636h() {
        return null;
    }

    /* renamed from: i */
    public final int mo28637i() {
        return 0;
    }

    /* renamed from: j */
    public final void mo28638j() {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30754a(Runnable runnable) {
        try {
            if (!this.f25667f.mo29706i(ObjectWrapper.m22188a(runnable))) {
                runnable.run();
            }
        } catch (RemoteException e) {
            runnable.run();
        }
    }
}
