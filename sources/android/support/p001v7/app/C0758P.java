package android.support.p001v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0591L;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.app.C0760a.C0762b;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.widget.ActionBarContainer;
import android.support.p001v7.widget.ActionBarContextView;
import android.support.p001v7.widget.ActionBarOverlayLayout;
import android.support.p001v7.widget.ActionBarOverlayLayout.C0902a;
import android.support.p001v7.widget.C1004Sa;
import android.support.p001v7.widget.C1021U;
import android.support.p001v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import p002b.p003c.p062h.p071g.C1299a;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;
import p002b.p003c.p062h.p071g.C1307g;
import p002b.p003c.p062h.p071g.C1311i;

/* renamed from: android.support.v7.app.P */
/* compiled from: WindowDecorActionBar */
public class C0758P extends C0760a implements C0902a {

    /* renamed from: a */
    private static final Interpolator f2274a = new AccelerateInterpolator();

    /* renamed from: b */
    private static final Interpolator f2275b = new DecelerateInterpolator();

    /* renamed from: A */
    private boolean f2276A = true;

    /* renamed from: B */
    C1311i f2277B;

    /* renamed from: C */
    private boolean f2278C;

    /* renamed from: D */
    boolean f2279D;

    /* renamed from: E */
    final C0589J f2280E = new C0755M(this);

    /* renamed from: F */
    final C0589J f2281F = new C0756N(this);

    /* renamed from: G */
    final C0591L f2282G = new C0757O(this);

    /* renamed from: c */
    Context f2283c;

    /* renamed from: d */
    private Context f2284d;

    /* renamed from: e */
    private Activity f2285e;

    /* renamed from: f */
    private Dialog f2286f;

    /* renamed from: g */
    ActionBarOverlayLayout f2287g;

    /* renamed from: h */
    ActionBarContainer f2288h;

    /* renamed from: i */
    C1021U f2289i;

    /* renamed from: j */
    ActionBarContextView f2290j;

    /* renamed from: k */
    View f2291k;

    /* renamed from: l */
    C1004Sa f2292l;

    /* renamed from: m */
    private ArrayList<Object> f2293m = new ArrayList<>();

    /* renamed from: n */
    private int f2294n = -1;

    /* renamed from: o */
    private boolean f2295o;

    /* renamed from: p */
    C0759a f2296p;

    /* renamed from: q */
    C1300b f2297q;

    /* renamed from: r */
    C1301a f2298r;

    /* renamed from: s */
    private boolean f2299s;

    /* renamed from: t */
    private ArrayList<C0762b> f2300t = new ArrayList<>();

    /* renamed from: u */
    private boolean f2301u;

    /* renamed from: v */
    private int f2302v = 0;

    /* renamed from: w */
    boolean f2303w = true;

    /* renamed from: x */
    boolean f2304x;

    /* renamed from: y */
    boolean f2305y;

    /* renamed from: z */
    private boolean f2306z;

    /* renamed from: android.support.v7.app.P$a */
    /* compiled from: WindowDecorActionBar */
    public class C0759a extends C1300b implements C0874a {

        /* renamed from: c */
        private final Context f2307c;

        /* renamed from: d */
        private final C0873l f2308d;

        /* renamed from: e */
        private C1301a f2309e;

        /* renamed from: f */
        private WeakReference<View> f2310f;

        public C0759a(Context context, C1301a callback) {
            this.f2307c = context;
            this.f2309e = callback;
            C0873l lVar = new C0873l(context);
            lVar.mo6728c(1);
            this.f2308d = lVar;
            this.f2308d.mo6561a((C0874a) this);
        }

        /* renamed from: d */
        public MenuInflater mo6194d() {
            return new C1307g(this.f2307c);
        }

        /* renamed from: c */
        public Menu mo6193c() {
            return this.f2308d;
        }

