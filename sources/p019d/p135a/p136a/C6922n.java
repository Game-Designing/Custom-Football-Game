package p019d.p135a.p136a;

import android.net.Uri;
import android.util.Log;
import p019d.p135a.p136a.p137a.C6854i;
import p019d.p135a.p136a.p138b.C6875t;
import p019d.p135a.p136a.p139c.C6886b;
import p019d.p135a.p136a.p139c.C6896i;

/* renamed from: d.a.a.n */
/* compiled from: PaymentStateHandler */
class C6922n implements C6854i {

    /* renamed from: a */
    final /* synthetic */ C6924p f12711a;

    C6922n(C6924p this$0) {
        this.f12711a = this$0;
    }

    /* renamed from: a */
    public void mo22286a(Uri uri) {
        String a = C6924p.f12713a;
        StringBuilder sb = new StringBuilder();
        sb.append("completionWithUri: ");
        sb.append(uri);
        Log.d(a, sb.toString());
        this.f12711a.f12723k = new C6896i(new C6886b(uri));
        this.f12711a.f12727o.mo22283a(C6875t.RETURN_URI_RECEIVED);
    }
}
