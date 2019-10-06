package android.support.p001v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.j */
/* compiled from: ListMenuPresenter */
public class C0870j implements C0890v, OnItemClickListener {

    /* renamed from: a */
    Context f2691a;

    /* renamed from: b */
    LayoutInflater f2692b;

    /* renamed from: c */
    C0873l f2693c;

    /* renamed from: d */
    ExpandedMenuView f2694d;

    /* renamed from: e */
    int f2695e;

    /* renamed from: f */
    int f2696f;

    /* renamed from: g */
    int f2697g;

    /* renamed from: h */
    private C0891a f2698h;

    /* renamed from: i */
    C0871a f2699i;

    /* renamed from: j */
    private int f2700j;

    /* renamed from: android.support.v7.view.menu.j$a */
    /* compiled from: ListMenuPresenter */
    private class C0871a extends BaseAdapter {

        /* renamed from: a */
        private int f2701a = -1;

        public C0871a() {
            mo6686a();
        }

        public int getCount() {
            int count = C0870j.this.f2693c.mo6749j().size() - C0870j.this.f2695e;
            if (this.f2701a < 0) {
                return count;
            }
            return count - 1;
        }

        public C0879p getItem(int position) {
            ArrayList<MenuItemImpl> items = C0870j.this.f2693c.mo6749j();
            int position2 = position + C0870j.this.f2695e;
            int i = this.f2701a;
            if (i >= 0 && position2 >= i) {
                position2++;
            }
            return (C0879p) items.get(position2);
        }

        public long getItemId(int position) {
            return (long) position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                C0870j jVar = C0870j.this;
                convertView = jVar.f2692b.inflate(jVar.f2697g, parent, false);
            }
            ((C0893a) convertView).mo4088a(getItem(position), 0);
            return convertView;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6686a() {
            C0879p expandedItem = C0870j.this.f2693c.mo6741f();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> items = C0870j.this.f2693c.mo6749j();
                int count = items.size();
                for (int i = 0; i < count; i++) {
                    if (((C0879p) items.get(i)) == expandedItem) {
                        this.f2701a = i;
                        return;
                    }
                }
            }
            this.f2701a = -1;
        }

        public void notifyDataSetChanged() {
            mo6686a();
            super.notifyDataSetChanged();
        }
    }

    public C0870j(Context context, int itemLayoutRes) {
        this(itemLayoutRes, 0);
        this.f2691a = context;
        this.f2692b = LayoutInflater.from(this.f2691a);
    }

    public C0870j(int itemLayoutRes, int themeRes) {
        this.f2697g = itemLayoutRes;
        this.f2696f = themeRes;
    }

    /* renamed from: a */
    public void mo4075a(Context context, C0873l menu) {
        int i = this.f2696f;
        if (i != 0) {
            this.f2691a = new ContextThemeWrapper(context, i);
            this.f2692b = LayoutInflater.from(this.f2691a);
        } else if (this.f2691a != null) {
            this.f2691a = context;
            if (this.f2692b == null) {
                this.f2692b = LayoutInflater.from(this.f2691a);
            }
        }
        this.f2693c = menu;
        C0871a aVar = this.f2699i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public C0892w mo6681a(ViewGroup root) {
        if (this.f2694d == null) {
            this.f2694d = (ExpandedMenuView) this.f2692b.inflate(C0793R.layout.abc_expanded_menu_layout, root, false);
            if (this.f2699i == null) {
                this.f2699i = new C0871a();
            }
            this.f2694d.setAdapter(this.f2699i);
            this.f2694d.setOnItemClickListener(this);
        }
        return this.f2694d;
    }

    /* renamed from: c */
    public ListAdapter mo6684c() {
        if (this.f2699i == null) {
            this.f2699i = new C0871a();
        }
        return this.f2699i;
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        C0871a aVar = this.f2699i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo6548a(C0891a cb) {
        this.f2698h = cb;
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D subMenu) {
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        new C0876m(subMenu).mo6764a((IBinder) null);
        C0891a aVar = this.f2698h;
        if (aVar != null) {
            aVar.mo6118a(subMenu);
        }
        return true;
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        C0891a aVar = this.f2698h;
        if (aVar != null) {
            aVar.mo6117a(menu, allMenusAreClosing);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        this.f2693c.mo6714a((MenuItem) this.f2699i.getItem(position), (C0890v) this, 0);
    }

    /* renamed from: b */
    public boolean mo4083b() {
        return false;
    }

    /* renamed from: a */
    public boolean mo4081a(C0873l menu, C0879p item) {
        return false;
    }

    /* renamed from: b */
    public boolean mo4084b(C0873l menu, C0879p item) {
        return false;
    }

    /* renamed from: b */
    public void mo6683b(Bundle outState) {
        SparseArray<Parcelable> viewStates = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f2694d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(viewStates);
        }
        outState.putSparseParcelableArray("android:menu:list", viewStates);
    }

    /* renamed from: a */
    public void mo6682a(Bundle inState) {
        SparseArray<Parcelable> viewStates = inState.getSparseParcelableArray("android:menu:list");
        if (viewStates != null) {
            this.f2694d.restoreHierarchyState(viewStates);
        }
    }

    public int getId() {
        return this.f2700j;
    }

    /* renamed from: a */
    public Parcelable mo4073a() {
        if (this.f2694d == null) {
            return null;
        }
        Bundle state = new Bundle();
        mo6683b(state);
        return state;
    }

    /* renamed from: a */
    public void mo4076a(Parcelable state) {
        mo6682a((Bundle) state);
    }
}
