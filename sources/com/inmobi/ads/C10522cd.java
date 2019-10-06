package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.inmobi.ads.cd */
/* compiled from: ViewableNativeV2VideoAd */
final class C10522cd extends C10503ca {

    /* renamed from: d */
    private final C10445bd f32085d;

    /* renamed from: e */
    private boolean f32086e = false;

    C10522cd(C10445bd bdVar) {
        super(bdVar);
        this.f32085d = bdVar;
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f32085d.f31554c;
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        if (this.f32086e) {
            return null;
        }
        Context j = this.f32085d.mo34025j();
        if (j == null) {
            return null;
        }
        C10445bd bdVar = this.f32085d;
        this.f32008b = new C10415at(j, bdVar.f31554c, bdVar, bdVar.mo34023h());
        View a = this.f32008b.mo34111a(view, viewGroup, false, null);
        mo34223a(a);
        this.f32085d.mo34042t();
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
        if (!this.f32086e) {
            this.f32086e = true;
            C10504a aVar = this.f32008b;
            if (aVar != null) {
                aVar.mo34112a();
            }
            super.mo33963e();
        }
    }
}
