package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import p026rx.C14980ia;

/* renamed from: d.i.a.c.f */
/* compiled from: ViewFocusChangeOnSubscribe */
class C13039f implements OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40015a;

    /* renamed from: b */
    final /* synthetic */ C13041h f40016b;

    C13039f(C13041h this$0, C14980ia iaVar) {
        this.f40016b = this$0;
        this.f40015a = iaVar;
    }

    public void onFocusChange(View v, boolean hasFocus) {
        if (!this.f40015a.isUnsubscribed()) {
            this.f40015a.onNext(Boolean.valueOf(hasFocus));
        }
    }
}
