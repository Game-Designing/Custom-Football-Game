package com.smaato.soma.p236a;

import android.view.KeyEvent;
import android.view.View;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.a.J */
/* compiled from: VideoChrome */
class C12102J extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ View f37978a;

    /* renamed from: b */
    final /* synthetic */ int f37979b;

    /* renamed from: c */
    final /* synthetic */ KeyEvent f37980c;

    /* renamed from: d */
    final /* synthetic */ C12103K f37981d;

    C12102J(C12103K this$3, View view, int i, KeyEvent keyEvent) {
        this.f37981d = this$3;
        this.f37978a = view;
        this.f37979b = i;
        this.f37980c = keyEvent;
    }

    public Boolean process() throws Exception {
        View view = this.f37978a;
        Boolean valueOf = Boolean.valueOf(false);
        if (view == null || this.f37979b != 4 || this.f37980c.getAction() != 1) {
            return valueOf;
        }
        C12146d.m39965a(new C12147e("VideoTest", "Back key pressed", 1, C12143a.DEBUG));
        this.f37981d.f37982a.f37986d.mo39326a();
        return Boolean.valueOf(true);
    }
}
