package com.inmobi.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.AdContainer.RenderingProperties.PlacementType;
import com.inmobi.ads.C10478c.C10490l;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.ab */
/* compiled from: InMobiTrackedNativeV2VideoAd */
class C10364ab extends C10477bz {

    /* renamed from: d */
    private static final String f31495d = C10364ab.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Context> f31496e;

    /* renamed from: f */
    private final C10503ca f31497f;

    /* renamed from: g */
    private final C10391ai f31498g = new C10391ai(0);

    /* renamed from: h */
    private final C10380ah f31499h;

    C10364ab(C10445bd bdVar, C10503ca caVar) {
        super(bdVar);
        this.f31496e = new WeakReference<>(bdVar.mo34025j());
        this.f31497f = caVar;
        this.f31499h = bdVar;
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        View b = this.f31497f.mo33960b();
        if (b != null) {
            this.f31498g.mo34072a((Context) this.f31496e.get(), b, this.f31499h);
        }
        return this.f31497f.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f31497f.mo33960b();
    }

    /* renamed from: f */
    public final C10504a mo33964f() {
        return this.f31497f.mo33964f();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f31497f.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            C10445bd bdVar = (C10445bd) this.f32007a;
            NativeVideoWrapper nativeVideoWrapper = (NativeVideoWrapper) bdVar.getVideoContainerView();
            Context context = (Context) this.f31496e.get();
            C10490l lVar = this.f31497f.mo33961c().f31899k;
            if (!(context == null || nativeVideoWrapper == null || bdVar.f31563l)) {
                NativeVideoView videoView = nativeVideoWrapper.getVideoView();
                this.f31498g.mo34074a(context, videoView, bdVar, lVar);
                View b = this.f31497f.mo33960b();
                if (!(videoView.getTag() == null || b == null)) {
                    C10449be beVar = (C10449be) videoView.getTag();
                    if (PlacementType.PLACEMENT_TYPE_INLINE == bdVar.f31553b.f31249a && !((Boolean) beVar.f31629v.get("isFullScreen")).booleanValue()) {
                        this.f31498g.mo34073a(context, b, this.f31499h, ((C10445bd) this.f31499h).f31776C, lVar);
                    }
                }
            }
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31497f.mo33959a(viewArr);
            throw th;
        }
        this.f31497f.mo33959a(viewArr);
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            Context context = (Context) this.f31496e.get();
            C10445bd bdVar = (C10445bd) this.f32007a;
            if (!bdVar.f31563l && context != null) {
                this.f31498g.mo34075a(context, bdVar);
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31497f.mo33962d();
            throw th;
        }
        this.f31497f.mo33962d();
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
        this.f31497f.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        if (i == 0) {
            C10391ai.m34012b(context);
        } else if (i == 1) {
            C10391ai.m34013c(context);
        } else if (i == 2) {
            try {
                this.f31498g.mo34071a(context);
            } catch (Exception e) {
                new StringBuilder("Exception in onActivityStateChanged with message : ").append(e.getMessage());
                C10621a.m34854a().mo34423a(new C10658a(e));
            } catch (Throwable th) {
                this.f31497f.mo33958a(context, i);
                throw th;
            }
        }
        this.f31497f.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        this.f31498g.mo34072a((Context) this.f31496e.get(), this.f31497f.mo33960b(), this.f31499h);
        super.mo33963e();
        this.f31496e.clear();
        this.f31497f.mo33963e();
    }
}
