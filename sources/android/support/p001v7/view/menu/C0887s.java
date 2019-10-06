package android.support.p001v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.s */
/* compiled from: MenuPopup */
abstract class C0887s implements C0896z, C0890v, OnItemClickListener {

    /* renamed from: a */
    private Rect f2783a;

    /* renamed from: a */
    public abstract void mo6546a(int i);

    /* renamed from: a */
    public abstract void mo6547a(C0873l lVar);

    /* renamed from: a */
    public abstract void mo6549a(View view);

    /* renamed from: a */
    public abstract void mo6550a(OnDismissListener onDismissListener);

    /* renamed from: b */
    public abstract void mo6551b(int i);

    /* renamed from: b */
    public abstract void mo6552b(boolean z);

    /* renamed from: c */
    public abstract void mo6553c(int i);

    /* renamed from: c */
    public abstract void mo6554c(boolean z);

    C0887s() {
    }

    /* renamed from: a */
    public void mo6886a(Rect bounds) {
        this.f2783a = bounds;
    }

    /* renamed from: f */
    public Rect mo6887f() {
        return this.f2783a;
    }

    /* renamed from: a */
    public void mo4075a(Context context, C0873l menu) {
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
        return 0;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ListAdapter outerAdapter = (ListAdapter) parent.getAdapter();
        m4233a(outerAdapter).f2704b.mo6714a((MenuItem) outerAdapter.getItem(position), (C0890v) this, mo6677e() ? 0 : 4);
    }

    /* renamed from: a */
    protected static int m4232a(ListAdapter adapter, ViewGroup parent, Context context, int maxAllowedWidth) {
        int maxWidth = 0;
        View itemView = null;
        int itemType = 0;
        int widthMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int heightMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int count = adapter.getCount();
        for (int i = 0; i < count; i++) {
            int positionType = adapter.getItemViewType(i);
            if (positionType != itemType) {
                itemType = positionType;
                itemView = null;
            }
            if (parent == null) {
                parent = new FrameLayout(context);
            }
            itemView = adapter.getView(i, itemView, parent);
            itemView.measure(widthMeasureSpec, heightMeasureSpec);
            int itemWidth = itemView.getMeasuredWidth();
            if (itemWidth >= maxAllowedWidth) {
                return maxAllowedWidth;
            }
            if (itemWidth > maxWidth) {
                maxWidth = itemWidth;
            }
        }
        return maxWidth;
    }

    /* renamed from: a */
    protected static C0872k m4233a(ListAdapter adapter) {
        if (adapter instanceof HeaderViewListAdapter) {
            return (C0872k) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
        }
        return (C0872k) adapter;
    }

    /* renamed from: b */
    protected static boolean m4234b(C0873l menu) {
        int count = menu.size();
        for (int i = 0; i < count; i++) {
            MenuItem childItem = menu.getItem(i);
            if (childItem.isVisible() && childItem.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo6677e() {
        return true;
    }
}
