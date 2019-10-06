package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaem;
import com.google.android.gms.internal.ads.zzbad;
import com.google.android.gms.internal.ads.zzyt;

@Deprecated
public class NativeAdView extends FrameLayout {

    /* renamed from: a */
    private final FrameLayout f19056a;

    /* renamed from: b */
    private final zzaem f19057b = m20812a();

    public NativeAdView(Context context) {
        super(context);
        this.f19056a = m20811a(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19056a = m20811a(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19056a = m20811a(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f19056a = m20811a(context);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        mo26485a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View a = mo26484a(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (a instanceof AdChoicesView) {
            return (AdChoicesView) a;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo26485a(String str, View view) {
        try {
            this.f19057b.mo29538b(str, ObjectWrapper.m22188a(view));
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final View mo26484a(String str) {
        try {
            IObjectWrapper f = this.f19057b.mo29542f(str);
            if (f != null) {
                return (View) ObjectWrapper.m22187H(f);
            }
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f19057b.mo29539d((IObjectWrapper) nativeAd.mo26460a());
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to call setNativeAd on delegate", e);
        }
    }

    public void destroy() {
        try {
            this.f19057b.destroy();
        } catch (RemoteException e) {
            zzbad.m26356b("Unable to destroy native ad view", e);
        }
    }

    /* renamed from: a */
    private final FrameLayout m20811a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    /* renamed from: a */
    private final zzaem m20812a() {
        Preconditions.m21858a(this.f19056a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzyt.m31533b().mo32387a(this.f19056a.getContext(), (FrameLayout) this, this.f19056a);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f19056a);
    }

    public void removeView(View view) {
        if (this.f19056a != view) {
            super.removeView(view);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f19056a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f19056a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaem zzaem = this.f19057b;
        if (zzaem != null) {
            try {
                zzaem.mo29537a(ObjectWrapper.m22188a(view), i);
            } catch (RemoteException e) {
                zzbad.m26356b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }
}
