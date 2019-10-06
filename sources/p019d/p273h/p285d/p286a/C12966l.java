package p019d.p273h.p285d.p286a;

import java.util.HashMap;

/* renamed from: d.h.d.a.l */
/* compiled from: ViewVisibilityParameters */
class C12966l extends HashMap<String, Boolean> {

    /* renamed from: a */
    final /* synthetic */ C12967m f39910a;

    C12966l(C12967m this$0) {
        this.f39910a = this$0;
        int a = this.f39910a.f39912b;
        boolean z = true;
        Boolean valueOf = Boolean.valueOf(false);
        put("isVisible", Boolean.valueOf(a == 0));
        if (this.f39910a.f39913c != 0) {
            z = false;
        }
        put("isWindowVisible", Boolean.valueOf(z));
        put("isShown", valueOf);
        put("isViewVisible", valueOf);
    }
}
