package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

@zzard
public final class zzano implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {

    /* renamed from: a */
    private final zzamv f24494a;

    /* renamed from: b */
    private NativeAdMapper f24495b;

    /* renamed from: c */
    private UnifiedNativeAdMapper f24496c;

    /* renamed from: d */
    private NativeCustomTemplateAd f24497d;

    public zzano(zzamv zzamv) {
        this.f24494a = zzamv;
    }

    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAppEvent.");
        try {
            this.f24494a.onAppEvent(str, str2);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClicked.");
        try {
            this.f24494a.onAdClicked();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClosed.");
        try {
            this.f24494a.onAdClosed();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzbad.m26352a(sb.toString());
        try {
            this.f24494a.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLeftApplication.");
        try {
            this.f24494a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdOpened.");
        try {
            this.f24494a.onAdOpened();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLoaded.");
        try {
            this.f24494a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClicked.");
        try {
            this.f24494a.onAdClicked();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClosed.");
        try {
            this.f24494a.onAdClosed();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzbad.m26352a(sb.toString());
        try {
            this.f24494a.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLeftApplication.");
        try {
            this.f24494a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdOpened.");
        try {
            this.f24494a.onAdOpened();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLoaded.");
        try {
            this.f24494a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLoaded.");
        this.f24495b = nativeAdMapper;
        this.f24496c = null;
        m25470a(mediationNativeAdapter, this.f24496c, this.f24495b);
        try {
            this.f24494a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLoaded.");
        this.f24496c = unifiedNativeAdMapper;
        this.f24495b = null;
        m25470a(mediationNativeAdapter, this.f24496c, this.f24495b);
        try {
            this.f24494a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    private static void m25470a(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper, NativeAdMapper nativeAdMapper) {
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            VideoController videoController = new VideoController();
            videoController.zza(new zzanj());
            if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.hasVideoContent()) {
                unifiedNativeAdMapper.zza(videoController);
            }
            if (nativeAdMapper != null && nativeAdMapper.hasVideoContent()) {
                nativeAdMapper.zza(videoController);
            }
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        String str = "Adapter called onAdLoaded with template id ";
        zzbad.m26352a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.f24497d = nativeCustomTemplateAd;
        try {
            this.f24494a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzafh) {
            try {
                this.f24494a.mo29869a(((zzafh) nativeCustomTemplateAd).mo29696a(), str);
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        } else {
            zzbad.m26359d("Unexpected native custom template ad type.");
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(".");
        zzbad.m26352a(sb.toString());
        try {
            this.f24494a.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdOpened.");
        try {
            this.f24494a.onAdOpened();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdClosed.");
        try {
            this.f24494a.onAdClosed();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onAdLeftApplication.");
        try {
            this.f24494a.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.f24495b;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.f24496c;
        String str = "#007 Could not call remote method.";
        if (this.f24497d == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbad.m26360d(str, null);
                return;
            }
            String str2 = "Could not call onAdClicked since setOverrideClickHandling is not set to true";
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideClickHandling()) {
                zzbad.m26352a(str2);
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideClickHandling()) {
                zzbad.m26352a(str2);
                return;
            }
        }
        zzbad.m26352a("Adapter called onAdClicked.");
        try {
            this.f24494a.onAdClicked();
        } catch (RemoteException e) {
            zzbad.m26360d(str, e);
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.f24495b;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.f24496c;
        String str = "#007 Could not call remote method.";
        if (this.f24497d == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbad.m26360d(str, null);
                return;
            }
            String str2 = "Could not call onAdImpression since setOverrideImpressionRecording is not set to true";
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideImpressionRecording()) {
                zzbad.m26352a(str2);
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideImpressionRecording()) {
                zzbad.m26352a(str2);
                return;
            }
        }
        zzbad.m26352a("Adapter called onAdImpression.");
        try {
            this.f24494a.onAdImpression();
        } catch (RemoteException e) {
            zzbad.m26360d(str, e);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.m21862a("#008 Must be called on the main UI thread.");
        zzbad.m26352a("Adapter called onVideoEnd.");
        try {
            this.f24494a.mo29867M();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final NativeAdMapper mo29952a() {
        return this.f24495b;
    }

    /* renamed from: b */
    public final UnifiedNativeAdMapper mo29953b() {
        return this.f24496c;
    }

    /* renamed from: c */
    public final NativeCustomTemplateAd mo29954c() {
        return this.f24497d;
    }
}