        /* renamed from: a */
        public void mo6185a() {
            C0758P p = C0758P.this;
            if (p.f2296p == this) {
                if (!C0758P.m3531a(p.f2304x, p.f2305y, false)) {
                    C0758P p2 = C0758P.this;
                    p2.f2297q = this;
                    p2.f2298r = this.f2309e;
                } else {
                    this.f2309e.mo6119a(this);
                }
                this.f2309e = null;
                C0758P.this.mo6178h(false);
                C0758P.this.f2290j.mo6999a();
                C0758P.this.f2289i.mo8338j().sendAccessibilityEvent(32);
                C0758P p3 = C0758P.this;
                p3.f2287g.setHideOnContentScrollEnabled(p3.f2279D);
                C0758P.this.f2296p = null;
            }
        }

        /* renamed from: i */
        public void mo6197i() {
            if (C0758P.this.f2296p == this) {
                this.f2308d.mo6756r();
                try {
                    this.f2309e.mo6122b(this, this.f2308d);
                } finally {
                    this.f2308d.mo6755q();
                }
            }
        }

        /* renamed from: k */
        public boolean mo6199k() {
            this.f2308d.mo6756r();
            try {
                return this.f2309e.mo6120a((C1300b) this, (Menu) this.f2308d);
            } finally {
                this.f2308d.mo6755q();
            }
        }

        /* renamed from: a */
        public void mo6187a(View view) {
            C0758P.this.f2290j.setCustomView(view);
            this.f2310f = new WeakReference<>(view);
        }

        /* renamed from: a */
        public void mo6188a(CharSequence subtitle) {
            C0758P.this.f2290j.setSubtitle(subtitle);
        }

        /* renamed from: b */
        public void mo6192b(CharSequence title) {
            C0758P.this.f2290j.setTitle(title);
        }

        /* renamed from: b */
        public void mo6191b(int resId) {
            mo6192b((CharSequence) C0758P.this.f2283c.getResources().getString(resId));
        }

        /* renamed from: a */
        public void mo6186a(int resId) {
            mo6188a((CharSequence) C0758P.this.f2283c.getResources().getString(resId));
        }

        /* renamed from: g */
        public CharSequence mo6196g() {
            return C0758P.this.f2290j.getTitle();
        }

        /* renamed from: e */
        public CharSequence mo6195e() {
            return C0758P.this.f2290j.getSubtitle();
        }

        /* renamed from: a */
        public void mo6189a(boolean titleOptional) {
            super.mo6189a(titleOptional);
            C0758P.this.f2290j.setTitleOptional(titleOptional);
        }

        /* renamed from: j */
        public boolean mo6198j() {
            return C0758P.this.f2290j.mo7001b();
        }

        /* renamed from: b */
        public View mo6190b() {
            WeakReference<View> weakReference = this.f2310f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        /* renamed from: a */
        public boolean mo4699a(C0873l menu, MenuItem item) {
            C1301a aVar = this.f2309e;
            if (aVar != null) {
                return aVar.mo6121a((C1300b) this, item);
            }
            return false;
        }

        /* renamed from: a */
        public void mo4698a(C0873l menu) {
            if (this.f2309e != null) {
                mo6197i();
                C0758P.this.f2290j.mo7003d();
            }
        }
    }

    public C0758P(Activity activity, boolean overlayMode) {
        this.f2285e = activity;
        View decor = activity.getWindow().getDecorView();
        m3532b(decor);
        if (!overlayMode) {
            this.f2291k = decor.findViewById(16908290);
        }
    }

    public C0758P(Dialog dialog) {
        this.f2286f = dialog;
        m3532b(dialog.getWindow().getDecorView());
    }

