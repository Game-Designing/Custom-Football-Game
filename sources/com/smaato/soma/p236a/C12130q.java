package com.smaato.soma.p236a;

import android.view.KeyEvent;
import android.view.View;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.a.q */
/* compiled from: BannerAnimator */
class C12130q extends C12398ha<Boolean> {

    /* renamed from: a */
    final /* synthetic */ View f38039a;

    /* renamed from: b */
    final /* synthetic */ int f38040b;

    /* renamed from: c */
    final /* synthetic */ KeyEvent f38041c;

    /* renamed from: d */
    final /* synthetic */ C12131r f38042d;

    C12130q(C12131r this$1, View view, int i, KeyEvent keyEvent) {
        this.f38042d = this$1;
        this.f38039a = view;
        this.f38040b = i;
        this.f38041c = keyEvent;
    }

    public Boolean process() throws Exception {
        View view = this.f38039a;
        Boolean valueOf = Boolean.valueOf(false);
        if (view == null || this.f38040b != 4 || this.f38041c.getAction() != 1 || this.f38042d.f38043a == null) {
            return valueOf;
        }
        C12146d.m39965a(new C12147e("BannerAnimator", "Back pressed", 1, C12143a.DEBUG));
        this.f38042d.f38044b.getBannerAnimatorHandler().sendMessage(this.f38042d.f38044b.getBannerAnimatorHandler().obtainMessage(102));
        C12131r rVar = this.f38042d;
        rVar.f38045c.mo39376a(rVar.f38043a, rVar.f38044b);
        return Boolean.valueOf(true);
    }
}
