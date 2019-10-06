package android.support.p001v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.app.C0445Y;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0624g;
import android.support.p000v4.view.C0641r;
import android.support.p000v4.view.C0646w;
import android.support.p000v4.widget.C0716r;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0870j;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0890v;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.view.menu.C0892w;
import android.support.p001v7.widget.ActionBarContextView;
import android.support.p001v7.widget.C0930Fb;
import android.support.p001v7.widget.C0946Ib;
import android.support.p001v7.widget.C1016T;
import android.support.p001v7.widget.C1076ka;
import android.support.p001v7.widget.C1096p;
import android.support.p001v7.widget.ContentFrameLayout;
import android.support.p001v7.widget.Toolbar;
import android.support.p001v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;
import p002b.p003c.p062h.p071g.C1303d;
import p002b.p003c.p062h.p071g.C1304e;

/* renamed from: android.support.v7.app.D */
/* compiled from: AppCompatDelegateImplV9 */
class C0737D extends C0778r implements C0874a, Factory2 {

    /* renamed from: u */
    private static final boolean f2183u = (VERSION.SDK_INT < 21);

    /* renamed from: A */
    PopupWindow f2184A;

    /* renamed from: B */
    Runnable f2185B;

    /* renamed from: C */
    C0587I f2186C = null;

    /* renamed from: D */
    private boolean f2187D;

    /* renamed from: E */
    private ViewGroup f2188E;

    /* renamed from: F */
    private TextView f2189F;

    /* renamed from: G */
    private View f2190G;

    /* renamed from: H */
    private boolean f2191H;

    /* renamed from: I */
    private boolean f2192I;

    /* renamed from: J */
    private boolean f2193J;

    /* renamed from: K */
    private C0741d[] f2194K;

    /* renamed from: L */
    private C0741d f2195L;

    /* renamed from: M */
    private boolean f2196M;

    /* renamed from: N */
    boolean f2197N;

    /* renamed from: O */
    int f2198O;

    /* renamed from: P */
    private final Runnable f2199P = new C0789w(this);

    /* renamed from: Q */
    private boolean f2200Q;

    /* renamed from: R */
    private Rect f2201R;

    /* renamed from: S */
    private Rect f2202S;

    /* renamed from: T */
    private AppCompatViewInflater f2203T;

    /* renamed from: v */
    private C1016T f2204v;

    /* renamed from: w */
    private C0738a f2205w;

    /* renamed from: x */
    private C0742e f2206x;

    /* renamed from: y */
    C1300b f2207y;

    /* renamed from: z */
    ActionBarContextView f2208z;

    /* renamed from: android.support.v7.app.D$a */
    /* compiled from: AppCompatDelegateImplV9 */
    private final class C0738a implements C0891a {
        C0738a() {
        }

        /* renamed from: a */
        public boolean mo6118a(C0873l subMenu) {
            Callback cb = C0737D.this.mo6253o();
            if (cb != null) {
                cb.onMenuOpened(108, subMenu);
            }
            return true;
        }

