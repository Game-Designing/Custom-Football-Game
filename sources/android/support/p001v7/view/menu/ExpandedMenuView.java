package android.support.p001v7.view.menu;

import android.content.Context;
import android.support.p001v7.view.menu.C0873l.C0875b;
import android.support.p001v7.widget.C1112sb;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/* renamed from: android.support.v7.view.menu.ExpandedMenuView */
public final class ExpandedMenuView extends ListView implements C0875b, C0892w, OnItemClickListener {

    /* renamed from: a */
    private static final int[] f2601a = {16842964, 16843049};

    /* renamed from: b */
    private C0873l f2602b;

    /* renamed from: c */
    private int f2603c;

    public ExpandedMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        setOnItemClickListener(this);
        C1112sb a = C1112sb.m5456a(context, attrs, f2601a, defStyleAttr, 0);
        if (a.mo8660g(0)) {
            setBackgroundDrawable(a.mo8650b(0));
        }
        if (a.mo8660g(1)) {
            setDivider(a.mo8650b(1));
        }
        a.mo8647a();
    }

    /* renamed from: a */
    public void mo4100a(C0873l menu) {
        this.f2602b = menu;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    /* renamed from: a */
    public boolean mo6589a(C0879p item) {
        return this.f2602b.mo6713a((MenuItem) item, 0);
    }

    public void onItemClick(AdapterView parent, View v, int position, long id) {
        mo6589a((C0879p) getAdapter().getItem(position));
    }

    public int getWindowAnimations() {
        return this.f2603c;
    }
}
