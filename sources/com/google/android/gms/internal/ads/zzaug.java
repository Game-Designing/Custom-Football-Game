package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzaug {

    /* renamed from: a */
    private final zzatt f24822a;

    /* renamed from: b */
    private final Context f24823b;

    public zzaug(Context context, String str) {
        this.f24823b = context.getApplicationContext();
        this.f24822a = zzyt.m31533b().mo32391b(context, str, new zzamo());
    }

    /* renamed from: a */
    public final void mo30095a(zzaaz zzaaz, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.f24822a.mo29552a(zzyc.m31508a(this.f24823b, zzaaz), (zzaub) new zzaul(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: b */
    public final String mo30096b() {
        try {
            return this.f24822a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return "";
        }
    }

    /* renamed from: a */
    public final void mo30094a(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.f24822a.mo29551a(new zzaum(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo30093a(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.f24822a.mo29548a((zzaao) new zzabz(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final Bundle mo30090a() {
        try {
            return this.f24822a.getAdMetadata();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    /* renamed from: d */
    public final boolean mo30098d() {
        try {
            return this.f24822a.isLoaded();
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo30091a(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.f24822a.mo29549a((zzatw) new zzaui(rewardedAdCallback));
            this.f24822a.mo29546C(ObjectWrapper.m22188a(activity));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo30092a(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.f24822a.mo29549a((zzatw) new zzaui(rewardedAdCallback));
            this.f24822a.mo29547a(ObjectWrapper.m22188a(activity), z);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: c */
    public final RewardItem mo30097c() {
        try {
            zzatq xa = this.f24822a.mo29556xa();
            if (xa == null) {
                return null;
            }
            return new zzauh(xa);
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }
}
