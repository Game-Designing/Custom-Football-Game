package android.support.p001v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.widget.C1131xa;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/* renamed from: android.support.v7.view.menu.C */
/* compiled from: StandardMenuPopup */
final class C0857C extends C0887s implements OnDismissListener, OnItemClickListener, C0890v, OnKeyListener {

    /* renamed from: b */
    private final Context f2579b;

    /* renamed from: c */
    private final C0873l f2580c;

    /* renamed from: d */
    private final C0872k f2581d;

    /* renamed from: e */
    private final boolean f2582e;

    /* renamed from: f */
    private final int f2583f;

    /* renamed from: g */
    private final int f2584g;

    /* renamed from: h */
    private final int f2585h;

    /* renamed from: i */
    final C1131xa f2586i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final OnGlobalLayoutListener f2587j = new C0853A(this);

    /* renamed from: k */
    private final OnAttachStateChangeListener f2588k = new C0856B(this);

    /* renamed from: l */
    private OnDismissListener f2589l;

    /* renamed from: m */
    private View f2590m;

    /* renamed from: n */
    View f2591n;

    /* renamed from: o */
    private C0891a f2592o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public ViewTreeObserver f2593p;

    /* renamed from: q */
    private boolean f2594q;

    /* renamed from: r */
    private boolean f2595r;

    /* renamed from: s */
    private int f2596s;

    /* renamed from: t */
    private int f2597t = 0;

    /* renamed from: u */
    private boolean f2598u;

    public C0857C(Context context, C0873l menu, View anchorView, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.f2579b = context;
        this.f2580c = menu;
        this.f2582e = overflowOnly;
        this.f2581d = new C0872k(menu, LayoutInflater.from(context), this.f2582e);
        this.f2584g = popupStyleAttr;
        this.f2585h = popupStyleRes;
        Resources res = context.getResources();
        this.f2583f = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(C0793R.dimen.abc_config_prefDialogWidth));
        this.f2590m = anchorView;
        this.f2586i = new C1131xa(this.f2579b, null, this.f2584g, this.f2585h);
        menu.mo6709a((C0890v) this, context);
    }

    /* renamed from: b */
    public void mo6552b(boolean forceShow) {
        this.f2581d.mo6693a(forceShow);
    }

    /* renamed from: a */
    public void mo6546a(int gravity) {
        this.f2597t = gravity;
    }

    /* renamed from: g */
    private boolean m4021g() {
        if (mo6555c()) {
            return true;
        }
        if (!this.f2594q) {
            View view = this.f2590m;
            if (view != null) {
                this.f2591n = view;
                this.f2586i.mo8689a((OnDismissListener) this);
                this.f2586i.mo8688a((OnItemClickListener) this);
                this.f2586i.mo8690a(true);
                View anchor = this.f2591n;
                boolean addGlobalListener = this.f2593p == null;
                this.f2593p = anchor.getViewTreeObserver();
                if (addGlobalListener) {
                    this.f2593p.addOnGlobalLayoutListener(this.f2587j);
                }
                anchor.addOnAttachStateChangeListener(this.f2588k);
                this.f2586i.mo8687a(anchor);
                this.f2586i.mo8694c(this.f2597t);
                if (!this.f2595r) {
                    this.f2596s = C0887s.m4232a(this.f2581d, null, this.f2579b, this.f2583f);
                    this.f2595r = true;
                }
                this.f2586i.mo8692b(this.f2596s);
                this.f2586i.mo8697e(2);
                this.f2586i.mo8685a(mo6887f());
                this.f2586i.show();
                ListView listView = this.f2586i.mo6556d();
                listView.setOnKeyListener(this);
                if (this.f2598u && this.f2580c.mo6745h() != null) {
                    FrameLayout titleItemView = (FrameLayout) LayoutInflater.from(this.f2579b).inflate(C0793R.layout.abc_popup_menu_header_item_layout, listView, false);
                    TextView titleView = (TextView) titleItemView.findViewById(16908310);
                    if (titleView != null) {
                        titleView.setText(this.f2580c.mo6745h());
                    }
                    titleItemView.setEnabled(false);
                    listView.addHeaderView(titleItemView, null, false);
                }
                this.f2586i.mo6961a((ListAdapter) this.f2581d);
                this.f2586i.show();
                return true;
            }
        }
        return false;
    }

    public void show() {
        if (!m4021g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void dismiss() {
        if (mo6555c()) {
            this.f2586i.dismiss();
        }
    }

    /* renamed from: a */
    public void mo6547a(C0873l menu) {
    }

    /* renamed from: c */
    public boolean mo6555c() {
        return !this.f2594q && this.f2586i.mo6555c();
    }

    public void onDismiss() {
        this.f2594q = true;
        this.f2580c.close();
        ViewTreeObserver viewTreeObserver = this.f2593p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f2593p = this.f2591n.getViewTreeObserver();
            }
            this.f2593p.removeGlobalOnLayoutListener(this.f2587j);
            this.f2593p = null;
        }
        this.f2591n.removeOnAttachStateChangeListener(this.f2588k);
        OnDismissListener onDismissListener = this.f2589l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        this.f2595r = false;
        C0872k kVar = this.f2581d;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo6548a(C0891a cb) {
        this.f2592o = cb;
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D subMenu) {
        if (subMenu.hasVisibleItems()) {
            C0889u uVar = new C0889u(this.f2579b, subMenu, this.f2591n, this.f2582e, this.f2584g, this.f2585h);
            uVar.mo6892a(this.f2592o);
            uVar.mo6895a(C0887s.m4234b((C0873l) subMenu));
            uVar.mo6891a(this.f2597t);
            uVar.mo6894a(this.f2589l);
            this.f2589l = null;
            this.f2580c.mo6712a(false);
            if (uVar.mo6896a(this.f2586i.mo8698f(), this.f2586i.mo8700g())) {
                C0891a aVar = this.f2592o;
                if (aVar != null) {
                    aVar.mo6118a(subMenu);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        if (menu == this.f2580c) {
            dismiss();
            C0891a aVar = this.f2592o;
            if (aVar != null) {
                aVar.mo6117a(menu, allMenusAreClosing);
            }
        }
    }

    /* renamed from: b */
    public boolean mo4083b() {
        return false;
    }

    /* renamed from: a */
    public Parcelable mo4073a() {
        return null;
    }

    /* renamed from: a */
    public void mo4076a(Parcelable state) {
    }

    /* renamed from: a */
    public void mo6549a(View anchor) {
        this.f2590m = anchor;
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 1 || keyCode != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* renamed from: a */
    public void mo6550a(OnDismissListener listener) {
        this.f2589l = listener;
    }

    /* renamed from: d */
    public ListView mo6556d() {
        return this.f2586i.mo6556d();
    }

    /* renamed from: b */
    public void mo6551b(int x) {
        this.f2586i.mo8695d(x);
    }

    /* renamed from: c */
    public void mo6553c(int y) {
        this.f2586i.mo8703h(y);
    }

    /* renamed from: c */
    public void mo6554c(boolean showTitle) {
        this.f2598u = showTitle;
    }
}
