package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.vungle.warren.model.Advertisement;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbxx implements zzbzb {

    /* renamed from: a */
    private final Context f26023a;

    /* renamed from: b */
    private final zzbzc f26024b;

    /* renamed from: c */
    private final JSONObject f26025c;

    /* renamed from: d */
    private final zzccj f26026d;

    /* renamed from: e */
    private final zzbyt f26027e;

    /* renamed from: f */
    private final zzdh f26028f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final zzbrt f26029g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final zzbri f26030h;

    /* renamed from: i */
    private final zzcxm f26031i;

    /* renamed from: j */
    private final zzbai f26032j;

    /* renamed from: k */
    private final zzcxv f26033k;

    /* renamed from: l */
    private final zzbmn f26034l;

    /* renamed from: m */
    private final zzbzq f26035m;

    /* renamed from: n */
    private final Clock f26036n;

    /* renamed from: o */
    private final zzbva f26037o;

    /* renamed from: p */
    private final zzdae f26038p;

    /* renamed from: q */
    private boolean f26039q = false;

    /* renamed from: r */
    private boolean f26040r;

    /* renamed from: s */
    private boolean f26041s = false;

    /* renamed from: t */
    private boolean f26042t = false;

    /* renamed from: u */
    private Point f26043u = new Point();

    /* renamed from: v */
    private Point f26044v = new Point();

    /* renamed from: w */
    private long f26045w = 0;

    /* renamed from: x */
    private long f26046x = 0;

    /* renamed from: y */
    private zzaag f26047y;

    public zzbxx(Context context, zzbzc zzbzc, JSONObject jSONObject, zzccj zzccj, zzbyt zzbyt, zzdh zzdh, zzbrt zzbrt, zzbri zzbri, zzcxm zzcxm, zzbai zzbai, zzcxv zzcxv, zzbmn zzbmn, zzbzq zzbzq, Clock clock, zzbva zzbva, zzdae zzdae) {
        this.f26023a = context;
        this.f26024b = zzbzc;
        this.f26025c = jSONObject;
        this.f26026d = zzccj;
        this.f26027e = zzbyt;
        this.f26028f = zzdh;
        this.f26029g = zzbrt;
        this.f26030h = zzbri;
        this.f26031i = zzcxm;
        this.f26032j = zzbai;
        this.f26033k = zzcxv;
        this.f26034l = zzbmn;
        this.f26035m = zzbzq;
        this.f26036n = clock;
        this.f26037o = zzbva;
        this.f26038p = zzdae;
    }

    /* renamed from: a */
    public final void mo30947a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        this.f26043u = new Point();
        this.f26044v = new Point();
        if (!this.f26040r) {
            this.f26037o.mo30923a(view);
            this.f26040r = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.f26034l.mo30743a((Object) this);
        if (map != null) {
            for (Entry value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Entry value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    view3.setOnTouchListener(onTouchListener);
                    view3.setClickable(false);
                }
            }
        }
    }

    /* renamed from: a */
    public final void mo30945a(View view, Map<String, WeakReference<View>> map) {
        this.f26043u = new Point();
        this.f26044v = new Point();
        this.f26037o.mo30924b(view);
        this.f26040r = false;
    }

    /* renamed from: b */
    private final boolean m27923b(String str) {
        JSONObject optJSONObject = this.f26025c.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    /* renamed from: a */
    public final void mo30944a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject a = m27917a(map, map2, view2);
        JSONObject b = m27922b(view2);
        JSONObject c = m27924c(view2);
        JSONObject d = m27926d(view2);
        View view4 = view;
        String b2 = m27921b(view, map);
        m27918a(view, b, a, c, d, b2, m27925c(b2), null, z, false);
    }

    /* renamed from: b */
    private final String m27921b(View view, Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Entry entry : map.entrySet()) {
                if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                    return (String) entry.getKey();
                }
            }
        }
        int n = this.f26027e.mo31016n();
        if (n == 1) {
            return "1099";
        }
        if (n == 2) {
            return "2099";
        }
        if (n == 3 || n != 6) {
            return null;
        }
        return "3099";
    }

    /* renamed from: a */
    public final void mo30952a(String str) {
        m27918a(null, null, null, null, null, str, null, null, false, false);
    }

    /* renamed from: c */
    public final void mo30957c(Bundle bundle) {
        if (bundle == null) {
            zzbad.m26352a("Click data is null. No click is reported.");
        } else if (!m27923b("click_reporting")) {
            zzbad.m26355b("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            m27918a(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzk.zzlg().mo30229a(bundle, (JSONObject) null), false, false);
        }
    }

    /* renamed from: a */
    public final void mo30948a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f26042t) {
            zzbad.m26352a("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!m27927d()) {
            zzbad.m26352a("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            JSONObject a = m27917a(map, map2, view);
            JSONObject b = m27922b(view);
            JSONObject c = m27924c(view);
            JSONObject d = m27926d(view);
            String b2 = m27921b(null, map);
            m27918a(view, b, a, c, d, b2, m27925c(b2), null, z, true);
        }
    }

    /* renamed from: d */
    private final boolean m27927d() {
        return this.f26025c.optBoolean("allow_custom_click_gesture", false);
    }

    /* renamed from: y */
    public final void mo30960y() {
        this.f26042t = true;
    }

    /* renamed from: a */
    private final void m27918a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        String str2 = "has_custom_click_handler";
        Preconditions.m21862a("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.f26025c);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put(str2, this.f26024b.mo31036b(this.f26027e.mo31007e()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put(Advertisement.KEY_TEMPLATE, this.f26027e.mo31016n());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.f26033k.f27605i != null && this.f26033k.f27605i.f24271g);
            jSONObject8.put("custom_mute_enabled", !this.f26027e.mo31011i().isEmpty() && this.f26027e.mo31018p() != null);
            if (this.f26035m.mo31075i() != null && this.f26025c.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.f26036n.mo27935b());
            if (this.f26042t && m27927d()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.f26024b.mo31036b(this.f26027e.mo31007e()) != null) {
                z3 = true;
            }
            jSONObject8.put(str2, z3);
            jSONObject8.put("click_signals", m27928e(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long b = this.f26036n.mo27935b();
            jSONObject9.put("time_from_last_touch_down", b - this.f26045w);
            jSONObject9.put("time_from_last_touch", b - this.f26046x);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbao.m26373a(this.f26026d.mo31110a("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzbad.m26356b("Unable to create click JSON.", e);
        }
    }

    /* renamed from: a */
    public final void mo30943a(View view, MotionEvent motionEvent, View view2) {
        int[] f = m27930f(view2);
        this.f26043u = new Point(((int) motionEvent.getRawX()) - f[0], ((int) motionEvent.getRawY()) - f[1]);
        long b = this.f26036n.mo27935b();
        this.f26046x = b;
        if (motionEvent.getAction() == 0) {
            this.f26045w = b;
            this.f26044v = this.f26043u;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        Point point = this.f26043u;
        obtain.setLocation((float) point.x, (float) point.y);
        this.f26028f.mo31484a(obtain);
        obtain.recycle();
    }

    /* renamed from: b */
    public final void mo30955b(Bundle bundle) {
        if (bundle == null) {
            zzbad.m26352a("Touch event data is null. No touch event is reported.");
        } else if (!m27923b("touch_reporting")) {
            zzbad.m26355b("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            this.f26028f.mo31483a().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
        }
    }

    /* renamed from: b */
    public final void mo30954b() {
        m27919a((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null);
    }

    /* renamed from: a */
    public final void mo30942a(View view) {
        if (!this.f26025c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbad.m26359d("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbzq zzbzq = this.f26035m;
        if (view != null) {
            view.setOnClickListener(zzbzq);
            view.setClickable(true);
            zzbzq.f26216g = new WeakReference<>(view);
        }
    }

    /* renamed from: a */
    public final void mo30951a(zzagd zzagd) {
        if (!this.f26025c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbad.m26359d("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.f26035m.mo31073a(zzagd);
        }
    }

    /* renamed from: r */
    public final void mo30959r() {
        if (this.f26025c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.f26035m.mo31074h();
        }
    }

    /* renamed from: a */
    public final void mo30950a(zzaak zzaak) {
        try {
            if (!this.f26041s) {
                if (zzaak != null || this.f26027e.mo31018p() == null) {
                    this.f26041s = true;
                    this.f26038p.mo31342a(zzaak.mo29360U());
                    mo30956c();
                    return;
                }
                this.f26041s = true;
                this.f26038p.mo31342a(this.f26027e.mo31018p().mo29360U());
                mo30956c();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo30949a(zzaag zzaag) {
        this.f26047y = zzaag;
    }

    /* renamed from: c */
    public final void mo30956c() {
        try {
            if (this.f26047y != null) {
                this.f26047y.onAdMuted();
            }
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }

    /* renamed from: a */
    public final void mo30946a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        m27919a(m27922b(view), m27917a(map, map2, view), m27924c(view), m27926d(view), (JSONObject) null);
    }

    /* renamed from: a */
    public final void mo30941a() {
        Preconditions.m21862a("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f26025c);
            zzbao.m26373a(this.f26026d.mo31110a("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzbad.m26356b("", e);
        }
    }

    /* renamed from: a */
    public final boolean mo30953a(Bundle bundle) {
        if (!m27923b("impression_reporting")) {
            zzbad.m26355b("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return m27919a((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, zzk.zzlg().mo30229a(bundle, (JSONObject) null));
    }

    /* renamed from: a */
    private final boolean m27919a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Preconditions.m21862a("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f26025c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            this.f26026d.mo31114a("/logScionEvent", (zzaho<Object>) new C9536kh<Object>(this));
            this.f26026d.mo31114a("/nativeImpression", (zzaho<Object>) new C9580mh<Object>(this));
            zzbao.m26373a(this.f26026d.mo31110a("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z = this.f26039q;
            if (!z && this.f26031i.f27575z != null) {
                this.f26039q = z | zzk.zzlq().mo30282b(this.f26023a, this.f26032j.f25057a, this.f26031i.f27575z.toString(), this.f26033k.f27602f);
            }
            return true;
        } catch (JSONException e) {
            zzbad.m26356b("Unable to create impression JSON.", e);
            return false;
        }
    }

    /* renamed from: a */
    private final JSONObject m27916a(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", m27914a(rect.right - rect.left));
        jSONObject.put("height", m27914a(rect.bottom - rect.top));
        jSONObject.put("x", m27914a(rect.left));
        jSONObject.put("y", m27914a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00db A[Catch:{ JSONException -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00eb A[Catch:{ JSONException -> 0x0107 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0103 A[Catch:{ JSONException -> 0x0107 }] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject m27922b(android.view.View r14) {
        /*
            r13 = this;
            java.lang.String r0 = "window"
            java.lang.String r1 = "relative_to"
            java.lang.String r2 = "y"
            java.lang.String r3 = "x"
            java.lang.String r4 = "height"
            java.lang.String r5 = "width"
            java.lang.String r6 = "Cannot access method getTemplateTypeName: "
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            if (r14 != 0) goto L_0x0016
            return r7
        L_0x0016:
            r8 = 1
            r9 = 0
            int[] r10 = m27930f(r14)     // Catch:{ Exception -> 0x008a }
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x008a }
            r11.<init>()     // Catch:{ Exception -> 0x008a }
            int r12 = r14.getMeasuredWidth()     // Catch:{ Exception -> 0x008a }
            int r12 = r13.m27914a(r12)     // Catch:{ Exception -> 0x008a }
            r11.put(r5, r12)     // Catch:{ Exception -> 0x008a }
            int r12 = r14.getMeasuredHeight()     // Catch:{ Exception -> 0x008a }
            int r12 = r13.m27914a(r12)     // Catch:{ Exception -> 0x008a }
            r11.put(r4, r12)     // Catch:{ Exception -> 0x008a }
            r12 = r10[r9]     // Catch:{ Exception -> 0x008a }
            int r12 = r13.m27914a(r12)     // Catch:{ Exception -> 0x008a }
            r11.put(r3, r12)     // Catch:{ Exception -> 0x008a }
            r12 = r10[r8]     // Catch:{ Exception -> 0x008a }
            int r12 = r13.m27914a(r12)     // Catch:{ Exception -> 0x008a }
            r11.put(r2, r12)     // Catch:{ Exception -> 0x008a }
            r11.put(r1, r0)     // Catch:{ Exception -> 0x008a }
            java.lang.String r12 = "frame"
            r7.put(r12, r11)     // Catch:{ Exception -> 0x008a }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x008a }
            r11.<init>()     // Catch:{ Exception -> 0x008a }
            boolean r12 = r14.getGlobalVisibleRect(r11)     // Catch:{ Exception -> 0x008a }
            if (r12 == 0) goto L_0x0063
            org.json.JSONObject r0 = r13.m27916a(r11)     // Catch:{ Exception -> 0x008a }
            goto L_0x0084
        L_0x0063:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x008a }
            r11.<init>()     // Catch:{ Exception -> 0x008a }
            r11.put(r5, r9)     // Catch:{ Exception -> 0x008a }
            r11.put(r4, r9)     // Catch:{ Exception -> 0x008a }
            r4 = r10[r9]     // Catch:{ Exception -> 0x008a }
            int r4 = r13.m27914a(r4)     // Catch:{ Exception -> 0x008a }
            r11.put(r3, r4)     // Catch:{ Exception -> 0x008a }
            r3 = r10[r8]     // Catch:{ Exception -> 0x008a }
            int r3 = r13.m27914a(r3)     // Catch:{ Exception -> 0x008a }
            r11.put(r2, r3)     // Catch:{ Exception -> 0x008a }
            r11.put(r1, r0)     // Catch:{ Exception -> 0x008a }
            r0 = r11
        L_0x0084:
            java.lang.String r1 = "visible_bounds"
            r7.put(r1, r0)     // Catch:{ Exception -> 0x008a }
            goto L_0x0090
        L_0x008a:
            r0 = move-exception
            java.lang.String r0 = "Unable to get native ad view bounding box"
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
        L_0x0090:
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzacu.f24051Ze
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r1.mo29599a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x010d
            android.view.ViewParent r14 = r14.getParent()
            if (r14 == 0) goto L_0x00cf
            java.lang.Class r0 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            java.lang.String r1 = "getTemplateTypeName"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            java.lang.Object r14 = r0.invoke(r14, r1)     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ NoSuchMethodException -> 0x00ce, SecurityException -> 0x00c9, IllegalAccessException -> 0x00c4, InvocationTargetException -> 0x00bf }
            goto L_0x00d1
        L_0x00bf:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r6, r14)
            goto L_0x00cf
        L_0x00c4:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r6, r14)
            goto L_0x00cf
        L_0x00c9:
            r14 = move-exception
            com.google.android.gms.internal.ads.zzbad.m26356b(r6, r14)
            goto L_0x00cf
        L_0x00ce:
            r14 = move-exception
        L_0x00cf:
            java.lang.String r14 = ""
        L_0x00d1:
            r0 = -1
            int r1 = r14.hashCode()     // Catch:{ JSONException -> 0x0107 }
            r2 = -2066603854(0xffffffff84d220b2, float:-4.940079E-36)
            if (r1 == r2) goto L_0x00eb
            r2 = 2019754500(0x78630204, float:1.8417067E34)
            if (r1 == r2) goto L_0x00e1
        L_0x00e0:
            goto L_0x00f4
        L_0x00e1:
            java.lang.String r1 = "medium_template"
            boolean r14 = r14.equals(r1)     // Catch:{ JSONException -> 0x0107 }
            if (r14 == 0) goto L_0x00e0
            r0 = 1
            goto L_0x00f4
        L_0x00eb:
            java.lang.String r1 = "small_template"
            boolean r14 = r14.equals(r1)     // Catch:{ JSONException -> 0x0107 }
            if (r14 == 0) goto L_0x00e0
            r0 = 0
        L_0x00f4:
            java.lang.String r14 = "native_template_type"
            if (r0 == 0) goto L_0x0103
            if (r0 == r8) goto L_0x00fe
            r7.put(r14, r9)     // Catch:{ JSONException -> 0x0107 }
            goto L_0x010d
        L_0x00fe:
            r0 = 2
            r7.put(r14, r0)     // Catch:{ JSONException -> 0x0107 }
            goto L_0x010d
        L_0x0103:
            r7.put(r14, r8)     // Catch:{ JSONException -> 0x0107 }
            goto L_0x010d
        L_0x0107:
            r14 = move-exception
            java.lang.String r0 = "Could not log native template signal to JSON"
            com.google.android.gms.internal.ads.zzbad.m26356b(r0, r14)
        L_0x010d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbxx.m27922b(android.view.View):org.json.JSONObject");
    }

    /* renamed from: c */
    private static JSONObject m27924c(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("contained_in_scroll_view", zzaxi.m26130d(view) != -1);
        } catch (Exception e) {
        }
        return jSONObject;
    }

    /* renamed from: d */
    private final JSONObject m27926d(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        String str = "can_show_on_lock_screen";
        try {
            zzk.zzlg();
            jSONObject.put(str, zzaxi.m26129c(view));
            zzk.zzlg();
            jSONObject.put("is_keyguard_locked", zzaxi.m26141i(this.f26023a));
        } catch (JSONException e) {
            zzbad.m26359d("Unable to get lock screen information");
        }
        return jSONObject;
    }

    /* renamed from: a */
    private final JSONObject m27917a(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        Map<String, WeakReference<View>> map3 = map2;
        String str3 = "ad_view";
        String str4 = "relative_to";
        String str5 = "y";
        String str6 = "x";
        String str7 = "height";
        String str8 = "width";
        JSONObject jSONObject2 = new JSONObject();
        if (map == null || view == null) {
            return jSONObject2;
        }
        int[] f = m27930f(view);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            View view2 = (View) ((WeakReference) entry.getValue()).get();
            if (view2 != null) {
                int[] f2 = m27930f(view2);
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                Iterator it2 = it;
                try {
                    jSONObject4.put(str8, m27914a(view2.getMeasuredWidth()));
                    jSONObject4.put(str7, m27914a(view2.getMeasuredHeight()));
                    jSONObject4.put(str6, m27914a(f2[0] - f[0]));
                    jSONObject4.put(str5, m27914a(f2[1] - f[1]));
                    jSONObject4.put(str4, str3);
                    jSONObject3.put("frame", jSONObject4);
                    Rect rect = new Rect();
                    if (view2.getLocalVisibleRect(rect)) {
                        jSONObject = m27916a(rect);
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put(str8, 0);
                        jSONObject.put(str7, 0);
                        jSONObject.put(str6, m27914a(f2[0] - f[0]));
                        jSONObject.put(str5, m27914a(f2[1] - f[1]));
                        jSONObject.put(str4, str3);
                    }
                    jSONObject3.put("visible_bounds", jSONObject);
                    if (view2 instanceof TextView) {
                        TextView textView = (TextView) view2;
                        jSONObject3.put("text_color", textView.getCurrentTextColor());
                        str2 = str3;
                        str = str4;
                        try {
                            jSONObject3.put("font_size", (double) textView.getTextSize());
                            jSONObject3.put(CommandHandler.TEXT, textView.getText());
                        } catch (JSONException e) {
                            zzbad.m26359d("Unable to get asset views information");
                            it = it2;
                            str3 = str2;
                            str4 = str;
                        }
                    } else {
                        str2 = str3;
                        str = str4;
                    }
                    jSONObject3.put("is_clickable", map3 != null && map3.containsKey(entry.getKey()) && view2.isClickable());
                    jSONObject2.put((String) entry.getKey(), jSONObject3);
                    it = it2;
                    str3 = str2;
                    str4 = str;
                } catch (JSONException e2) {
                    str2 = str3;
                    str = str4;
                    zzbad.m26359d("Unable to get asset views information");
                    it = it2;
                    str3 = str2;
                    str4 = str;
                }
            } else {
                String str9 = str3;
                String str10 = str4;
                Iterator it3 = it;
            }
        }
        return jSONObject2;
    }

    /* renamed from: e */
    private final String m27928e(View view) {
        try {
            JSONObject optJSONObject = this.f26025c.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.f26028f.mo31483a().zza(this.f26023a, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzbad.m26356b("Exception obtaining click signals", e);
            return null;
        }
    }

    /* renamed from: c */
    private final JSONObject m27925c(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("click_point", m27929e());
                jSONObject.put("asset_id", str);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            jSONObject = null;
            zzbad.m26356b("Error occurred while grabbing click signals.", e);
            return jSONObject;
        }
        return jSONObject;
    }

    /* renamed from: e */
    private final JSONObject m27929e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", m27914a(this.f26043u.x));
            jSONObject.put("y", m27914a(this.f26043u.y));
            jSONObject.put("start_x", m27914a(this.f26044v.x));
            jSONObject.put("start_y", m27914a(this.f26044v.y));
            return jSONObject;
        } catch (JSONException e) {
            zzbad.m26356b("Error occurred while putting signals into JSON object.", e);
            return null;
        }
    }

    /* renamed from: f */
    private static int[] m27930f(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    /* renamed from: a */
    private final int m27914a(int i) {
        return zzyt.m31532a().mo30315b(this.f26023a, i);
    }

    public final void destroy() {
        this.f26026d.mo31113a();
    }
}
