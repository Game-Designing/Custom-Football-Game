package p019d.p022i.p296a.p305c;

import android.view.View;
import android.view.View.OnLongClickListener;
import p026rx.C14980ia;

/* renamed from: d.i.a.c.i */
/* compiled from: ViewLongClickOnSubscribe */
class C13042i implements OnLongClickListener {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40019a;

    /* renamed from: b */
    final /* synthetic */ C13044k f40020b;

    C13042i(C13044k this$0, C14980ia iaVar) {
        this.f40020b = this$0;
        this.f40019a = iaVar;
    }

    public boolean onLongClick(View v) {
        if (!((Boolean) this.f40020b.f40023b.call()).booleanValue()) {
            return false;
        }
        if (!this.f40019a.isUnsubscribed()) {
            this.f40019a.onNext(null);
        }
        return true;
    }
}
