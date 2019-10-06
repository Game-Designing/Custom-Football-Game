package android.support.p001v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import p002b.p003c.p053g.p056b.p057a.C1224b;
import p002b.p003c.p053g.p056b.p057a.C1225c;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.v7.view.menu.c */
/* compiled from: BaseMenuWrapper */
abstract class C0862c<T> extends C0863d<T> {

    /* renamed from: b */
    final Context f2651b;

    /* renamed from: c */
    private Map<C1224b, MenuItem> f2652c;

    /* renamed from: d */
    private Map<C1225c, SubMenu> f2653d;

    C0862c(Context context, T object) {
        super(object);
        this.f2651b = context;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final MenuItem mo6666a(MenuItem menuItem) {
        if (!(menuItem instanceof C1224b)) {
            return menuItem;
        }
        C1224b supportMenuItem = (C1224b) menuItem;
        if (this.f2652c == null) {
            this.f2652c = new C1253b();
        }
        MenuItem wrappedItem = (MenuItem) this.f2652c.get(menuItem);
        if (wrappedItem == null) {
            wrappedItem = C0894x.m4279a(this.f2651b, supportMenuItem);
            this.f2652c.put(supportMenuItem, wrappedItem);
        }
        return wrappedItem;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final SubMenu mo6667a(SubMenu subMenu) {
        if (!(subMenu instanceof C1225c)) {
            return subMenu;
        }
        C1225c supportSubMenu = (C1225c) subMenu;
        if (this.f2653d == null) {
            this.f2653d = new C1253b();
        }
        SubMenu wrappedMenu = (SubMenu) this.f2653d.get(supportSubMenu);
        if (wrappedMenu == null) {
            wrappedMenu = C0894x.m4280a(this.f2651b, supportSubMenu);
            this.f2653d.put(supportSubMenu, wrappedMenu);
        }
        return wrappedMenu;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo6669b() {
        Map<C1224b, MenuItem> map = this.f2652c;
        if (map != null) {
            map.clear();
        }
        Map<C1225c, SubMenu> map2 = this.f2653d;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo6668a(int groupId) {
        Map<C1224b, MenuItem> map = this.f2652c;
        if (map != null) {
            Iterator<SupportMenuItem> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                if (groupId == ((MenuItem) iterator.next()).getGroupId()) {
                    iterator.remove();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo6670b(int id) {
        Map<C1224b, MenuItem> map = this.f2652c;
        if (map != null) {
            Iterator<SupportMenuItem> iterator = map.keySet().iterator();
            while (true) {
                if (iterator.hasNext()) {
                    if (id == ((MenuItem) iterator.next()).getItemId()) {
                        iterator.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
    }
}
