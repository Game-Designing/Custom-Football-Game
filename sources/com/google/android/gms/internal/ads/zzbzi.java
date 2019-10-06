package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@zzard
public final class zzbzi extends zzaes implements OnGlobalLayoutListener, OnScrollChangedListener, zzcab {

    /* renamed from: b */
    private final WeakReference<View> f26177b;

    /* renamed from: c */
    private final Map<String, WeakReference<View>> f26178c = new HashMap();

    /* renamed from: d */
    private final Map<String, WeakReference<View>> f26179d = new HashMap();

    /* renamed from: e */
    private final Map<String, WeakReference<View>> f26180e = new HashMap();

    /* renamed from: f */
    private zzbyn f26181f;

    /* renamed from: g */
    private zzua f26182g;

    public zzbzi(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzk.zzmd();
        zzbbz.m26408a(view, (OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.m26409a(view, (OnScrollChangedListener) this);
        this.f26177b = new WeakReference<>(view);
        for (Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.f26178c.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.f26180e.putAll(this.f26178c);
        for (Entry entry2 : hashMap2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.f26179d.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.f26180e.putAll(this.f26179d);
        this.f26182g = new zzua(view.getContext(), view);
    }

    /* renamed from: na */
    public final synchronized void mo29545na() {
        if (this.f26181f != null) {
            this.f26181f.mo30975b((zzcab) this);
            this.f26181f = null;
        }
    }

    /* renamed from: d */
    public final synchronized void mo29543d(IObjectWrapper iObjectWrapper) {
        Object H = ObjectWrapper.m22187H(iObjectWrapper);
        if (!(H instanceof zzbyn)) {
            zzbad.m26359d("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.f26181f != null) {
            this.f26181f.mo30975b((zzcab) this);
        }
        if (((zzbyn) H).mo30981i()) {
            this.f26181f = (zzbyn) H;
            this.f26181f.mo30971a((zzcab) this);
            this.f26181f.mo30976c(mo31050a());
            return;
        }
        zzbad.m26355b("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    /* renamed from: b */
    public final FrameLayout mo31053b() {
        return null;
    }

    /* renamed from: a */
    public final View mo31050a() {
        return (View) this.f26177b.get();
    }

    /* renamed from: c */
    public final zzua mo31054c() {
        return this.f26182g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo31052a(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f26180e     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f26178c     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.f26179d     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f26180e     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.f26178c     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzi.mo31052a(java.lang.String, android.view.View, boolean):void");
    }

    /* renamed from: e */
    public final synchronized Map<String, WeakReference<View>> mo31056e() {
        return this.f26180e;
    }

    /* renamed from: d */
    public final synchronized Map<String, WeakReference<View>> mo31055d() {
        return this.f26178c;
    }

    /* renamed from: f */
    public final synchronized Map<String, WeakReference<View>> mo31057f() {
        return this.f26179d;
    }

    /* renamed from: a */
    public final synchronized View mo31051a(String str) {
        WeakReference weakReference;
        weakReference = (WeakReference) this.f26180e.get(str);
        return weakReference == null ? null : (View) weakReference.get();
    }

    /* renamed from: g */
    public final synchronized String mo31058g() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f26181f != null) {
            this.f26181f.mo30965a(view, motionEvent, mo31050a());
        }
        return false;
    }

    public final synchronized void onClick(View view) {
        if (this.f26181f != null) {
            this.f26181f.mo30966a(view, mo31050a(), mo31056e(), mo31055d(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.f26181f != null) {
            this.f26181f.mo30967a(mo31050a(), mo31056e(), mo31055d(), zzbyn.m27957b(mo31050a()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.f26181f != null) {
            this.f26181f.mo30967a(mo31050a(), mo31056e(), mo31055d(), zzbyn.m27957b(mo31050a()));
        }
    }

    /* renamed from: e */
    public final synchronized void mo29544e(IObjectWrapper iObjectWrapper) {
        if (this.f26181f != null) {
            Object H = ObjectWrapper.m22187H(iObjectWrapper);
            if (!(H instanceof View)) {
                zzbad.m26359d("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.f26181f.mo30964a((View) H);
        }
    }
}
