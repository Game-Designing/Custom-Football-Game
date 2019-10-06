package p019d.p022i.p296a.p298b.p299a.p300a;

import android.support.design.widget.Snackbar;
import android.support.design.widget.Snackbar.C0266a;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.a.a.b */
/* compiled from: SnackbarDismissesOnSubscribe */
class C13009b extends C0266a {

    /* renamed from: a */
    final /* synthetic */ C14980ia f39981a;

    /* renamed from: b */
    final /* synthetic */ C13011d f39982b;

    C13009b(C13011d this$0, C14980ia iaVar) {
        this.f39982b = this$0;
        this.f39981a = iaVar;
    }

    public void onDismissed(Snackbar snackbar, int event) {
        if (!this.f39981a.isUnsubscribed()) {
            this.f39981a.onNext(Integer.valueOf(event));
        }
    }
}
