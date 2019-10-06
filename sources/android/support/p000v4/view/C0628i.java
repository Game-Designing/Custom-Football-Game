package android.support.p000v4.view;

import android.support.p000v4.view.C0629j.C0633d;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

/* renamed from: android.support.v4.view.i */
/* compiled from: MenuItemCompat */
class C0628i implements OnActionExpandListener {

    /* renamed from: a */
    final /* synthetic */ C0633d f1851a;

    C0628i(C0633d dVar) {
        this.f1851a = dVar;
    }

    public boolean onMenuItemActionExpand(MenuItem item) {
        return this.f1851a.onMenuItemActionExpand(item);
    }

    public boolean onMenuItemActionCollapse(MenuItem item) {
        return this.f1851a.onMenuItemActionCollapse(item);
    }
}
