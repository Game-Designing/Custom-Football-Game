package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.Toolbar.C1020c;
import android.view.MenuItem;
import p026rx.C14980ia;

/* renamed from: d.i.a.b.c.a.l */
/* compiled from: ToolbarItemClickOnSubscribe */
class C13031l implements C1020c {

    /* renamed from: a */
    final /* synthetic */ C14980ia f40006a;

    /* renamed from: b */
    final /* synthetic */ C13033n f40007b;

    C13031l(C13033n this$0, C14980ia iaVar) {
        this.f40007b = this$0;
        this.f40006a = iaVar;
    }

    public boolean onMenuItemClick(MenuItem item) {
        if (!this.f40006a.isUnsubscribed()) {
            this.f40006a.onNext(item);
        }
        return true;
    }
}
