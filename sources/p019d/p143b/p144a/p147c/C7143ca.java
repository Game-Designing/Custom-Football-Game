package p019d.p143b.p144a.p147c;

import android.app.AlertDialog.Builder;

/* renamed from: d.b.a.c.ca */
class C7143ca implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7135aa f13481a;

    C7143ca(C7135aa aaVar) {
        this.f13481a = aaVar;
    }

    public void run() {
        Builder builder = new Builder(this.f13481a.f13440b);
        builder.setTitle((CharSequence) this.f13481a.f13439a.mo23039a(C7196pb.f13828ia));
        builder.setMessage((CharSequence) this.f13481a.f13439a.mo23039a(C7196pb.f13833ja));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f13481a.f13439a.mo23039a(C7196pb.f13843la), new C7147da(this));
        builder.setNegativeButton((CharSequence) this.f13481a.f13439a.mo23039a(C7196pb.f13838ka), new C7151ea(this));
        this.f13481a.f13441c = builder.show();
    }
}
