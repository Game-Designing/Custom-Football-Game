package p019d.p022i.p296a.p298b.p299a.p300a;

import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0266a;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.a.a.d */
/* compiled from: SnackbarDismissesOnSubscribe */
final class C13011d implements C0122a<Integer> {

    /* renamed from: a */
    final Snackbar f39984a;

    C13011d(Snackbar view) {
        this.f39984a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super Integer> subscriber) {
        C14521b.verifyMainThread();
        C0266a callback = new C13009b(this, subscriber);
        subscriber.add(new C13010c(this));
        this.f39984a.mo4553a(callback);
    }
}
