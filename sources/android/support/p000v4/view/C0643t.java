package android.support.p000v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* renamed from: android.support.v4.view.t */
/* compiled from: PointerIconCompat */
public final class C0643t {

    /* renamed from: a */
    private Object f1860a;

    private C0643t(Object pointerIcon) {
        this.f1860a = pointerIcon;
    }

    /* renamed from: a */
    public Object mo5701a() {
        return this.f1860a;
    }

    /* renamed from: a */
    public static C0643t m2943a(Context context, int style) {
        if (VERSION.SDK_INT >= 24) {
            return new C0643t(PointerIcon.getSystemIcon(context, style));
        }
        return new C0643t(null);
    }
}
