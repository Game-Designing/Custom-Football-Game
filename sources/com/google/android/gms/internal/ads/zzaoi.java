package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzaoi extends zzanh {

    /* renamed from: b */
    private final UnifiedNativeAdMapper f24517b;

    public zzaoi(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.f24517b = unifiedNativeAdMapper;
    }

    /* renamed from: o */
    public final String mo29945o() {
        return this.f24517b.getHeadline();
    }

    /* renamed from: q */
    public final List mo29947q() {
        List<Image> images = this.f24517b.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (Image image : images) {
                zzadw zzadw = new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight());
                arrayList.add(zzadw);
            }
        }
        return arrayList;
    }

    /* renamed from: p */
    public final String mo29946p() {
        return this.f24517b.getBody();
    }

    /* renamed from: t */
    public final zzaei mo29949t() {
        Image icon = this.f24517b.getIcon();
        if (icon == null) {
            return null;
        }
        zzadw zzadw = new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        return zzadw;
    }

    /* renamed from: m */
    public final String mo29943m() {
        return this.f24517b.getCallToAction();
    }

    /* renamed from: x */
    public final String mo29951x() {
        return this.f24517b.getAdvertiser();
    }

    /* renamed from: j */
    public final double mo29941j() {
        if (this.f24517b.getStarRating() != null) {
            return this.f24517b.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    public final String getStore() {
        return this.f24517b.getStore();
    }

    /* renamed from: u */
    public final String mo29950u() {
        return this.f24517b.getPrice();
    }

    public final zzaar getVideoController() {
        if (this.f24517b.getVideoController() != null) {
            return this.f24517b.getVideoController().zzdh();
        }
        return null;
    }

    /* renamed from: l */
    public final zzaea mo29942l() {
        return null;
    }

    /* renamed from: B */
    public final IObjectWrapper mo29931B() {
        View adChoicesContent = this.f24517b.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.m22188a(adChoicesContent);
    }

    /* renamed from: A */
    public final IObjectWrapper mo29930A() {
        View zzacd = this.f24517b.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.m22188a(zzacd);
    }

    /* renamed from: ia */
    public final float mo29940ia() {
        return 0.0f;
    }

    /* renamed from: n */
    public final IObjectWrapper mo29944n() {
        Object zzkv = this.f24517b.zzkv();
        if (zzkv == null) {
            return null;
        }
        return ObjectWrapper.m22188a(zzkv);
    }

    public final Bundle getExtras() {
        return this.f24517b.getExtras();
    }

    /* renamed from: C */
    public final boolean mo29932C() {
        return this.f24517b.getOverrideImpressionRecording();
    }

    /* renamed from: F */
    public final boolean mo29933F() {
        return this.f24517b.getOverrideClickHandling();
    }

    public final void recordImpression() {
        this.f24517b.recordImpression();
    }

    /* renamed from: a */
    public final void mo29934a(IObjectWrapper iObjectWrapper) {
        this.f24517b.handleClick((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: a */
    public final void mo29935a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f24517b.trackViews((View) ObjectWrapper.m22187H(iObjectWrapper), (HashMap) ObjectWrapper.m22187H(iObjectWrapper2), (HashMap) ObjectWrapper.m22187H(iObjectWrapper3));
    }

    /* renamed from: b */
    public final void mo29936b(IObjectWrapper iObjectWrapper) {
        this.f24517b.untrackView((View) ObjectWrapper.m22187H(iObjectWrapper));
    }
}
