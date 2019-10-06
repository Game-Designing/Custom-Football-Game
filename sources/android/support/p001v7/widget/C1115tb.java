package android.support.p001v7.widget;

import android.support.p001v7.widget.ActionMenuView.C0914e;
import android.support.p001v7.widget.Toolbar.C1020c;
import android.view.MenuItem;

/* renamed from: android.support.v7.widget.tb */
/* compiled from: Toolbar */
class C1115tb implements C0914e {

    /* renamed from: a */
    final /* synthetic */ Toolbar f3699a;

    C1115tb(Toolbar this$0) {
        this.f3699a = this$0;
    }

    public boolean onMenuItemClick(MenuItem item) {
        C1020c cVar = this.f3699a.f3380G;
        if (cVar != null) {
            return cVar.onMenuItemClick(item);
        }
        return false;
    }
}
