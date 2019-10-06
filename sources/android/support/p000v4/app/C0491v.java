package android.support.p000v4.app;

/* renamed from: android.support.v4.app.v */
/* compiled from: FragmentManager */
class C0491v implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0492w f1620a;

    C0491v(C0492w this$1) {
        this.f1620a = this$1;
    }

    public void run() {
        if (this.f1620a.f1622c.getAnimatingAway() != null) {
            this.f1620a.f1622c.setAnimatingAway(null);
            C0492w wVar = this.f1620a;
            C0409A a = wVar.f1623d;
            Fragment fragment = wVar.f1622c;
            a.mo4917a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
