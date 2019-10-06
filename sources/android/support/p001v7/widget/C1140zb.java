package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.widget.Toolbar.C1019b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window.Callback;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.zb */
/* compiled from: ToolbarWidgetWrapper */
public class C1140zb implements C1021U {

    /* renamed from: a */
    Toolbar f3773a;

    /* renamed from: b */
    private int f3774b;

    /* renamed from: c */
    private View f3775c;

    /* renamed from: d */
    private View f3776d;

    /* renamed from: e */
    private Drawable f3777e;

    /* renamed from: f */
    private Drawable f3778f;

    /* renamed from: g */
    private Drawable f3779g;

    /* renamed from: h */
    private boolean f3780h;

    /* renamed from: i */
    CharSequence f3781i;

    /* renamed from: j */
    private CharSequence f3782j;

    /* renamed from: k */
    private CharSequence f3783k;

    /* renamed from: l */
    Callback f3784l;

    /* renamed from: m */
    boolean f3785m;

    /* renamed from: n */
    private ActionMenuPresenter f3786n;

    /* renamed from: o */
    private int f3787o;

    /* renamed from: p */
    private int f3788p;

    /* renamed from: q */
    private Drawable f3789q;

    public C1140zb(Toolbar toolbar, boolean style) {
        this(toolbar, style, C0793R.string.abc_action_bar_up_description, C0793R.drawable.abc_ic_ab_back_material);
    }

    public C1140zb(Toolbar toolbar, boolean style, int defaultNavigationContentDescription, int defaultNavigationIcon) {
        this.f3787o = 0;
        this.f3788p = 0;
        this.f3773a = toolbar;
        this.f3781i = toolbar.getTitle();
        this.f3782j = toolbar.getSubtitle();
        this.f3780h = this.f3781i != null;
        this.f3779g = toolbar.getNavigationIcon();
        C1112sb a = C1112sb.m5456a(toolbar.getContext(), null, C0793R.styleable.ActionBar, C0793R.attr.actionBarStyle, 0);
        this.f3789q = a.mo8650b(C0793R.styleable.ActionBar_homeAsUpIndicator);
        if (style) {
            CharSequence title = a.mo8656e(C0793R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(title)) {
                setTitle(title);
            }
            CharSequence subtitle = a.mo8656e(C0793R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(subtitle)) {
                mo8740b(subtitle);
            }
            Drawable logo = a.mo8650b(C0793R.styleable.ActionBar_logo);
            if (logo != null) {
                mo8739b(logo);
            }
            Drawable icon = a.mo8650b(C0793R.styleable.ActionBar_icon);
            if (icon != null) {
                setIcon(icon);
            }
            if (this.f3779g == null) {
                Drawable drawable = this.f3789q;
                if (drawable != null) {
                    mo8741c(drawable);
                }
            }
            mo8317a(a.mo8653d(C0793R.styleable.ActionBar_displayOptions, 0));
            int customNavId = a.mo8659g(C0793R.styleable.ActionBar_customNavigationLayout, 0);
            if (customNavId != 0) {
                mo8737a(LayoutInflater.from(this.f3773a.getContext()).inflate(customNavId, this.f3773a, false));
                mo8317a(this.f3774b | 16);
            }
            int height = a.mo8657f(C0793R.styleable.ActionBar_height, 0);
            if (height > 0) {
                LayoutParams lp = this.f3773a.getLayoutParams();
                lp.height = height;
                this.f3773a.setLayoutParams(lp);
            }
            int contentInsetStart = a.mo8649b(C0793R.styleable.ActionBar_contentInsetStart, -1);
            int contentInsetEnd = a.mo8649b(C0793R.styleable.ActionBar_contentInsetEnd, -1);
            if (contentInsetStart >= 0 || contentInsetEnd >= 0) {
                this.f3773a.mo8237a(Math.max(contentInsetStart, 0), Math.max(contentInsetEnd, 0));
            }
            int titleTextStyle = a.mo8659g(C0793R.styleable.ActionBar_titleTextStyle, 0);
            if (titleTextStyle != 0) {
                Toolbar toolbar2 = this.f3773a;
                toolbar2.mo8241b(toolbar2.getContext(), titleTextStyle);
            }
            int subtitleTextStyle = a.mo8659g(C0793R.styleable.ActionBar_subtitleTextStyle, 0);
            if (subtitleTextStyle != 0) {
                Toolbar toolbar3 = this.f3773a;
                toolbar3.mo8238a(toolbar3.getContext(), subtitleTextStyle);
            }
            int popupTheme = a.mo8659g(C0793R.styleable.ActionBar_popupTheme, 0);
            if (popupTheme != 0) {
                this.f3773a.setPopupTheme(popupTheme);
            }
        } else {
            this.f3774b = m5566o();
        }
        a.mo8647a();
        mo8742d(defaultNavigationContentDescription);
        this.f3783k = this.f3773a.getNavigationContentDescription();
        this.f3773a.setNavigationOnClickListener(new C1133xb(this));
    }

