package p019d.p143b.p144a.p147c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: d.b.a.c.W */
class C7120W implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C7117V f13396a;

    C7120W(C7117V v) {
        this.f13396a = v;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.f13396a.f13392b.f13387f.schedule(new C7123X(this), 200);
    }
}
