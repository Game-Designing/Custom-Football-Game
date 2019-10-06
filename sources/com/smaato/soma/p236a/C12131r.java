package com.smaato.soma.p236a;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.smaato.soma.C12369fa;

/* renamed from: com.smaato.soma.a.r */
/* compiled from: BannerAnimator */
class C12131r implements OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C12125n f38043a;

    /* renamed from: b */
    final /* synthetic */ C12369fa f38044b;

    /* renamed from: c */
    final /* synthetic */ C12137x f38045c;

    C12131r(C12137x this$0, C12125n nVar, C12369fa faVar) {
        this.f38045c = this$0;
        this.f38043a = nVar;
        this.f38044b = faVar;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return ((Boolean) new C12130q(this, v, keyCode, event).execute()).booleanValue();
    }
}
