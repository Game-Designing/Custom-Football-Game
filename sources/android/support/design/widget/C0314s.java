package android.support.design.widget;

import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.view.MenuItem;

/* renamed from: android.support.design.widget.s */
/* compiled from: BottomNavigationView */
class C0314s implements C0874a {

    /* renamed from: a */
    final /* synthetic */ BottomNavigationView f1128a;

    C0314s(BottomNavigationView this$0) {
        this.f1128a = this$0;
    }

    /* renamed from: a */
    public boolean mo4699a(C0873l menu, MenuItem item) {
        boolean z = true;
        if (this.f1128a.f844h == null || item.getItemId() != this.f1128a.getSelectedItemId()) {
            if (this.f1128a.f843g == null || this.f1128a.f843g.mo4269a(item)) {
                z = false;
            }
            return z;
        }
        this.f1128a.f844h.mo4268a(item);
        return true;
    }

    /* renamed from: a */
    public void mo4698a(C0873l menu) {
    }
}
