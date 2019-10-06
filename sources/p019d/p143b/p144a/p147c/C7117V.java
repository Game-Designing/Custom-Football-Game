package p019d.p143b.p144a.p147c;

import android.app.AlertDialog.Builder;
import p019d.p143b.p150d.C7251a;

/* renamed from: d.b.a.c.V */
class C7117V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7251a f13391a;

    /* renamed from: b */
    final /* synthetic */ C7114U f13392b;

    C7117V(C7114U u, C7251a aVar) {
        this.f13392b = u;
        this.f13391a = aVar;
    }

    public void run() {
        Builder builder = new Builder(this.f13392b.f13384c);
        builder.setTitle((CharSequence) this.f13392b.f13382a.mo23039a(C7196pb.f13772X));
        builder.setMessage((CharSequence) this.f13392b.f13382a.mo23039a(C7196pb.f13776Y));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f13392b.f13382a.mo23039a(C7196pb.f13780Z), new C7120W(this));
        builder.setNegativeButton((CharSequence) this.f13392b.f13382a.mo23039a(C7196pb.f13788aa), new C7126Y(this));
        builder.show();
    }
}
