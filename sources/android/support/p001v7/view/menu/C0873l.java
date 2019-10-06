package android.support.p001v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0620e;
import android.support.p001v7.appcompat.C0793R;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p002b.p003c.p053g.p056b.p057a.C1223a;

/* renamed from: android.support.v7.view.menu.l */
/* compiled from: MenuBuilder */
public class C0873l implements C1223a {

    /* renamed from: a */
    private static final int[] f2709a = {1, 4, 5, 3, 2, 0};

    /* renamed from: b */
    private final Context f2710b;

    /* renamed from: c */
    private final Resources f2711c;

    /* renamed from: d */
    private boolean f2712d;

    /* renamed from: e */
    private boolean f2713e;

    /* renamed from: f */
    private C0874a f2714f;

    /* renamed from: g */
    private ArrayList<C0879p> f2715g;

    /* renamed from: h */
    private ArrayList<C0879p> f2716h;

    /* renamed from: i */
    private boolean f2717i;

    /* renamed from: j */
    private ArrayList<C0879p> f2718j;

    /* renamed from: k */
    private ArrayList<C0879p> f2719k;

    /* renamed from: l */
    private boolean f2720l;

    /* renamed from: m */
    private int f2721m = 0;

    /* renamed from: n */
    private ContextMenuInfo f2722n;

    /* renamed from: o */
    CharSequence f2723o;

    /* renamed from: p */
    Drawable f2724p;

    /* renamed from: q */
    View f2725q;

    /* renamed from: r */
    private boolean f2726r = false;

    /* renamed from: s */
    private boolean f2727s = false;

    /* renamed from: t */
    private boolean f2728t = false;

    /* renamed from: u */
    private boolean f2729u = false;

    /* renamed from: v */
    private boolean f2730v = false;

    /* renamed from: w */
    private ArrayList<C0879p> f2731w = new ArrayList<>();

    /* renamed from: x */
    private CopyOnWriteArrayList<WeakReference<C0890v>> f2732x = new CopyOnWriteArrayList<>();

    /* renamed from: y */
    private C0879p f2733y;

    /* renamed from: z */
    private boolean f2734z;

    /* renamed from: android.support.v7.view.menu.l$a */
    /* compiled from: MenuBuilder */
    public interface C0874a {
        /* renamed from: a */
        void mo4698a(C0873l lVar);

        /* renamed from: a */
        boolean mo4699a(C0873l lVar, MenuItem menuItem);
    }

    /* renamed from: android.support.v7.view.menu.l$b */
    /* compiled from: MenuBuilder */
    public interface C0875b {
        /* renamed from: a */
        boolean mo6589a(C0879p pVar);
    }

    public C0873l(Context context) {
        this.f2710b = context;
        this.f2711c = context.getResources();
        this.f2715g = new ArrayList<>();
        this.f2716h = new ArrayList<>();
        this.f2717i = true;
        this.f2718j = new ArrayList<>();
        this.f2719k = new ArrayList<>();
        this.f2720l = true;
        m4137e(true);
    }

    /* renamed from: c */
    public C0873l mo6728c(int defaultShowAsAction) {
        this.f2721m = defaultShowAsAction;
        return this;
    }

    /* renamed from: a */
    public void mo6708a(C0890v presenter) {
        mo6709a(presenter, this.f2710b);
    }

    /* renamed from: a */
    public void mo6709a(C0890v presenter, Context menuContext) {
        this.f2732x.add(new WeakReference(presenter));
        presenter.mo4075a(menuContext, this);
        this.f2720l = true;
    }

