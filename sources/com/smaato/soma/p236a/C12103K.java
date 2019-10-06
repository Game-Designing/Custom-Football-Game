package com.smaato.soma.p236a;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* renamed from: com.smaato.soma.a.K */
/* compiled from: VideoChrome */
class C12103K implements OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C12104L f37982a;

    C12103K(C12104L this$2) {
        this.f37982a = this$2;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return ((Boolean) new C12102J(this, v, keyCode, event).execute()).booleanValue();
    }
}
