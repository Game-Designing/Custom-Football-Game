package android.support.p001v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p002b.p003c.p053g.p056b.p057a.C1225c;

/* renamed from: android.support.v7.view.menu.E */
/* compiled from: SubMenuWrapperICS */
class C0859E extends C0895y implements SubMenu {
    C0859E(Context context, C1225c subMenu) {
        super(context, subMenu);
    }

    /* renamed from: c */
    public C1225c mo6579c() {
        return (C1225c) this.f2654a;
    }

    public SubMenu setHeaderTitle(int titleRes) {
        mo6579c().setHeaderTitle(titleRes);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence title) {
        mo6579c().setHeaderTitle(title);
        return this;
    }

    public SubMenu setHeaderIcon(int iconRes) {
        mo6579c().setHeaderIcon(iconRes);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable icon) {
        mo6579c().setHeaderIcon(icon);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        mo6579c().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        mo6579c().clearHeader();
    }

    public SubMenu setIcon(int iconRes) {
        mo6579c().setIcon(iconRes);
        return this;
    }

    public SubMenu setIcon(Drawable icon) {
        mo6579c().setIcon(icon);
        return this;
    }

    public MenuItem getItem() {
        return mo6666a(mo6579c().getItem());
    }
}
