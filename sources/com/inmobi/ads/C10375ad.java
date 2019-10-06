package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.moat.analytics.mobile.inm.WebAdTracker;
import java.lang.ref.WeakReference;
import java.util.Map;

/* renamed from: com.inmobi.ads.ad */
/* compiled from: MoatTrackedHtmlAd */
public class C10375ad extends C10477bz {

    /* renamed from: d */
    private static final String f31519d = C10375ad.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Activity> f31520e;

    /* renamed from: f */
    private final C10503ca f31521f;

    /* renamed from: g */
    private final Map<String, Object> f31522g;

    /* renamed from: h */
    private WebAdTracker f31523h;

    public C10375ad(AdContainer adContainer, Activity activity, C10503ca caVar, Map<String, Object> map) {
        super(adContainer);
        this.f31520e = new WeakReference<>(activity);
        this.f31521f = caVar;
        this.f31522g = map;
    }

    /* renamed from: a */
    public final View mo34004a() {
        return this.f31521f.mo34004a();
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        return this.f31521f.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f31521f.mo33960b();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f31521f.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            Activity activity = (Activity) this.f31520e.get();
            if (this.f31521f.mo33961c().f31899k.f31972i && activity != null && ((Boolean) this.f31522g.get("enabled")).booleanValue()) {
                if (this.f31523h == null) {
                    if (this.f32007a instanceof C10380ah) {
                        C10380ah ahVar = (C10380ah) this.f32007a;
                        if (ahVar.mo34041s() != null) {
                            this.f31523h = C10613z.m34818a(activity.getApplication(), (WebView) ahVar.mo34041s());
                        }
                    } else {
                        View b = this.f31521f.mo33960b();
                        if (b != null) {
                            this.f31523h = C10613z.m34818a(activity.getApplication(), (WebView) b);
                        }
                    }
                }
                if (this.f31523h != null) {
                    this.f31523h.startTracking();
                }
            }
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31521f.mo33959a(viewArr);
            throw th;
        }
        this.f31521f.mo33959a(viewArr);
    }

    /* renamed from: d */
    public final void mo33962d() {
        try {
            if (this.f31523h != null) {
                this.f31523h.stopTracking();
            }
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
            C10621a.m34854a().mo34423a(new C10658a(e));
        } catch (Throwable th) {
            this.f31521f.mo33962d();
            throw th;
        }
        this.f31521f.mo33962d();
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
        this.f31521f.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        this.f31521f.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        this.f31523h = null;
        this.f31520e.clear();
        super.mo33963e();
        this.f31521f.mo33963e();
    }
}
