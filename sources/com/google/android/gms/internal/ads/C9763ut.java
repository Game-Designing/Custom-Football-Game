package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(14)
/* renamed from: com.google.android.gms.internal.ads.ut */
final class C9763ut implements ActivityLifecycleCallbacks {

    /* renamed from: a */
    private Activity f23242a;

    /* renamed from: b */
    private Context f23243b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f23244c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f23245d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f23246e = false;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final List<zzut> f23247f = new ArrayList();

    /* renamed from: g */
    private final List<zzvg> f23248g = new ArrayList();

    /* renamed from: h */
    private Runnable f23249h;

    /* renamed from: i */
    private boolean f23250i = false;

    /* renamed from: j */
    private long f23251j;

    C9763ut() {
    }

    /* renamed from: a */
    public final void mo29218a(Application application, Context context) {
        if (!this.f23250i) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                m24161a((Activity) context);
            }
            this.f23243b = application;
            this.f23251j = ((Long) zzyt.m31536e().mo29599a(zzacu.f24078db)).longValue();
            this.f23250i = true;
        }
    }

    /* renamed from: a */
    public final void mo29219a(zzut zzut) {
        synchronized (this.f23244c) {
            this.f23247f.add(zzut);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    /* renamed from: a */
    public final Activity mo29217a() {
        return this.f23242a;
    }

    /* renamed from: b */
    public final Context mo29220b() {
        return this.f23243b;
    }

    public final void onActivityStarted(Activity activity) {
        m24161a(activity);
    }

    public final void onActivityResumed(Activity activity) {
        m24161a(activity);
        this.f23246e = false;
        boolean z = !this.f23245d;
        this.f23245d = true;
        Runnable runnable = this.f23249h;
        if (runnable != null) {
            zzaxi.f24961a.removeCallbacks(runnable);
        }
        synchronized (this.f23244c) {
            for (zzvg onActivityResumed : this.f23248g) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzk.zzlk().mo30168a((Throwable) e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbad.m26356b("", e);
                }
            }
            if (z) {
                for (zzut a : this.f23247f) {
                    try {
                        a.mo28176a(true);
                    } catch (Exception e2) {
                        zzbad.m26356b("", e2);
                    }
                }
            } else {
                zzbad.m26352a("App is still foreground.");
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        m24161a(activity);
        synchronized (this.f23244c) {
            for (zzvg onActivityPaused : this.f23248g) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzk.zzlk().mo30168a((Throwable) e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbad.m26356b("", e);
                }
            }
        }
        this.f23246e = true;
        Runnable runnable = this.f23249h;
        if (runnable != null) {
            zzaxi.f24961a.removeCallbacks(runnable);
        }
        Handler handler = zzaxi.f24961a;
        C9784vt vtVar = new C9784vt(this);
        this.f23249h = vtVar;
        handler.postDelayed(vtVar, this.f23251j);
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f23244c) {
            if (this.f23242a != null) {
                if (this.f23242a.equals(activity)) {
                    this.f23242a = null;
                }
                Iterator it = this.f23248g.iterator();
                while (it.hasNext()) {
                    try {
                        if (((zzvg) it.next()).mo32307a(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzk.zzlk().mo30168a((Throwable) e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbad.m26356b("", e);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m24161a(Activity activity) {
        synchronized (this.f23244c) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f23242a = activity;
            }
        }
    }
}
