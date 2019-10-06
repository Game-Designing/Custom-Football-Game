package p002b.p003c.p062h.p071g;

import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.view.View;

/* renamed from: b.c.h.g.h */
/* compiled from: ViewPropertyAnimatorCompatSet */
class C1310h extends C0590K {

    /* renamed from: a */
    private boolean f4185a = false;

    /* renamed from: b */
    private int f4186b = 0;

    /* renamed from: c */
    final /* synthetic */ C1311i f4187c;

    C1310h(C1311i this$0) {
        this.f4187c = this$0;
    }

    public void onAnimationStart(View view) {
        if (!this.f4185a) {
            this.f4185a = true;
            C0589J j = this.f4187c.f4191d;
            if (j != null) {
                j.onAnimationStart(null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo9266a() {
        this.f4186b = 0;
        this.f4185a = false;
        this.f4187c.mo9273b();
    }

    public void onAnimationEnd(View view) {
        int i = this.f4186b + 1;
        this.f4186b = i;
        if (i == this.f4187c.f4188a.size()) {
            C0589J j = this.f4187c.f4191d;
            if (j != null) {
                j.onAnimationEnd(null);
            }
            mo9266a();
        }
    }
}
