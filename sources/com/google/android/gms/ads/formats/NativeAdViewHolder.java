package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaer;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbql = new WeakHashMap<>();

    /* renamed from: a */
    private zzaer f19058a;

    /* renamed from: b */
    private WeakReference<View> f19059b;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.m21858a(view, (Object) "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbad.m26355b("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbql.get(view) != null) {
            zzbad.m26355b("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbql.put(view, this);
            this.f19059b = new WeakReference<>(view);
            this.f19058a = zzyt.m31533b().mo32388a(view, m20815a(map), m20815a(map2));
        }
    }

    /* renamed from: a */
    private static HashMap<String, View> m20815a(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setNativeAd(NativeAd nativeAd) {
        m20816a((IObjectWrapper) nativeAd.mo26460a());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        m20816a((IObjectWrapper) unifiedNativeAd.mo26573a());
    }

    /* renamed from: a */
    private final void m20816a(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.f19059b;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzbad.m26359d("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbql.containsKey(view)) {
            zzbql.put(view, this);
        }
        zzaer zzaer = this.f19058a;
        if (zzaer != null) {
            try {
                zzaer.mo29543d(iObjectWrapper);
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    public final void unregisterNativeAd() {
        zzaer zzaer = this.f19058a;
        if (zzaer != null) {
            try {
                zzaer.mo29545na();
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.f19059b;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zzbql.remove(view);
        }
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.f19058a.mo29544e(ObjectWrapper.m22188a(view));
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setClickConfirmingView on delegate", e);
        }
    }
}
