package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
public final class zzabd {

    /* renamed from: a */
    private final zzamo f23850a;

    /* renamed from: b */
    private final Context f23851b;

    /* renamed from: c */
    private final zzyc f23852c;

    /* renamed from: d */
    private AdListener f23853d;

    /* renamed from: e */
    private zzxr f23854e;

    /* renamed from: f */
    private zzzk f23855f;

    /* renamed from: g */
    private String f23856g;

    /* renamed from: h */
    private AdMetadataListener f23857h;

    /* renamed from: i */
    private AppEventListener f23858i;

    /* renamed from: j */
    private OnCustomRenderedAdLoadedListener f23859j;

    /* renamed from: k */
    private Correlator f23860k;

    /* renamed from: l */
    private RewardedVideoAdListener f23861l;

    /* renamed from: m */
    private boolean f23862m;

    /* renamed from: n */
    private boolean f23863n;

    public zzabd(Context context) {
        this(context, zzyc.f29767a, null);
    }

    public zzabd(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzyc.f29767a, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzabd(Context context, zzyc zzyc, PublisherInterstitialAd publisherInterstitialAd) {
        this.f23850a = new zzamo();
        this.f23851b = context;
        this.f23852c = zzyc;
    }

    /* renamed from: a */
    public final AdListener mo29453a() {
        return this.f23853d;
    }

    /* renamed from: c */
    public final String mo29466c() {
        return this.f23856g;
    }

    /* renamed from: d */
    public final AppEventListener mo29467d() {
        return this.f23858i;
    }

    /* renamed from: f */
    public final OnCustomRenderedAdLoadedListener mo29469f() {
        return this.f23859j;
    }

    /* renamed from: g */
    public final boolean mo29470g() {
        try {
            if (this.f23855f == null) {
                return false;
            }
            return this.f23855f.isReady();
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    /* renamed from: h */
    public final boolean mo29471h() {
        try {
            if (this.f23855f == null) {
                return false;
            }
            return this.f23855f.mo29503I();
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo29460a(zzaaz zzaaz) {
        try {
            if (this.f23855f == null) {
                String str = "loadAd";
                if (this.f23856g == null) {
                    m24631b(str);
                }
                zzyd a = this.f23862m ? zzyd.m31510a() : new zzyd();
                zzyh b = zzyt.m31533b();
                Context context = this.f23851b;
                C9483hu huVar = new C9483hu(b, context, a, this.f23856g, this.f23850a);
                this.f23855f = (zzzk) huVar.mo29114a(context, false);
                if (this.f23853d != null) {
                    this.f23855f.mo29517a((zzyz) new zzxv(this.f23853d));
                }
                if (this.f23854e != null) {
                    this.f23855f.mo29516a((zzyw) new zzxs(this.f23854e));
                }
                if (this.f23857h != null) {
                    this.f23855f.mo29518a((zzzp) new zzxy(this.f23857h));
                }
                if (this.f23858i != null) {
                    this.f23855f.mo29519a((zzzs) new zzyf(this.f23858i));
                }
                if (this.f23859j != null) {
                    this.f23855f.mo29511a((zzado) new zzadr(this.f23859j));
                }
                if (this.f23860k != null) {
                    this.f23855f.mo29520a((zzzy) this.f23860k.zzdf());
                }
                if (this.f23861l != null) {
                    this.f23855f.mo29514a((zzatb) new zzatg(this.f23861l));
                }
                this.f23855f.setImmersiveMode(this.f23863n);
            }
            if (this.f23855f.mo29521b(zzyc.m31508a(this.f23851b, zzaaz))) {
                this.f23850a.mo29833b(zzaaz.mo29399m());
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29454a(AdListener adListener) {
        try {
            this.f23853d = adListener;
            if (this.f23855f != null) {
                this.f23855f.mo29517a((zzyz) adListener != null ? new zzxv(adListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29461a(zzxr zzxr) {
        try {
            this.f23854e = zzxr;
            if (this.f23855f != null) {
                this.f23855f.mo29516a((zzyw) zzxr != null ? new zzxs(zzxr) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29462a(String str) {
        if (this.f23856g == null) {
            this.f23856g = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    /* renamed from: a */
    public final void mo29458a(AdMetadataListener adMetadataListener) {
        try {
            this.f23857h = adMetadataListener;
            if (this.f23855f != null) {
                this.f23855f.mo29518a((zzzp) adMetadataListener != null ? new zzxy(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: b */
    public final Bundle mo29464b() {
        try {
            if (this.f23855f != null) {
                return this.f23855f.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    /* renamed from: a */
    public final void mo29456a(AppEventListener appEventListener) {
        try {
            this.f23858i = appEventListener;
            if (this.f23855f != null) {
                this.f23855f.mo29519a((zzzs) appEventListener != null ? new zzyf(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29457a(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        zzadr zzadr;
        try {
            this.f23859j = onCustomRenderedAdLoadedListener;
            if (this.f23855f != null) {
                zzzk zzzk = this.f23855f;
                if (onCustomRenderedAdLoadedListener != null) {
                    zzadr = new zzadr(onCustomRenderedAdLoadedListener);
                } else {
                    zzadr = null;
                }
                zzzk.mo29511a((zzado) zzadr);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29455a(Correlator correlator) {
        this.f23860k = correlator;
        try {
            if (this.f23855f != null) {
                this.f23855f.mo29520a((zzzy) this.f23860k == null ? null : this.f23860k.zzdf());
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29459a(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.f23861l = rewardedVideoAdListener;
            if (this.f23855f != null) {
                this.f23855f.mo29514a((zzatb) rewardedVideoAdListener != null ? new zzatg(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: b */
    public final void mo29465b(boolean z) {
        this.f23862m = true;
    }

    /* renamed from: e */
    public final String mo29468e() {
        try {
            if (this.f23855f != null) {
                return this.f23855f.mo29505L();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
        return null;
    }

    /* renamed from: i */
    public final void mo29472i() {
        try {
            m24631b("show");
            this.f23855f.showInterstitial();
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: a */
    public final void mo29463a(boolean z) {
        try {
            this.f23863n = z;
            if (this.f23855f != null) {
                this.f23855f.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#008 Must be called on the main UI thread.", e);
        }
    }

    /* renamed from: b */
    private final void m24631b(String str) {
        if (this.f23855f == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }
}
