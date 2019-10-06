package android.support.p001v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import p002b.p003c.p053g.p056b.p057a.C1223a;

/* renamed from: android.support.v7.view.menu.y */
/* compiled from: MenuWrapperICS */
class C0895y extends C0862c<C1223a> implements Menu {
    C0895y(Context context, C1223a object) {
        super(context, object);
    }

    public MenuItem add(CharSequence title) {
        return mo6666a(((C1223a) this.f2654a).add(title));
    }

    public MenuItem add(int titleRes) {
        return mo6666a(((C1223a) this.f2654a).add(titleRes));
    }

    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return mo6666a(((C1223a) this.f2654a).add(groupId, itemId, order, title));
    }

    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return mo6666a(((C1223a) this.f2654a).add(groupId, itemId, order, titleRes));
    }

    public SubMenu addSubMenu(CharSequence title) {
        return mo6667a(((C1223a) this.f2654a).addSubMenu(title));
    }

    public SubMenu addSubMenu(int titleRes) {
        return mo6667a(((C1223a) this.f2654a).addSubMenu(titleRes));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return mo6667a(((C1223a) this.f2654a).addSubMenu(groupId, itemId, order, title));
    }

    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return mo6667a(((C1223a) this.f2654a).addSubMenu(groupId, itemId, order, titleRes));
    }

    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        MenuItem[] menuItemArr = outSpecificItems;
        MenuItem[] items = null;
        if (menuItemArr != null) {
            items = new MenuItem[menuItemArr.length];
        }
        int result = ((C1223a) this.f2654a).addIntentOptions(groupId, itemId, order, caller, specifics, intent, flags, items);
        if (items != null) {
            int z = items.length;
            for (int i = 0; i < z; i++) {
                menuItemArr[i] = mo6666a(items[i]);
            }
        }
        return result;
    }

    public void removeItem(int id) {
        mo6670b(id);
        ((C1223a) this.f2654a).removeItem(id);
    }

    public void removeGroup(int groupId) {
        mo6668a(groupId);
        ((C1223a) this.f2654a).removeGroup(groupId);
    }

    public void clear() {
        mo6669b();
        ((C1223a) this.f2654a).clear();
    }

    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        ((C1223a) this.f2654a).setGroupCheckable(group, checkable, exclusive);
    }

    public void setGroupVisible(int group, boolean visible) {
        ((C1223a) this.f2654a).setGroupVisible(group, visible);
    }

    public void setGroupEnabled(int group, boolean enabled) {
        ((C1223a) this.f2654a).setGroupEnabled(group, enabled);
    }

    public boolean hasVisibleItems() {
        return ((C1223a) this.f2654a).hasVisibleItems();
    }

    public MenuItem findItem(int id) {
        return mo6666a(((C1223a) this.f2654a).findItem(id));
    }

    public int size() {
        return ((C1223a) this.f2654a).size();
    }

    public MenuItem getItem(int index) {
        return mo6666a(((C1223a) this.f2654a).getItem(index));
    }

    public void close() {
        ((C1223a) this.f2654a).close();
    }

    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return ((C1223a) this.f2654a).performShortcut(keyCode, event, flags);
    }

    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return ((C1223a) this.f2654a).isShortcutKey(keyCode, event);
    }

    public boolean performIdentifierAction(int id, int flags) {
        return ((C1223a) this.f2654a).performIdentifierAction(id, flags);
    }

    public void setQwertyMode(boolean isQwerty) {
        ((C1223a) this.f2654a).setQwertyMode(isQwerty);
    }
}