    /* renamed from: b */
    public void mo6726b(C0890v presenter) {
        Iterator it = this.f2732x.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> ref = (WeakReference) it.next();
            C0890v item = (C0890v) ref.get();
            if (item == null || item == presenter) {
                this.f2732x.remove(ref);
            }
        }
    }

    /* renamed from: d */
    private void m4135d(boolean cleared) {
        if (!this.f2732x.isEmpty()) {
            mo6756r();
            Iterator it = this.f2732x.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> ref = (WeakReference) it.next();
                C0890v presenter = (C0890v) ref.get();
                if (presenter == null) {
                    this.f2732x.remove(ref);
                } else {
                    presenter.mo4079a(cleared);
                }
            }
            mo6755q();
        }
    }

    /* renamed from: a */
    private boolean m4134a(C0858D subMenu, C0890v preferredPresenter) {
        if (this.f2732x.isEmpty()) {
            return false;
        }
        boolean result = false;
        if (preferredPresenter != null) {
            result = preferredPresenter.mo4080a(subMenu);
        }
        Iterator it = this.f2732x.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> ref = (WeakReference) it.next();
            C0890v presenter = (C0890v) ref.get();
            if (presenter == null) {
                this.f2732x.remove(ref);
            } else if (!result) {
                result = presenter.mo4080a(subMenu);
            }
        }
        return result;
    }

    /* renamed from: f */
    private void m4139f(Bundle outState) {
        if (!this.f2732x.isEmpty()) {
            SparseArray<Parcelable> presenterStates = new SparseArray<>();
            Iterator it = this.f2732x.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> ref = (WeakReference) it.next();
                C0890v presenter = (C0890v) ref.get();
                if (presenter == null) {
                    this.f2732x.remove(ref);
                } else {
                    int id = presenter.getId();
                    if (id > 0) {
                        Parcelable state = presenter.mo4073a();
                        if (state != null) {
                            presenterStates.put(id, state);
                        }
                    }
                }
            }
            outState.putSparseParcelableArray("android:menu:presenters", presenterStates);
        }
    }

    /* renamed from: e */
    private void m4136e(Bundle state) {
        SparseArray<Parcelable> presenterStates = state.getSparseParcelableArray("android:menu:presenters");
        if (presenterStates != null && !this.f2732x.isEmpty()) {
            Iterator it = this.f2732x.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> ref = (WeakReference) it.next();
                C0890v presenter = (C0890v) ref.get();
                if (presenter == null) {
                    this.f2732x.remove(ref);
                } else {
                    int id = presenter.getId();
                    if (id > 0) {
                        Parcelable parcel = (Parcelable) presenterStates.get(id);
                        if (parcel != null) {
                            presenter.mo4076a(parcel);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo6737d(Bundle outState) {
        m4139f(outState);
    }

    /* renamed from: b */
    public void mo6725b(Bundle state) {
        m4136e(state);
    }

    /* renamed from: c */
    public void mo6730c(Bundle outStates) {
        SparseArray sparseArray = null;
        int itemCount = size();
        for (int i = 0; i < itemCount; i++) {
            MenuItem item = getItem(i);
            View v = item.getActionView();
            if (!(v == null || v.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                v.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    outStates.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((C0858D) item.getSubMenu()).mo6730c(outStates);
            }
        }
        if (sparseArray != null) {
            outStates.putSparseParcelableArray(mo6565d(), sparseArray);
        }
    }

    /* renamed from: a */
    public void mo6707a(Bundle states) {
        if (states != null) {
            SparseArray<Parcelable> viewStates = states.getSparseParcelableArray(mo6565d());
            int itemCount = size();
            for (int i = 0; i < itemCount; i++) {
                MenuItem item = getItem(i);
                View v = item.getActionView();
                if (!(v == null || v.getId() == -1)) {
                    v.restoreHierarchyState(viewStates);
                }
                if (item.hasSubMenu()) {
                    ((C0858D) item.getSubMenu()).mo6707a(states);
                }
            }
            int expandedId = states.getInt("android:menu:expandedactionview");
            if (expandedId > 0) {
                MenuItem itemToExpand = findItem(expandedId);
                if (itemToExpand != null) {
                    itemToExpand.expandActionView();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo6565d() {
        return "android:menu:actionviewstates";
    }

    /* renamed from: a */
    public void mo6561a(C0874a cb) {
        this.f2714f = cb;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public MenuItem mo4120a(int group, int id, int categoryOrder, CharSequence title) {
        int ordering = m4138f(categoryOrder);
        C0879p item = m4131a(group, id, categoryOrder, ordering, title, this.f2721m);
        ContextMenuInfo contextMenuInfo = this.f2722n;
        if (contextMenuInfo != null) {
            item.mo6770a(contextMenuInfo);
        }
        ArrayList<C0879p> arrayList = this.f2715g;
        arrayList.add(m4130a(arrayList, ordering), item);
        mo6727b(true);
        return item;
    }

    /* renamed from: a */
    private C0879p m4131a(int group, int id, int categoryOrder, int ordering, CharSequence title, int defaultShowAsAction) {
        C0879p pVar = new C0879p(this, group, id, categoryOrder, ordering, title, defaultShowAsAction);
        return pVar;
    }

    public MenuItem add(CharSequence title) {
        return mo4120a(0, 0, 0, title);
    }

    public MenuItem add(int titleRes) {
        return mo4120a(0, 0, 0, this.f2711c.getString(titleRes));
    }

    public MenuItem add(int group, int id, int categoryOrder, CharSequence title) {
        return mo4120a(group, id, categoryOrder, title);
    }

    public MenuItem add(int group, int id, int categoryOrder, int title) {
        return mo4120a(group, id, categoryOrder, this.f2711c.getString(title));
    }

    public SubMenu addSubMenu(CharSequence title) {
        return addSubMenu(0, 0, 0, title);
    }

    public SubMenu addSubMenu(int titleRes) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f2711c.getString(titleRes));
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, CharSequence title) {
        C0879p item = (C0879p) mo4120a(group, id, categoryOrder, title);
        C0858D subMenu = new C0858D(this.f2710b, this, item);
        item.mo6769a(subMenu);
        return subMenu;
    }

    public SubMenu addSubMenu(int group, int id, int categoryOrder, int title) {
        return addSubMenu(group, id, categoryOrder, (CharSequence) this.f2711c.getString(title));
    }

    public int addIntentOptions(int group, int id, int categoryOrder, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        Intent[] intentArr = specifics;
        PackageManager pm = this.f2710b.getPackageManager();
        int N = 0;
        Intent intent2 = intent;
        List<ResolveInfo> lri = pm.queryIntentActivityOptions(caller, intentArr, intent2, 0);
        if (lri != null) {
            N = lri.size();
        }
        if ((flags & 1) == 0) {
            removeGroup(group);
        }
        for (int i = 0; i < N; i++) {
            ResolveInfo ri = (ResolveInfo) lri.get(i);
            int i2 = ri.specificIndex;
            Intent rintent = new Intent(i2 < 0 ? intent2 : intentArr[i2]);
            rintent.setComponent(new ComponentName(ri.activityInfo.applicationInfo.packageName, ri.activityInfo.name));
            MenuItem item = add(group, id, categoryOrder, ri.loadLabel(pm)).setIcon(ri.loadIcon(pm)).setIntent(rintent);
            if (outSpecificItems != null) {
                int i3 = ri.specificIndex;
                if (i3 >= 0) {
                    outSpecificItems[i3] = item;
                }
            }
        }
        int i4 = group;
        int i5 = id;
        int i6 = categoryOrder;
        return N;
    }

    public void removeItem(int id) {
        m4133a(mo6723b(id), true);
    }

    public void removeGroup(int group) {
        int i = mo6700a(group);
        if (i >= 0) {
            int maxRemovable = this.f2715g.size() - i;
            int numRemoved = 0;
            while (true) {
                int numRemoved2 = numRemoved + 1;
                if (numRemoved >= maxRemovable || ((C0879p) this.f2715g.get(i)).getGroupId() != group) {
                    mo6727b(true);
                } else {
                    m4133a(i, false);
                    numRemoved = numRemoved2;
                }
            }
            mo6727b(true);
        }
    }

    /* renamed from: a */
    private void m4133a(int index, boolean updateChildrenOnMenuViews) {
        if (index >= 0 && index < this.f2715g.size()) {
            this.f2715g.remove(index);
            if (updateChildrenOnMenuViews) {
                mo6727b(true);
            }
        }
    }

    public void clear() {
        C0879p pVar = this.f2733y;
        if (pVar != null) {
            mo6563a(pVar);
        }
        this.f2715g.clear();
        mo6727b(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6710a(MenuItem item) {
        int group = item.getGroupId();
        int N = this.f2715g.size();
        mo6756r();
        for (int i = 0; i < N; i++) {
            C0879p curItem = (C0879p) this.f2715g.get(i);
            if (curItem.getGroupId() == group && curItem.mo6796i() && curItem.isCheckable()) {
                curItem.mo6773b(curItem == item);
            }
        }
        mo6755q();
    }

    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {
        int N = this.f2715g.size();
        for (int i = 0; i < N; i++) {
            C0879p item = (C0879p) this.f2715g.get(i);
            if (item.getGroupId() == group) {
                item.mo6775c(exclusive);
                item.setCheckable(checkable);
            }
        }
    }

    public void setGroupVisible(int group, boolean visible) {
        int N = this.f2715g.size();
        boolean changedAtLeastOneItem = false;
        for (int i = 0; i < N; i++) {
            C0879p item = (C0879p) this.f2715g.get(i);
            if (item.getGroupId() == group && item.mo6779e(visible)) {
                changedAtLeastOneItem = true;
            }
        }
        if (changedAtLeastOneItem) {
            mo6727b(true);
        }
    }

    public void setGroupEnabled(int group, boolean enabled) {
        int N = this.f2715g.size();
        for (int i = 0; i < N; i++) {
            C0879p item = (C0879p) this.f2715g.get(i);
            if (item.getGroupId() == group) {
                item.setEnabled(enabled);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f2734z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0879p) this.f2715g.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            C0879p item = (C0879p) this.f2715g.get(i);
            if (item.getItemId() == id) {
                return item;
            }
            if (item.hasSubMenu()) {
                MenuItem possibleItem = item.getSubMenu().findItem(id);
                if (possibleItem != null) {
                    return possibleItem;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    public int mo6723b(int id) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0879p) this.f2715g.get(i)).getItemId() == id) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public int mo6700a(int group) {
        return mo6701a(group, 0);
    }

    /* renamed from: a */
    public int mo6701a(int group, int start) {
        int size = size();
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < size; i++) {
            if (((C0879p) this.f2715g.get(i)).getGroupId() == group) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.f2715g.size();
    }

    public MenuItem getItem(int index) {
        return (MenuItem) this.f2715g.get(index);
    }

    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return mo6705a(keyCode, event) != null;
    }

    public void setQwertyMode(boolean isQwerty) {
        this.f2712d = isQwerty;
        mo6727b(false);
    }

    /* renamed from: f */
    private static int m4138f(int categoryOrder) {
        int index = (-65536 & categoryOrder) >> 16;
        if (index >= 0) {
            int[] iArr = f2709a;
            if (index < iArr.length) {
                return (iArr[index] << 16) | (65535 & categoryOrder);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: o */
    public boolean mo6568o() {
        return this.f2712d;
    }

    /* renamed from: e */
    private void m4137e(boolean shortcutsVisible) {
        boolean z = true;
        if (!shortcutsVisible || this.f2711c.getConfiguration().keyboard == 1 || !this.f2711c.getBoolean(C0793R.bool.abc_config_showMenuShortcutsWhenKeyboardPresent)) {
            z = false;
        }
        this.f2713e = z;
    }

    /* renamed from: p */
    public boolean mo6569p() {
        return this.f2713e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public Resources mo6751l() {
        return this.f2711c;
    }

    /* renamed from: e */
    public Context mo6739e() {
        return this.f2710b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6562a(C0873l menu, MenuItem item) {
        C0874a aVar = this.f2714f;
        return aVar != null && aVar.mo4699a(menu, item);
    }

    /* renamed from: a */
    public void mo6706a() {
        C0874a aVar = this.f2714f;
        if (aVar != null) {
            aVar.mo4698a(this);
        }
    }

    /* renamed from: a */
    private static int m4130a(ArrayList<C0879p> items, int ordering) {
        for (int i = items.size() - 1; i >= 0; i--) {
            if (((C0879p) items.get(i)).mo6774c() <= ordering) {
                return i + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        C0879p item = mo6705a(keyCode, event);
        boolean handled = false;
        if (item != null) {
            handled = mo6713a((MenuItem) item, flags);
        }
        if ((flags & 2) != 0) {
            mo6712a(true);
        }
        return handled;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6711a(List<C0879p> items, int keyCode, KeyEvent event) {
        List<C0879p> list = items;
        int i = keyCode;
        KeyEvent keyEvent = event;
        boolean qwerty = mo6568o();
        int modifierState = event.getModifiers();
        KeyData possibleChars = new KeyData();
        if (keyEvent.getKeyData(possibleChars) || i == 67) {
            int N = this.f2715g.size();
            for (int i2 = 0; i2 < N; i2++) {
                C0879p item = (C0879p) this.f2715g.get(i2);
                if (item.hasSubMenu()) {
                    ((C0873l) item.getSubMenu()).mo6711a(list, i, keyEvent);
                }
                char shortcutChar = qwerty ? item.getAlphabeticShortcut() : item.getNumericShortcut();
                if (((modifierState & 69647) == (69647 & (qwerty ? item.getAlphabeticModifiers() : item.getNumericModifiers()))) && shortcutChar != 0) {
                    char[] cArr = possibleChars.meta;
                    if (shortcutChar != cArr[0] && shortcutChar != cArr[2]) {
                        if (qwerty && shortcutChar == 8) {
                            if (i != 67) {
                            }
                        }
                    }
                    if (item.isEnabled()) {
                        list.add(item);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0879p mo6705a(int keyCode, KeyEvent event) {
        char shortcutChar;
        ArrayList<C0879p> arrayList = this.f2731w;
        arrayList.clear();
        mo6711a((List<C0879p>) arrayList, keyCode, event);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = event.getMetaState();
        KeyData possibleChars = new KeyData();
        event.getKeyData(possibleChars);
        int size = arrayList.size();
        if (size == 1) {
            return (C0879p) arrayList.get(0);
        }
        boolean qwerty = mo6568o();
        for (int i = 0; i < size; i++) {
            C0879p item = (C0879p) arrayList.get(i);
            if (qwerty) {
                shortcutChar = item.getAlphabeticShortcut();
            } else {
                shortcutChar = item.getNumericShortcut();
            }
            if ((shortcutChar == possibleChars.meta[0] && (metaState & 2) == 0) || ((shortcutChar == possibleChars.meta[2] && (metaState & 2) != 0) || (qwerty && shortcutChar == 8 && keyCode == 67))) {
                return item;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int id, int flags) {
        return mo6713a(findItem(id), flags);
    }

    /* renamed from: a */
    public boolean mo6713a(MenuItem item, int flags) {
        return mo6714a(item, (C0890v) null, flags);
    }

    /* renamed from: a */
    public boolean mo6714a(MenuItem item, C0890v preferredPresenter, int flags) {
        C0879p itemImpl = (C0879p) item;
        if (itemImpl == null || !itemImpl.isEnabled()) {
            return false;
        }
        boolean invoked = itemImpl.mo6781g();
        C0620e provider = itemImpl.mo6601a();
        boolean providerHasSubMenu = provider != null && provider.mo5649a();
        if (itemImpl.mo6780f()) {
            invoked |= itemImpl.expandActionView();
            if (invoked) {
                mo6712a(true);
            }
        } else if (itemImpl.hasSubMenu() || providerHasSubMenu) {
            if ((flags & 4) == 0) {
                mo6712a(false);
            }
            if (!itemImpl.hasSubMenu()) {
                itemImpl.mo6769a(new C0858D(mo6739e(), this, itemImpl));
            }
            C0858D subMenu = (C0858D) itemImpl.getSubMenu();
            if (providerHasSubMenu) {
                provider.mo5648a((SubMenu) subMenu);
            }
            invoked |= m4134a(subMenu, preferredPresenter);
            if (!invoked) {
                mo6712a(true);
            }
        } else if ((flags & 1) == 0) {
            mo6712a(true);
        }
        return invoked;
    }

    /* renamed from: a */
    public final void mo6712a(boolean closeAllMenus) {
        if (!this.f2730v) {
            this.f2730v = true;
            Iterator it = this.f2732x.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> ref = (WeakReference) it.next();
                C0890v presenter = (C0890v) ref.get();
                if (presenter == null) {
                    this.f2732x.remove(ref);
                } else {
                    presenter.mo4078a(this, closeAllMenus);
                }
            }
            this.f2730v = false;
        }
    }

    public void close() {
        mo6712a(true);
    }

    /* renamed from: b */
    public void mo6727b(boolean structureChanged) {
        if (!this.f2726r) {
            if (structureChanged) {
                this.f2717i = true;
                this.f2720l = true;
            }
            m4135d(structureChanged);
            return;
        }
        this.f2727s = true;
        if (structureChanged) {
            this.f2728t = true;
        }
    }

    /* renamed from: r */
    public void mo6756r() {
        if (!this.f2726r) {
            this.f2726r = true;
            this.f2727s = false;
            this.f2728t = false;
        }
    }

    /* renamed from: q */
    public void mo6755q() {
        this.f2726r = false;
        if (this.f2727s) {
            this.f2727s = false;
            mo6727b(this.f2728t);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo6738d(C0879p item) {
        this.f2717i = true;
        mo6727b(true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo6731c(C0879p item) {
        this.f2720l = true;
        mo6727b(true);
    }

    /* renamed from: n */
    public ArrayList<C0879p> mo6752n() {
        if (!this.f2717i) {
            return this.f2716h;
        }
        this.f2716h.clear();
        int itemsSize = this.f2715g.size();
        for (int i = 0; i < itemsSize; i++) {
            C0879p item = (C0879p) this.f2715g.get(i);
            if (item.isVisible()) {
                this.f2716h.add(item);
            }
        }
        this.f2717i = false;
        this.f2720l = true;
        return this.f2716h;
    }

    /* renamed from: b */
    public void mo6724b() {
        ArrayList<MenuItemImpl> visibleItems = mo6752n();
        if (this.f2720l) {
            boolean flagged = false;
            Iterator it = this.f2732x.iterator();
            while (it.hasNext()) {
                WeakReference<MenuPresenter> ref = (WeakReference) it.next();
                C0890v presenter = (C0890v) ref.get();
                if (presenter == null) {
                    this.f2732x.remove(ref);
                } else {
                    flagged |= presenter.mo4083b();
                }
            }
            if (flagged) {
                this.f2718j.clear();
                this.f2719k.clear();
                int itemsSize = visibleItems.size();
                for (int i = 0; i < itemsSize; i++) {
                    C0879p item = (C0879p) visibleItems.get(i);
                    if (item.mo6794h()) {
                        this.f2718j.add(item);
                    } else {
                        this.f2719k.add(item);
                    }
                }
            } else {
                this.f2718j.clear();
                this.f2719k.clear();
                this.f2719k.addAll(mo6752n());
            }
            this.f2720l = false;
        }
    }

    /* renamed from: c */
    public ArrayList<C0879p> mo6729c() {
        mo6724b();
        return this.f2718j;
    }

    /* renamed from: j */
    public ArrayList<C0879p> mo6749j() {
        mo6724b();
        return this.f2719k;
    }

    public void clearHeader() {
        this.f2724p = null;
        this.f2723o = null;
        this.f2725q = null;
        mo6727b(false);
    }

    /* renamed from: a */
    private void m4132a(int titleRes, CharSequence title, int iconRes, Drawable icon, View view) {
        Resources r = mo6751l();
        if (view != null) {
            this.f2725q = view;
            this.f2723o = null;
            this.f2724p = null;
        } else {
            if (titleRes > 0) {
                this.f2723o = r.getText(titleRes);
            } else if (title != null) {
                this.f2723o = title;
            }
            if (iconRes > 0) {
                this.f2724p = C0510b.m2572c(mo6739e(), iconRes);
            } else if (icon != null) {
                this.f2724p = icon;
            }
            this.f2725q = null;
        }
        mo6727b(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0873l mo6704a(CharSequence title) {
        m4132a(0, title, 0, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C0873l mo6740e(int titleRes) {
        m4132a(titleRes, null, 0, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0873l mo6702a(Drawable icon) {
        m4132a(0, null, 0, icon, null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C0873l mo6736d(int iconRes) {
        m4132a(0, null, iconRes, null, null);
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0873l mo6703a(View view) {
        m4132a(0, null, 0, null, view);
        return this;
    }

    /* renamed from: h */
    public CharSequence mo6745h() {
        return this.f2723o;
    }

    /* renamed from: g */
    public Drawable mo6743g() {
        return this.f2724p;
    }

    /* renamed from: i */
    public View mo6747i() {
        return this.f2725q;
    }

    /* renamed from: m */
    public C0873l mo6567m() {
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: k */
    public boolean mo6750k() {
        return this.f2729u;
    }

    /* renamed from: b */
    public boolean mo6564b(C0879p item) {
        if (this.f2732x.isEmpty()) {
            return false;
        }
        boolean expanded = false;
        mo6756r();
        Iterator it = this.f2732x.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> ref = (WeakReference) it.next();
            C0890v presenter = (C0890v) ref.get();
            if (presenter == null) {
                this.f2732x.remove(ref);
            } else {
                boolean a = presenter.mo4081a(this, item);
                expanded = a;
                if (a) {
                    break;
                }
            }
        }
        mo6755q();
        if (expanded) {
            this.f2733y = item;
        }
        return expanded;
    }

    /* renamed from: a */
    public boolean mo6563a(C0879p item) {
        if (this.f2732x.isEmpty() || this.f2733y != item) {
            return false;
        }
        boolean collapsed = false;
        mo6756r();
        Iterator it = this.f2732x.iterator();
        while (it.hasNext()) {
            WeakReference<MenuPresenter> ref = (WeakReference) it.next();
            C0890v presenter = (C0890v) ref.get();
            if (presenter == null) {
                this.f2732x.remove(ref);
            } else {
                boolean b = presenter.mo4084b(this, item);
                collapsed = b;
                if (b) {
                    break;
                }
            }
        }
        mo6755q();
        if (collapsed) {
            this.f2733y = null;
        }
        return collapsed;
    }

    /* renamed from: f */
    public C0879p mo6741f() {
        return this.f2733y;
    }

    /* renamed from: c */
    public void mo6732c(boolean override) {
        this.f2734z = override;
    }
}