    /* renamed from: d */
    public void mo8742d(int defaultNavigationContentDescription) {
        if (defaultNavigationContentDescription != this.f3788p) {
            this.f3788p = defaultNavigationContentDescription;
            if (TextUtils.isEmpty(this.f3773a.getNavigationContentDescription())) {
                mo8743e(this.f3788p);
            }
        }
    }

    /* renamed from: o */
    private int m5566o() {
        if (this.f3773a.getNavigationIcon() == null) {
            return 11;
        }
        int opts = 11 | 4;
        this.f3789q = this.f3773a.getNavigationIcon();
        return opts;
    }

    /* renamed from: j */
    public ViewGroup mo8338j() {
        return this.f3773a;
    }

    public Context getContext() {
        return this.f3773a.getContext();
    }

    /* renamed from: g */
    public boolean mo8333g() {
        return this.f3773a.mo8247f();
    }

    public void collapseActionView() {
        this.f3773a.mo8243c();
    }

    public void setWindowCallback(Callback cb) {
        this.f3784l = cb;
    }

    public void setWindowTitle(CharSequence title) {
        if (!this.f3780h) {
            m5565c(title);
        }
    }

    public CharSequence getTitle() {
        return this.f3773a.getTitle();
    }

    public void setTitle(CharSequence title) {
        this.f3780h = true;
        m5565c(title);
    }

    /* renamed from: c */
    private void m5565c(CharSequence title) {
        this.f3781i = title;
        if ((this.f3774b & 8) != 0) {
            this.f3773a.setTitle(title);
        }
    }

    /* renamed from: b */
    public void mo8740b(CharSequence subtitle) {
        this.f3782j = subtitle;
        if ((this.f3774b & 8) != 0) {
            this.f3773a.setSubtitle(subtitle);
        }
    }

    /* renamed from: k */
    public void mo8339k() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* renamed from: n */
    public void mo8342n() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void setIcon(int resId) {
        setIcon(resId != 0 ? C1282b.m6000b(getContext(), resId) : null);
    }

    public void setIcon(Drawable d) {
        this.f3777e = d;
        m5569r();
    }

    /* renamed from: b */
    public void mo8324b(int resId) {
        mo8739b(resId != 0 ? C1282b.m6000b(getContext(), resId) : null);
    }

    /* renamed from: b */
    public void mo8739b(Drawable d) {
        this.f3778f = d;
        m5569r();
    }

    /* renamed from: r */
    private void m5569r() {
        Drawable logo = null;
        int i = this.f3774b;
        if ((i & 2) != 0) {
            if ((i & 1) != 0) {
                Drawable drawable = this.f3778f;
                if (drawable == null) {
                    drawable = this.f3777e;
                }
                logo = drawable;
            } else {
                logo = this.f3777e;
            }
        }
        this.f3773a.setLogo(logo);
    }

    /* renamed from: a */
    public boolean mo8323a() {
        return this.f3773a.mo8242b();
    }

    /* renamed from: d */
    public boolean mo8330d() {
        return this.f3773a.mo8279i();
    }

    /* renamed from: f */
    public boolean mo8332f() {
        return this.f3773a.mo8278h();
    }

    /* renamed from: c */
    public boolean mo8328c() {
        return this.f3773a.mo8281k();
    }

    /* renamed from: b */
    public boolean mo8326b() {
        return this.f3773a.mo8248g();
    }

    /* renamed from: e */
    public void mo8331e() {
        this.f3785m = true;
    }

    /* renamed from: a */
    public void mo8321a(Menu menu, C0891a cb) {
        if (this.f3786n == null) {
            this.f3786n = new ActionMenuPresenter(this.f3773a.getContext());
            this.f3786n.mo6659a(C0793R.C0794id.action_menu_presenter);
        }
        this.f3786n.mo6548a(cb);
        this.f3773a.mo8239a((C0873l) menu, this.f3786n);
    }

