package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzard
public final class zzanr extends zzane {

    /* renamed from: b */
    private final NativeContentAdMapper f24501b;

    public zzanr(NativeContentAdMapper nativeContentAdMapper) {
        this.f24501b = nativeContentAdMapper;
    }

    /* renamed from: o */
    public final String mo29925o() {
        return this.f24501b.getHeadline();
    }

    /* renamed from: q */
    public final List mo29927q() {
        List<Image> images = this.f24501b.getImages();
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
    public final String mo29926p() {
        return this.f24501b.getBody();
    }

    /* renamed from: J */
    public final zzaei mo29915J() {
        Image logo = this.f24501b.getLogo();
        if (logo == null) {
            return null;
        }
        zzadw zzadw = new zzadw(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        return zzadw;
    }

    /* renamed from: m */
    public final String mo29923m() {
        return this.f24501b.getCallToAction();
    }

    /* renamed from: x */
    public final String mo29929x() {
        return this.f24501b.getAdvertiser();
    }

    public final void recordImpression() {
        this.f24501b.recordImpression();
    }

    /* renamed from: a */
    public final void mo29916a(IObjectWrapper iObjectWrapper) {
        this.f24501b.handleClick((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: c */
    public final void mo29919c(IObjectWrapper iObjectWrapper) {
        this.f24501b.trackView((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: a */
    public final void mo29917a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.f24501b.trackViews((View) ObjectWrapper.m22187H(iObjectWrapper), (HashMap) ObjectWrapper.m22187H(iObjectWrapper2), (HashMap) ObjectWrapper.m22187H(iObjectWrapper3));
    }

    /* renamed from: b */
    public final void mo29918b(IObjectWrapper iObjectWrapper) {
        this.f24501b.untrackView((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: C */
    public final boolean mo29913C() {
        return this.f24501b.getOverrideImpressionRecording();
    }

    /* renamed from: F */
    public final boolean mo29914F() {
        return this.f24501b.getOverrideClickHandling();
    }

    public final Bundle getExtras() {
        return this.f24501b.getExtras();
    }

    /* renamed from: B */
    public final IObjectWrapper mo29912B() {
        View adChoicesContent = this.f24501b.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.m22188a(adChoicesContent);
    }

    /* renamed from: l */
    public final zzaea mo29922l() {
        return null;
    }

    public final zzaar getVideoController() {
        if (this.f24501b.getVideoController() != null) {
            return this.f24501b.getVideoController().zzdh();
        }
        return null;
    }

    /* renamed from: A */
    public final IObjectWrapper mo29911A() {
        View zzacd = this.f24501b.zzacd();
        if (zzacd == null) {
            return null;
        }
        return ObjectWrapper.m22188a(zzacd);
    }

    /* renamed from: n */
    public final IObjectWrapper mo29924n() {
        return null;
    }
}