    /* renamed from: b */
    private void m3532b(View decor) {
        this.f2287g = (ActionBarOverlayLayout) decor.findViewById(C0793R.C0794id.decor_content_parent);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2287g;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f2289i = m3530a(decor.findViewById(C0793R.C0794id.action_bar));
        this.f2290j = (ActionBarContextView) decor.findViewById(C0793R.C0794id.action_context_bar);
        this.f2288h = (ActionBarContainer) decor.findViewById(C0793R.C0794id.action_bar_container);
        C1021U u = this.f2289i;
        if (u == null || this.f2290j == null || this.f2288h == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getSimpleName());
            sb.append(" can only be used ");
            sb.append("with a compatible window decor layout");
            throw new IllegalStateException(sb.toString());
        }
        this.f2283c = u.getContext();
        boolean homeAsUp = (this.f2289i.mo8341m() & 4) != 0;
        if (homeAsUp) {
            this.f2295o = true;
        }
        C1299a abp = C1299a.m6042a(this.f2283c);
        mo6156f(abp.mo9221a() || homeAsUp);
        m3533l(abp.mo9226f());
        TypedArray a = this.f2283c.obtainStyledAttributes(null, C0793R.styleable.ActionBar, C0793R.attr.actionBarStyle, 0);
        if (a.getBoolean(C0793R.styleable.ActionBar_hideOnContentScroll, false)) {
            mo6181k(true);
        }
        int elevation = a.getDimensionPixelSize(C0793R.styleable.ActionBar_elevation, 0);
        if (elevation != 0) {
            mo6172a((float) elevation);
        }
        a.recycle();
    }

