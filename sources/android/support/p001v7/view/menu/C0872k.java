package android.support.p001v7.view.menu;

import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.k */
/* compiled from: MenuAdapter */
public class C0872k extends BaseAdapter {

    /* renamed from: a */
    static final int f2703a = C0793R.layout.abc_popup_menu_item_layout;

    /* renamed from: b */
    C0873l f2704b;

    /* renamed from: c */
    private int f2705c = -1;

    /* renamed from: d */
    private boolean f2706d;

    /* renamed from: e */
    private final boolean f2707e;

    /* renamed from: f */
    private final LayoutInflater f2708f;

    public C0872k(C0873l menu, LayoutInflater inflater, boolean overflowOnly) {
        this.f2707e = overflowOnly;
        this.f2708f = inflater;
        this.f2704b = menu;
        mo6692a();
    }

    /* renamed from: a */
    public void mo6693a(boolean forceShow) {
        this.f2706d = forceShow;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> items = this.f2707e ? this.f2704b.mo6749j() : this.f2704b.mo6752n();
        if (this.f2705c < 0) {
            return items.size();
        }
        return items.size() - 1;
    }

    /* renamed from: b */
    public C0873l mo6694b() {
        return this.f2704b;
    }

    public C0879p getItem(int position) {
        ArrayList<MenuItemImpl> items = this.f2707e ? this.f2704b.mo6749j() : this.f2704b.mo6752n();
        int i = this.f2705c;
        if (i >= 0 && position >= i) {
            position++;
        }
        return (C0879p) items.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.f2708f.inflate(f2703a, parent, false);
        }
        C0893a itemView = (C0893a) convertView;
        if (this.f2706d) {
            ((ListMenuItemView) convertView).setForceShowIcon(true);
        }
        itemView.mo4088a(getItem(position), 0);
        return convertView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6692a() {
        C0879p expandedItem = this.f2704b.mo6741f();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> items = this.f2704b.mo6749j();
            int count = items.size();
            for (int i = 0; i < count; i++) {
                if (((C0879p) items.get(i)) == expandedItem) {
                    this.f2705c = i;
                    return;
                }
            }
        }
        this.f2705c = -1;
    }

    public void notifyDataSetChanged() {
        mo6692a();
        super.notifyDataSetChanged();
    }
}