        /* renamed from: a */
        public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
            C0737D.this.mo6095b(menu);
        }
    }

    /* renamed from: android.support.v7.app.D$b */
    /* compiled from: AppCompatDelegateImplV9 */
    class C0739b implements C1301a {

        /* renamed from: a */
        private C1301a f2210a;

        public C0739b(C1301a wrapped) {
            this.f2210a = wrapped;
        }

        /* renamed from: a */
        public boolean mo6120a(C1300b mode, Menu menu) {
            return this.f2210a.mo6120a(mode, menu);
        }

        /* renamed from: b */
        public boolean mo6122b(C1300b mode, Menu menu) {
            return this.f2210a.mo6122b(mode, menu);
        }

        /* renamed from: a */
        public boolean mo6121a(C1300b mode, MenuItem item) {
            return this.f2210a.mo6121a(mode, item);
        }

        /* renamed from: a */
        public void mo6119a(C1300b mode) {
            this.f2210a.mo6119a(mode);
            C0737D d = C0737D.this;
            if (d.f2184A != null) {
                d.f2348g.getDecorView().removeCallbacks(C0737D.this.f2185B);
            }
            C0737D d2 = C0737D.this;
            if (d2.f2208z != null) {
                d2.mo6114t();
                C0737D d3 = C0737D.this;
                C0587I a = C0646w.m2945a(d3.f2208z);
                a.mo5470a(0.0f);
                d3.f2186C = a;
                C0737D.this.f2186C.mo5472a((C0589J) new C0743E(this));
            }
            C0737D d4 = C0737D.this;
            C0020o oVar = d4.f2351j;
            if (oVar != null) {
                oVar.onSupportActionModeFinished(d4.f2207y);
            }
            C0737D.this.f2207y = null;
        }
    }

    /* renamed from: android.support.v7.app.D$c */
    /* compiled from: AppCompatDelegateImplV9 */
    private class C0740c extends ContentFrameLayout {
        public C0740c(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent event) {
            return C0737D.this.mo6090a(event) || super.dispatchKeyEvent(event);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            if (event.getAction() != 0 || !m3479a((int) event.getX(), (int) event.getY())) {
                return super.onInterceptTouchEvent(event);
            }
            C0737D.this.mo6102d(0);
            return true;
        }

        public void setBackgroundResource(int resid) {
            setBackgroundDrawable(C1282b.m6000b(getContext(), resid));
        }

        /* renamed from: a */
        private boolean m3479a(int x, int y) {
            return x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5;
        }
    }

    /* renamed from: android.support.v7.app.D$d */
    /* compiled from: AppCompatDelegateImplV9 */
    protected static final class C0741d {

        /* renamed from: a */
        int f2213a;

        /* renamed from: b */
        int f2214b;

        /* renamed from: c */
        int f2215c;

        /* renamed from: d */
        int f2216d;

        /* renamed from: e */
        int f2217e;

        /* renamed from: f */
        int f2218f;

        /* renamed from: g */
        ViewGroup f2219g;

        /* renamed from: h */
        View f2220h;

        /* renamed from: i */
        View f2221i;

        /* renamed from: j */
        C0873l f2222j;

        /* renamed from: k */
        C0870j f2223k;

        /* renamed from: l */
        Context f2224l;

        /* renamed from: m */
        boolean f2225m;

        /* renamed from: n */
        boolean f2226n;

        /* renamed from: o */
        boolean f2227o;

        /* renamed from: p */
        public boolean f2228p;

        /* renamed from: q */
        boolean f2229q = false;

        /* renamed from: r */
        boolean f2230r;

        /* renamed from: s */
        Bundle f2231s;

        C0741d(int featureId) {
            this.f2213a = featureId;
        }

        /* renamed from: a */
        public boolean mo6129a() {
            boolean z = false;
            if (this.f2220h == null) {
                return false;
            }
            if (this.f2221i != null) {
                return true;
            }
            if (this.f2223k.mo6684c().getCount() > 0) {
                z = true;
            }
            return z;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6127a(Context context) {
            TypedValue outValue = new TypedValue();
            Theme widgetTheme = context.getResources().newTheme();
            widgetTheme.setTo(context.getTheme());
            widgetTheme.resolveAttribute(C0793R.attr.actionBarPopupTheme, outValue, true);
            int i = outValue.resourceId;
            if (i != 0) {
                widgetTheme.applyStyle(i, true);
            }
            widgetTheme.resolveAttribute(C0793R.attr.panelMenuListTheme, outValue, true);
            int i2 = outValue.resourceId;
            if (i2 != 0) {
                widgetTheme.applyStyle(i2, true);
            } else {
                widgetTheme.applyStyle(C0793R.style.Theme_AppCompat_CompactMenu, true);
            }
            C1303d dVar = new C1303d(context, 0);
            dVar.getTheme().setTo(widgetTheme);
            this.f2224l = dVar;
            TypedArray a = dVar.obtainStyledAttributes(C0793R.styleable.AppCompatTheme);
            this.f2214b = a.getResourceId(C0793R.styleable.AppCompatTheme_panelBackground, 0);
            this.f2218f = a.getResourceId(C0793R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            a.recycle();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo6128a(C0873l menu) {
            C0873l lVar = this.f2222j;
            if (menu != lVar) {
                if (lVar != null) {
                    lVar.mo6726b((C0890v) this.f2223k);
                }
                this.f2222j = menu;
                if (menu != null) {
                    C0870j jVar = this.f2223k;
                    if (jVar != null) {
                        menu.mo6708a((C0890v) jVar);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C0892w mo6126a(C0891a cb) {
            if (this.f2222j == null) {
                return null;
            }
            if (this.f2223k == null) {
                this.f2223k = new C0870j(this.f2224l, C0793R.layout.abc_list_menu_item_layout);
                this.f2223k.mo6548a(cb);
                this.f2222j.mo6708a((C0890v) this.f2223k);
            }
            return this.f2223k.mo6681a(this.f2219g);
        }
    }

    /* renamed from: android.support.v7.app.D$e */
    /* compiled from: AppCompatDelegateImplV9 */
    private final class C0742e implements C0891a {
        C0742e() {
        }

        /* renamed from: a */
        public void mo6117a(C0873l menu, boolean allMenusAreClosing) {
            C0873l m = menu.mo6567m();
            boolean isSubMenu = m != menu;
            C0741d panel = C0737D.this.mo6076a((Menu) isSubMenu ? m : menu);
            if (panel == null) {
                return;
            }
            if (isSubMenu) {
                C0737D.this.mo6080a(panel.f2213a, panel, m);
                C0737D.this.mo6083a(panel, true);
                return;
            }
            C0737D.this.mo6083a(panel, allMenusAreClosing);
        }

        /* renamed from: a */
        public boolean mo6118a(C0873l subMenu) {
            if (subMenu == null) {
                C0737D d = C0737D.this;
                if (d.f2354m) {
                    Callback cb = d.mo6253o();
                    if (cb != null && !C0737D.this.mo6254q()) {
                        cb.onMenuOpened(108, subMenu);
                    }
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo6078a(View view, String str, Context context, AttributeSet attributeSet) {
        throw null;
    }

    C0737D(Context context, Window window, C0020o callback) {
        super(context, window, callback);
    }

    /* renamed from: a */
    public void mo6082a(Bundle savedInstanceState) {
        Callback callback = this.f2349h;
        if ((callback instanceof Activity) && C0445Y.m2295b((Activity) callback) != null) {
            C0760a ab = mo6255r();
            if (ab == null) {
                this.f2200Q = true;
            } else {
                ab.mo6152c(true);
            }
        }
    }

    /* renamed from: b */
    public void mo6094b(Bundle savedInstanceState) {
        m3429y();
    }

    /* renamed from: p */
    public void mo6112p() {
        m3429y();
        if (this.f2354m && this.f2352k == null) {
            Callback callback = this.f2349h;
            if (callback instanceof Activity) {
                this.f2352k = new C0758P((Activity) callback, this.f2355n);
            } else if (callback instanceof Dialog) {
                this.f2352k = new C0758P((Dialog) callback);
            }
            C0760a aVar = this.f2352k;
            if (aVar != null) {
                aVar.mo6152c(this.f2200Q);
            }
        }
    }

    /* renamed from: a */
    public void mo6084a(Toolbar toolbar) {
        if (this.f2349h instanceof Activity) {
            C0760a ab = mo6247e();
            if (!(ab instanceof C0758P)) {
                this.f2353l = null;
                if (ab != null) {
                    ab.mo6162j();
                }
                if (toolbar != null) {
                    C0748J tbab = new C0748J(toolbar, ((Activity) this.f2349h).getTitle(), this.f2350i);
                    this.f2352k = tbab;
                    this.f2348g.setCallback(tbab.mo6164l());
                } else {
                    this.f2352k = null;
                    this.f2348g.setCallback(this.f2350i);
                }
                mo6106g();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    /* renamed from: a */
    public <T extends View> T mo6077a(int id) {
        m3429y();
        return this.f2348g.findViewById(id);
    }

    /* renamed from: a */
    public void mo6081a(Configuration newConfig) {
        if (this.f2354m && this.f2187D) {
            C0760a ab = mo6247e();
            if (ab != null) {
                ab.mo6145a(newConfig);
            }
        }
        C1096p.m5420a().mo8568a(this.f2347f);
        mo6243a();
    }

    /* renamed from: l */
    public void mo6109l() {
        C0760a ab = mo6247e();
        if (ab != null) {
            ab.mo6159g(false);
        }
    }

    /* renamed from: j */
    public void mo6108j() {
        C0760a ab = mo6247e();
        if (ab != null) {
            ab.mo6159g(true);
        }
    }

    /* renamed from: a */
    public void mo6085a(View v) {
        m3429y();
        ViewGroup contentParent = (ViewGroup) this.f2188E.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v);
        this.f2349h.onContentChanged();
    }

    /* renamed from: c */
    public void mo6100c(int resId) {
        m3429y();
        ViewGroup contentParent = (ViewGroup) this.f2188E.findViewById(16908290);
        contentParent.removeAllViews();
        LayoutInflater.from(this.f2347f).inflate(resId, contentParent);
        this.f2349h.onContentChanged();
    }

    /* renamed from: b */
    public void mo6096b(View v, LayoutParams lp) {
        m3429y();
        ViewGroup contentParent = (ViewGroup) this.f2188E.findViewById(16908290);
        contentParent.removeAllViews();
        contentParent.addView(v, lp);
        this.f2349h.onContentChanged();
    }

    /* renamed from: a */
    public void mo6086a(View v, LayoutParams lp) {
        m3429y();
        ((ViewGroup) this.f2188E.findViewById(16908290)).addView(v, lp);
        this.f2349h.onContentChanged();
    }

    /* renamed from: i */
    public void mo6107i() {
        if (this.f2197N) {
            this.f2348g.getDecorView().removeCallbacks(this.f2199P);
        }
        super.mo6107i();
        C0760a aVar = this.f2352k;
        if (aVar != null) {
            aVar.mo6162j();
        }
    }

    /* renamed from: y */
    private void m3429y() {
        if (!this.f2187D) {
            this.f2188E = m3428x();
            CharSequence title = mo6252n();
            if (!TextUtils.isEmpty(title)) {
                mo6097b(title);
            }
            mo6264w();
            mo6087a(this.f2188E);
            this.f2187D = true;
            C0741d st = mo6075a(0, false);
            if (mo6254q()) {
                return;
            }
            if (st == null || st.f2222j == null) {
                mo6263g(108);
            }
        }
    }

    /* renamed from: x */
    private ViewGroup m3428x() {
        Context themedContext;
        TypedArray a = this.f2347f.obtainStyledAttributes(C0793R.styleable.AppCompatTheme);
        if (a.hasValue(C0793R.styleable.AppCompatTheme_windowActionBar)) {
            if (a.getBoolean(C0793R.styleable.AppCompatTheme_windowNoTitle, false)) {
                mo6098b(1);
            } else if (a.getBoolean(C0793R.styleable.AppCompatTheme_windowActionBar, false)) {
                mo6098b(108);
            }
            if (a.getBoolean(C0793R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                mo6098b(109);
            }
            if (a.getBoolean(C0793R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                mo6098b(10);
            }
            this.f2357p = a.getBoolean(C0793R.styleable.AppCompatTheme_android_windowIsFloating, false);
            a.recycle();
            this.f2348g.getDecorView();
            LayoutInflater inflater = LayoutInflater.from(this.f2347f);
            ViewGroup subDecor = null;
            if (this.f2358q) {
                if (this.f2356o) {
                    subDecor = (ViewGroup) inflater.inflate(C0793R.layout.abc_screen_simple_overlay_action_mode, null);
                } else {
                    subDecor = (ViewGroup) inflater.inflate(C0793R.layout.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    C0646w.m2956a((View) subDecor, (C0641r) new C0790x(this));
                } else {
                    ((C1076ka) subDecor).setOnFitSystemWindowsListener(new C0791y(this));
                }
            } else if (this.f2357p) {
                subDecor = (ViewGroup) inflater.inflate(C0793R.layout.abc_dialog_title_material, null);
                this.f2355n = false;
                this.f2354m = false;
            } else if (this.f2354m) {
                TypedValue outValue = new TypedValue();
                this.f2347f.getTheme().resolveAttribute(C0793R.attr.actionBarTheme, outValue, true);
                int i = outValue.resourceId;
                if (i != 0) {
                    themedContext = new C1303d(this.f2347f, i);
                } else {
                    themedContext = this.f2347f;
                }
                subDecor = (ViewGroup) LayoutInflater.from(themedContext).inflate(C0793R.layout.abc_screen_toolbar, null);
                this.f2204v = (C1016T) subDecor.findViewById(C0793R.C0794id.decor_content_parent);
                this.f2204v.setWindowCallback(mo6253o());
                if (this.f2355n) {
                    this.f2204v.mo7023a(109);
                }
                if (this.f2191H) {
                    this.f2204v.mo7023a(2);
                }
                if (this.f2192I) {
                    this.f2204v.mo7023a(5);
                }
            }
            if (subDecor != null) {
                if (this.f2204v == null) {
                    this.f2189F = (TextView) subDecor.findViewById(C0793R.C0794id.title);
                }
                C0946Ib.m4566b(subDecor);
                ContentFrameLayout contentView = (ContentFrameLayout) subDecor.findViewById(C0793R.C0794id.action_bar_activity_content);
                ViewGroup windowContentView = (ViewGroup) this.f2348g.findViewById(16908290);
                if (windowContentView != null) {
                    while (windowContentView.getChildCount() > 0) {
                        View child = windowContentView.getChildAt(0);
                        windowContentView.removeViewAt(0);
                        contentView.addView(child);
                    }
                    windowContentView.setId(-1);
                    contentView.setId(16908290);
                    if (windowContentView instanceof FrameLayout) {
                        ((FrameLayout) windowContentView).setForeground(null);
                    }
                }
                this.f2348g.setContentView(subDecor);
                contentView.setAttachListener(new C0792z(this));
                return subDecor;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("AppCompat does not support the current theme features: { windowActionBar: ");
            sb.append(this.f2354m);
            sb.append(", windowActionBarOverlay: ");
            sb.append(this.f2355n);
            sb.append(", android:windowIsFloating: ");
            sb.append(this.f2357p);
            sb.append(", windowActionModeOverlay: ");
            sb.append(this.f2356o);
            sb.append(", windowNoTitle: ");
            sb.append(this.f2358q);
            sb.append(" }");
            throw new IllegalArgumentException(sb.toString());
        }
        a.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6087a(ViewGroup subDecor) {
    }

    /* renamed from: w */
    private void mo6264w() {
        ContentFrameLayout cfl = (ContentFrameLayout) this.f2188E.findViewById(16908290);
        View windowDecor = this.f2348g.getDecorView();
        cfl.mo7173a(windowDecor.getPaddingLeft(), windowDecor.getPaddingTop(), windowDecor.getPaddingRight(), windowDecor.getPaddingBottom());
        TypedArray a = this.f2347f.obtainStyledAttributes(C0793R.styleable.AppCompatTheme);
        a.getValue(C0793R.styleable.AppCompatTheme_windowMinWidthMajor, cfl.getMinWidthMajor());
        a.getValue(C0793R.styleable.AppCompatTheme_windowMinWidthMinor, cfl.getMinWidthMinor());
        if (a.hasValue(C0793R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            a.getValue(C0793R.styleable.AppCompatTheme_windowFixedWidthMajor, cfl.getFixedWidthMajor());
        }
        if (a.hasValue(C0793R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            a.getValue(C0793R.styleable.AppCompatTheme_windowFixedWidthMinor, cfl.getFixedWidthMinor());
        }
        if (a.hasValue(C0793R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            a.getValue(C0793R.styleable.AppCompatTheme_windowFixedHeightMajor, cfl.getFixedHeightMajor());
        }
        if (a.hasValue(C0793R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            a.getValue(C0793R.styleable.AppCompatTheme_windowFixedHeightMinor, cfl.getFixedHeightMinor());
        }
        a.recycle();
        cfl.requestLayout();
    }

    /* renamed from: b */
    public boolean mo6098b(int featureId) {
        int featureId2 = m3426h(featureId);
        if (this.f2358q && featureId2 == 108) {
            return false;
        }
        if (this.f2354m && featureId2 == 1) {
            this.f2354m = false;
        }
        if (featureId2 == 1) {
            m3430z();
            this.f2358q = true;
            return true;
        } else if (featureId2 == 2) {
            m3430z();
            this.f2191H = true;
            return true;
        } else if (featureId2 == 5) {
            m3430z();
            this.f2192I = true;
            return true;
        } else if (featureId2 == 10) {
            m3430z();
            this.f2356o = true;
            return true;
        } else if (featureId2 == 108) {
            m3430z();
            this.f2354m = true;
            return true;
        } else if (featureId2 != 109) {
            return this.f2348g.requestFeature(featureId2);
        } else {
            m3430z();
            this.f2355n = true;
            return true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6097b(CharSequence title) {
        C1016T t = this.f2204v;
        if (t != null) {
            t.setWindowTitle(title);
        } else if (mo6255r() != null) {
            mo6255r().mo6150b(title);
        } else {
            TextView textView = this.f2189F;
            if (textView != null) {
                textView.setText(title);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6093b(int featureId, Menu menu) {
        if (featureId == 108) {
            C0760a ab = mo6247e();
            if (ab != null) {
                ab.mo6151b(false);
            }
        } else if (featureId == 0) {
            C0741d st = mo6075a(featureId, true);
            if (st.f2227o) {
                mo6083a(st, false);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6089a(int featureId, Menu menu) {
        if (featureId != 108) {
            return false;
        }
        C0760a ab = mo6247e();
        if (ab != null) {
            ab.mo6151b(true);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo4699a(C0873l menu, MenuItem item) {
        Callback cb = mo6253o();
        if (cb != null && !mo6254q()) {
            C0741d panel = mo6076a((Menu) menu.mo6567m());
            if (panel != null) {
                return cb.onMenuItemSelected(panel.f2213a, item);
            }
        }
        return false;
    }

    /* renamed from: a */
    public void mo4698a(C0873l menu) {
        m3416a(menu, true);
    }

    /* renamed from: a */
    public C1300b mo6079a(C1301a callback) {
        if (callback != null) {
            C1300b bVar = this.f2207y;
            if (bVar != null) {
                bVar.mo6185a();
            }
            C1301a wrappedCallback = new C0739b(callback);
            C0760a ab = mo6247e();
            if (ab != null) {
                this.f2207y = ab.mo6170a(wrappedCallback);
                C1300b bVar2 = this.f2207y;
                if (bVar2 != null) {
                    C0020o oVar = this.f2351j;
                    if (oVar != null) {
                        oVar.onSupportActionModeStarted(bVar2);
                    }
                }
            }
            if (this.f2207y == null) {
                this.f2207y = mo6092b(wrappedCallback);
            }
            return this.f2207y;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    /* renamed from: g */
    public void mo6106g() {
        C0760a ab = mo6247e();
        if (ab == null || !ab.mo6161i()) {
            mo6263g(0);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C1300b mo6092b(C1301a callback) {
        Context actionBarContext;
        mo6114t();
        C1300b bVar = this.f2207y;
        if (bVar != null) {
            bVar.mo6185a();
        }
        if (!(callback instanceof C0739b)) {
            callback = new C0739b(callback);
        }
        C1300b mode = null;
        if (this.f2351j != null && !mo6254q()) {
            try {
                mode = this.f2351j.onWindowStartingSupportActionMode(callback);
            } catch (AbstractMethodError e) {
            }
        }
        if (mode != null) {
            this.f2207y = mode;
        } else {
            boolean z = true;
            if (this.f2208z == null) {
                if (this.f2357p) {
                    TypedValue outValue = new TypedValue();
                    Theme baseTheme = this.f2347f.getTheme();
                    baseTheme.resolveAttribute(C0793R.attr.actionBarTheme, outValue, true);
                    if (outValue.resourceId != 0) {
                        Theme actionBarTheme = this.f2347f.getResources().newTheme();
                        actionBarTheme.setTo(baseTheme);
                        actionBarTheme.applyStyle(outValue.resourceId, true);
                        C1303d dVar = new C1303d(this.f2347f, 0);
                        dVar.getTheme().setTo(actionBarTheme);
                        actionBarContext = dVar;
                    } else {
                        actionBarContext = this.f2347f;
                    }
                    this.f2208z = new ActionBarContextView(actionBarContext);
                    this.f2184A = new PopupWindow(actionBarContext, null, C0793R.attr.actionModePopupWindowStyle);
                    C0716r.m3354a(this.f2184A, 2);
                    this.f2184A.setContentView(this.f2208z);
                    this.f2184A.setWidth(-1);
                    actionBarContext.getTheme().resolveAttribute(C0793R.attr.actionBarSize, outValue, true);
                    this.f2208z.setContentHeight(TypedValue.complexToDimensionPixelSize(outValue.data, actionBarContext.getResources().getDisplayMetrics()));
                    this.f2184A.setHeight(-2);
                    this.f2185B = new C0735B(this);
                } else {
                    ViewStubCompat stub = (ViewStubCompat) this.f2188E.findViewById(C0793R.C0794id.action_mode_bar_stub);
                    if (stub != null) {
                        stub.setLayoutInflater(LayoutInflater.from(mo6251m()));
                        this.f2208z = (ActionBarContextView) stub.mo8351a();
                    }
                }
            }
            if (this.f2208z != null) {
                mo6114t();
                this.f2208z.mo7002c();
                Context context = this.f2208z.getContext();
                ActionBarContextView actionBarContextView = this.f2208z;
                if (this.f2184A != null) {
                    z = false;
                }
                C1304e eVar = new C1304e(context, actionBarContextView, callback, z);
                if (callback.mo6120a((C1300b) eVar, eVar.mo6193c())) {
                    eVar.mo6197i();
                    this.f2208z.mo7000a(eVar);
                    this.f2207y = eVar;
                    if (mo6116v()) {
                        this.f2208z.setAlpha(0.0f);
                        C0587I a = C0646w.m2945a(this.f2208z);
                        a.mo5470a(1.0f);
                        this.f2186C = a;
                        this.f2186C.mo5472a((C0589J) new C0736C(this));
                    } else {
                        this.f2208z.setAlpha(1.0f);
                        this.f2208z.setVisibility(0);
                        this.f2208z.sendAccessibilityEvent(32);
                        if (this.f2208z.getParent() instanceof View) {
                            C0646w.m2991y((View) this.f2208z.getParent());
                        }
                    }
                    if (this.f2184A != null) {
                        this.f2348g.getDecorView().post(this.f2185B);
                    }
                } else {
                    this.f2207y = null;
                }
            }
        }
        C1300b bVar2 = this.f2207y;
        if (bVar2 != null) {
            C0020o oVar = this.f2351j;
            if (oVar != null) {
                oVar.onSupportActionModeStarted(bVar2);
            }
        }
        return this.f2207y;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: v */
    public final boolean mo6116v() {
        if (this.f2187D) {
            ViewGroup viewGroup = this.f2188E;
            if (viewGroup != null && C0646w.m2987u(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo6114t() {
        C0587I i = this.f2186C;
        if (i != null) {
            i.mo5475a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: u */
    public boolean mo6115u() {
        C1300b bVar = this.f2207y;
        if (bVar != null) {
            bVar.mo6185a();
            return true;
        }
        C0760a ab = mo6247e();
        if (ab == null || !ab.mo6157f()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6088a(int keyCode, KeyEvent ev) {
        C0760a ab = mo6247e();
        if (ab != null && ab.mo6148a(keyCode, ev)) {
            return true;
        }
        C0741d dVar = this.f2195L;
        if (dVar == null || !m3418a(dVar, ev.getKeyCode(), ev, 1)) {
            if (this.f2195L == null) {
                C0741d st = mo6075a(0, true);
                m3421b(st, ev);
                boolean handled = m3418a(st, ev.getKeyCode(), ev, 1);
                st.f2225m = false;
                if (handled) {
                    return true;
                }
            }
            return false;
        }
        C0741d dVar2 = this.f2195L;
        if (dVar2 != null) {
            dVar2.f2226n = true;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo6090a(KeyEvent event) {
        boolean isDown = true;
        if (event.getKeyCode() == 82 && this.f2349h.dispatchKeyEvent(event)) {
            return true;
        }
        int keyCode = event.getKeyCode();
        if (event.getAction() != 0) {
            isDown = false;
        }
        return isDown ? mo6099b(keyCode, event) : mo6101c(keyCode, event);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo6101c(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            boolean wasLongPressBackDown = this.f2196M;
            this.f2196M = false;
            C0741d st = mo6075a(0, false);
            if (st != null && st.f2227o) {
                if (!wasLongPressBackDown) {
                    mo6083a(st, true);
                }
                return true;
            } else if (mo6115u()) {
                return true;
            }
        } else if (keyCode == 82) {
            m3424e(0, event);
            return true;
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public boolean mo6099b(int keyCode, KeyEvent event) {
        boolean z = true;
        if (keyCode == 4) {
            if ((event.getFlags() & 128) == 0) {
                z = false;
            }
            this.f2196M = z;
        } else if (keyCode == 82) {
            m3423d(0, event);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public View mo6091b(View parent, String name, Context context, AttributeSet attrs) {
        boolean z = false;
        if (this.f2203T == null) {
            String viewInflaterClassName = this.f2347f.obtainStyledAttributes(C0793R.styleable.AppCompatTheme).getString(C0793R.styleable.AppCompatTheme_viewInflaterClass);
            if (viewInflaterClassName == null || AppCompatViewInflater.class.getName().equals(viewInflaterClassName)) {
                this.f2203T = new AppCompatViewInflater();
            } else {
                try {
                    this.f2203T = (AppCompatViewInflater) Class.forName(viewInflaterClassName).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable t) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to instantiate custom view inflater ");
                    sb.append(viewInflaterClassName);
                    sb.append(". Falling back to default.");
                    Log.i("AppCompatDelegate", sb.toString(), t);
                    this.f2203T = new AppCompatViewInflater();
                }
            }
        }
        boolean inheritContext = false;
        if (f2183u) {
            if (!(attrs instanceof XmlPullParser)) {
                z = m3419a((ViewParent) parent);
            } else if (((XmlPullParser) attrs).getDepth() > 1) {
                z = true;
            }
            inheritContext = z;
        }
        return this.f2203T.mo6060a(parent, name, context, attrs, inheritContext, f2183u, true, C0930Fb.m4471a());
    }

    /* renamed from: a */
    private boolean m3419a(ViewParent parent) {
        if (parent == null) {
            return false;
        }
        View windowDecor = this.f2348g.getDecorView();
        while (parent != null) {
            if (parent == windowDecor || !(parent instanceof View) || C0646w.m2986t((View) parent)) {
                return false;
            }
            parent = parent.getParent();
        }
        return true;
    }

    /* renamed from: f */
    public void mo6105f() {
        LayoutInflater layoutInflater = LayoutInflater.from(this.f2347f);
        if (layoutInflater.getFactory() == null) {
            C0624g.m2884b(layoutInflater, this);
        } else if (!(layoutInflater.getFactory2() instanceof C0737D)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        View view = mo6078a(parent, name, context, attrs);
        if (view != null) {
            return view;
        }
        return mo6091b(parent, name, context, attrs);
    }

    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return onCreateView(null, name, context, attrs);
    }

    /* renamed from: a */
    private void m3415a(C0741d st, KeyEvent event) {
        C0741d dVar = st;
        if (!dVar.f2227o && !mo6254q()) {
            if (dVar.f2213a == 0) {
                if ((this.f2347f.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Callback cb = mo6253o();
            if (cb == null || cb.onMenuOpened(dVar.f2213a, dVar.f2222j)) {
                WindowManager wm = (WindowManager) this.f2347f.getSystemService("window");
                if (wm != null && m3421b(st, event)) {
                    int width = -2;
                    if (dVar.f2219g == null || dVar.f2229q) {
                        ViewGroup viewGroup = dVar.f2219g;
                        if (viewGroup == null) {
                            if (!m3420b(st) || dVar.f2219g == null) {
                                return;
                            }
                        } else if (dVar.f2229q && viewGroup.getChildCount() > 0) {
                            dVar.f2219g.removeAllViews();
                        }
                        if (m3417a(st) && st.mo6129a()) {
                            LayoutParams lp = dVar.f2220h.getLayoutParams();
                            if (lp == null) {
                                lp = new LayoutParams(-2, -2);
                            }
                            dVar.f2219g.setBackgroundResource(dVar.f2214b);
                            ViewParent shownPanelParent = dVar.f2220h.getParent();
                            if (shownPanelParent != null && (shownPanelParent instanceof ViewGroup)) {
                                ((ViewGroup) shownPanelParent).removeView(dVar.f2220h);
                            }
                            dVar.f2219g.addView(dVar.f2220h, lp);
                            if (!dVar.f2220h.hasFocus()) {
                                dVar.f2220h.requestFocus();
                            }
                        } else {
                            return;
                        }
                    } else {
                        View view = dVar.f2221i;
                        if (view != null) {
                            LayoutParams lp2 = view.getLayoutParams();
                            if (lp2 != null && lp2.width == -1) {
                                width = -1;
                            }
                        }
                    }
                    dVar.f2226n = false;
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(width, -2, dVar.f2216d, dVar.f2217e, 1002, 8519680, -3);
                    layoutParams.gravity = dVar.f2215c;
                    layoutParams.windowAnimations = dVar.f2218f;
                    wm.addView(dVar.f2219g, layoutParams);
                    dVar.f2227o = true;
                    return;
                }
                return;
            }
            mo6083a(dVar, true);
        }
    }

    /* renamed from: b */
    private boolean m3420b(C0741d st) {
        st.mo6127a(mo6251m());
        st.f2219g = new C0740c(st.f2224l);
        st.f2215c = 81;
        return true;
    }

    /* renamed from: a */
    private void m3416a(C0873l menu, boolean toggleMenuMode) {
        C1016T t = this.f2204v;
        if (t == null || !t.mo7025a() || (ViewConfiguration.get(this.f2347f).hasPermanentMenuKey() && !this.f2204v.mo7032f())) {
            C0741d st = mo6075a(0, true);
            st.f2229q = true;
            mo6083a(st, false);
            m3415a(st, (KeyEvent) null);
            return;
        }
        Callback cb = mo6253o();
        if (this.f2204v.mo7029d() && toggleMenuMode) {
            this.f2204v.mo7026b();
            if (!mo6254q()) {
                cb.onPanelClosed(108, mo6075a(0, true).f2222j);
            }
        } else if (cb != null && !mo6254q()) {
            if (this.f2197N && (this.f2198O & 1) != 0) {
                this.f2348g.getDecorView().removeCallbacks(this.f2199P);
                this.f2199P.run();
            }
            C0741d st2 = mo6075a(0, true);
            C0873l lVar = st2.f2222j;
            if (lVar != null && !st2.f2230r && cb.onPreparePanel(0, st2.f2221i, lVar)) {
                cb.onMenuOpened(108, st2.f2222j);
                this.f2204v.mo7027c();
            }
        }
    }

    /* renamed from: c */
    private boolean m3422c(C0741d st) {
        Context context = this.f2347f;
        int i = st.f2213a;
        if ((i == 0 || i == 108) && this.f2204v != null) {
            TypedValue outValue = new TypedValue();
            Theme baseTheme = context.getTheme();
            baseTheme.resolveAttribute(C0793R.attr.actionBarTheme, outValue, true);
            Theme widgetTheme = null;
            if (outValue.resourceId != 0) {
                widgetTheme = context.getResources().newTheme();
                widgetTheme.setTo(baseTheme);
                widgetTheme.applyStyle(outValue.resourceId, true);
                widgetTheme.resolveAttribute(C0793R.attr.actionBarWidgetTheme, outValue, true);
            } else {
                baseTheme.resolveAttribute(C0793R.attr.actionBarWidgetTheme, outValue, true);
            }
            if (outValue.resourceId != 0) {
                if (widgetTheme == null) {
                    widgetTheme = context.getResources().newTheme();
                    widgetTheme.setTo(baseTheme);
                }
                widgetTheme.applyStyle(outValue.resourceId, true);
            }
            if (widgetTheme != null) {
                C1303d dVar = new C1303d(context, 0);
                dVar.getTheme().setTo(widgetTheme);
                context = dVar;
            }
        }
        C0873l menu = new C0873l(context);
        menu.mo6561a((C0874a) this);
        st.mo6128a(menu);
        return true;
    }

    /* renamed from: a */
    private boolean m3417a(C0741d st) {
        View view = st.f2221i;
        boolean z = true;
        if (view != null) {
            st.f2220h = view;
            return true;
        } else if (st.f2222j == null) {
            return false;
        } else {
            if (this.f2206x == null) {
                this.f2206x = new C0742e();
            }
            st.f2220h = (View) st.mo6126a((C0891a) this.f2206x);
            if (st.f2220h == null) {
                z = false;
            }
            return z;
        }
    }

    /* renamed from: b */
    private boolean m3421b(C0741d st, KeyEvent event) {
        if (mo6254q()) {
            return false;
        }
        if (st.f2225m) {
            return true;
        }
        C0741d dVar = this.f2195L;
        if (!(dVar == null || dVar == st)) {
            mo6083a(dVar, false);
        }
        Callback cb = mo6253o();
        if (cb != null) {
            st.f2221i = cb.onCreatePanelView(st.f2213a);
        }
        int i = st.f2213a;
        boolean isActionBarMenu = i == 0 || i == 108;
        if (isActionBarMenu) {
            C1016T t = this.f2204v;
            if (t != null) {
                t.mo7031e();
            }
        }
        if (st.f2221i == null && (!isActionBarMenu || !(mo6255r() instanceof C0748J))) {
            if (st.f2222j == null || st.f2230r) {
                if (st.f2222j == null && (!m3422c(st) || st.f2222j == null)) {
                    return false;
                }
                if (isActionBarMenu && this.f2204v != null) {
                    if (this.f2205w == null) {
                        this.f2205w = new C0738a();
                    }
                    this.f2204v.mo7024a(st.f2222j, this.f2205w);
                }
                st.f2222j.mo6756r();
                if (!cb.onCreatePanelMenu(st.f2213a, st.f2222j)) {
                    st.mo6128a((C0873l) null);
                    if (isActionBarMenu) {
                        C1016T t2 = this.f2204v;
                        if (t2 != null) {
                            t2.mo7024a(null, this.f2205w);
                        }
                    }
                    return false;
                }
                st.f2230r = false;
            }
            st.f2222j.mo6756r();
            Bundle bundle = st.f2231s;
            if (bundle != null) {
                st.f2222j.mo6707a(bundle);
                st.f2231s = null;
            }
            if (!cb.onPreparePanel(0, st.f2221i, st.f2222j)) {
                if (isActionBarMenu) {
                    C1016T t3 = this.f2204v;
                    if (t3 != null) {
                        t3.mo7024a(null, this.f2205w);
                    }
                }
                st.f2222j.mo6755q();
                return false;
            }
            st.f2228p = KeyCharacterMap.load(event != null ? event.getDeviceId() : -1).getKeyboardType() != 1;
            st.f2222j.setQwertyMode(st.f2228p);
            st.f2222j.mo6755q();
        }
        st.f2225m = true;
        st.f2226n = false;
        this.f2195L = st;
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6095b(C0873l menu) {
        if (!this.f2193J) {
            this.f2193J = true;
            this.f2204v.mo7034g();
            Callback cb = mo6253o();
            if (cb != null && !mo6254q()) {
                cb.onPanelClosed(108, menu);
            }
            this.f2193J = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public void mo6102d(int featureId) {
        mo6083a(mo6075a(featureId, true), true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6083a(C0741d st, boolean doCallback) {
        if (doCallback && st.f2213a == 0) {
            C1016T t = this.f2204v;
            if (t != null && t.mo7029d()) {
                mo6095b(st.f2222j);
                return;
            }
        }
        WindowManager wm = (WindowManager) this.f2347f.getSystemService("window");
        if (wm != null && st.f2227o) {
            ViewGroup viewGroup = st.f2219g;
            if (viewGroup != null) {
                wm.removeView(viewGroup);
                if (doCallback) {
                    mo6080a(st.f2213a, st, null);
                }
            }
        }
        st.f2225m = false;
        st.f2226n = false;
        st.f2227o = false;
        st.f2220h = null;
        st.f2229q = true;
        if (this.f2195L == st) {
            this.f2195L = null;
        }
    }

    /* renamed from: d */
    private boolean m3423d(int featureId, KeyEvent event) {
        if (event.getRepeatCount() == 0) {
            C0741d st = mo6075a(featureId, true);
            if (!st.f2227o) {
                return m3421b(st, event);
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c  */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m3424e(int r6, android.view.KeyEvent r7) {
        /*
            r5 = this;
            b.c.h.g.b r0 = r5.f2207y
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 0
            r2 = 1
            android.support.v7.app.D$d r3 = r5.mo6075a(r6, r2)
            if (r6 != 0) goto L_0x0046
            android.support.v7.widget.T r4 = r5.f2204v
            if (r4 == 0) goto L_0x0046
            boolean r4 = r4.mo7025a()
            if (r4 == 0) goto L_0x0046
            android.content.Context r4 = r5.f2347f
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0046
            android.support.v7.widget.T r2 = r5.f2204v
            boolean r2 = r2.mo7029d()
            if (r2 != 0) goto L_0x003f
            boolean r2 = r5.mo6254q()
            if (r2 != 0) goto L_0x006a
            boolean r2 = r5.m3421b(r3, r7)
            if (r2 == 0) goto L_0x006a
            android.support.v7.widget.T r2 = r5.f2204v
            boolean r0 = r2.mo7027c()
            goto L_0x006a
        L_0x003f:
            android.support.v7.widget.T r2 = r5.f2204v
            boolean r0 = r2.mo7026b()
            goto L_0x006a
        L_0x0046:
            boolean r4 = r3.f2227o
            if (r4 != 0) goto L_0x0065
            boolean r4 = r3.f2226n
            if (r4 == 0) goto L_0x004f
            goto L_0x0065
        L_0x004f:
            boolean r2 = r3.f2225m
            if (r2 == 0) goto L_0x006a
            r2 = 1
            boolean r4 = r3.f2230r
            if (r4 == 0) goto L_0x005e
            r3.f2225m = r1
            boolean r2 = r5.m3421b(r3, r7)
        L_0x005e:
            if (r2 == 0) goto L_0x006a
            r5.m3415a(r3, r7)
            r0 = 1
            goto L_0x006a
        L_0x0065:
            boolean r0 = r3.f2227o
            r5.mo6083a(r3, r2)
        L_0x006a:
            if (r0 == 0) goto L_0x0083
            android.content.Context r2 = r5.f2347f
            java.lang.String r4 = "audio"
            java.lang.Object r2 = r2.getSystemService(r4)
            android.media.AudioManager r2 = (android.media.AudioManager) r2
            if (r2 == 0) goto L_0x007c
            r2.playSoundEffect(r1)
            goto L_0x0083
        L_0x007c:
            java.lang.String r1 = "AppCompatDelegate"
            java.lang.String r4 = "Couldn't get audio manager"
            android.util.Log.w(r1, r4)
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.app.C0737D.m3424e(int, android.view.KeyEvent):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6080a(int featureId, C0741d panel, Menu menu) {
        if (menu == null) {
            if (panel == null && featureId >= 0) {
                C0741d[] dVarArr = this.f2194K;
                if (featureId < dVarArr.length) {
                    panel = dVarArr[featureId];
                }
            }
            if (panel != null) {
                menu = panel.f2222j;
            }
        }
        if ((panel == null || panel.f2227o) && !mo6254q()) {
            this.f2349h.onPanelClosed(featureId, menu);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0741d mo6076a(Menu menu) {
        C0741d[] panels = this.f2194K;
        int N = panels != null ? panels.length : 0;
        for (int i = 0; i < N; i++) {
            C0741d panel = panels[i];
            if (panel != null && panel.f2222j == menu) {
                return panel;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0741d mo6075a(int featureId, boolean required) {
        C0741d[] dVarArr = this.f2194K;
        C0741d[] ar = dVarArr;
        if (dVarArr == null || ar.length <= featureId) {
            C0741d[] nar = new C0741d[(featureId + 1)];
            if (ar != null) {
                System.arraycopy(ar, 0, nar, 0, ar.length);
            }
            ar = nar;
            this.f2194K = nar;
        }
        C0741d st = ar[featureId];
        if (st != null) {
            return st;
        }
        C0741d dVar = new C0741d(featureId);
        C0741d st2 = dVar;
        ar[featureId] = dVar;
        return st2;
    }

    /* renamed from: a */
    private boolean m3418a(C0741d st, int keyCode, KeyEvent event, int flags) {
        if (event.isSystem()) {
            return false;
        }
        boolean handled = false;
        if (st.f2225m || m3421b(st, event)) {
            C0873l lVar = st.f2222j;
            if (lVar != null) {
                handled = lVar.performShortcut(keyCode, event, flags);
            }
        }
        if (handled && (flags & 1) == 0 && this.f2204v == null) {
            mo6083a(st, true);
        }
        return handled;
    }

    /* renamed from: g */
    private void mo6263g(int featureId) {
        this.f2198O |= 1 << featureId;
        if (!this.f2197N) {
            C0646w.m2958a(this.f2348g.getDecorView(), this.f2199P);
            this.f2197N = true;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo6103e(int featureId) {
        C0741d st = mo6075a(featureId, true);
        if (st.f2222j != null) {
            Bundle savedActionViewStates = new Bundle();
            st.f2222j.mo6730c(savedActionViewStates);
            if (savedActionViewStates.size() > 0) {
                st.f2231s = savedActionViewStates;
            }
            st.f2222j.mo6756r();
            st.f2222j.clear();
        }
        st.f2230r = true;
        st.f2229q = true;
        if ((featureId == 108 || featureId == 0) && this.f2204v != null) {
            C0741d st2 = mo6075a(0, false);
            if (st2 != null) {
                st2.f2225m = false;
                m3421b(st2, (KeyEvent) null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public int mo6104f(int insetTop) {
        boolean showStatusGuard = false;
        ActionBarContextView actionBarContextView = this.f2208z;
        int i = 0;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams mlp = (MarginLayoutParams) this.f2208z.getLayoutParams();
            boolean mlpChanged = false;
            if (this.f2208z.isShown()) {
                if (this.f2201R == null) {
                    this.f2201R = new Rect();
                    this.f2202S = new Rect();
                }
                Rect insets = this.f2201R;
                Rect localInsets = this.f2202S;
                insets.set(0, insetTop, 0, 0);
                C0946Ib.m4564a(this.f2188E, insets, localInsets);
                if (mlp.topMargin != (localInsets.top == 0 ? insetTop : 0)) {
                    mlpChanged = true;
                    mlp.topMargin = insetTop;
                    View view = this.f2190G;
                    if (view == null) {
                        this.f2190G = new View(this.f2347f);
                        this.f2190G.setBackgroundColor(this.f2347f.getResources().getColor(C0793R.color.abc_input_method_navigation_guard));
                        this.f2188E.addView(this.f2190G, -1, new LayoutParams(-1, insetTop));
                    } else {
                        LayoutParams lp = view.getLayoutParams();
                        if (lp.height != insetTop) {
                            lp.height = insetTop;
                            this.f2190G.setLayoutParams(lp);
                        }
                    }
                }
                showStatusGuard = this.f2190G != null;
                if (!this.f2356o && showStatusGuard) {
                    insetTop = 0;
                }
            } else if (mlp.topMargin != 0) {
                mlpChanged = true;
                mlp.topMargin = 0;
            }
            if (mlpChanged) {
                this.f2208z.setLayoutParams(mlp);
            }
        }
        View view2 = this.f2190G;
        if (view2 != null) {
            if (!showStatusGuard) {
                i = 8;
            }
            view2.setVisibility(i);
        }
        return insetTop;
    }

    /* renamed from: z */
    private void m3430z() {
        if (this.f2187D) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: h */
    private int m3426h(int featureId) {
        String str = "AppCompatDelegate";
        if (featureId == 8) {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (featureId != 9) {
            return featureId;
        } else {
            Log.i(str, "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: s */
    public void mo6113s() {
        C1016T t = this.f2204v;
        if (t != null) {
            t.mo7034g();
        }
        if (this.f2184A != null) {
            this.f2348g.getDecorView().removeCallbacks(this.f2185B);
            if (this.f2184A.isShowing()) {
                try {
                    this.f2184A.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f2184A = null;
        }
        mo6114t();
        C0741d st = mo6075a(0, false);
        if (st != null) {
            C0873l lVar = st.f2222j;
            if (lVar != null) {
                lVar.close();
            }
        }
    }
}