    /* renamed from: a */
    private C1021U m3530a(View view) {
        if (view instanceof C1021U) {
            return (C1021U) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* renamed from: a */
    public void mo6172a(float elevation) {
        C0646w.m2964b((View) this.f2288h, elevation);
    }

    /* renamed from: a */
    public void mo6145a(Configuration newConfig) {
        m3533l(C1299a.m6042a(this.f2283c).mo9226f());
    }

    /* renamed from: l */
    private void m3533l(boolean hasEmbeddedTabs) {
        this.f2301u = hasEmbeddedTabs;
        if (!this.f2301u) {
            this.f2289i.mo8320a((C1004Sa) null);
            this.f2288h.setTabContainer(this.f2292l);
        } else {
            this.f2288h.setTabContainer(null);
            this.f2289i.mo8320a(this.f2292l);
        }
        boolean z = true;
        boolean isInTabMode = mo6183m() == 2;
        C1004Sa sa = this.f2292l;
        if (sa != null) {
            if (isInTabMode) {
                sa.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f2287g;
                if (actionBarOverlayLayout != null) {
                    C0646w.m2991y(actionBarOverlayLayout);
                }
            } else {
                sa.setVisibility(8);
            }
        }
        this.f2289i.mo8325b(!this.f2301u && isInTabMode);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f2287g;
        if (this.f2301u || !isInTabMode) {
            z = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: l */
    public void mo6182l() {
        C1301a aVar = this.f2298r;
        if (aVar != null) {
            aVar.mo6119a(this.f2297q);
            this.f2297q = null;
            this.f2298r = null;
        }
    }

    public void onWindowVisibilityChanged(int visibility) {
        this.f2302v = visibility;
    }

    /* renamed from: g */
    public void mo6159g(boolean enabled) {
        this.f2278C = enabled;
        if (!enabled) {
            C1311i iVar = this.f2277B;
            if (iVar != null) {
                iVar.mo9272a();
            }
        }
    }

    /* renamed from: b */
    public void mo6151b(boolean isVisible) {
        if (isVisible != this.f2299s) {
            this.f2299s = isVisible;
            int count = this.f2300t.size();
            for (int i = 0; i < count; i++) {
                ((C0762b) this.f2300t.get(i)).onMenuVisibilityChanged(isVisible);
            }
        }
    }

    /* renamed from: e */
    public void mo6154e(boolean showHome) {
        mo6173a(showHome ? 2 : 0, 2);
    }

    /* renamed from: d */
    public void mo6153d(boolean showHomeAsUp) {
        mo6173a(showHomeAsUp ? 4 : 0, 4);
    }

    /* renamed from: f */
    public void mo6156f(boolean enable) {
        this.f2289i.mo8322a(enable);
    }

    /* renamed from: a */
    public void mo6147a(CharSequence title) {
        this.f2289i.setTitle(title);
    }

    /* renamed from: b */
    public void mo6150b(CharSequence title) {
        this.f2289i.setWindowTitle(title);
    }

    /* renamed from: a */
    public void mo6173a(int options, int mask) {
        int current = this.f2289i.mo8341m();
        if ((mask & 4) != 0) {
            this.f2295o = true;
        }
        this.f2289i.mo8317a((options & mask) | ((mask ^ -1) & current));
    }

    /* renamed from: a */
    public void mo6146a(Drawable d) {
        this.f2288h.setPrimaryBackground(d);
    }

    /* renamed from: m */
    public int mo6183m() {
        return this.f2289i.mo8337i();
    }

    /* renamed from: g */
    public int mo6158g() {
        return this.f2289i.mo8341m();
    }

    /* renamed from: a */
    public C1300b mo6170a(C1301a callback) {
        C0759a aVar = this.f2296p;
        if (aVar != null) {
            aVar.mo6185a();
        }
        this.f2287g.setHideOnContentScrollEnabled(false);
        this.f2290j.mo7002c();
        C0759a mode = new C0759a(this.f2290j.getContext(), callback);
        if (!mode.mo6199k()) {
            return null;
        }
        this.f2296p = mode;
        mode.mo6197i();
        this.f2290j.mo7000a(mode);
        mo6178h(true);
        this.f2290j.sendAccessibilityEvent(32);
        return mode;
    }

    /* renamed from: a */
    public void mo6174a(boolean enabled) {
        this.f2303w = enabled;
    }

    /* renamed from: p */
    private void m3537p() {
        if (!this.f2306z) {
            this.f2306z = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2287g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            m3534m(false);
        }
    }

    /* renamed from: a */
    public void mo6171a() {
        if (this.f2305y) {
            this.f2305y = false;
            m3534m(true);
        }
    }

    /* renamed from: n */
    private void m3535n() {
        if (this.f2306z) {
            this.f2306z = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f2287g;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            m3534m(false);
        }
    }

    /* renamed from: c */
    public void mo6176c() {
        if (!this.f2305y) {
            this.f2305y = true;
            m3534m(true);
        }
    }

    /* renamed from: k */
    public void mo6181k(boolean hideOnContentScroll) {
        if (!hideOnContentScroll || this.f2287g.mo7042i()) {
            this.f2279D = hideOnContentScroll;
            this.f2287g.setHideOnContentScrollEnabled(hideOnContentScroll);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    /* renamed from: a */
    static boolean m3531a(boolean hiddenByApp, boolean hiddenBySystem, boolean showingForMode) {
        if (showingForMode) {
            return true;
        }
        if (hiddenByApp || hiddenBySystem) {
            return false;
        }
        return true;
    }

    /* renamed from: m */
    private void m3534m(boolean fromSystem) {
        if (m3531a(this.f2304x, this.f2305y, this.f2306z)) {
            if (!this.f2276A) {
                this.f2276A = true;
                mo6180j(fromSystem);
            }
        } else if (this.f2276A) {
            this.f2276A = false;
            mo6179i(fromSystem);
        }
    }

    /* renamed from: j */
    public void mo6180j(boolean fromSystem) {
        C1311i iVar = this.f2277B;
        if (iVar != null) {
            iVar.mo9272a();
        }
        this.f2288h.setVisibility(0);
        if (this.f2302v != 0 || (!this.f2278C && !fromSystem)) {
            this.f2288h.setAlpha(1.0f);
            this.f2288h.setTranslationY(0.0f);
            if (this.f2303w) {
                View view = this.f2291k;
                if (view != null) {
                    view.setTranslationY(0.0f);
                }
            }
            this.f2281F.onAnimationEnd(null);
        } else {
            this.f2288h.setTranslationY(0.0f);
            float startingY = (float) (-this.f2288h.getHeight());
            if (fromSystem) {
                int[] topLeft = {0, 0};
                this.f2288h.getLocationInWindow(topLeft);
                startingY -= (float) topLeft[1];
            }
            this.f2288h.setTranslationY(startingY);
            C1311i anim = new C1311i();
            C0587I a = C0646w.m2945a(this.f2288h).mo5477b(0.0f);
            a.mo5473a(this.f2282G);
            anim.mo9268a(a);
            if (this.f2303w) {
                View view2 = this.f2291k;
                if (view2 != null) {
                    view2.setTranslationY(startingY);
                    C0587I a2 = C0646w.m2945a(this.f2291k);
                    a2.mo5477b(0.0f);
                    anim.mo9268a(a2);
                }
            }
            anim.mo9271a(f2275b);
            anim.mo9267a(250);
            anim.mo9270a(this.f2281F);
            this.f2277B = anim;
            anim.mo9274c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2287g;
        if (actionBarOverlayLayout != null) {
            C0646w.m2991y(actionBarOverlayLayout);
        }
    }

    /* renamed from: i */
    public void mo6179i(boolean fromSystem) {
        C1311i iVar = this.f2277B;
        if (iVar != null) {
            iVar.mo9272a();
        }
        if (this.f2302v != 0 || (!this.f2278C && !fromSystem)) {
            this.f2280E.onAnimationEnd(null);
            return;
        }
        this.f2288h.setAlpha(1.0f);
        this.f2288h.setTransitioning(true);
        C1311i anim = new C1311i();
        float endingY = (float) (-this.f2288h.getHeight());
        if (fromSystem) {
            int[] topLeft = {0, 0};
            this.f2288h.getLocationInWindow(topLeft);
            endingY -= (float) topLeft[1];
        }
        C0587I a = C0646w.m2945a(this.f2288h).mo5477b(endingY);
        a.mo5473a(this.f2282G);
        anim.mo9268a(a);
        if (this.f2303w) {
            View view = this.f2291k;
            if (view != null) {
                C0587I a2 = C0646w.m2945a(view);
                a2.mo5477b(endingY);
                anim.mo9268a(a2);
            }
        }
        anim.mo9271a(f2274a);
        anim.mo9267a(250);
        anim.mo9270a(this.f2280E);
        this.f2277B = anim;
        anim.mo9274c();
    }

    /* renamed from: h */
    public void mo6178h(boolean toActionMode) {
        C0587I fadeIn;
        C0587I fadeOut;
        if (toActionMode) {
            m3537p();
        } else {
            m3535n();
        }
        if (m3536o()) {
            if (toActionMode) {
                fadeOut = this.f2289i.mo8316a(4, 100);
                fadeIn = this.f2290j.mo6998a(0, 200);
            } else {
                fadeIn = this.f2289i.mo8316a(0, 200);
                fadeOut = this.f2290j.mo6998a(8, 100);
            }
            C1311i set = new C1311i();
            set.mo9269a(fadeOut, fadeIn);
            set.mo9274c();
        } else if (toActionMode) {
            this.f2289i.mo8327c(4);
            this.f2290j.setVisibility(0);
        } else {
            this.f2289i.mo8327c(0);
            this.f2290j.setVisibility(8);
        }
    }

    /* renamed from: o */
    private boolean m3536o() {
        return C0646w.m2987u(this.f2288h);
    }

    /* renamed from: h */
    public Context mo6160h() {
        if (this.f2284d == null) {
            TypedValue outValue = new TypedValue();
            this.f2283c.getTheme().resolveAttribute(C0793R.attr.actionBarWidgetTheme, outValue, true);
            int targetThemeRes = outValue.resourceId;
            if (targetThemeRes != 0) {
                this.f2284d = new ContextThemeWrapper(this.f2283c, targetThemeRes);
            } else {
                this.f2284d = this.f2283c;
            }
        }
        return this.f2284d;
    }

    /* renamed from: d */
    public void mo6177d() {
        C1311i iVar = this.f2277B;
        if (iVar != null) {
            iVar.mo9272a();
            this.f2277B = null;
        }
    }

    /* renamed from: b */
    public void mo6175b() {
    }

    /* renamed from: f */
    public boolean mo6157f() {
        C1021U u = this.f2289i;
        if (u == null || !u.mo8333g()) {
            return false;
        }
        this.f2289i.collapseActionView();
        return true;
    }

    /* renamed from: c */
    public void mo6152c(boolean enable) {
        if (!this.f2295o) {
            mo6153d(enable);
        }
    }

    /* renamed from: a */
    public boolean mo6148a(int keyCode, KeyEvent event) {
        C0759a aVar = this.f2296p;
        if (aVar == null) {
            return false;
        }
        Menu menu = aVar.mo6193c();
        if (menu == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(event != null ? event.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        menu.setQwertyMode(z);
        return menu.performShortcut(keyCode, event, 0);
    }
}
