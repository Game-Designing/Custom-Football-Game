package android.support.p001v7.view.menu;

import android.content.Context;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.b */
/* compiled from: BaseMenuPresenter */
public abstract class C0861b implements C0890v {

    /* renamed from: a */
    protected Context f2641a;

    /* renamed from: b */
    protected Context f2642b;

    /* renamed from: c */
    protected C0873l f2643c;

    /* renamed from: d */
    protected LayoutInflater f2644d;

    /* renamed from: e */
    protected LayoutInflater f2645e;

    /* renamed from: f */
    private C0891a f2646f;

    /* renamed from: g */
    private int f2647g;

    /* renamed from: h */
    private int f2648h;

    /* renamed from: i */
    protected C0892w f2649i;

    /* renamed from: j */
    private int f2650j;

    /* renamed from: a */
    public abstract void mo6660a(C0879p pVar, C0893a aVar);

    /* renamed from: a */
    public abstract boolean mo6662a(int i, C0879p pVar);

    public C0861b(Context context, int menuLayoutRes, int itemLayoutRes) {
        this.f2641a = context;
        this.f2644d = LayoutInflater.from(context);
        this.f2647g = menuLayoutRes;
        this.f2648h = itemLayoutRes;
    }

    /* renamed from: a */
    public void mo4075a(Context context, C0873l menu) {
        this.f2642b = context;
        this.f2645e = LayoutInflater.from(this.f2642b);
        this.f2643c = menu;
    }

    /* renamed from: b */
    public C0892w mo6664b(ViewGroup root) {
        if (this.f2649i == null) {
            this.f2649i = (C0892w) this.f2644d.inflate(this.f2647g, root, false);
            this.f2649i.mo4100a(this.f2643c);
            mo4079a(true);
        }
        return this.f2649i;
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        ViewGroup parent = (ViewGroup) this.f2649i;
        if (parent != null) {
            int childIndex = 0;
            C0873l lVar = this.f2643c;
            if (lVar != null) {
                lVar.mo6724b();
                ArrayList<MenuItemImpl> visibleItems = this.f2643c.mo6752n();
                int itemCount = visibleItems.size();
                for (int i = 0; i < itemCount; i++) {
                    C0879p item = (C0879p) visibleItems.get(i);
                    if (mo6662a(childIndex, item)) {
                        View convertView = parent.getChildAt(childIndex);
                        C0879p oldItem = convertView instanceof C0893a ? ((C0893a) convertView).getItemData() : null;
                        View itemView = mo6658a(item, convertView, parent);
                        if (item != oldItem) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != convertView) {
                            mo6661a(itemView, childIndex);
                        }
                        childIndex++;
                    }
                }
            }
            while (childIndex < parent.getChildCount()) {
                if (!mo6663a(parent, childIndex)) {
                    childIndex++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6661a(View itemView, int childIndex) {
        ViewGroup currentParent = (ViewGroup) itemView.getParent();
        if (currentParent != null) {
            currentParent.removeView(itemView);
        }
        ((ViewGroup) this.f2649i).addView(itemView, childIndex);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6663a(ViewGroup parent, int childIndex) {
        parent.removeViewAt(childIndex);
        return true;
    }

    /* renamed from: a */
    public void mo6548a(C0891a cb) {
        this.f2646f = cb;
    }

    /* renamed from: c */
    public C0891a mo6665c() {
        return this.f2646f;
    }

    /* renamed from: a */
    public C0893a mo6657a(ViewGroup parent) {
        return (C0893a) this.f2644d.inflate(this.f2648h, parent, false);
    }

    /* renamed from: a */
    public View mo6658a(C0879p item, View convertView, ViewGroup parent) {
        C0893a itemView;
        if (convertView instanceof C0893a) {
            itemView = (C0893a) convertView;
        } else {
            itemView = mo6657a(parent);
        }
        mo6660a(item, itemView);
        return (View) itemView;
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        C0891a aVar = this.f2646f;
        if (aVar != null) {
            aVar.mo6117a(menu, allMenusAreClosing);
        }
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D menu) {
        C0891a aVar = this.f2646f;
        if (aVar != null) {
            return aVar.mo6118a(menu);
        }
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

    public int getId() {
        return this.f2650j;
    }

    /* renamed from: a */
    public void mo6659a(int id) {
        this.f2650j = id;
    }
}
