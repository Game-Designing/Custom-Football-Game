package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ironsource.sdk.controller.C10877y.C10884f;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p285d.p291e.C12980b;
import p019d.p273h.p285d.p292f.C12991g;

/* renamed from: com.ironsource.sdk.controller.j */
/* compiled from: ControllerView */
public class C10857j extends FrameLayout implements C12991g {

    /* renamed from: a */
    private Context f33111a;

    /* renamed from: b */
    private C10877y f33112b;

    public C10857j(Context context) {
        super(context);
        this.f33111a = context;
        setClickable(true);
    }

    /* renamed from: a */
    public void mo35434a(C10877y webView) {
        this.f33112b = webView;
        this.f33112b.setOnWebViewControllerChangeListener(this);
        this.f33112b.requestFocus();
        this.f33111a = this.f33112b.getCurrentActivityContext();
        m35427a(getStatusBarPadding(), getNavigationBarPadding());
        m35428c();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f33112b.mo35507m();
        this.f33112b.mo35472a(true, "main");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f33112b.mo35505k();
        this.f33112b.mo35472a(false, "main");
        C10877y yVar = this.f33112b;
        if (yVar != null) {
            yVar.setState(C10884f.Gone);
            this.f33112b.mo35506l();
        }
        removeAllViews();
    }

    /* renamed from: c */
    private void m35428c() {
        ((Activity) this.f33111a).runOnUiThread(new C10853h(this));
    }

    /* renamed from: d */
    private void m35429d() {
        ((Activity) this.f33111a).runOnUiThread(new C10855i(this));
    }

    /* access modifiers changed from: private */
    public ViewGroup getWindowDecorViewGroup() {
        Activity activity = (Activity) this.f33111a;
        if (activity != null) {
            return (ViewGroup) activity.getWindow().getDecorView();
        }
        return null;
    }

    /* renamed from: a */
    private void m35427a(int statusBarHeight, int navigationBarSize) {
        try {
            if (this.f33111a != null) {
                int orientation = C12725c.m41095e(this.f33111a);
                if (orientation == 1) {
                    setPadding(0, statusBarHeight, 0, navigationBarSize);
                } else if (orientation == 2) {
                    setPadding(0, statusBarHeight, navigationBarSize, 0);
                }
            }
        } catch (Exception e) {
        }
    }

    private int getStatusBarPadding() {
        int i = 0;
        if ((((Activity) this.f33111a).getWindow().getAttributes().flags & Opcodes.ACC_ABSTRACT) != 0) {
            return 0;
        }
        int top = getStatusBarHeight();
        if (top > 0) {
            i = top;
        }
        return i;
    }

    private int getStatusBarHeight() {
        try {
            if (this.f33111a == null) {
                return 0;
            }
            int resourceId = this.f33111a.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                return this.f33111a.getResources().getDimensionPixelSize(resourceId);
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private int getNavigationBarPadding() {
        Activity activity = (Activity) this.f33111a;
        int i = 0;
        try {
            if (VERSION.SDK_INT > 9) {
                Rect screenRect = new Rect();
                activity.getWindow().getDecorView().getDrawingRect(screenRect);
                Rect visibleFrame = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(visibleFrame);
                if (C12725c.m41095e(activity) == 1) {
                    if (screenRect.bottom - visibleFrame.bottom > 0) {
                        i = screenRect.bottom - visibleFrame.bottom;
                    }
                    return i;
                }
                if (screenRect.right - visibleFrame.right > 0) {
                    i = screenRect.right - visibleFrame.right;
                }
                return i;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    /* renamed from: b */
    public void mo35357b() {
        m35429d();
    }

    /* renamed from: a */
    public void mo35354a(String orientation, int rotation) {
    }

    /* renamed from: a */
    public boolean mo35356a() {
        return C12980b.m42339a().mo41856a((Activity) this.f33111a);
    }
}
