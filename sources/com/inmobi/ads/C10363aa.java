package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.C10478c.C10490l;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.aa */
/* compiled from: InMobiTrackedNativeV2DisplayAd */
class C10363aa extends C10477bz {

    /* renamed from: d */
    private static final String f31490d = C10363aa.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Context> f31491e;

    /* renamed from: f */
    private final C10503ca f31492f;

    /* renamed from: g */
    private final C10391ai f31493g = new C10391ai(1);

    /* renamed from: h */
    private final C10380ah f31494h;

    C10363aa(Context context, C10380ah ahVar, C10503ca caVar) {
        super(ahVar);
        this.f31491e = new WeakReference<>(context);
        this.f31492f = caVar;
        this.f31494h = ahVar;
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        View b = this.f31492f.mo33960b();
        if (b != null) {
            this.f31493g.mo34072a(this.f31494h.mo34019d(), b, this.f31494h);
        }
        return this.f31492f.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f31492f.mo33960b();
    }

    /* renamed from: f */
    public final C10504a mo33964f() {
        return this.f31492f.mo33964f();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f31492f.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            Context context = (Context) this.f31491e.get();
            View b = this.f31492f.mo33960b();
            C10490l lVar = this.f31492f.mo33961c().f31899k;
            C10380ah ahVar = (C10380ah) this.f32007a;
            if (!(context == null || b == null || ahVar.f31563l)) {
                this.f31493g.mo34074a(context, b, ahVar, lVar);
                this.f31493g.mo34073a(context, b, this.f31494h, this.f31494h.f31538A, lVar);
            }
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31492f.mo33959a(viewArr);
            throw th;
        }
        this.f31492f.mo33959a(viewArr);
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            C10380ah ahVar = (C10380ah) this.f32007a;
            if (!ahVar.f31563l) {
                this.f31493g.mo34075a((Context) this.f31491e.get(), ahVar);
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31492f.mo33962d();
            throw th;
        }
        this.f31492f.mo33962d();
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
        this.f31492f.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        if (i == 0) {
            C10391ai.m34012b(context);
        } else if (i == 1) {
            C10391ai.m34013c(context);
        } else if (i == 2) {
            try {
                this.f31493g.mo34071a(context);
            } catch (Exception e) {
                new StringBuilder("Exception in onActivityStateChanged with message : ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
            } catch (Throwable th) {
                this.f31492f.mo33958a(context, i);
                throw th;
            }
        }
        this.f31492f.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        this.f31493g.mo34072a(this.f31494h.mo34019d(), this.f31492f.mo33960b(), this.f31494h);
        super.mo33963e();
        this.f31491e.clear();
        this.f31492f.mo33963e();
    }
}
