package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzady;
import com.google.android.gms.internal.ads.zzafi;
import com.google.android.gms.internal.ads.zzafl;
import com.google.android.gms.internal.ads.zzafx;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagp;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzamo;
import com.google.android.gms.internal.ads.zzamp;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzxv;
import com.google.android.gms.internal.ads.zzyc;
import com.google.android.gms.internal.ads.zzyd;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzyz;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzf;
import com.google.android.gms.internal.ads.zzzy;

public class AdLoader {

    /* renamed from: a */
    private final zzyc f19010a;

    /* renamed from: b */
    private final Context f19011b;

    /* renamed from: c */
    private final zzzc f19012c;

    public static class Builder {

        /* renamed from: a */
        private final Context f19013a;

        /* renamed from: b */
        private final zzzf f19014b;

        public Builder(Context context, String str) {
            Preconditions.m21858a(context, (Object) "context cannot be null");
            this(context, zzyt.m31533b().mo32390a(context, str, (zzamp) new zzamo()));
        }

        private Builder(Context context, zzzf zzzf) {
            this.f19013a = context;
            this.f19014b = zzzf;
        }

        @Deprecated
        public Builder forContentAd(OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.f19014b.mo29494a((zzafl) new zzagn(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to add content ad listener", e);
            }
            return this;
        }

        @Deprecated
        public Builder forAppInstallAd(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.f19014b.mo29493a((zzafi) new zzagm(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.f19014b.mo29496a((zzafx) new zzags(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to add google native ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, OnCustomClickListener onCustomClickListener) {
            zzago zzago;
            try {
                zzzf zzzf = this.f19014b;
                zzagp zzagp = new zzagp(onCustomTemplateAdLoadedListener);
                if (onCustomClickListener == null) {
                    zzago = null;
                } else {
                    zzago = new zzago(onCustomClickListener);
                }
                zzzf.mo29499a(str, zzagp, zzago);
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.f19014b.mo29495a(new zzagq(onPublisherAdViewLoadedListener), new zzyd(this.f19013a, adSizeArr));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to add publisher banner ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.f19014b.mo29500b((zzyz) new zzxv(adListener));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.f19014b.mo29492a(new zzady(nativeAdOptions));
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to specify native ad options", e);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.f19014b.mo29491a(publisherAdViewOptions);
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to specify DFP banner ad options", e);
            }
            return this;
        }

        public Builder withCorrelator(Correlator correlator) {
            Preconditions.m21857a(correlator);
            try {
                this.f19014b.mo29501b((zzzy) correlator.f19020a);
            } catch (RemoteException e) {
                zzbad.m26358c("Failed to set correlator.", e);
            }
            return this;
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.f19013a, this.f19014b.mo29490Fa());
            } catch (RemoteException e) {
                zzbad.m26356b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    AdLoader(Context context, zzzc zzzc) {
        this(context, zzzc, zzyc.f29767a);
    }

    private AdLoader(Context context, zzzc zzzc, zzyc zzyc) {
        this.f19011b = context;
        this.f19012c = zzzc;
        this.f19010a = zzyc;
    }

    /* renamed from: a */
    private final void m20793a(zzaaz zzaaz) {
        try {
            this.f19012c.mo28922a(zzyc.m31508a(this.f19011b, zzaaz));
        } catch (RemoteException e) {
            zzbad.m26356b("Failed to load ad.", e);
        }
    }

    public void loadAd(AdRequest adRequest) {
        m20793a(adRequest.zzde());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.f19012c.mo28923a(zzyc.m31508a(this.f19011b, adRequest.zzde()), i);
        } catch (RemoteException e) {
            zzbad.m26356b("Failed to load ads.", e);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        m20793a(publisherAdRequest.zzde());
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.f19012c.mo28921L();
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.f19012c.mo28920I();
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to check if ad is loading.", e);
            return false;
        }
    }
}
