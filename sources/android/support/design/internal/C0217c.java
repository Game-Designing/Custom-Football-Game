package android.support.design.internal;

import android.support.p001v7.view.menu.C0890v;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.design.internal.c */
/* compiled from: BottomNavigationMenuView */
class C0217c implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0218d f742a;

    C0217c(C0218d this$0) {
        this.f742a = this$0;
    }

    public void onClick(View v) {
        MenuItem item = ((C0215a) v).getItemData();
        if (!this.f742a.f758p.mo6714a(item, (C0890v) this.f742a.f757o, 0)) {
            item.setChecked(true);
        }
    }
}
