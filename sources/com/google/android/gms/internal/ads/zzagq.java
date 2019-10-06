package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzagq extends zzafv {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final OnPublisherAdViewLoadedListener f24316b;

    public zzagq(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.f24316b = onPublisherAdViewLoadedListener;
    }

    /* renamed from: a */
    public final void mo29701a(zzzk zzzk, IObjectWrapper iObjectWrapper) {
        String str = "";
        if (zzzk != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.m22187H(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzzk.mo29507Ya() instanceof zzxv) {
                    zzxv zzxv = (zzxv) zzzk.mo29507Ya();
                    publisherAdView.setAdListener(zzxv != null ? zzxv.mo32364ib() : null);
                }
            } catch (RemoteException e) {
                zzbad.m26356b(str, e);
            }
            try {
                if (zzzk.mo29506Ta() instanceof zzyf) {
                    zzyf zzyf = (zzyf) zzzk.mo29506Ta();
                    if (zzyf != null) {
                        appEventListener = zzyf.mo32383ib();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzbad.m26356b(str, e2);
            }
            zzazt.f25042a.post(new C9806x(this, publisherAdView, zzzk));
        }
    }
}
