package p019d.p022i.p296a.p306d;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import p026rx.C14980ia;

/* renamed from: d.i.a.d.k */
/* compiled from: TextViewEditorActionEventOnSubscribe */
class C13056k implements OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40040a;

    /* renamed from: b */
    final /* synthetic */ C13058m f40041b;

    C13056k(C13058m this$0, C14980ia iaVar) {
        this.f40041b = this$0;
        this.f40040a = iaVar;
    }

    public boolean onEditorAction(TextView v, int actionId, KeyEvent keyEvent) {
        C13055j event = C13055j.m42508a(v, actionId, keyEvent);
        if (!((Boolean) this.f40041b.f40044b.call(event)).booleanValue()) {
            return false;
        }
        if (!this.f40040a.isUnsubscribed()) {
            this.f40040a.onNext(event);
        }
        return true;
    }
}
