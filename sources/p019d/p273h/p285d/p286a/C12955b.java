package p019d.p273h.p285d.p286a;

/* renamed from: d.h.d.a.b */
/* compiled from: ISNAdView */
class C12955b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39881a;

    /* renamed from: b */
    final /* synthetic */ String f39882b;

    /* renamed from: c */
    final /* synthetic */ C12957d f39883c;

    C12955b(C12957d this$0, String str, String str2) {
        this.f39883c = this$0;
        this.f39881a = str;
        this.f39882b = str2;
    }

    public void run() {
        if (this.f39883c.f39886a == null) {
            this.f39883c.m42217b(this.f39881a);
        }
        C12957d dVar = this.f39883c;
        dVar.addView(dVar.f39886a);
        this.f39883c.f39886a.loadUrl(this.f39882b);
    }
}
