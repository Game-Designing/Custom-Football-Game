package android.support.p001v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.widget.C1128wa;
import android.support.p001v7.widget.C1131xa;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.view.menu.i */
/* compiled from: CascadingMenuPopup */
final class C0868i extends C0887s implements C0890v, OnKeyListener, OnDismissListener {

    /* renamed from: A */
    boolean f2662A;

    /* renamed from: b */
    private final Context f2663b;

    /* renamed from: c */
    private final int f2664c;

    /* renamed from: d */
    private final int f2665d;

    /* renamed from: e */
    private final int f2666e;

    /* renamed from: f */
    private final boolean f2667f;

    /* renamed from: g */
    final Handler f2668g;

    /* renamed from: h */
    private final List<C0873l> f2669h = new ArrayList();

    /* renamed from: i */
    final List<C0869a> f2670i = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final OnGlobalLayoutListener f2671j = new C0864e(this);

    /* renamed from: k */
    private final OnAttachStateChangeListener f2672k = new C0865f(this);

    /* renamed from: l */
    private final C1128wa f2673l = new C0867h(this);

    /* renamed from: m */
    private int f2674m = 0;

    /* renamed from: n */
    private int f2675n = 0;

    /* renamed from: o */
    private View f2676o;

    /* renamed from: p */
    View f2677p;

    /* renamed from: q */
    private int f2678q;

    /* renamed from: r */
    private boolean f2679r;

    /* renamed from: s */
    private boolean f2680s;

    /* renamed from: t */
    private int f2681t;

    /* renamed from: u */
    private int f2682u;

    /* renamed from: v */
    private boolean f2683v;

    /* renamed from: w */
    private boolean f2684w;

    /* renamed from: x */
    private C0891a f2685x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ViewTreeObserver f2686y;

    /* renamed from: z */
    private OnDismissListener f2687z;

    /* renamed from: android.support.v7.view.menu.i$a */
    /* compiled from: CascadingMenuPopup */
    private static class C0869a {

        /* renamed from: a */
        public final C1131xa f2688a;

        /* renamed from: b */
        public final C0873l f2689b;

        /* renamed from: c */
        public final int f2690c;

        public C0869a(C1131xa window, C0873l menu, int position) {
            this.f2688a = window;
            this.f2689b = menu;
            this.f2690c = position;
        }

        /* renamed from: a */
        public ListView mo6680a() {
            return this.f2688a.mo6556d();
        }
    }

    public C0868i(Context context, View anchor, int popupStyleAttr, int popupStyleRes, boolean overflowOnly) {
        this.f2663b = context;
        this.f2676o = anchor;
        this.f2665d = popupStyleAttr;
        this.f2666e = popupStyleRes;
        this.f2667f = overflowOnly;
        this.f2683v = false;
        this.f2678q = m4092h();
        Resources res = context.getResources();
        this.f2664c = Math.max(res.getDisplayMetrics().widthPixels / 2, res.getDimensionPixelSize(C0793R.dimen.abc_config_prefDialogWidth));
        this.f2668g = new Handler();
    }

    /* renamed from: b */
    public void mo6552b(boolean forceShow) {
        this.f2683v = forceShow;
    }

    /* renamed from: g */
    private C1131xa m4091g() {
        C1131xa popupWindow = new C1131xa(this.f2663b, null, this.f2665d, this.f2666e);
        popupWindow.mo8723a(this.f2673l);
        popupWindow.mo8688a((OnItemClickListener) this);
        popupWindow.mo8689a((OnDismissListener) this);
        popupWindow.mo8687a(this.f2676o);
        popupWindow.mo8694c(this.f2675n);
        popupWindow.mo8690a(true);
        popupWindow.mo8697e(2);
        return popupWindow;
    }

    public void show() {
        if (!mo6555c()) {
            for (C0873l menu : this.f2669h) {
                m4090d(menu);
            }
            this.f2669h.clear();
            this.f2677p = this.f2676o;
            if (this.f2677p != null) {
                boolean addGlobalListener = this.f2686y == null;
                this.f2686y = this.f2677p.getViewTreeObserver();
                if (addGlobalListener) {
                    this.f2686y.addOnGlobalLayoutListener(this.f2671j);
                }
                this.f2677p.addOnAttachStateChangeListener(this.f2672k);
            }
        }
    }

    public void dismiss() {
        int length = this.f2670i.size();
        if (length > 0) {
            C0869a[] addedMenus = (C0869a[]) this.f2670i.toArray(new C0869a[length]);
            for (int i = length - 1; i >= 0; i--) {
                C0869a info = addedMenus[i];
                if (info.f2688a.mo6555c()) {
                    info.f2688a.dismiss();
                }
            }
        }
    }

    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() != 1 || keyCode != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* renamed from: h */
    private int m4092h() {
        return C0646w.m2974h(this.f2676o) == 1 ? 0 : 1;
    }

