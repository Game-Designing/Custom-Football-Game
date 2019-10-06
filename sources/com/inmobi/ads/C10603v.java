package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.inmobi.ads.C10478c.C10490l;
import com.integralads.avid.library.inmobi.session.AbstractAvidAdSession;
import java.lang.ref.WeakReference;

/* renamed from: com.inmobi.ads.v */
/* compiled from: IasTrackedHtmlAd */
public class C10603v extends C10477bz {

    /* renamed from: d */
    private static final String f32292d = C10603v.class.getSimpleName();

    /* renamed from: e */
    private final WeakReference<Activity> f32293e;

    /* renamed from: f */
    private final C10503ca f32294f;

    /* renamed from: g */
    private final AbstractAvidAdSession<WebView> f32295g;

    /* renamed from: h */
    private final boolean f32296h;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.integralads.avid.library.inmobi.session.AbstractAvidAdSession<android.webkit.WebView> m34772a(android.content.Context r4, boolean r5, java.lang.String r6, com.inmobi.rendering.RenderView r7) {
        /*
            com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext r0 = new com.integralads.avid.library.inmobi.session.ExternalAvidAdSessionContext
            java.lang.String r1 = "7.2.7"
            r0.<init>(r1, r5)
            int r5 = r6.hashCode()
            r1 = -284840886(0xffffffffef05ac4a, float:-4.136979E28)
            r2 = 3
            r3 = 2
            if (r5 == r1) goto L_0x0033
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r5 == r1) goto L_0x0029
            r1 = 1425678798(0x54fa21ce, float:8.5944718E12)
            if (r5 == r1) goto L_0x001f
        L_0x001e:
            goto L_0x003d
        L_0x001f:
            java.lang.String r5 = "nonvideo"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x001e
            r5 = 2
            goto L_0x003e
        L_0x0029:
            java.lang.String r5 = "video"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x001e
            r5 = 3
            goto L_0x003e
        L_0x0033:
            java.lang.String r5 = "unknown"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x001e
            r5 = 1
            goto L_0x003e
        L_0x003d:
            r5 = -1
        L_0x003e:
            r6 = 0
            if (r5 == r3) goto L_0x004a
            if (r5 == r2) goto L_0x0045
            r5 = r6
            goto L_0x004f
        L_0x0045:
            com.integralads.avid.library.inmobi.session.AvidVideoAdSession r5 = com.integralads.avid.library.inmobi.session.AvidAdSessionManager.startAvidVideoAdSession(r4, r0)
            goto L_0x004f
        L_0x004a:
            com.integralads.avid.library.inmobi.session.AvidDisplayAdSession r5 = com.integralads.avid.library.inmobi.session.AvidAdSessionManager.startAvidDisplayAdSession(r4, r0)
        L_0x004f:
            if (r5 == 0) goto L_0x005e
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L_0x005b
            android.app.Activity r4 = (android.app.Activity) r4
            r5.registerAdView(r7, r4)
            goto L_0x005e
        L_0x005b:
            r5.registerAdView(r7, r6)
        L_0x005e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.ads.C10603v.m34772a(android.content.Context, boolean, java.lang.String, com.inmobi.rendering.RenderView):com.integralads.avid.library.inmobi.session.AbstractAvidAdSession");
    }

    public C10603v(AdContainer adContainer, Activity activity, C10503ca caVar, AbstractAvidAdSession<WebView> abstractAvidAdSession, boolean z) {
        super(adContainer);
        this.f32293e = new WeakReference<>(activity);
        this.f32294f = caVar;
        this.f32295g = abstractAvidAdSession;
        this.f32296h = z;
    }

    /* renamed from: a */
    public final View mo34004a() {
        return this.f32294f.mo34004a();
    }

    /* renamed from: a */
    public final View mo33956a(View view, ViewGroup viewGroup, boolean z) {
        return this.f32294f.mo33956a(view, viewGroup, z);
    }

    /* renamed from: b */
    public final View mo33960b() {
        return this.f32294f.mo33960b();
    }

    /* renamed from: c */
    public final C10478c mo33961c() {
        return this.f32294f.mo33961c();
    }

    /* renamed from: a */
    public final void mo33959a(View... viewArr) {
        try {
            Activity activity = (Activity) this.f32293e.get();
            C10490l lVar = this.f32294f.mo33961c().f31899k;
            if (activity != null && lVar.f31973j) {
                if (this.f32007a instanceof C10380ah) {
                    C10380ah ahVar = (C10380ah) this.f32007a;
                    if (ahVar.mo34041s() != null) {
                        m34773a(activity, (WebView) ahVar.mo34041s(), viewArr);
                    }
                } else {
                    View b = this.f32294f.mo33960b();
                    if (b != null) {
                        m34773a(activity, (WebView) b, viewArr);
                    }
                }
            }
        } catch (Exception e) {
            new StringBuilder("Exception in startTrackingForImpression with message : ").append(e.getMessage());
        } catch (Throwable th) {
            this.f32294f.mo33959a(viewArr);
            throw th;
        }
        this.f32294f.mo33959a(viewArr);
    }

    /* renamed from: a */
    private void m34773a(Activity activity, WebView webView, View[] viewArr) {
        if (viewArr != null) {
            for (View registerFriendlyObstruction : viewArr) {
                this.f32295g.registerFriendlyObstruction(registerFriendlyObstruction);
            }
        }
        this.f32295g.registerAdView(webView, activity);
        if (this.f32296h && this.f32295g.getAvidDeferredAdSessionListener() != null) {
            this.f32295g.getAvidDeferredAdSessionListener().recordReadyEvent();
        }
    }

    /* renamed from: d */
    public final void mo33962d() {
        View view;
        try {
            if (this.f32007a instanceof C10380ah) {
                view = ((C10380ah) this.f32007a).mo34041s();
            } else {
                view = (WebView) this.f32294f.mo33960b();
            }
            this.f32295g.unregisterAdView(view);
            this.f32295g.endSession();
        } catch (Exception e) {
            new StringBuilder("Exception in stopTrackingForImpression with message : ").append(e.getMessage());
        } catch (Throwable th) {
            this.f32294f.mo33962d();
            throw th;
        }
        this.f32294f.mo33962d();
    }

    /* renamed from: a */
    public final void mo33957a(int i) {
        this.f32294f.mo33957a(i);
    }

    /* renamed from: a */
    public final void mo33958a(Context context, int i) {
        this.f32294f.mo33958a(context, i);
    }

    /* renamed from: e */
    public final void mo33963e() {
        super.mo33963e();
        try {
            this.f32293e.clear();
        } catch (Exception e) {
            new StringBuilder("Exception in destroy with message : ").append(e.getMessage());
        } catch (Throwable th) {
            this.f32294f.mo33963e();
            throw th;
        }
        this.f32294f.mo33963e();
    }
}
