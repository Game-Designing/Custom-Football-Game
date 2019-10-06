package p019d.p143b.p144a.p147c;

import android.app.AlertDialog.Builder;

/* renamed from: d.b.a.c.fa */
class C7155fa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7135aa f13534a;

    C7155fa(C7135aa aaVar) {
        this.f13534a = aaVar;
    }

    public void run() {
        Builder builder = new Builder(this.f13534a.f13440b);
        builder.setTitle((CharSequence) this.f13534a.f13439a.mo23039a(C7196pb.f13853na));
        builder.setMessage((CharSequence) this.f13534a.f13439a.mo23039a(C7196pb.f13858oa));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) this.f13534a.f13439a.mo23039a(C7196pb.f13868qa), null);
        builder.setNegativeButton((CharSequence) this.f13534a.f13439a.mo23039a(C7196pb.f13863pa), new C7159ga(this));
        this.f13534a.f13441c = builder.show();
    }
}
