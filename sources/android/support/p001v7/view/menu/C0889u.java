package android.support.p001v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.u */
/* compiled from: MenuPopupHelper */
public class C0889u implements C0877n {

    /* renamed from: a */
    private final Context f2785a;

    /* renamed from: b */
    private final C0873l f2786b;

    /* renamed from: c */
    private final boolean f2787c;

    /* renamed from: d */
    private final int f2788d;

    /* renamed from: e */
    private final int f2789e;

    /* renamed from: f */
    private View f2790f;

    /* renamed from: g */
    private int f2791g;

    /* renamed from: h */
    private boolean f2792h;

    /* renamed from: i */
    private C0891a f2793i;

    /* renamed from: j */
    private C0887s f2794j;

    /* renamed from: k */
    private OnDismissListener f2795k;

    /* renamed from: l */
    private final OnDismissListener f2796l;

    public C0889u(Context context, C0873l menu, View anchorView, boolean overflowOnly, int popupStyleAttr) {
        this(context, menu, anchorView, overflowOnly, popupStyleAttr, 0);
    }

    public C0889u(Context context, C0873l menu, View anchorView, boolean overflowOnly, int popupStyleAttr, int popupStyleRes) {
        this.f2791g = 8388611;
        this.f2796l = new C0888t(this);
        this.f2785a = context;
        this.f2786b = menu;
        this.f2790f = anchorView;
        this.f2787c = overflowOnly;
        this.f2788d = popupStyleAttr;
        this.f2789e = popupStyleRes;
    }

    /* renamed from: a */
    public void mo6894a(OnDismissListener listener) {
        this.f2795k = listener;
    }

    /* renamed from: a */
    public void mo6893a(View anchor) {
        this.f2790f = anchor;
    }

    /* renamed from: a */
    public void mo6895a(boolean forceShowIcon) {
        this.f2792h = forceShowIcon;
        C0887s sVar = this.f2794j;
        if (sVar != null) {
            sVar.mo6552b(forceShowIcon);
        }
    }

    /* renamed from: a */
    public void mo6891a(int gravity) {
        this.f2791g = gravity;
    }

    /* renamed from: e */
    public void mo6900e() {
        if (!mo6901f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: b */
    public C0887s mo6897b() {
        if (this.f2794j == null) {
            this.f2794j = m4250g();
        }
        return this.f2794j;
    }

    /* renamed from: f */
    public boolean mo6901f() {
        if (mo6898c()) {
            return true;
        }
        if (this.f2790f == null) {
            return false;
        }
        m4249a(0, 0, false, false);
        return true;
    }

    /* renamed from: a */
    public boolean mo6896a(int x, int y) {
        if (mo6898c()) {
            return true;
        }
        if (this.f2790f == null) {
            return false;
        }
        m4249a(x, y, true, true);
        return true;
    }

    /* renamed from: g */
    private C0887s m4250g() {
        C0857C c;
        Display display = ((WindowManager) this.f2785a.getSystemService("window")).getDefaultDisplay();
        Point displaySize = new Point();
        if (VERSION.SDK_INT >= 17) {
            display.getRealSize(displaySize);
        } else {
            display.getSize(displaySize);
        }
        if (Math.min(displaySize.x, displaySize.y) >= this.f2785a.getResources().getDimensionPixelSize(C0793R.dimen.abc_cascading_menus_min_smallest_width)) {
            C0868i iVar = new C0868i(this.f2785a, this.f2790f, this.f2788d, this.f2789e, this.f2787c);
            c = iVar;
        } else {
            C0857C c2 = new C0857C(this.f2785a, this.f2786b, this.f2790f, this.f2788d, this.f2789e, this.f2787c);
            c = c2;
        }
        c.mo6547a(this.f2786b);
        c.mo6550a(this.f2796l);
        c.mo6549a(this.f2790f);
        c.mo6548a(this.f2793i);
        c.mo6552b(this.f2792h);
        c.mo6546a(this.f2791g);
        return c;
    }

    /* renamed from: a */
    private void m4249a(int xOffset, int yOffset, boolean useOffsets, boolean showTitle) {
        C0887s popup = mo6897b();
        popup.mo6554c(showTitle);
        if (useOffsets) {
            if ((C0623f.m2881a(this.f2791g, C0646w.m2974h(this.f2790f)) & 7) == 5) {
                xOffset += this.f2790f.getWidth();
            }
            popup.mo6551b(xOffset);
            popup.mo6553c(yOffset);
            int halfSize = (int) ((48.0f * this.f2785a.getResources().getDisplayMetrics().density) / 2.0f);
            popup.mo6886a(new Rect(xOffset - halfSize, yOffset - halfSize, xOffset + halfSize, yOffset + halfSize));
        }
        popup.show();
    }

    /* renamed from: a */
    public void mo6890a() {
        if (mo6898c()) {
            this.f2794j.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo6899d() {
        this.f2794j = null;
        OnDismissListener onDismissListener = this.f2795k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: c */
    public boolean mo6898c() {
        C0887s sVar = this.f2794j;
        return sVar != null && sVar.mo6555c();
    }

    /* renamed from: a */
    public void mo6892a(C0891a cb) {
        this.f2793i = cb;
        C0887s sVar = this.f2794j;
        if (sVar != null) {
            sVar.mo6548a(cb);
        }
    }
}