    /* renamed from: d */
    private int m4089d(int nextMenuWidth) {
        List<C0869a> list = this.f2670i;
        ListView lastListView = ((C0869a) list.get(list.size() - 1)).mo6680a();
        int[] screenLocation = new int[2];
        lastListView.getLocationOnScreen(screenLocation);
        Rect displayFrame = new Rect();
        this.f2677p.getWindowVisibleDisplayFrame(displayFrame);
        if (this.f2678q == 1) {
            if (screenLocation[0] + lastListView.getWidth() + nextMenuWidth > displayFrame.right) {
                return 0;
            }
            return 1;
        } else if (screenLocation[0] - nextMenuWidth < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: a */
    public void mo6547a(C0873l menu) {
        menu.mo6709a((C0890v) this, this.f2663b);
        if (mo6555c()) {
            m4090d(menu);
        } else {
            this.f2669h.add(menu);
        }
    }

    /* renamed from: d */
    private void m4090d(C0873l menu) {
        View parentView;
        C0869a parentInfo;
        int parentOffsetY;
        int parentOffsetX;
        int x;
        C0873l lVar = menu;
        LayoutInflater inflater = LayoutInflater.from(this.f2663b);
        C0872k adapter = new C0872k(lVar, inflater, this.f2667f);
        if (!mo6555c() && this.f2683v) {
            adapter.mo6693a(true);
        } else if (mo6555c()) {
            adapter.mo6693a(C0887s.m4234b(menu));
        }
        int menuWidth = C0887s.m4232a(adapter, null, this.f2663b, this.f2664c);
        C1131xa popupWindow = m4091g();
        popupWindow.mo6961a((ListAdapter) adapter);
        popupWindow.mo8692b(menuWidth);
        popupWindow.mo8694c(this.f2675n);
        if (this.f2670i.size() > 0) {
            List<C0869a> list = this.f2670i;
            parentInfo = (C0869a) list.get(list.size() - 1);
            parentView = m4084a(parentInfo, lVar);
        } else {
            parentInfo = null;
            parentView = null;
        }
        if (parentView != null) {
            popupWindow.mo8726c(false);
            popupWindow.mo8724a((Object) null);
            int nextMenuPosition = m4089d(menuWidth);
            boolean showOnRight = nextMenuPosition == 1;
            this.f2678q = nextMenuPosition;
            if (VERSION.SDK_INT >= 26) {
                popupWindow.mo8687a(parentView);
                parentOffsetX = 0;
                parentOffsetY = 0;
            } else {
                int[] anchorScreenLocation = new int[2];
                this.f2676o.getLocationOnScreen(anchorScreenLocation);
                int[] parentViewScreenLocation = new int[2];
                parentView.getLocationOnScreen(parentViewScreenLocation);
                if ((this.f2675n & 7) == 5) {
                    anchorScreenLocation[0] = anchorScreenLocation[0] + this.f2676o.getWidth();
                    parentViewScreenLocation[0] = parentViewScreenLocation[0] + parentView.getWidth();
                }
                parentOffsetX = parentViewScreenLocation[0] - anchorScreenLocation[0];
                parentOffsetY = parentViewScreenLocation[1] - anchorScreenLocation[1];
            }
            if ((this.f2675n & 5) == 5) {
                if (showOnRight) {
                    x = parentOffsetX + menuWidth;
                } else {
                    x = parentOffsetX - parentView.getWidth();
                }
            } else if (showOnRight) {
                x = parentView.getWidth() + parentOffsetX;
            } else {
                x = parentOffsetX - menuWidth;
            }
            popupWindow.mo8695d(x);
            popupWindow.mo8693b(true);
            popupWindow.mo8703h(parentOffsetY);
        } else {
            if (this.f2679r) {
                popupWindow.mo8695d(this.f2681t);
            }
            if (this.f2680s) {
                popupWindow.mo8703h(this.f2682u);
            }
            popupWindow.mo8685a(mo6887f());
        }
        this.f2670i.add(new C0869a(popupWindow, lVar, this.f2678q));
        popupWindow.show();
        ListView listView = popupWindow.mo6556d();
        listView.setOnKeyListener(this);
        if (parentInfo == null && this.f2684w && menu.mo6745h() != null) {
            FrameLayout titleItemView = (FrameLayout) inflater.inflate(C0793R.layout.abc_popup_menu_header_item_layout, listView, false);
            TextView titleView = (TextView) titleItemView.findViewById(16908310);
            titleItemView.setEnabled(false);
            titleView.setText(menu.mo6745h());
            listView.addHeaderView(titleItemView, null, false);
            popupWindow.show();
        }
    }

    /* renamed from: a */
    private MenuItem m4083a(C0873l parent, C0873l submenu) {
        int count = parent.size();
        for (int i = 0; i < count; i++) {
            MenuItem item = parent.getItem(i);
            if (item.hasSubMenu() && submenu == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private View m4084a(C0869a parentInfo, C0873l submenu) {
        int headersCount;
        C0872k menuAdapter;
        MenuItem owner = m4083a(parentInfo.f2689b, submenu);
        if (owner == null) {
            return null;
        }
        ListView listView = parentInfo.mo6680a();
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerAdapter = (HeaderViewListAdapter) listAdapter;
            headersCount = headerAdapter.getHeadersCount();
            menuAdapter = (C0872k) headerAdapter.getWrappedAdapter();
        } else {
            headersCount = 0;
            menuAdapter = (C0872k) listAdapter;
        }
        int ownerPosition = -1;
        int i = 0;
        int count = menuAdapter.getCount();
        while (true) {
            if (i >= count) {
                break;
            } else if (owner == menuAdapter.getItem(i)) {
                ownerPosition = i;
                break;
            } else {
                i++;
            }
        }
        if (ownerPosition == -1) {
            return null;
        }
        int ownerViewPosition = (ownerPosition + headersCount) - listView.getFirstVisiblePosition();
        if (ownerViewPosition < 0 || ownerViewPosition >= listView.getChildCount()) {
            return null;
        }
        return listView.getChildAt(ownerViewPosition);
    }

    /* renamed from: c */
    public boolean mo6555c() {
        return this.f2670i.size() > 0 && ((C0869a) this.f2670i.get(0)).f2688a.mo6555c();
    }

    public void onDismiss() {
        C0869a dismissedInfo = null;
        int i = 0;
        int count = this.f2670i.size();
        while (true) {
            if (i >= count) {
                break;
            }
            C0869a info = (C0869a) this.f2670i.get(i);
            if (!info.f2688a.mo6555c()) {
                dismissedInfo = info;
                break;
            }
            i++;
        }
        if (dismissedInfo != null) {
            dismissedInfo.f2689b.mo6712a(false);
        }
    }

    /* renamed from: a */
    public void mo4079a(boolean cleared) {
        for (C0869a info : this.f2670i) {
            C0887s.m4233a(info.mo6680a().getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public void mo6548a(C0891a cb) {
        this.f2685x = cb;
    }

    /* renamed from: a */
    public boolean mo4080a(C0858D subMenu) {
        for (C0869a info : this.f2670i) {
            if (subMenu == info.f2689b) {
                info.mo6680a().requestFocus();
                return true;
            }
        }
        if (!subMenu.hasVisibleItems()) {
            return false;
        }
        mo6547a((C0873l) subMenu);
        C0891a aVar = this.f2685x;
        if (aVar != null) {
            aVar.mo6118a(subMenu);
        }
        return true;
    }

    /* renamed from: c */
    private int m4088c(C0873l menu) {
        int count = this.f2670i.size();
        for (int i = 0; i < count; i++) {
            if (menu == ((C0869a) this.f2670i.get(i)).f2689b) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        int menuIndex = m4088c(menu);
        if (menuIndex >= 0) {
            int nextMenuIndex = menuIndex + 1;
            if (nextMenuIndex < this.f2670i.size()) {
                ((C0869a) this.f2670i.get(nextMenuIndex)).f2689b.mo6712a(false);
            }
            C0869a info = (C0869a) this.f2670i.remove(menuIndex);
            info.f2689b.mo6726b((C0890v) this);
            if (this.f2662A) {
                info.f2688a.mo8725b(null);
                info.f2688a.mo8684a(0);
            }
            info.f2688a.dismiss();
            int count = this.f2670i.size();
            if (count > 0) {
                this.f2678q = ((C0869a) this.f2670i.get(count - 1)).f2690c;
            } else {
                this.f2678q = m4092h();
            }
            if (count == 0) {
                dismiss();
                C0891a aVar = this.f2685x;
                if (aVar != null) {
                    aVar.mo6117a(menu, true);
                }
                ViewTreeObserver viewTreeObserver = this.f2686y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f2686y.removeGlobalOnLayoutListener(this.f2671j);
                    }
                    this.f2686y = null;
                }
                this.f2677p.removeOnAttachStateChangeListener(this.f2672k);
                this.f2687z.onDismiss();
            } else if (allMenusAreClosing) {
                ((C0869a) this.f2670i.get(0)).f2689b.mo6712a(false);
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
    public void mo6546a(int dropDownGravity) {
        if (this.f2674m != dropDownGravity) {
            this.f2674m = dropDownGravity;
            this.f2675n = C0623f.m2881a(dropDownGravity, C0646w.m2974h(this.f2676o));
        }
    }

    /* renamed from: a */
    public void mo6549a(View anchor) {
        if (this.f2676o != anchor) {
            this.f2676o = anchor;
            this.f2675n = C0623f.m2881a(this.f2674m, C0646w.m2974h(this.f2676o));
        }
    }

    /* renamed from: a */
    public void mo6550a(OnDismissListener listener) {
        this.f2687z = listener;
    }

    /* renamed from: d */
    public ListView mo6556d() {
        if (this.f2670i.isEmpty()) {
            return null;
        }
        List<C0869a> list = this.f2670i;
        return ((C0869a) list.get(list.size() - 1)).mo6680a();
    }

    /* renamed from: b */
    public void mo6551b(int x) {
        this.f2679r = true;
        this.f2681t = x;
    }

    /* renamed from: c */
    public void mo6553c(int y) {
        this.f2680s = true;
        this.f2682u = y;
    }

    /* renamed from: c */
    public void mo6554c(boolean showTitle) {
        this.f2684w = showTitle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo6677e() {
        return false;
    }
}
