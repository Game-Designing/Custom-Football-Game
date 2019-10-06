package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnClickListener;
import p026rx.C14980ia;

/* renamed from: d.i.a.c.b */
/* compiled from: ViewClickOnSubscribe */
class C13035b implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40010a;

    /* renamed from: b */
    final /* synthetic */ C13037d f40011b;

    C13035b(C13037d this$0, C14980ia iaVar) {
        this.f40011b = this$0;
        this.f40010a = iaVar;
    }

    public void onClick(View v) {
        if (!this.f40010a.isUnsubscribed()) {
            this.f40010a.onNext(null);
        }
    }
}
