package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzcae implements zzbzb {

    /* renamed from: a */
    private final zzana f26241a;

    /* renamed from: b */
    private final zzand f26242b;

    /* renamed from: c */
    private final zzang f26243c;

    /* renamed from: d */
    private final zzbrt f26244d;

    /* renamed from: e */
    private final zzbri f26245e;

    /* renamed from: f */
    private final Context f26246f;

    /* renamed from: g */
    private final zzcxm f26247g;

    /* renamed from: h */
    private final zzbai f26248h;

    /* renamed from: i */
    private final zzcxv f26249i;

    /* renamed from: j */
    private boolean f26250j = false;

    /* renamed from: k */
    private boolean f26251k = false;

    public zzcae(zzana zzana, zzand zzand, zzang zzang, zzbrt zzbrt, zzbri zzbri, Context context, zzcxm zzcxm, zzbai zzbai, zzcxv zzcxv) {
        this.f26241a = zzana;
        this.f26242b = zzand;
        this.f26243c = zzang;
        this.f26244d = zzbrt;
        this.f26245e = zzbri;
        this.f26246f = context;
        this.f26247g = zzcxm;
        this.f26248h = zzbai;
        this.f26249i = zzcxv;
    }

    /* renamed from: a */
    public final void mo30947a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        try {
            IObjectWrapper a = ObjectWrapper.m22188a(view);
            HashMap a2 = m28147a(map);
            HashMap a3 = m28147a(map2);
            if (this.f26243c != null) {
                this.f26243c.mo29935a(a, ObjectWrapper.m22188a(a2), ObjectWrapper.m22188a(a3));
            } else if (this.f26241a != null) {
                this.f26241a.mo29895a(a, ObjectWrapper.m22188a(a2), ObjectWrapper.m22188a(a3));
                this.f26241a.mo29897c(a);
            } else {
                if (this.f26242b != null) {
                    this.f26242b.mo29917a(a, ObjectWrapper.m22188a(a2), ObjectWrapper.m22188a(a3));
                    this.f26242b.mo29919c(a);
                }
            }
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to call trackView", e);
        }
    }

    /* renamed from: a */
    private static HashMap<String, View> m28147a(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    /* renamed from: a */
    public final void mo30945a(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper a = ObjectWrapper.m22188a(view);
            if (this.f26243c != null) {
                this.f26243c.mo29936b(a);
            } else if (this.f26241a != null) {
                this.f26241a.mo29896b(a);
            } else {
                if (this.f26242b != null) {
                    this.f26242b.mo29918b(a);
                }
            }
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to call untrackView", e);
        }
    }

    /* renamed from: a */
    public final void mo30944a(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f26251k || !this.f26247g.f27538D) {
            m28148b(view);
        }
    }

    /* renamed from: b */
    private final void m28148b(View view) {
        try {
            if (this.f26243c != null && !this.f26243c.mo29933F()) {
                this.f26243c.mo29934a(ObjectWrapper.m22188a(view));
                this.f26245e.onAdClicked();
            } else if (this.f26241a == null || this.f26241a.mo29893F()) {
                if (this.f26242b != null && !this.f26242b.mo29914F()) {
                    this.f26242b.mo29916a(ObjectWrapper.m22188a(view));
                    this.f26245e.onAdClicked();
                }
            } else {
                this.f26241a.mo29894a(ObjectWrapper.m22188a(view));
                this.f26245e.onAdClicked();
            }
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to call handleClick", e);
        }
    }

    /* renamed from: c */
    public final void mo30957c(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo30952a(String str) {
    }

    /* renamed from: a */
    public final void mo30948a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.f26251k) {
            zzbad.m26359d("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.f26247g.f27538D) {
            zzbad.m26359d("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            m28148b(view);
        }
    }

    /* renamed from: y */
    public final void mo30960y() {
        this.f26251k = true;
    }

    /* renamed from: a */
    public final void mo30946a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.f26250j && this.f26247g.f27575z != null) {
                this.f26250j |= zzk.zzlq().mo30282b(this.f26246f, this.f26248h.f25057a, this.f26247g.f27575z.toString(), this.f26249i.f27602f);
            }
            if (this.f26243c != null && !this.f26243c.mo29932C()) {
                this.f26243c.recordImpression();
                this.f26244d.mo30877G();
            } else if (this.f26241a == null || this.f26241a.mo29892C()) {
                if (this.f26242b != null && !this.f26242b.mo29913C()) {
                    this.f26242b.recordImpression();
                    this.f26244d.mo30877G();
                }
            } else {
                this.f26241a.recordImpression();
                this.f26244d.mo30877G();
            }
        } catch (RemoteException e) {
            zzbad.m26358c("Failed to call recordImpression", e);
        }
    }

    /* renamed from: a */
    public final void mo30941a() {
    }

    /* renamed from: a */
    public final boolean mo30953a(Bundle bundle) {
        return false;
    }

    /* renamed from: b */
    public final void mo30954b() {
    }

    /* renamed from: a */
    public final void mo30943a(View view, MotionEvent motionEvent, View view2) {
    }

    /* renamed from: b */
    public final void mo30955b(Bundle bundle) {
    }

    /* renamed from: a */
    public final void mo30942a(View view) {
    }

    /* renamed from: a */
    public final void mo30951a(zzagd zzagd) {
    }

    /* renamed from: r */
    public final void mo30959r() {
    }

    /* renamed from: a */
    public final void mo30950a(zzaak zzaak) {
        zzbad.m26359d("Mute This Ad is not supported for 3rd party ads");
    }

    /* renamed from: a */
    public final void mo30949a(zzaag zzaag) {
        zzbad.m26359d("Mute This Ad is not supported for 3rd party ads");
    }

    /* renamed from: c */
    public final void mo30956c() {
        zzbad.m26359d("Mute This Ad is not supported for 3rd party ads");
    }

    public final void destroy() {
    }
}
