package android.support.p001v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p002b.p003c.p053g.p056b.p057a.C1223a;
import p002b.p003c.p053g.p056b.p057a.C1224b;
import p002b.p003c.p053g.p056b.p057a.C1225c;

/* renamed from: android.support.v7.view.menu.x */
/* compiled from: MenuWrapperFactory */
public final class C0894x {
    /* renamed from: a */
    public static Menu m4278a(Context context, C1223a supportMenu) {
        return new C0895y(context, supportMenu);
    }

    /* renamed from: a */
    public static MenuItem m4279a(Context context, C1224b supportMenuItem) {
        if (VERSION.SDK_INT >= 16) {
            return new C0885r(context, supportMenuItem);
        }
        return new C0880q(context, supportMenuItem);
    }

    /* renamed from: a */
    public static SubMenu m4280a(Context context, C1225c supportSubMenu) {
        return new C0859E(context, supportSubMenu);
    }
}
