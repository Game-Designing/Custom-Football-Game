package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import com.google.android.gms.ads.internal.zzk;

@zzard
public final class zzazs {

    /* renamed from: a */
    private final View f25035a;

    /* renamed from: b */
    private Activity f25036b;

    /* renamed from: c */
    private boolean f25037c;

    /* renamed from: d */
    private boolean f25038d;

    /* renamed from: e */
    private boolean f25039e;

    /* renamed from: f */
    private OnGlobalLayoutListener f25040f;

    /* renamed from: g */
    private OnScrollChangedListener f25041g = null;

    public zzazs(Activity activity, View view, OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        this.f25036b = activity;
        this.f25035a = view;
        this.f25040f = onGlobalLayoutListener;
    }

    /* renamed from: a */
    public final void mo30308a(Activity activity) {
        this.f25036b = activity;
    }

    /* renamed from: c */
    public final void mo30310c() {
        this.f25039e = true;
        if (this.f25038d) {
            m26295e();
        }
    }

    /* renamed from: d */
    public final void mo30311d() {
        this.f25039e = false;
        m26296f();
    }

    /* renamed from: a */
    public final void mo30307a() {
        this.f25038d = true;
        if (this.f25039e) {
            m26295e();
        }
    }

    /* renamed from: b */
    public final void mo30309b() {
        this.f25038d = false;
        m26296f();
    }

    /* renamed from: e */
    private final void m26295e() {
        if (!this.f25037c) {
            OnGlobalLayoutListener onGlobalLayoutListener = this.f25040f;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.f25036b;
                if (activity != null) {
                    ViewTreeObserver b = m26294b(activity);
                    if (b != null) {
                        b.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    }
                }
                zzk.zzmd();
                zzbbz.m26408a(this.f25035a, this.f25040f);
            }
            this.f25037c = true;
        }
    }

    /* renamed from: f */
    private final void m26296f() {
        Activity activity = this.f25036b;
        if (activity != null && this.f25037c) {
            OnGlobalLayoutListener onGlobalLayoutListener = this.f25040f;
            if (onGlobalLayoutListener != null) {
                ViewTreeObserver b = m26294b(activity);
                if (b != null) {
                    zzk.zzli().mo30252a(b, onGlobalLayoutListener);
                }
            }
            this.f25037c = false;
        }
    }

    /* renamed from: b */
    private static ViewTreeObserver m26294b(Activity activity) {
        if (activity == null) {
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
