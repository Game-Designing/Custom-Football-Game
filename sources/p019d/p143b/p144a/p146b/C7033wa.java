package p019d.p143b.p144a.p146b;

import android.view.View;

/* renamed from: d.b.a.b.wa */
class C7033wa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6988a f13126a;

    C7033wa(C6988a aVar) {
        this.f13126a = aVar;
    }

    public void run() {
        this.f13126a.m14396s();
        if (this.f13126a.f12958b != null && this.f13126a.f12968l != null && this.f13126a.f12968l.getParent() == null) {
            this.f13126a.f12958b.addView(this.f13126a.f12968l);
            C6988a.m14379b((View) this.f13126a.f12968l, this.f13126a.f12972p.mo22756a());
        }
    }
}
