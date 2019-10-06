package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzatj implements RewardedVideoAd {

    /* renamed from: a */
    private final zzasw f24813a;

    /* renamed from: b */
    private final Context f24814b;

    /* renamed from: c */
    private final Object f24815c = new Object();

    /* renamed from: d */
    private final zzatg f24816d = new zzatg(null);

    /* renamed from: e */
    private String f24817e;

    /* renamed from: f */
    private String f24818f;

    public zzatj(Context context, zzasw zzasw) {
        if (zzasw == null) {
            zzasw = new zzabx();
        }
        this.f24813a = zzasw;
        this.f24814b = context.getApplicationContext();
    }

    /* renamed from: a */
    private final void m25784a(String str, zzaaz zzaaz) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29562a(new zzath(zzyc.m31508a(this.f24814b, zzaaz), str));
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void loadAd(String str, AdRequest adRequest) {
        m25784a(str, adRequest.zzde());
    }

    public final void loadAd(String str, PublisherAdRequest publisherAdRequest) {
        m25784a(str, publisherAdRequest.zzde());
    }

    public final void show() {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.show();
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.f24815c) {
            this.f24816d.mo30070a(rewardedVideoAdListener);
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29561a((zzatb) this.f24816d);
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29563a((zzzp) new zzxy(adMetadataListener));
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final Bundle getAdMetadata() {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    Bundle adMetadata = this.f24813a.getAdMetadata();
                    return adMetadata;
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public final void setUserId(String str) {
        synchronized (this.f24815c) {
            this.f24817e = str;
            if (this.f24813a != null) {
                try {
                    this.f24813a.setUserId(str);
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean isLoaded() {
        synchronized (this.f24815c) {
            if (this.f24813a == null) {
                return false;
            }
            try {
                boolean isLoaded = this.f24813a.isLoaded();
                return isLoaded;
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    public final void pause() {
        pause(null);
    }

    public final void pause(Context context) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29559G(ObjectWrapper.m22188a(context));
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void resume() {
        resume(null);
    }

    public final void resume(Context context) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29558D(ObjectWrapper.m22188a(context));
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void destroy() {
        destroy(null);
    }

    public final void destroy(Context context) {
        synchronized (this.f24815c) {
            this.f24816d.mo30070a((RewardedVideoAdListener) null);
            if (this.f24813a != null) {
                try {
                    this.f24813a.mo29567h(ObjectWrapper.m22188a(context));
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener ib;
        synchronized (this.f24815c) {
            ib = this.f24816d.mo30071ib();
        }
        return ib;
    }

    public final String getUserId() {
        String str;
        synchronized (this.f24815c) {
            str = this.f24817e;
        }
        return str;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.f24813a != null) {
                return this.f24813a.getMediationAdapterClassName();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
        return null;
    }

    public final void setImmersiveMode(boolean z) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.setImmersiveMode(z);
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void setCustomData(String str) {
        synchronized (this.f24815c) {
            if (this.f24813a != null) {
                try {
                    this.f24813a.setCustomData(str);
                    this.f24818f = str;
                } catch (RemoteException e) {
                    zzbad.m26360d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getCustomData() {
        String str;
        synchronized (this.f24815c) {
            str = this.f24818f;
        }
        return str;
    }
}
