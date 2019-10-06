package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.commons.core.utilities.Logger;
import com.inmobi.commons.core.utilities.Logger.InternalLogLevel;
import com.inmobi.rendering.RenderView;

/* renamed from: com.inmobi.ads.cc */
/* compiled from: ViewableNativeV2DisplayAd */
final class C10521cc extends C10503ca {

    /* renamed from: d */
    private final C10380ah f32082d;

    /* renamed from: e */
    private boolean f32083e = false;

    /* renamed from: f */
    private RenderView f32084f;

    C10521cc(C10380ah ahVar, RenderView renderView) {
        super(ahVar);
        this.f32082d = ahVar;
        this.f32084f = renderView;
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f32082d.f31554c;
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        if (this.f32083e) {
            return null;
        }
        Context j = this.f32082d.mo34025j();
        if (j == null) {
            return null;
        }
        C10380ah ahVar = this.f32082d;
        this.f32008b = new C10415at(j, ahVar.f31554c, ahVar, ahVar.mo34023h());
        Logger.m35065a(InternalLogLevel.DEBUG, "InMobi", "Ad markup loaded into the container will be inflated into a View.");
        View a = this.f32008b.mo34111a(view, viewGroup, z, this.f32084f);
        mo34223a(a);
        this.f32082d.mo34042t();
        return a;
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
    }

    /* renamed from: d */
    public final void mo33962d() {
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
    }

    /* renamed from: e */
    public final void mo33963e() {
        if (!this.f32083e) {
            this.f32083e = true;
            C10504a aVar = this.f32008b;
            if (aVar != null) {
                aVar.mo34112a();
            }
            RenderView renderView = this.f32084f;
            if (renderView != null) {
                renderView.destroy();
                this.f32084f = null;
            }
            super.mo33963e();
        }
    }
}
