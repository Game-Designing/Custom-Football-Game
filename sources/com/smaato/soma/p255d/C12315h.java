package com.smaato.soma.p255d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.smaato.soma.C12369fa;

/* renamed from: com.smaato.soma.d.h */
/* compiled from: BannerMeasurements */
public class C12315h {

    /* renamed from: a */
    private static C12315h f38501a;

    /* renamed from: b */
    private static long f38502b = 0;

    private C12315h() {
    }

    /* renamed from: c */
    public static final C12315h m40496c() {
        if (f38501a == null) {
            f38501a = new C12315h();
        }
        return f38501a;
    }

    /* renamed from: b */
    public final void mo39734b() {
        f38502b = System.currentTimeMillis();
    }

    /* renamed from: a */
    public final void mo39732a() {
        if (System.currentTimeMillis() - f38502b <= 3000) {
            C12319l.m40504b().mo39735a(C12316i.AUTO_CLICK);
        }
    }

    /* renamed from: a */
    public final void mo39733a(C12369fa baseView) {
        new C12314g(this, baseView).execute();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public boolean m40499d(C12369fa baseView) {
        ViewGroup vg = (ViewGroup) baseView.getParent();
        if (vg == null) {
            return false;
        }
        for (int i = 0; i < vg.getChildCount(); i++) {
            if (vg.getChildAt(i) != baseView && m40493a(baseView, vg.getChildAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m40493a(C12369fa baseView, View childAt) {
        return Rect.intersects(new Rect(baseView.getLeft(), baseView.getTop(), baseView.getRight(), baseView.getBottom()), new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m40495b(C12369fa baseView) {
        return baseView.getWidth() >= 320 || baseView.getHeight() >= 50;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m40498c(C12369fa baseView) {
        return baseView.getGlobalVisibleRect(new Rect(baseView.getLeft(), baseView.getTop(), baseView.getRight(), baseView.getBottom()));
    }
}