    /* renamed from: l */
    public void mo8340l() {
        this.f3773a.mo8245d();
    }

    /* renamed from: m */
    public int mo8341m() {
        return this.f3774b;
    }

    /* renamed from: a */
    public void mo8317a(int newOpts) {
        int changed = this.f3774b ^ newOpts;
        this.f3774b = newOpts;
        if (changed != 0) {
            if ((changed & 4) != 0) {
                if ((newOpts & 4) != 0) {
                    m5567p();
                }
                m5568q();
            }
            if ((changed & 3) != 0) {
                m5569r();
            }
            if ((changed & 8) != 0) {
                if ((newOpts & 8) != 0) {
                    this.f3773a.setTitle(this.f3781i);
                    this.f3773a.setSubtitle(this.f3782j);
                } else {
                    this.f3773a.setTitle((CharSequence) null);
                    this.f3773a.setSubtitle((CharSequence) null);
                }
            }
            if ((changed & 16) != 0) {
                View view = this.f3776d;
                if (view == null) {
                    return;
                }
                if ((newOpts & 16) != 0) {
                    this.f3773a.addView(view);
                } else {
                    this.f3773a.removeView(view);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo8320a(C1004Sa tabView) {
        View view = this.f3775c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f3773a;
            if (parent == toolbar) {
                toolbar.removeView(this.f3775c);
            }
        }
        this.f3775c = tabView;
        if (tabView != null && this.f3787o == 2) {
            this.f3773a.addView(this.f3775c, 0);
            C1019b lp = (C1019b) this.f3775c.getLayoutParams();
            lp.width = -2;
            lp.height = -2;
            lp.f2312a = 8388691;
            tabView.setAllowCollapse(true);
        }
    }

    /* renamed from: b */
    public void mo8325b(boolean collapsible) {
        this.f3773a.setCollapsible(collapsible);
    }

    /* renamed from: a */
    public void mo8322a(boolean enable) {
    }

    /* renamed from: i */
    public int mo8337i() {
        return this.f3787o;
    }

    /* renamed from: a */
    public void mo8737a(View view) {
        View view2 = this.f3776d;
        if (!(view2 == null || (this.f3774b & 16) == 0)) {
            this.f3773a.removeView(view2);
        }
        this.f3776d = view;
        if (view != null && (this.f3774b & 16) != 0) {
            this.f3773a.addView(this.f3776d);
        }
    }

    /* renamed from: a */
    public C0587I mo8316a(int visibility, long duration) {
        C0587I a = C0646w.m2945a(this.f3773a);
        a.mo5470a(visibility == 0 ? 1.0f : 0.0f);
        a.mo5471a(duration);
        a.mo5472a((C0589J) new C1137yb(this, visibility));
        return a;
    }

    /* renamed from: c */
    public void mo8741c(Drawable icon) {
        this.f3779g = icon;
        m5568q();
    }

    /* renamed from: q */
    private void m5568q() {
        if ((this.f3774b & 4) != 0) {
            Toolbar toolbar = this.f3773a;
            Drawable drawable = this.f3779g;
            if (drawable == null) {
                drawable = this.f3789q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f3773a.setNavigationIcon((Drawable) null);
    }

    /* renamed from: a */
    public void mo8738a(CharSequence description) {
        this.f3783k = description;
        m5567p();
    }

    /* renamed from: e */
    public void mo8743e(int resId) {
        mo8738a((CharSequence) resId == 0 ? null : getContext().getString(resId));
    }

    /* renamed from: p */
    private void m5567p() {
        if ((this.f3774b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f3783k)) {
            this.f3773a.setNavigationContentDescription(this.f3788p);
        } else {
            this.f3773a.setNavigationContentDescription(this.f3783k);
        }
    }

    /* renamed from: a */
    public void mo8318a(Drawable d) {
        C0646w.m2954a((View) this.f3773a, d);
    }

    /* renamed from: c */
    public void mo8327c(int visible) {
        this.f3773a.setVisibility(visible);
    }

    /* renamed from: a */
    public void mo8319a(C0891a actionMenuPresenterCallback, C0874a menuBuilderCallback) {
        this.f3773a.mo8240a(actionMenuPresenterCallback, menuBuilderCallback);
    }

    /* renamed from: h */
    public Menu mo8336h() {
        return this.f3773a.getMenu();
    }
}
