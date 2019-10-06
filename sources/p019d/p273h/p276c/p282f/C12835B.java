package p019d.p273h.p276c.p282f;

import android.text.TextUtils;

/* renamed from: d.h.c.f.B */
/* compiled from: ListenersWrapper */
class C12835B implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39544a;

    /* renamed from: b */
    final /* synthetic */ C12858Z f39545b;

    C12835B(C12858Z this$0, String str) {
        this.f39545b = this$0;
        this.f39544a = str;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.f39544a)) {
            this.f39545b.f39599g.mo41615a(this.f39544a);
        }
    }
}
