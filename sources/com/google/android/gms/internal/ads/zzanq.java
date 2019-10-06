package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzanq extends zzanb {

    /* renamed from: b */
    private final NativeAppInstallAdMapper f24500b;

    public zzanq(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.f24500b = nativeAppInstallAdMapper;
    }

    /* renamed from: o */
    public final String mo29905o() {
        return this.f24500b.getHeadline();
    }

    /* renamed from: q */
    public final List mo29907q() {
        List<Image> images = this.f24500b.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Image image : images) {
            zzadw zzadw = new zzadw(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight());
            arrayList.add(zzadw);
        }
        return arrayList;
    }

    /* renamed from: p */
    public final String mo29906p() {
        return this.f24500b.getBody();
    }

    /* renamed from: t */
    public final zzaei mo29909t() {
        Image icon = this.f24500b.getIcon();
        if (icon == null) {
            return null;
        }
        zzadw zzadw = new zzadw(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        return zzadw;
    }

    /* renamed from: m */
    public final String mo29903m() {
        return this.f24500b.getCallToAction();
    }

    /* renamed from: j */
    public final double mo29901j() {
        return this.f24500b.getStarRating();
    }

    public final String getStore() {
        return this.f24500b.getStore();
    }

    /* renamed from: u */
    public final String mo29910u() {
        return this.f24500b.getPrice();
    }

    public final void recordImpression() {
        this.f24500b.recordImpression();
    }

    /* renamed from: a */
    public final void mo29894a(IObjectWrapper iObjectWrapper) {
        this.f24500b.handleClick((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: c */
    public final void mo29897c(IObjectWrapper iObjectWrapper) {
        this.f24500b.trackView((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: a */
    public final void mo29895a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f24500b.trackViews((View) ObjectWrapper.m22187H(iObjectWrapper), (HashMap) ObjectWrapper.m22187H(iObjectWrapper2), (HashMap) ObjectWrapper.m22187H(iObjectWrapper3));
    }

    /* renamed from: b */
    public final void mo29896b(IObjectWrapper iObjectWrapper) {
        this.f24500b.untrackView((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: C */
    public final boolean mo29892C() {
        return this.f24500b.getOverrideImpressionRecording();
    }

    /* renamed from: F */
    public final boolean mo29893F() {
        return this.f24500b.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.f24500b.getExtras();
    }

    public final zzaar getVideoController() {
        if (this.f24500b.getVideoController() != null) {
            return this.f24500b.getVideoController().zzdh();
        }
        return null;
    }

    /* renamed from: l */
    public final zzaea mo29902l() {
        return null;
    }

    /* renamed from: B */
    public final IObjectWrapper mo29891B() {
        View adChoicesContent = this.f24500b.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.m22188a(adChoicesContent);
    }

    /* renamed from: A */
    public final IObjectWrapper mo29890A() {
        View zzacd = this.f24500b.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.m22188a(zzacd);
    }

    /* renamed from: n */
    public final IObjectWrapper mo29904n() {
        return null;
    }
}
