package p019d.p273h.p285d.p286a;

import android.util.Log;

/* renamed from: d.h.d.a.a */
/* compiled from: ISNAdView */
class C12954a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12957d f39880a;

    C12954a(C12957d this$0) {
        this.f39880a = this$0;
    }

    public void run() {
        try {
            this.f39880a.f39890e.mo41813b();
            this.f39880a.removeView(this.f39880a.f39886a);
            if (this.f39880a.f39886a != null) {
                this.f39880a.f39886a.destroy();
            }
            this.f39880a.f39887b = null;
            this.f39880a.f39888c = null;
            this.f39880a.f39889d = null;
            this.f39880a.f39890e.mo41806a();
            this.f39880a.f39890e = null;
        } catch (Exception e) {
            Log.e(this.f39880a.f39891f, "performCleanup | could not destroy ISNAdView");
            e.printStackTrace();
        }
    }
}
