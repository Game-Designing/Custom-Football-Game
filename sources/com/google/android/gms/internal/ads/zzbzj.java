package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzbzj extends zzaen implements OnGlobalLayoutListener, OnScrollChangedListener, zzcab {

    /* renamed from: b */
    public static final String[] f26183b = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};

    /* renamed from: c */
    private final String f26184c;

    /* renamed from: d */
    private Map<String, WeakReference<View>> f26185d = new HashMap();

    /* renamed from: e */
    private FrameLayout f26186e;

    /* renamed from: f */
    private FrameLayout f26187f;

    /* renamed from: g */
    private zzbbl f26188g;

    /* renamed from: h */
    private View f26189h;

    /* renamed from: i */
    private zzbyn f26190i;

    /* renamed from: j */
    private zzua f26191j;

    /* renamed from: k */
    private boolean f26192k = false;

    public zzbzj(FrameLayout frameLayout, FrameLayout frameLayout2) {
        String str;
        this.f26186e = frameLayout;
        this.f26187f = frameLayout2;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.f26184c = str;
        zzk.zzmd();
        zzbbz.m26408a((View) frameLayout, (OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.m26409a((View) frameLayout, (OnScrollChangedListener) this);
        this.f26188g = zzbbm.f25066c;
        this.f26191j = new zzua(this.f26186e.getContext(), this.f26186e);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    /* renamed from: b */
    public final synchronized void mo29538b(String str, IObjectWrapper iObjectWrapper) {
        mo31052a(str, (View) ObjectWrapper.m22187H(iObjectWrapper), true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo31052a(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.f26192k     // Catch:{ all -> 0x0039 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f26185d     // Catch:{ all -> 0x0039 }
            r3.remove(r2)     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f26185d     // Catch:{ all -> 0x0039 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0039 }
            r0.<init>(r3)     // Catch:{ all -> 0x0039 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0039 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x0037
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0039 }
            if (r2 == 0) goto L_0x002b
            goto L_0x0037
        L_0x002b:
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0039 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0039 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)
            return
        L_0x0037:
            monitor-exit(r1)
            return
        L_0x0039:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzj.mo31052a(java.lang.String, android.view.View, boolean):void");
    }

    /* renamed from: f */
    public final synchronized IObjectWrapper mo29542f(String str) {
        return ObjectWrapper.m22188a(mo31051a(str));
    }

    /* renamed from: a */
    public final synchronized View mo31051a(String str) {
        if (this.f26192k) {
            return null;
        }
        WeakReference weakReference = (WeakReference) this.f26185d.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    /* renamed from: d */
    public final synchronized void mo29539d(IObjectWrapper iObjectWrapper) {
        if (!this.f26192k) {
            Object H = ObjectWrapper.m22187H(iObjectWrapper);
            if (!(H instanceof zzbyn)) {
                zzbad.m26359d("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            if (this.f26190i != null) {
                this.f26190i.mo30975b((zzcab) this);
            }
            m28102jb();
            this.f26190i = (zzbyn) H;
            this.f26190i.mo30971a((zzcab) this);
            this.f26190i.mo30976c((View) this.f26186e);
        }
    }

    /* renamed from: jb */
    private final synchronized void m28102jb() {
        this.f26188g.execute(new C9709sh(this));
    }

    public final synchronized void destroy() {
        if (!this.f26192k) {
            if (this.f26190i != null) {
                this.f26190i.mo30975b((zzcab) this);
                this.f26190i = null;
            }
            this.f26185d.clear();
            this.f26186e.removeAllViews();
            this.f26187f.removeAllViews();
            this.f26185d = null;
            this.f26186e = null;
            this.f26187f = null;
            this.f26189h = null;
            this.f26191j = null;
            this.f26192k = true;
        }
    }

    /* renamed from: a */
    public final synchronized void mo29537a(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized void onClick(View view) {
        if (this.f26190i != null) {
            this.f26190i.mo30978f();
            this.f26190i.mo30966a(view, this.f26186e, mo31056e(), mo31055d(), false);
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f26190i != null) {
            this.f26190i.mo30965a(view, motionEvent, this.f26186e);
        }
        return false;
    }

    public final synchronized void onGlobalLayout() {
        if (this.f26190i != null) {
            this.f26190i.mo30967a(this.f26186e, mo31056e(), mo31055d(), zzbyn.m27957b((View) this.f26186e));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.f26190i != null) {
            this.f26190i.mo30967a(this.f26186e, mo31056e(), mo31055d(), zzbyn.m27957b((View) this.f26186e));
        }
    }

    /* renamed from: e */
    public final synchronized Map<String, WeakReference<View>> mo31056e() {
        return this.f26185d;
    }

    /* renamed from: d */
    public final synchronized Map<String, WeakReference<View>> mo31055d() {
        return this.f26185d;
    }

    /* renamed from: f */
    public final synchronized Map<String, WeakReference<View>> mo31057f() {
        return null;
    }

    /* renamed from: g */
    public final synchronized String mo31058g() {
        return this.f26184c;
    }

    /* renamed from: b */
    public final FrameLayout mo31053b() {
        return this.f26187f;
    }

    /* renamed from: c */
    public final zzua mo31054c() {
        return this.f26191j;
    }

    /* renamed from: e */
    public final synchronized void mo29541e(IObjectWrapper iObjectWrapper) {
        this.f26190i.mo30964a((View) ObjectWrapper.m22187H(iObjectWrapper));
    }

    /* renamed from: a */
    public final /* synthetic */ View mo31050a() {
        return this.f26186e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: ib */
    public final /* synthetic */ void mo31063ib() {
        if (this.f26189h == null) {
            this.f26189h = new View(this.f26186e.getContext());
            this.f26189h.setLayoutParams(new LayoutParams(-1, 0));
        }
        if (this.f26186e != this.f26189h.getParent()) {
            this.f26186e.addView(this.f26189h);
        }
    }
}
