package android.support.design.internal;

import android.content.Context;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0879p;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.design.internal.b */
/* compiled from: BottomNavigationMenu */
public final class C0216b extends C0873l {
    public C0216b(Context context) {
        super(context);
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo4120a(int group, int id, int categoryOrder, CharSequence title) {
        if (size() + 1 <= 5) {
            mo6756r();
            MenuItem item = super.mo4120a(group, id, categoryOrder, title);
            if (item instanceof C0879p) {
                ((C0879p) item).mo6775c(true);
            }
            mo6755q();
            return item;
        }
        throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }
}
