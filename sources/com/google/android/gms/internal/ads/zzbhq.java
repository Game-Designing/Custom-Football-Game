package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzbhq extends zzaas {

    /* renamed from: b */
    private final zzbdf f25357b;

    /* renamed from: c */
    private final Object f25358c = new Object();

    /* renamed from: d */
    private final boolean f25359d;

    /* renamed from: e */
    private final boolean f25360e;

    /* renamed from: f */
    private int f25361f;

    /* renamed from: g */
    private zzaau f25362g;

    /* renamed from: h */
    private boolean f25363h;

    /* renamed from: i */
    private boolean f25364i = true;

    /* renamed from: j */
    private float f25365j;

    /* renamed from: k */
    private float f25366k;

    /* renamed from: l */
    private float f25367l;

    /* renamed from: m */
    private boolean f25368m;

    /* renamed from: n */
    private boolean f25369n;

    public zzbhq(zzbdf zzbdf, float f, boolean z, boolean z2) {
        this.f25357b = zzbdf;
        this.f25365j = f;
        this.f25359d = z;
        this.f25360e = z2;
    }

    public final void play() {
        m26946a("play", null);
    }

    public final void pause() {
        m26946a("pause", null);
    }

    /* renamed from: h */
    public final void mo29368h(boolean z) {
        m26946a(z ? "mute" : "unmute", null);
    }

    /* renamed from: b */
    public final void mo30631b(zzacd zzacd) {
        boolean z = zzacd.f23878a;
        boolean z2 = zzacd.f23879b;
        boolean z3 = zzacd.f23880c;
        synchronized (this.f25358c) {
            this.f25368m = z2;
            this.f25369n = z3;
        }
        m26946a("initialState", CollectionUtils.m22079a("muteStart", z ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID, "customControlsRequested", z2 ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID, "clickToExpandRequested", z3 ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID));
    }

    /* renamed from: a */
    private final void m26946a(String str, Map<String, String> map) {
        HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbm.f25064a.execute(new C9336bf(this, hashMap));
    }

    /* renamed from: Da */
    public final boolean mo29363Da() {
        boolean z;
        synchronized (this.f25358c) {
            z = this.f25364i;
        }
        return z;
    }

    /* renamed from: i */
    public final int mo29369i() {
        int i;
        synchronized (this.f25358c) {
            i = this.f25361f;
        }
        return i;
    }

    /* renamed from: K */
    public final float mo29364K() {
        float f;
        synchronized (this.f25358c) {
            f = this.f25367l;
        }
        return f;
    }

    /* renamed from: ya */
    public final float mo29374ya() {
        float f;
        synchronized (this.f25358c) {
            f = this.f25365j;
        }
        return f;
    }

    /* renamed from: ra */
    public final float mo29373ra() {
        float f;
        synchronized (this.f25358c) {
            f = this.f25366k;
        }
        return f;
    }

    /* renamed from: a */
    public final void mo29367a(zzaau zzaau) {
        synchronized (this.f25358c) {
            this.f25362g = zzaau;
        }
    }

    /* renamed from: ma */
    public final zzaau mo29370ma() throws RemoteException {
        zzaau zzaau;
        synchronized (this.f25358c) {
            zzaau = this.f25362g;
        }
        return zzaau;
    }

    /* renamed from: Xa */
    public final boolean mo29366Xa() {
        boolean z;
        synchronized (this.f25358c) {
            z = this.f25359d && this.f25368m;
        }
        return z;
    }

    /* renamed from: O */
    public final boolean mo29365O() {
        boolean z;
        boolean Xa = mo29366Xa();
        synchronized (this.f25358c) {
            if (!Xa) {
                try {
                    if (this.f25369n && this.f25360e) {
                        z = true;
                    }
                } finally {
                }
            }
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    public final void mo30630b(float f) {
        synchronized (this.f25358c) {
            this.f25366k = f;
        }
    }

    /* renamed from: ib */
    public final void mo30633ib() {
        boolean z;
        int i;
        synchronized (this.f25358c) {
            z = this.f25364i;
            i = this.f25361f;
            this.f25361f = 3;
        }
        m26947b(i, 3, z, z);
    }

    /* renamed from: a */
    public final void mo30628a(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.f25358c) {
            this.f25365j = f2;
            this.f25366k = f;
            z2 = this.f25364i;
            this.f25364i = z;
            i2 = this.f25361f;
            this.f25361f = i;
            float f4 = this.f25367l;
            this.f25367l = f3;
            if (Math.abs(this.f25367l - f4) > 1.0E-4f) {
                this.f25357b.getView().invalidate();
            }
        }
        m26947b(i2, i, z2, z);
    }

    /* renamed from: b */
    private final void m26947b(int i, int i2, boolean z, boolean z2) {
        Executor executor = zzbbm.f25064a;
        C9358cf cfVar = new C9358cf(this, i, i2, z, z2);
        executor.execute(cfVar);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo30629a(int i, int i2, boolean z, boolean z2) {
        synchronized (this.f25358c) {
            boolean z3 = false;
            boolean z4 = i != i2;
            boolean z5 = !this.f25363h && i2 == 1;
            boolean z6 = z4 && i2 == 1;
            boolean z7 = z4 && i2 == 2;
            boolean z8 = z4 && i2 == 3;
            boolean z9 = z != z2;
            if (this.f25363h || z5) {
                z3 = true;
            }
            this.f25363h = z3;
            if (z5) {
                try {
                    if (this.f25362g != null) {
                        this.f25362g.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
            if (z6 && this.f25362g != null) {
                this.f25362g.onVideoPlay();
            }
            if (z7 && this.f25362g != null) {
                this.f25362g.onVideoPause();
            }
            if (z8) {
                if (this.f25362g != null) {
                    this.f25362g.mo29375M();
                }
                this.f25357b.mo28707C();
            }
            if (z9 && this.f25362g != null) {
                this.f25362g.mo29376k(z2);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ void mo30632b(Map map) {
        this.f25357b.mo28729a("pubVideoCmd", map);
    }
}
