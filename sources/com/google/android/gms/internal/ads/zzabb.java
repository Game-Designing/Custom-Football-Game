package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

@zzard
public final class zzabb {

    /* renamed from: a */
    private final zzamo f23833a;

    /* renamed from: b */
    private final zzyc f23834b;

    /* renamed from: c */
    private final AtomicBoolean f23835c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final VideoController f23836d;
    @VisibleForTesting

    /* renamed from: e */
    private final zzyv f23837e;

    /* renamed from: f */
    private zzxr f23838f;

    /* renamed from: g */
    private AdListener f23839g;

    /* renamed from: h */
    private AdSize[] f23840h;

    /* renamed from: i */
    private AppEventListener f23841i;

    /* renamed from: j */
    private Correlator f23842j;

    /* renamed from: k */
    private zzzk f23843k;

    /* renamed from: l */
    private OnCustomRenderedAdLoadedListener f23844l;

    /* renamed from: m */
    private VideoOptions f23845m;

    /* renamed from: n */
    private String f23846n;

    /* renamed from: o */
    private ViewGroup f23847o;

    /* renamed from: p */
    private int f23848p;

    /* renamed from: q */
    private boolean f23849q;

    public zzabb(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzyc.f29767a, 0);
    }

    public zzabb(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzyc.f29767a, i);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzyc.f29767a, 0);
    }

    public zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzyc.f29767a, i);
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzyc, zzzk zzzk, int i) {
        this.f23833a = new zzamo();
        this.f23836d = new VideoController();
        this.f23837e = new C9308a(this);
        this.f23847o = viewGroup;
        this.f23834b = zzyc;
        this.f23843k = null;
        this.f23835c = new AtomicBoolean(false);
        this.f23848p = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzyg zzyg = new zzyg(context, attributeSet);
                this.f23840h = zzyg.mo32386a(z);
                this.f23846n = zzyg.mo32385a();
                if (viewGroup.isInEditMode()) {
                    zzazt a = zzyt.m31532a();
                    AdSize adSize = this.f23840h[0];
                    int i2 = this.f23848p;
                    zzyd zzyd = new zzyd(context, adSize);
                    zzyd.f29777j = m24603a(i2);
                    a.mo30313a(viewGroup, zzyd, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzyt.m31532a().mo30314a(viewGroup, new zzyd(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzabb(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzyc zzyc, int i) {
        this(viewGroup, attributeSet, z, zzyc, null, i);
    }

    /* renamed from: a */
    public final void mo29426a() {
        try {
            if (this.f23843k != null) {
                this.f23843k.destroy();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    public final AdListener mo29438b() {
        return this.f23839g;
    }

    /* renamed from: c */
    public final AdSize mo29440c() {
        try {
            if (this.f23843k != null) {
                zzyd Za = this.f23843k.mo29508Za();
                if (Za != null) {
                    return zzb.zza(Za.f29772e, Za.f29769b, Za.f29768a);
                }
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.f23840h;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    /* renamed from: d */
    public final AdSize[] mo29441d() {
        return this.f23840h;
    }

    /* renamed from: e */
    public final String mo29442e() {
        if (this.f23846n == null) {
            zzzk zzzk = this.f23843k;
            if (zzzk != null) {
                try {
                    this.f23846n = zzzk.mo29522cb();
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
        return this.f23846n;
    }

    /* renamed from: f */
    public final AppEventListener mo29443f() {
        return this.f23841i;
    }

    /* renamed from: h */
    public final OnCustomRenderedAdLoadedListener mo29445h() {
        return this.f23844l;
    }

    /* renamed from: a */
    public final void mo29432a(zzaaz zzaaz) {
        zzzk zzzk;
        String str = "#007 Could not call remote method.";
        try {
            if (this.f23843k == null) {
                if ((this.f23840h == null || this.f23846n == null) && this.f23843k == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.f23847o.getContext();
                zzyd a = m24602a(context, this.f23840h, this.f23848p);
                if ("search_v2".equals(a.f29768a)) {
                    zzzk = (zzzk) new C9461gu(zzyt.m31533b(), context, a, this.f23846n).mo29114a(context, false);
                } else {
                    C9417eu euVar = new C9417eu(zzyt.m31533b(), context, a, this.f23846n, this.f23833a);
                    zzzk = (zzzk) euVar.mo29114a(context, false);
                }
                this.f23843k = zzzk;
                this.f23843k.mo29517a((zzyz) new zzxv(this.f23837e));
                if (this.f23838f != null) {
                    this.f23843k.mo29516a((zzyw) new zzxs(this.f23838f));
                }
                if (this.f23841i != null) {
                    this.f23843k.mo29519a((zzzs) new zzyf(this.f23841i));
                }
                if (this.f23844l != null) {
                    this.f23843k.mo29511a((zzado) new zzadr(this.f23844l));
                }
                if (this.f23842j != null) {
                    this.f23843k.mo29520a((zzzy) this.f23842j.zzdf());
                }
                if (this.f23845m != null) {
                    this.f23843k.mo29510a(new zzacd(this.f23845m));
                }
                this.f23843k.mo29530m(this.f23849q);
                try {
                    IObjectWrapper Aa = this.f23843k.mo29502Aa();
                    if (Aa != null) {
                        this.f23847o.addView((View) ObjectWrapper.m22187H(Aa));
                    }
                } catch (RemoteException e) {
                    zzbad.m26360d(str, e);
                }
            }
            if (this.f23843k.mo29521b(zzyc.m31508a(this.f23847o.getContext(), zzaaz))) {
                this.f23833a.mo29833b(zzaaz.mo29399m());
            }
        } catch (RemoteException e2) {
            zzbad.m26360d(str, e2);
        }
    }

    /* renamed from: l */
    public final void mo29449l() {
        try {
            if (this.f23843k != null) {
                this.f23843k.pause();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: m */
    public final void mo29450m() {
        if (!this.f23835c.getAndSet(true)) {
            try {
                if (this.f23843k != null) {
                    this.f23843k.mo29523db();
                }
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: n */
    public final void mo29451n() {
        try {
            if (this.f23843k != null) {
                this.f23843k.resume();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo29427a(AdListener adListener) {
        this.f23839g = adListener;
        this.f23837e.mo32393a(adListener);
    }

    /* renamed from: a */
    public final void mo29433a(zzxr zzxr) {
        try {
            this.f23838f = zzxr;
            if (this.f23843k != null) {
                this.f23843k.mo29516a((zzyw) zzxr != null ? new zzxs(zzxr) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo29436a(AdSize... adSizeArr) {
        if (this.f23840h == null) {
            mo29439b(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    /* renamed from: b */
    public final void mo29439b(AdSize... adSizeArr) {
        this.f23840h = adSizeArr;
        try {
            if (this.f23843k != null) {
                this.f23843k.mo29515a(m24602a(this.f23847o.getContext(), this.f23840h, this.f23848p));
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        this.f23847o.requestLayout();
    }

    /* renamed from: a */
    public final void mo29434a(String str) {
        if (this.f23846n == null) {
            this.f23846n = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    /* renamed from: a */
    public final void mo29430a(AppEventListener appEventListener) {
        try {
            this.f23841i = appEventListener;
            if (this.f23843k != null) {
                this.f23843k.mo29519a((zzzs) appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo29431a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        zzadr zzadr;
        this.f23844l = onCustomRenderedAdLoadedListener;
        try {
            if (this.f23843k != null) {
                zzzk zzzk = this.f23843k;
                if (onCustomRenderedAdLoadedListener != null) {
                    zzadr = new zzadr(onCustomRenderedAdLoadedListener);
                } else {
                    zzadr = null;
                }
                zzzk.mo29511a((zzado) zzadr);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo29435a(boolean z) {
        this.f23849q = z;
        try {
            if (this.f23843k != null) {
                this.f23843k.mo29530m(this.f23849q);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo29428a(Correlator correlator) {
        this.f23842j = correlator;
        try {
            if (this.f23843k != null) {
                this.f23843k.mo29520a((zzzy) this.f23842j == null ? null : this.f23842j.zzdf());
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: g */
    public final String mo29444g() {
        try {
            if (this.f23843k != null) {
                return this.f23843k.mo29505L();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        return null;
    }

    /* renamed from: k */
    public final boolean mo29448k() {
        try {
            if (this.f23843k != null) {
                return this.f23843k.mo29503I();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        return false;
    }

    /* renamed from: i */
    public final VideoController mo29446i() {
        return this.f23836d;
    }

    /* renamed from: o */
    public final zzaar mo29452o() {
        zzzk zzzk = this.f23843k;
        if (zzzk == null) {
            return null;
        }
        try {
            return zzzk.getVideoController();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo29429a(VideoOptions videoOptions) {
        this.f23845m = videoOptions;
        try {
            if (this.f23843k != null) {
                this.f23843k.mo29510a(videoOptions == null ? null : new zzacd(videoOptions));
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: j */
    public final VideoOptions mo29447j() {
        return this.f23845m;
    }

    /* renamed from: a */
    public final boolean mo29437a(zzzk zzzk) {
        if (zzzk == null) {
            return false;
        }
        try {
            IObjectWrapper Aa = zzzk.mo29502Aa();
            if (Aa == null || ((View) ObjectWrapper.m22187H(Aa)).getParent() != null) {
                return false;
            }
            this.f23847o.addView((View) ObjectWrapper.m22187H(Aa));
            this.f23843k = zzzk;
            return true;
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return false;
        }
    }

    /* renamed from: a */
    private static zzyd m24602a(Context context, AdSize[] adSizeArr, int i) {
        zzyd zzyd = new zzyd(context, adSizeArr);
        zzyd.f29777j = m24603a(i);
        return zzyd;
    }

    /* renamed from: a */
    private static boolean m24603a(int i) {
        return i == 1;
    }
}
