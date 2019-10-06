package android.support.p001v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p000v4.view.AbsSavedState;
import android.support.p000v4.view.C0623f;
import android.support.p000v4.view.C0627h;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.app.C0760a.C0761a;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0858D;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0890v;
import android.support.p001v7.view.menu.C0890v.C0891a;
import android.support.p001v7.widget.ActionMenuView.C0914e;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import p002b.p003c.p062h.p064b.p065a.C1282b;
import p002b.p003c.p062h.p071g.C1302c;
import p002b.p003c.p062h.p071g.C1307g;

/* renamed from: android.support.v7.widget.Toolbar */
public class Toolbar extends ViewGroup {

    /* renamed from: A */
    private int f3374A;

    /* renamed from: B */
    private boolean f3375B;

    /* renamed from: C */
    private boolean f3376C;

    /* renamed from: D */
    private final ArrayList<View> f3377D;

    /* renamed from: E */
    private final ArrayList<View> f3378E;

    /* renamed from: F */
    private final int[] f3379F;

    /* renamed from: G */
    C1020c f3380G;

    /* renamed from: H */
    private final C0914e f3381H;

    /* renamed from: I */
    private C1140zb f3382I;

    /* renamed from: J */
    private ActionMenuPresenter f3383J;

    /* renamed from: K */
    private C1018a f3384K;

    /* renamed from: L */
    private C0891a f3385L;

    /* renamed from: M */
    private C0874a f3386M;

    /* renamed from: N */
    private boolean f3387N;

    /* renamed from: O */
    private final Runnable f3388O;

    /* renamed from: a */
    private ActionMenuView f3389a;

    /* renamed from: b */
    private TextView f3390b;

    /* renamed from: c */
    private TextView f3391c;

    /* renamed from: d */
    private ImageButton f3392d;

    /* renamed from: e */
    private ImageView f3393e;

    /* renamed from: f */
    private Drawable f3394f;

    /* renamed from: g */
    private CharSequence f3395g;

    /* renamed from: h */
    ImageButton f3396h;

    /* renamed from: i */
    View f3397i;

    /* renamed from: j */
    private Context f3398j;

    /* renamed from: k */
    private int f3399k;

    /* renamed from: l */
    private int f3400l;

    /* renamed from: m */
    private int f3401m;

    /* renamed from: n */
    int f3402n;

    /* renamed from: o */
    private int f3403o;

    /* renamed from: p */
    private int f3404p;

    /* renamed from: q */
    private int f3405q;

    /* renamed from: r */
    private int f3406r;

    /* renamed from: s */
    private int f3407s;

    /* renamed from: t */
    private C0966Pa f3408t;

    /* renamed from: u */
    private int f3409u;

    /* renamed from: v */
    private int f3410v;

    /* renamed from: w */
    private int f3411w;

    /* renamed from: x */
    private CharSequence f3412x;

    /* renamed from: y */
    private CharSequence f3413y;

    /* renamed from: z */
    private int f3414z;

    /* renamed from: android.support.v7.widget.Toolbar$SavedState */
    public static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C1129wb();

        /* renamed from: c */
        int f3415c;

        /* renamed from: d */
        boolean f3416d;

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            this.f3415c = source.readInt();
            this.f3416d = source.readInt() != 0;
        }

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeInt(this.f3415c);
            out.writeInt(this.f3416d ? 1 : 0);
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$a */
    private class C1018a implements C0890v {

        /* renamed from: a */
        C0873l f3417a;

        /* renamed from: b */
        C0879p f3418b;

        C1018a() {
        }

        /* renamed from: a */
        public void mo4075a(Context context, C0873l menu) {
            C0873l lVar = this.f3417a;
            if (lVar != null) {
                C0879p pVar = this.f3418b;
                if (pVar != null) {
                    lVar.mo6563a(pVar);
                }
            }
            this.f3417a = menu;
        }

        /* renamed from: a */
        public void mo4079a(boolean cleared) {
            if (this.f3418b != null) {
                boolean found = false;
                C0873l lVar = this.f3417a;
                if (lVar != null) {
                    int count = lVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= count) {
                            break;
                        } else if (this.f3417a.getItem(i) == this.f3418b) {
                            found = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!found) {
                    mo4084b(this.f3417a, this.f3418b);
                }
            }
        }

        /* renamed from: a */
        public boolean mo4080a(C0858D subMenu) {
            return false;
        }

        /* renamed from: a */
        public void mo4078a(C0873l menu, boolean allMenusAreClosing) {
        }

        /* renamed from: b */
        public boolean mo4083b() {
            return false;
        }

        /* renamed from: a */
        public boolean mo4081a(C0873l menu, C0879p item) {
            Toolbar.this.mo8246e();
            ViewParent collapseButtonParent = Toolbar.this.f3396h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (collapseButtonParent != toolbar) {
                if (collapseButtonParent instanceof ViewGroup) {
                    ((ViewGroup) collapseButtonParent).removeView(toolbar.f3396h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f3396h);
            }
            Toolbar.this.f3397i = item.getActionView();
            this.f3418b = item;
            ViewParent expandedActionParent = Toolbar.this.f3397i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (expandedActionParent != toolbar3) {
                if (expandedActionParent instanceof ViewGroup) {
                    ((ViewGroup) expandedActionParent).removeView(toolbar3.f3397i);
                }
                C1019b lp = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                lp.f2312a = 8388611 | (toolbar4.f3402n & 112);
                lp.f3420b = 2;
                toolbar4.f3397i.setLayoutParams(lp);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f3397i);
            }
            Toolbar.this.mo8280j();
            Toolbar.this.requestLayout();
            item.mo6771a(true);
            View view = Toolbar.this.f3397i;
            if (view instanceof C1302c) {
                ((C1302c) view).onActionViewExpanded();
            }
            return true;
        }

        /* renamed from: b */
        public boolean mo4084b(C0873l menu, C0879p item) {
            View view = Toolbar.this.f3397i;
            if (view instanceof C1302c) {
                ((C1302c) view).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f3397i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f3396h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f3397i = null;
            toolbar3.mo8236a();
            this.f3418b = null;
            Toolbar.this.requestLayout();
            item.mo6771a(false);
            return true;
        }

        public int getId() {
            return 0;
        }

        /* renamed from: a */
        public Parcelable mo4073a() {
            return null;
        }

        /* renamed from: a */
        public void mo4076a(Parcelable state) {
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$b */
    public static class C1019b extends C0761a {

        /* renamed from: b */
        int f3420b;

        public C1019b(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.f3420b = 0;
        }

        public C1019b(int width, int height) {
            super(width, height);
            this.f3420b = 0;
            this.f2312a = 8388627;
        }

        public C1019b(C1019b source) {
            super((C0761a) source);
            this.f3420b = 0;
            this.f3420b = source.f3420b;
        }

        public C1019b(C0761a source) {
            super(source);
            this.f3420b = 0;
        }

        public C1019b(MarginLayoutParams source) {
            super((LayoutParams) source);
            this.f3420b = 0;
            mo8315a(source);
        }

        public C1019b(LayoutParams source) {
            super(source);
            this.f3420b = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo8315a(MarginLayoutParams source) {
            this.leftMargin = source.leftMargin;
            this.topMargin = source.topMargin;
            this.rightMargin = source.rightMargin;
            this.bottomMargin = source.bottomMargin;
        }
    }

    /* renamed from: android.support.v7.widget.Toolbar$c */
    public interface C1020c {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        this(context, attrs, C0793R.attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        int i;
        super(context, attrs, defStyleAttr);
        this.f3411w = 8388627;
        this.f3377D = new ArrayList<>();
        this.f3378E = new ArrayList<>();
        this.f3379F = new int[2];
        this.f3381H = new C1115tb(this);
        this.f3388O = new C1118ub(this);
        C1112sb a = C1112sb.m5456a(getContext(), attrs, C0793R.styleable.Toolbar, defStyleAttr, 0);
        this.f3400l = a.mo8659g(C0793R.styleable.Toolbar_titleTextAppearance, 0);
        this.f3401m = a.mo8659g(C0793R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.f3411w = a.mo8655e(C0793R.styleable.Toolbar_android_gravity, this.f3411w);
        this.f3402n = a.mo8655e(C0793R.styleable.Toolbar_buttonGravity, 48);
        int titleMargin = a.mo8649b(C0793R.styleable.Toolbar_titleMargin, 0);
        if (a.mo8660g(C0793R.styleable.Toolbar_titleMargins)) {
            titleMargin = a.mo8649b(C0793R.styleable.Toolbar_titleMargins, titleMargin);
        }
        this.f3407s = titleMargin;
        this.f3406r = titleMargin;
        this.f3405q = titleMargin;
        this.f3404p = titleMargin;
        int marginStart = a.mo8649b(C0793R.styleable.Toolbar_titleMarginStart, -1);
        if (marginStart >= 0) {
            this.f3404p = marginStart;
        }
        int marginEnd = a.mo8649b(C0793R.styleable.Toolbar_titleMarginEnd, -1);
        if (marginEnd >= 0) {
            this.f3405q = marginEnd;
        }
        int marginTop = a.mo8649b(C0793R.styleable.Toolbar_titleMarginTop, -1);
        if (marginTop >= 0) {
            this.f3406r = marginTop;
        }
        int marginBottom = a.mo8649b(C0793R.styleable.Toolbar_titleMarginBottom, -1);
        if (marginBottom >= 0) {
            this.f3407s = marginBottom;
        }
        this.f3403o = a.mo8651c(C0793R.styleable.Toolbar_maxButtonHeight, -1);
        int contentInsetStart = a.mo8649b(C0793R.styleable.Toolbar_contentInsetStart, LinearLayoutManager.INVALID_OFFSET);
        int contentInsetEnd = a.mo8649b(C0793R.styleable.Toolbar_contentInsetEnd, LinearLayoutManager.INVALID_OFFSET);
        int contentInsetLeft = a.mo8651c(C0793R.styleable.Toolbar_contentInsetLeft, 0);
        int contentInsetRight = a.mo8651c(C0793R.styleable.Toolbar_contentInsetRight, 0);
        m5142l();
        this.f3408t.mo7511a(contentInsetLeft, contentInsetRight);
        if (!(contentInsetStart == Integer.MIN_VALUE && contentInsetEnd == Integer.MIN_VALUE)) {
            this.f3408t.mo7514b(contentInsetStart, contentInsetEnd);
        }
        this.f3409u = a.mo8649b(C0793R.styleable.Toolbar_contentInsetStartWithNavigation, LinearLayoutManager.INVALID_OFFSET);
        this.f3410v = a.mo8649b(C0793R.styleable.Toolbar_contentInsetEndWithActions, LinearLayoutManager.INVALID_OFFSET);
        this.f3394f = a.mo8650b(C0793R.styleable.Toolbar_collapseIcon);
        this.f3395g = a.mo8656e(C0793R.styleable.Toolbar_collapseContentDescription);
        CharSequence title = a.mo8656e(C0793R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(title)) {
            setTitle(title);
        }
        CharSequence subtitle = a.mo8656e(C0793R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(subtitle)) {
            setSubtitle(subtitle);
        }
        this.f3398j = getContext();
        int i2 = titleMargin;
        setPopupTheme(a.mo8659g(C0793R.styleable.Toolbar_popupTheme, 0));
        Drawable navIcon = a.mo8650b(C0793R.styleable.Toolbar_navigationIcon);
        if (navIcon != null) {
            setNavigationIcon(navIcon);
        }
        CharSequence navDesc = a.mo8656e(C0793R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(navDesc)) {
            setNavigationContentDescription(navDesc);
        }
        Drawable drawable = navIcon;
        Drawable logo = a.mo8650b(C0793R.styleable.Toolbar_logo);
        if (logo != null) {
            setLogo(logo);
        }
        Drawable drawable2 = logo;
        CharSequence logoDesc = a.mo8656e(C0793R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(logoDesc)) {
            setLogoDescription(logoDesc);
        }
        CharSequence charSequence = logoDesc;
        if (a.mo8660g(C0793R.styleable.Toolbar_titleTextColor)) {
            CharSequence charSequence2 = navDesc;
            i = -1;
            setTitleTextColor(a.mo8644a(C0793R.styleable.Toolbar_titleTextColor, -1));
        } else {
            i = -1;
        }
        if (a.mo8660g(C0793R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(a.mo8644a(C0793R.styleable.Toolbar_subtitleTextColor, i));
        }
        a.mo8647a();
    }

    public void setPopupTheme(int resId) {
        if (this.f3399k != resId) {
            this.f3399k = resId;
            if (resId == 0) {
                this.f3398j = getContext();
            } else {
                this.f3398j = new ContextThemeWrapper(getContext(), resId);
            }
        }
    }

    public int getPopupTheme() {
        return this.f3399k;
    }

    public int getTitleMarginStart() {
        return this.f3404p;
    }

    public void setTitleMarginStart(int margin) {
        this.f3404p = margin;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.f3406r;
    }

    public void setTitleMarginTop(int margin) {
        this.f3406r = margin;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.f3405q;
    }

    public void setTitleMarginEnd(int margin) {
        this.f3405q = margin;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.f3407s;
    }

    public void setTitleMarginBottom(int margin) {
        this.f3407s = margin;
        requestLayout();
    }

    public void onRtlPropertiesChanged(int layoutDirection) {
        if (VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(layoutDirection);
        }
        m5142l();
        C0966Pa pa = this.f3408t;
        boolean z = true;
        if (layoutDirection != 1) {
            z = false;
        }
        pa.mo7512a(z);
    }

    public void setLogo(int resId) {
        setLogo(C1282b.m6000b(getContext(), resId));
    }

    /* renamed from: b */
    public boolean mo8242b() {
        if (getVisibility() == 0) {
            ActionMenuView actionMenuView = this.f3389a;
            if (actionMenuView != null && actionMenuView.mo7089f()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    public boolean mo8279i() {
        ActionMenuView actionMenuView = this.f3389a;
        return actionMenuView != null && actionMenuView.mo7088e();
    }

    /* renamed from: h */
    public boolean mo8278h() {
        ActionMenuView actionMenuView = this.f3389a;
        return actionMenuView != null && actionMenuView.mo7086d();
    }

    /* renamed from: k */
    public boolean mo8281k() {
        ActionMenuView actionMenuView = this.f3389a;
        return actionMenuView != null && actionMenuView.mo7098i();
    }

    /* renamed from: g */
    public boolean mo8248g() {
        ActionMenuView actionMenuView = this.f3389a;
        return actionMenuView != null && actionMenuView.mo7084c();
    }

    /* renamed from: a */
    public void mo8239a(C0873l menu, ActionMenuPresenter outerPresenter) {
        if (menu != null || this.f3389a != null) {
            m5145o();
            C0873l oldMenu = this.f3389a.mo7090g();
            if (oldMenu != menu) {
                if (oldMenu != null) {
                    oldMenu.mo6726b((C0890v) this.f3383J);
                    oldMenu.mo6726b((C0890v) this.f3384K);
                }
                if (this.f3384K == null) {
                    this.f3384K = new C1018a();
                }
                outerPresenter.mo7066b(true);
                if (menu != null) {
                    menu.mo6709a((C0890v) outerPresenter, this.f3398j);
                    menu.mo6709a((C0890v) this.f3384K, this.f3398j);
                } else {
                    outerPresenter.mo4075a(this.f3398j, (C0873l) null);
                    this.f3384K.mo4075a(this.f3398j, (C0873l) null);
                    outerPresenter.mo4079a(true);
                    this.f3384K.mo4079a(true);
                }
                this.f3389a.setPopupTheme(this.f3399k);
                this.f3389a.setPresenter(outerPresenter);
                this.f3383J = outerPresenter;
            }
        }
    }

    /* renamed from: d */
    public void mo8245d() {
        ActionMenuView actionMenuView = this.f3389a;
        if (actionMenuView != null) {
            actionMenuView.mo7080a();
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m5143m();
            if (!m5140c(this.f3393e)) {
                m5135a((View) this.f3393e, true);
            }
        } else {
            ImageView imageView = this.f3393e;
            if (imageView != null && m5140c(imageView)) {
                removeView(this.f3393e);
                this.f3378E.remove(this.f3393e);
            }
        }
        ImageView imageView2 = this.f3393e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.f3393e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int resId) {
        setLogoDescription(getContext().getText(resId));
    }

    public void setLogoDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            m5143m();
        }
        ImageView imageView = this.f3393e;
        if (imageView != null) {
            imageView.setContentDescription(description);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f3393e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    /* renamed from: m */
    private void m5143m() {
        if (this.f3393e == null) {
            this.f3393e = new AppCompatImageView(getContext());
        }
    }

    /* renamed from: f */
    public boolean mo8247f() {
        C1018a aVar = this.f3384K;
        return (aVar == null || aVar.f3418b == null) ? false : true;
    }

    /* renamed from: c */
    public void mo8243c() {
        C1018a aVar = this.f3384K;
        C0879p item = aVar == null ? null : aVar.f3418b;
        if (item != null) {
            item.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.f3412x;
    }

    public void setTitle(int resId) {
        setTitle(getContext().getText(resId));
    }

    public void setTitle(CharSequence title) {
        if (!TextUtils.isEmpty(title)) {
            if (this.f3390b == null) {
                Context context = getContext();
                this.f3390b = new C0939H(context);
                this.f3390b.setSingleLine();
                this.f3390b.setEllipsize(TruncateAt.END);
                int i = this.f3400l;
                if (i != 0) {
                    this.f3390b.setTextAppearance(context, i);
                }
                int i2 = this.f3414z;
                if (i2 != 0) {
                    this.f3390b.setTextColor(i2);
                }
            }
            if (!m5140c(this.f3390b)) {
                m5135a((View) this.f3390b, true);
            }
        } else {
            TextView textView = this.f3390b;
            if (textView != null && m5140c(textView)) {
                removeView(this.f3390b);
                this.f3378E.remove(this.f3390b);
            }
        }
        TextView textView2 = this.f3390b;
        if (textView2 != null) {
            textView2.setText(title);
        }
        this.f3412x = title;
    }

    public CharSequence getSubtitle() {
        return this.f3413y;
    }

    public void setSubtitle(int resId) {
        setSubtitle(getContext().getText(resId));
    }

    public void setSubtitle(CharSequence subtitle) {
        if (!TextUtils.isEmpty(subtitle)) {
            if (this.f3391c == null) {
                Context context = getContext();
                this.f3391c = new C0939H(context);
                this.f3391c.setSingleLine();
                this.f3391c.setEllipsize(TruncateAt.END);
                int i = this.f3401m;
                if (i != 0) {
                    this.f3391c.setTextAppearance(context, i);
                }
                int i2 = this.f3374A;
                if (i2 != 0) {
                    this.f3391c.setTextColor(i2);
                }
            }
            if (!m5140c(this.f3391c)) {
                m5135a((View) this.f3391c, true);
            }
        } else {
            TextView textView = this.f3391c;
            if (textView != null && m5140c(textView)) {
                removeView(this.f3391c);
                this.f3378E.remove(this.f3391c);
            }
        }
        TextView textView2 = this.f3391c;
        if (textView2 != null) {
            textView2.setText(subtitle);
        }
        this.f3413y = subtitle;
    }

    /* renamed from: b */
    public void mo8241b(Context context, int resId) {
        this.f3400l = resId;
        TextView textView = this.f3390b;
        if (textView != null) {
            textView.setTextAppearance(context, resId);
        }
    }

    /* renamed from: a */
    public void mo8238a(Context context, int resId) {
        this.f3401m = resId;
        TextView textView = this.f3391c;
        if (textView != null) {
            textView.setTextAppearance(context, resId);
        }
    }

    public void setTitleTextColor(int color) {
        this.f3414z = color;
        TextView textView = this.f3390b;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setSubtitleTextColor(int color) {
        this.f3374A = color;
        TextView textView = this.f3391c;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f3392d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int resId) {
        setNavigationContentDescription(resId != 0 ? getContext().getText(resId) : null);
    }

    public void setNavigationContentDescription(CharSequence description) {
        if (!TextUtils.isEmpty(description)) {
            m5146p();
        }
        ImageButton imageButton = this.f3392d;
        if (imageButton != null) {
            imageButton.setContentDescription(description);
        }
    }

    public void setNavigationIcon(int resId) {
        setNavigationIcon(C1282b.m6000b(getContext(), resId));
    }

    public void setNavigationIcon(Drawable icon) {
        if (icon != null) {
            m5146p();
            if (!m5140c(this.f3392d)) {
                m5135a((View) this.f3392d, true);
            }
        } else {
            ImageButton imageButton = this.f3392d;
            if (imageButton != null && m5140c(imageButton)) {
                removeView(this.f3392d);
                this.f3378E.remove(this.f3392d);
            }
        }
        ImageButton imageButton2 = this.f3392d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(icon);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f3392d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(OnClickListener listener) {
        m5146p();
        this.f3392d.setOnClickListener(listener);
    }

    public Menu getMenu() {
        m5144n();
        return this.f3389a.getMenu();
    }

    public void setOverflowIcon(Drawable icon) {
        m5144n();
        this.f3389a.setOverflowIcon(icon);
    }

    public Drawable getOverflowIcon() {
        m5144n();
        return this.f3389a.getOverflowIcon();
    }

    /* renamed from: n */
    private void m5144n() {
        m5145o();
        if (this.f3389a.mo7090g() == null) {
            C0873l menu = (C0873l) this.f3389a.getMenu();
            if (this.f3384K == null) {
                this.f3384K = new C1018a();
            }
            this.f3389a.setExpandedActionViewsExclusive(true);
            menu.mo6709a((C0890v) this.f3384K, this.f3398j);
        }
    }

    /* renamed from: o */
    private void m5145o() {
        if (this.f3389a == null) {
            this.f3389a = new ActionMenuView(getContext());
            this.f3389a.setPopupTheme(this.f3399k);
            this.f3389a.setOnMenuItemClickListener(this.f3381H);
            this.f3389a.mo7081a(this.f3385L, this.f3386M);
            C1019b lp = generateDefaultLayoutParams();
            lp.f2312a = 8388613 | (this.f3402n & 112);
            this.f3389a.setLayoutParams(lp);
            m5135a((View) this.f3389a, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new C1307g(getContext());
    }

    public void setOnMenuItemClickListener(C1020c listener) {
        this.f3380G = listener;
    }

    /* renamed from: a */
    public void mo8237a(int contentInsetStart, int contentInsetEnd) {
        m5142l();
        this.f3408t.mo7514b(contentInsetStart, contentInsetEnd);
    }

    public int getContentInsetStart() {
        C0966Pa pa = this.f3408t;
        if (pa != null) {
            return pa.mo7516d();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        C0966Pa pa = this.f3408t;
        if (pa != null) {
            return pa.mo7510a();
        }
        return 0;
    }

    public int getContentInsetLeft() {
        C0966Pa pa = this.f3408t;
        if (pa != null) {
            return pa.mo7513b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        C0966Pa pa = this.f3408t;
        if (pa != null) {
            return pa.mo7515c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.f3409u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int insetStartWithNavigation) {
        if (insetStartWithNavigation < 0) {
            insetStartWithNavigation = LinearLayoutManager.INVALID_OFFSET;
        }
        if (insetStartWithNavigation != this.f3409u) {
            this.f3409u = insetStartWithNavigation;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.f3410v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int insetEndWithActions) {
        if (insetEndWithActions < 0) {
            insetEndWithActions = LinearLayoutManager.INVALID_OFFSET;
        }
        if (insetEndWithActions != this.f3410v) {
            this.f3410v = insetEndWithActions;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f3409u, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        boolean hasActions = false;
        ActionMenuView actionMenuView = this.f3389a;
        if (actionMenuView != null) {
            C0873l mb = actionMenuView.mo7090g();
            hasActions = mb != null && mb.hasVisibleItems();
        }
        if (hasActions) {
            return Math.max(getContentInsetEnd(), Math.max(this.f3410v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (C0646w.m2974h(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (C0646w.m2974h(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    /* renamed from: p */
    private void m5146p() {
        if (this.f3392d == null) {
            this.f3392d = new C1110s(getContext(), null, C0793R.attr.toolbarNavigationButtonStyle);
            C1019b lp = generateDefaultLayoutParams();
            lp.f2312a = 8388611 | (this.f3402n & 112);
            this.f3392d.setLayoutParams(lp);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo8246e() {
        if (this.f3396h == null) {
            this.f3396h = new C1110s(getContext(), null, C0793R.attr.toolbarNavigationButtonStyle);
            this.f3396h.setImageDrawable(this.f3394f);
            this.f3396h.setContentDescription(this.f3395g);
            C1019b lp = generateDefaultLayoutParams();
            lp.f2312a = 8388611 | (this.f3402n & 112);
            lp.f3420b = 2;
            this.f3396h.setLayoutParams(lp);
            this.f3396h.setOnClickListener(new C1126vb(this));
        }
    }

    /* renamed from: a */
    private void m5135a(View v, boolean allowHide) {
        C1019b lp;
        LayoutParams vlp = v.getLayoutParams();
        if (vlp == null) {
            lp = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(vlp)) {
            lp = generateLayoutParams(vlp);
        } else {
            lp = (C1019b) vlp;
        }
        lp.f3420b = 1;
        if (!allowHide || this.f3397i == null) {
            addView(v, lp);
            return;
        }
        v.setLayoutParams(lp);
        this.f3378E.add(v);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState state = new SavedState(super.onSaveInstanceState());
        C1018a aVar = this.f3384K;
        if (aVar != null) {
            C0879p pVar = aVar.f3418b;
            if (pVar != null) {
                state.f3415c = pVar.getItemId();
            }
        }
        state.f3416d = mo8279i();
        return state;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState ss = (SavedState) state;
        super.onRestoreInstanceState(ss.mo5452a());
        ActionMenuView actionMenuView = this.f3389a;
        Menu menu = actionMenuView != null ? actionMenuView.mo7090g() : null;
        int i = ss.f3415c;
        if (!(i == 0 || this.f3384K == null || menu == null)) {
            MenuItem item = menu.findItem(i);
            if (item != null) {
                item.expandActionView();
            }
        }
        if (ss.f3416d) {
            m5147q();
        }
    }

    /* renamed from: q */
    private void m5147q() {
        removeCallbacks(this.f3388O);
        post(this.f3388O);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f3388O);
    }

    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 0) {
            this.f3375B = false;
        }
        if (!this.f3375B) {
            boolean handled = super.onTouchEvent(ev);
            if (action == 0 && !handled) {
                this.f3375B = true;
            }
        }
        if (action == 1 || action == 3) {
            this.f3375B = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent ev) {
        int action = ev.getActionMasked();
        if (action == 9) {
            this.f3376C = false;
        }
        if (!this.f3376C) {
            boolean handled = super.onHoverEvent(ev);
            if (action == 9 && !handled) {
                this.f3376C = true;
            }
        }
        if (action == 10 || action == 3) {
            this.f3376C = false;
        }
        return true;
    }

    /* renamed from: a */
    private void m5134a(View child, int parentWidthSpec, int widthUsed, int parentHeightSpec, int heightUsed, int heightConstraint) {
        MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        int childWidthSpec = ViewGroup.getChildMeasureSpec(parentWidthSpec, getPaddingLeft() + getPaddingRight() + lp.leftMargin + lp.rightMargin + widthUsed, lp.width);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(parentHeightSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height);
        int childHeightMode = MeasureSpec.getMode(childHeightSpec);
        if (childHeightMode != 1073741824 && heightConstraint >= 0) {
            childHeightSpec = MeasureSpec.makeMeasureSpec(childHeightMode != 0 ? Math.min(MeasureSpec.getSize(childHeightSpec), heightConstraint) : heightConstraint, 1073741824);
        }
        child.measure(childWidthSpec, childHeightSpec);
    }

    /* renamed from: a */
    private int m5131a(View child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed, int[] collapsingMargins) {
        MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
        int leftDiff = lp.leftMargin - collapsingMargins[0];
        int rightDiff = lp.rightMargin - collapsingMargins[1];
        int hMargins = Math.max(0, leftDiff) + Math.max(0, rightDiff);
        collapsingMargins[0] = Math.max(0, -leftDiff);
        collapsingMargins[1] = Math.max(0, -rightDiff);
        child.measure(ViewGroup.getChildMeasureSpec(parentWidthMeasureSpec, getPaddingLeft() + getPaddingRight() + hMargins + widthUsed, lp.width), ViewGroup.getChildMeasureSpec(parentHeightMeasureSpec, getPaddingTop() + getPaddingBottom() + lp.topMargin + lp.bottomMargin + heightUsed, lp.height));
        return child.getMeasuredWidth() + hMargins;
    }

    /* renamed from: r */
    private boolean m5148r() {
        if (!this.f3387N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (m5141d(child) && child.getMeasuredWidth() > 0 && child.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        char c;
        char c2;
        int marginStartIndex;
        int childState;
        int height;
        int childState2;
        int childState3;
        int titleHeight;
        int menuWidth;
        int childCount;
        int menuWidth2;
        int height2 = 0;
        int childState4 = 0;
        int[] collapsingMargins = this.f3379F;
        if (C0946Ib.m4565a(this)) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        int navWidth = 0;
        if (m5141d(this.f3392d)) {
            m5134a((View) this.f3392d, widthMeasureSpec, 0, heightMeasureSpec, 0, this.f3403o);
            navWidth = this.f3392d.getMeasuredWidth() + m5129a((View) this.f3392d);
            height2 = Math.max(0, this.f3392d.getMeasuredHeight() + m5138b((View) this.f3392d));
            childState4 = View.combineMeasuredStates(0, this.f3392d.getMeasuredState());
        }
        if (m5141d(this.f3396h)) {
            m5134a((View) this.f3396h, widthMeasureSpec, 0, heightMeasureSpec, 0, this.f3403o);
            navWidth = this.f3396h.getMeasuredWidth() + m5129a((View) this.f3396h);
            height2 = Math.max(height2, this.f3396h.getMeasuredHeight() + m5138b((View) this.f3396h));
            childState4 = View.combineMeasuredStates(childState4, this.f3396h.getMeasuredState());
        }
        int contentInsetStart = getCurrentContentInsetStart();
        int width = 0 + Math.max(contentInsetStart, navWidth);
        collapsingMargins[c2] = Math.max(0, contentInsetStart - navWidth);
        if (m5141d(this.f3389a)) {
            char c3 = c2;
            marginStartIndex = 0;
            m5134a((View) this.f3389a, widthMeasureSpec, width, heightMeasureSpec, 0, this.f3403o);
            int menuWidth3 = this.f3389a.getMeasuredWidth() + m5129a((View) this.f3389a);
            int height3 = Math.max(height2, this.f3389a.getMeasuredHeight() + m5138b((View) this.f3389a));
            childState2 = View.combineMeasuredStates(childState4, this.f3389a.getMeasuredState());
            childState = height3;
            height = menuWidth3;
        } else {
            int marginStartIndex2 = c2;
            marginStartIndex = 0;
            childState2 = childState4;
            childState = height2;
            height = 0;
        }
        int contentInsetEnd = getCurrentContentInsetEnd();
        int width2 = width + Math.max(contentInsetEnd, height);
        collapsingMargins[c] = Math.max(marginStartIndex, contentInsetEnd - height);
        if (m5141d(this.f3397i)) {
            int i = contentInsetEnd;
            int childState5 = childState2;
            width2 += m5131a(this.f3397i, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            childState = Math.max(childState, this.f3397i.getMeasuredHeight() + m5138b(this.f3397i));
            childState3 = View.combineMeasuredStates(childState5, this.f3397i.getMeasuredState());
        } else {
            childState3 = childState2;
        }
        if (m5141d(this.f3393e)) {
            width2 += m5131a((View) this.f3393e, widthMeasureSpec, width2, heightMeasureSpec, 0, collapsingMargins);
            childState = Math.max(childState, this.f3393e.getMeasuredHeight() + m5138b((View) this.f3393e));
            childState3 = View.combineMeasuredStates(childState3, this.f3393e.getMeasuredState());
        }
        int childCount2 = getChildCount();
        int height4 = childState;
        int width3 = width2;
        int i2 = 0;
        while (i2 < childCount2) {
            View child = getChildAt(i2);
            C1019b lp = (C1019b) child.getLayoutParams();
            if (lp.f3420b != 0) {
                View view = child;
                childCount = childCount2;
                menuWidth = height;
                menuWidth2 = height4;
            } else if (!m5141d(child)) {
                childCount = childCount2;
                menuWidth = height;
                menuWidth2 = height4;
            } else {
                C1019b bVar = lp;
                View child2 = child;
                menuWidth = height;
                childCount = childCount2;
                width3 += m5131a(child, widthMeasureSpec, width3, heightMeasureSpec, 0, collapsingMargins);
                View child3 = child2;
                height4 = Math.max(height4, child2.getMeasuredHeight() + m5138b(child3));
                childState3 = View.combineMeasuredStates(childState3, child3.getMeasuredState());
                i2++;
                childCount2 = childCount;
                height = menuWidth;
            }
            height4 = menuWidth2;
            i2++;
            childCount2 = childCount;
            height = menuWidth;
        }
        int i3 = height;
        int height5 = height4;
        int titleWidth = 0;
        int titleHeight2 = 0;
        int titleVertMargins = this.f3406r + this.f3407s;
        int titleHorizMargins = this.f3404p + this.f3405q;
        if (m5141d(this.f3390b)) {
            int a = m5131a((View) this.f3390b, widthMeasureSpec, width3 + titleHorizMargins, heightMeasureSpec, titleVertMargins, collapsingMargins);
            titleWidth = this.f3390b.getMeasuredWidth() + m5129a((View) this.f3390b);
            titleHeight2 = this.f3390b.getMeasuredHeight() + m5138b((View) this.f3390b);
            childState3 = View.combineMeasuredStates(childState3, this.f3390b.getMeasuredState());
        }
        if (m5141d(this.f3391c)) {
            titleWidth = Math.max(titleWidth, m5131a((View) this.f3391c, widthMeasureSpec, width3 + titleHorizMargins, heightMeasureSpec, titleHeight2 + titleVertMargins, collapsingMargins));
            int titleHeight3 = titleHeight2 + this.f3391c.getMeasuredHeight() + m5138b((View) this.f3391c);
            childState3 = View.combineMeasuredStates(childState3, this.f3391c.getMeasuredState());
            titleHeight = titleHeight3;
        } else {
            titleHeight = titleHeight2;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(width3 + titleWidth + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), widthMeasureSpec, -16777216 & childState3), m5148r() ? 0 : View.resolveSizeAndState(Math.max(Math.max(height5, titleHeight) + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), heightMeasureSpec, childState3 << 16));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015e, code lost:
        if (r0.f3390b.getMeasuredWidth() <= 0) goto L_0x0163;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x025c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r34, int r35, int r36, int r37, int r38) {
        /*
            r33 = this;
            r0 = r33
            int r1 = android.support.p000v4.view.C0646w.m2974h(r33)
            r2 = 1
            r3 = 0
            if (r1 != r2) goto L_0x000c
            r1 = 1
            goto L_0x000d
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r4 = r33.getWidth()
            int r5 = r33.getHeight()
            int r6 = r33.getPaddingLeft()
            int r7 = r33.getPaddingRight()
            int r8 = r33.getPaddingTop()
            int r9 = r33.getPaddingBottom()
            r10 = r6
            int r11 = r4 - r7
            int[] r12 = r0.f3379F
            r12[r2] = r3
            r12[r3] = r3
            int r13 = android.support.p000v4.view.C0646w.m2975i(r33)
            if (r13 < 0) goto L_0x003b
            int r14 = r38 - r36
            int r14 = java.lang.Math.min(r13, r14)
            goto L_0x003c
        L_0x003b:
            r14 = 0
        L_0x003c:
            android.widget.ImageButton r15 = r0.f3392d
            boolean r15 = r0.m5141d(r15)
            if (r15 == 0) goto L_0x0053
            if (r1 == 0) goto L_0x004d
            android.widget.ImageButton r15 = r0.f3392d
            int r11 = r0.m5139b(r15, r11, r12, r14)
            goto L_0x0053
        L_0x004d:
            android.widget.ImageButton r15 = r0.f3392d
            int r10 = r0.m5132a(r15, r10, r12, r14)
        L_0x0053:
            android.widget.ImageButton r15 = r0.f3396h
            boolean r15 = r0.m5141d(r15)
            if (r15 == 0) goto L_0x006a
            if (r1 == 0) goto L_0x0064
            android.widget.ImageButton r15 = r0.f3396h
            int r11 = r0.m5139b(r15, r11, r12, r14)
            goto L_0x006a
        L_0x0064:
            android.widget.ImageButton r15 = r0.f3396h
            int r10 = r0.m5132a(r15, r10, r12, r14)
        L_0x006a:
            android.support.v7.widget.ActionMenuView r15 = r0.f3389a
            boolean r15 = r0.m5141d(r15)
            if (r15 == 0) goto L_0x0081
            if (r1 == 0) goto L_0x007b
            android.support.v7.widget.ActionMenuView r15 = r0.f3389a
            int r10 = r0.m5132a(r15, r10, r12, r14)
            goto L_0x0081
        L_0x007b:
            android.support.v7.widget.ActionMenuView r15 = r0.f3389a
            int r11 = r0.m5139b(r15, r11, r12, r14)
        L_0x0081:
            int r15 = r33.getCurrentContentInsetLeft()
            int r16 = r33.getCurrentContentInsetRight()
            int r2 = r15 - r10
            int r2 = java.lang.Math.max(r3, r2)
            r12[r3] = r2
            int r2 = r4 - r7
            int r2 = r2 - r11
            int r2 = r16 - r2
            int r2 = java.lang.Math.max(r3, r2)
            r17 = 1
            r12[r17] = r2
            int r2 = java.lang.Math.max(r10, r15)
            int r10 = r4 - r7
            int r10 = r10 - r16
            int r10 = java.lang.Math.min(r11, r10)
            android.view.View r11 = r0.f3397i
            boolean r11 = r0.m5141d(r11)
            if (r11 == 0) goto L_0x00c1
            if (r1 == 0) goto L_0x00bb
            android.view.View r11 = r0.f3397i
            int r10 = r0.m5139b(r11, r10, r12, r14)
            goto L_0x00c1
        L_0x00bb:
            android.view.View r11 = r0.f3397i
            int r2 = r0.m5132a(r11, r2, r12, r14)
        L_0x00c1:
            android.widget.ImageView r11 = r0.f3393e
            boolean r11 = r0.m5141d(r11)
            if (r11 == 0) goto L_0x00d8
            if (r1 == 0) goto L_0x00d2
            android.widget.ImageView r11 = r0.f3393e
            int r10 = r0.m5139b(r11, r10, r12, r14)
            goto L_0x00d8
        L_0x00d2:
            android.widget.ImageView r11 = r0.f3393e
            int r2 = r0.m5132a(r11, r2, r12, r14)
        L_0x00d8:
            android.widget.TextView r11 = r0.f3390b
            boolean r11 = r0.m5141d(r11)
            android.widget.TextView r3 = r0.f3391c
            boolean r3 = r0.m5141d(r3)
            r19 = 0
            if (r11 == 0) goto L_0x0105
            r20 = r13
            android.widget.TextView r13 = r0.f3390b
            android.view.ViewGroup$LayoutParams r13 = r13.getLayoutParams()
            android.support.v7.widget.Toolbar$b r13 = (android.support.p001v7.widget.Toolbar.C1019b) r13
            r21 = r15
            int r15 = r13.topMargin
            r22 = r7
            android.widget.TextView r7 = r0.f3390b
            int r7 = r7.getMeasuredHeight()
            int r15 = r15 + r7
            int r7 = r13.bottomMargin
            int r15 = r15 + r7
            int r19 = r19 + r15
            goto L_0x010b
        L_0x0105:
            r22 = r7
            r20 = r13
            r21 = r15
        L_0x010b:
            if (r3 == 0) goto L_0x0123
            android.widget.TextView r7 = r0.f3391c
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            android.support.v7.widget.Toolbar$b r7 = (android.support.p001v7.widget.Toolbar.C1019b) r7
            int r13 = r7.topMargin
            android.widget.TextView r15 = r0.f3391c
            int r15 = r15.getMeasuredHeight()
            int r13 = r13 + r15
            int r15 = r7.bottomMargin
            int r13 = r13 + r15
            int r19 = r19 + r13
        L_0x0123:
            if (r11 != 0) goto L_0x0136
            if (r3 == 0) goto L_0x0128
            goto L_0x0136
        L_0x0128:
            r27 = r1
            r29 = r2
            r25 = r4
            r30 = r5
            r26 = r6
            r28 = r14
            goto L_0x02d9
        L_0x0136:
            if (r11 == 0) goto L_0x013b
            android.widget.TextView r7 = r0.f3390b
            goto L_0x013d
        L_0x013b:
            android.widget.TextView r7 = r0.f3391c
        L_0x013d:
            if (r3 == 0) goto L_0x0142
            android.widget.TextView r13 = r0.f3391c
            goto L_0x0144
        L_0x0142:
            android.widget.TextView r13 = r0.f3390b
        L_0x0144:
            android.view.ViewGroup$LayoutParams r15 = r7.getLayoutParams()
            android.support.v7.widget.Toolbar$b r15 = (android.support.p001v7.widget.Toolbar.C1019b) r15
            android.view.ViewGroup$LayoutParams r23 = r13.getLayoutParams()
            r24 = r7
            r7 = r23
            android.support.v7.widget.Toolbar$b r7 = (android.support.p001v7.widget.Toolbar.C1019b) r7
            if (r11 == 0) goto L_0x0161
            r23 = r13
            android.widget.TextView r13 = r0.f3390b
            int r13 = r13.getMeasuredWidth()
            if (r13 > 0) goto L_0x016d
            goto L_0x0163
        L_0x0161:
            r23 = r13
        L_0x0163:
            if (r3 == 0) goto L_0x016f
            android.widget.TextView r13 = r0.f3391c
            int r13 = r13.getMeasuredWidth()
            if (r13 <= 0) goto L_0x016f
        L_0x016d:
            r13 = 1
            goto L_0x0170
        L_0x016f:
            r13 = 0
        L_0x0170:
            r25 = r4
            int r4 = r0.f3411w
            r4 = r4 & 112(0x70, float:1.57E-43)
            r26 = r6
            r6 = 48
            if (r4 == r6) goto L_0x01cb
            r6 = 80
            if (r4 == r6) goto L_0x01b6
            int r4 = r5 - r8
            int r4 = r4 - r9
            int r6 = r4 - r19
            int r6 = r6 / 2
            r27 = r4
            int r4 = r15.topMargin
            r28 = r14
            int r14 = r0.f3406r
            r29 = r2
            int r2 = r4 + r14
            if (r6 >= r2) goto L_0x0199
            int r6 = r4 + r14
            r14 = 0
            goto L_0x01b3
        L_0x0199:
            int r2 = r5 - r9
            int r2 = r2 - r19
            int r2 = r2 - r6
            int r2 = r2 - r8
            int r4 = r15.bottomMargin
            int r14 = r0.f3407s
            int r4 = r4 + r14
            if (r2 >= r4) goto L_0x01b2
            int r4 = r7.bottomMargin
            int r4 = r4 + r14
            int r4 = r4 - r2
            int r4 = r6 - r4
            r14 = 0
            int r6 = java.lang.Math.max(r14, r4)
            goto L_0x01b3
        L_0x01b2:
            r14 = 0
        L_0x01b3:
            int r2 = r8 + r6
            goto L_0x01da
        L_0x01b6:
            r29 = r2
            r28 = r14
            r14 = 0
            r2 = r14
            r4 = r14
            r6 = r14
            int r14 = r5 - r9
            r27 = r2
            int r2 = r7.bottomMargin
            int r14 = r14 - r2
            int r2 = r0.f3407s
            int r14 = r14 - r2
            int r2 = r14 - r19
            goto L_0x01da
        L_0x01cb:
            r29 = r2
            r28 = r14
            int r2 = r33.getPaddingTop()
            int r4 = r15.topMargin
            int r2 = r2 + r4
            int r4 = r0.f3406r
            int r2 = r2 + r4
        L_0x01da:
            if (r1 == 0) goto L_0x025c
            if (r13 == 0) goto L_0x01e1
            int r4 = r0.f3404p
            goto L_0x01e2
        L_0x01e1:
            r4 = 0
        L_0x01e2:
            r6 = 1
            r14 = r12[r6]
            int r4 = r4 - r14
            r14 = 0
            int r17 = java.lang.Math.max(r14, r4)
            int r10 = r10 - r17
            r27 = r1
            int r1 = -r4
            int r1 = java.lang.Math.max(r14, r1)
            r12[r6] = r1
            r1 = r10
            r6 = r10
            if (r11 == 0) goto L_0x0225
            android.widget.TextView r14 = r0.f3390b
            android.view.ViewGroup$LayoutParams r14 = r14.getLayoutParams()
            android.support.v7.widget.Toolbar$b r14 = (android.support.p001v7.widget.Toolbar.C1019b) r14
            r18 = r4
            android.widget.TextView r4 = r0.f3390b
            int r4 = r4.getMeasuredWidth()
            int r4 = r1 - r4
            r30 = r5
            android.widget.TextView r5 = r0.f3390b
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r2
            r31 = r7
            android.widget.TextView r7 = r0.f3390b
            r7.layout(r4, r2, r1, r5)
            int r7 = r0.f3405q
            int r1 = r4 - r7
            int r7 = r14.bottomMargin
            int r2 = r5 + r7
            goto L_0x022b
        L_0x0225:
            r18 = r4
            r30 = r5
            r31 = r7
        L_0x022b:
            if (r3 == 0) goto L_0x0253
            android.widget.TextView r4 = r0.f3391c
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            android.support.v7.widget.Toolbar$b r4 = (android.support.p001v7.widget.Toolbar.C1019b) r4
            int r5 = r4.topMargin
            int r2 = r2 + r5
            android.widget.TextView r5 = r0.f3391c
            int r5 = r5.getMeasuredWidth()
            int r5 = r6 - r5
            android.widget.TextView r7 = r0.f3391c
            int r7 = r7.getMeasuredHeight()
            int r7 = r7 + r2
            android.widget.TextView r14 = r0.f3391c
            r14.layout(r5, r2, r6, r7)
            int r14 = r0.f3405q
            int r6 = r6 - r14
            int r14 = r4.bottomMargin
            int r2 = r7 + r14
        L_0x0253:
            if (r13 == 0) goto L_0x025a
            int r4 = java.lang.Math.min(r1, r6)
            r10 = r4
        L_0x025a:
            goto L_0x02d9
        L_0x025c:
            r27 = r1
            r30 = r5
            r31 = r7
            if (r13 == 0) goto L_0x0267
            int r1 = r0.f3404p
            goto L_0x0268
        L_0x0267:
            r1 = 0
        L_0x0268:
            r4 = 0
            r5 = r12[r4]
            int r1 = r1 - r5
            int r5 = java.lang.Math.max(r4, r1)
            int r5 = r29 + r5
            int r6 = -r1
            int r6 = java.lang.Math.max(r4, r6)
            r12[r4] = r6
            r4 = r5
            r6 = r5
            if (r11 == 0) goto L_0x02a5
            android.widget.TextView r7 = r0.f3390b
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            android.support.v7.widget.Toolbar$b r7 = (android.support.p001v7.widget.Toolbar.C1019b) r7
            android.widget.TextView r14 = r0.f3390b
            int r14 = r14.getMeasuredWidth()
            int r14 = r14 + r4
            r18 = r1
            android.widget.TextView r1 = r0.f3390b
            int r1 = r1.getMeasuredHeight()
            int r1 = r1 + r2
            r29 = r5
            android.widget.TextView r5 = r0.f3390b
            r5.layout(r4, r2, r14, r1)
            int r5 = r0.f3405q
            int r4 = r14 + r5
            int r5 = r7.bottomMargin
            int r2 = r1 + r5
            goto L_0x02a9
        L_0x02a5:
            r18 = r1
            r29 = r5
        L_0x02a9:
            if (r3 == 0) goto L_0x02d1
            android.widget.TextView r1 = r0.f3391c
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            android.support.v7.widget.Toolbar$b r1 = (android.support.p001v7.widget.Toolbar.C1019b) r1
            int r5 = r1.topMargin
            int r2 = r2 + r5
            android.widget.TextView r5 = r0.f3391c
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 + r6
            android.widget.TextView r7 = r0.f3391c
            int r7 = r7.getMeasuredHeight()
            int r7 = r7 + r2
            android.widget.TextView r14 = r0.f3391c
            r14.layout(r6, r2, r5, r7)
            int r14 = r0.f3405q
            int r6 = r5 + r14
            int r14 = r1.bottomMargin
            int r2 = r7 + r14
        L_0x02d1:
            if (r13 == 0) goto L_0x02d9
            int r1 = java.lang.Math.max(r4, r6)
            r29 = r1
        L_0x02d9:
            java.util.ArrayList<android.view.View> r1 = r0.f3377D
            r2 = 3
            r0.m5136a(r1, r2)
            java.util.ArrayList<android.view.View> r1 = r0.f3377D
            int r1 = r1.size()
            r2 = 0
            r4 = r29
        L_0x02e8:
            if (r2 >= r1) goto L_0x02fb
            java.util.ArrayList<android.view.View> r5 = r0.f3377D
            java.lang.Object r5 = r5.get(r2)
            android.view.View r5 = (android.view.View) r5
            r6 = r28
            int r4 = r0.m5132a(r5, r4, r12, r6)
            int r2 = r2 + 1
            goto L_0x02e8
        L_0x02fb:
            r6 = r28
            java.util.ArrayList<android.view.View> r2 = r0.f3377D
            r5 = 5
            r0.m5136a(r2, r5)
            java.util.ArrayList<android.view.View> r2 = r0.f3377D
            int r2 = r2.size()
            r5 = 0
        L_0x030a:
            if (r5 >= r2) goto L_0x031b
            java.util.ArrayList<android.view.View> r7 = r0.f3377D
            java.lang.Object r7 = r7.get(r5)
            android.view.View r7 = (android.view.View) r7
            int r10 = r0.m5139b(r7, r10, r12, r6)
            int r5 = r5 + 1
            goto L_0x030a
        L_0x031b:
            java.util.ArrayList<android.view.View> r5 = r0.f3377D
            r7 = 1
            r0.m5136a(r5, r7)
            java.util.ArrayList<android.view.View> r5 = r0.f3377D
            int r5 = r0.m5133a(r5, r12)
            int r7 = r25 - r26
            int r7 = r7 - r22
            int r7 = r7 / 2
            int r7 = r26 + r7
            int r13 = r5 / 2
            int r14 = r7 - r13
            int r15 = r14 + r5
            if (r14 >= r4) goto L_0x0339
            r14 = r4
            goto L_0x033f
        L_0x0339:
            if (r15 <= r10) goto L_0x033f
            int r17 = r15 - r10
            int r14 = r14 - r17
        L_0x033f:
            r17 = r1
            java.util.ArrayList<android.view.View> r1 = r0.f3377D
            int r1 = r1.size()
            r18 = 0
            r32 = r18
            r18 = r2
            r2 = r14
            r14 = r32
        L_0x0350:
            if (r14 >= r1) goto L_0x0365
            r23 = r1
            java.util.ArrayList<android.view.View> r1 = r0.f3377D
            java.lang.Object r1 = r1.get(r14)
            android.view.View r1 = (android.view.View) r1
            int r2 = r0.m5132a(r1, r2, r12, r6)
            int r14 = r14 + 1
            r1 = r23
            goto L_0x0350
        L_0x0365:
            r23 = r1
            java.util.ArrayList<android.view.View> r1 = r0.f3377D
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* renamed from: a */
    private int m5133a(List<View> views, int[] collapsingMargins) {
        int collapseLeft = collapsingMargins[0];
        int collapseRight = collapsingMargins[1];
        int width = 0;
        int count = views.size();
        for (int i = 0; i < count; i++) {
            View v = (View) views.get(i);
            C1019b lp = (C1019b) v.getLayoutParams();
            int l = lp.leftMargin - collapseLeft;
            int r = lp.rightMargin - collapseRight;
            int leftMargin = Math.max(0, l);
            int rightMargin = Math.max(0, r);
            collapseLeft = Math.max(0, -l);
            collapseRight = Math.max(0, -r);
            width += v.getMeasuredWidth() + leftMargin + rightMargin;
        }
        return width;
    }

    /* renamed from: a */
    private int m5132a(View child, int left, int[] collapsingMargins, int alignmentHeight) {
        C1019b lp = (C1019b) child.getLayoutParams();
        int l = lp.leftMargin - collapsingMargins[0];
        int left2 = left + Math.max(0, l);
        collapsingMargins[0] = Math.max(0, -l);
        int top = m5130a(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(left2, top, left2 + childWidth, child.getMeasuredHeight() + top);
        return left2 + lp.rightMargin + childWidth;
    }

    /* renamed from: b */
    private int m5139b(View child, int right, int[] collapsingMargins, int alignmentHeight) {
        C1019b lp = (C1019b) child.getLayoutParams();
        int r = lp.rightMargin - collapsingMargins[1];
        int right2 = right - Math.max(0, r);
        collapsingMargins[1] = Math.max(0, -r);
        int top = m5130a(child, alignmentHeight);
        int childWidth = child.getMeasuredWidth();
        child.layout(right2 - childWidth, top, right2, child.getMeasuredHeight() + top);
        return right2 - (lp.leftMargin + childWidth);
    }

    /* renamed from: a */
    private int m5130a(View child, int alignmentHeight) {
        C1019b lp = (C1019b) child.getLayoutParams();
        int childHeight = child.getMeasuredHeight();
        int alignmentOffset = alignmentHeight > 0 ? (childHeight - alignmentHeight) / 2 : 0;
        int b = m5137b(lp.f2312a);
        if (b == 48) {
            return getPaddingTop() - alignmentOffset;
        }
        if (b == 80) {
            return (((getHeight() - getPaddingBottom()) - childHeight) - lp.bottomMargin) - alignmentOffset;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int spaceAbove = (((height - paddingTop) - paddingBottom) - childHeight) / 2;
        if (spaceAbove < lp.topMargin) {
            spaceAbove = lp.topMargin;
        } else {
            int spaceBelow = (((height - paddingBottom) - childHeight) - spaceAbove) - paddingTop;
            int i = lp.bottomMargin;
            if (spaceBelow < i) {
                spaceAbove = Math.max(0, spaceAbove - (i - spaceBelow));
            }
        }
        return paddingTop + spaceAbove;
    }

    /* renamed from: b */
    private int m5137b(int gravity) {
        int vgrav = gravity & 112;
        if (vgrav == 16 || vgrav == 48 || vgrav == 80) {
            return vgrav;
        }
        return this.f3411w & 112;
    }

    /* renamed from: a */
    private void m5136a(List<View> views, int gravity) {
        boolean z = true;
        if (C0646w.m2974h(this) != 1) {
            z = false;
        }
        boolean isRtl = z;
        int childCount = getChildCount();
        int absGrav = C0623f.m2881a(gravity, C0646w.m2974h(this));
        views.clear();
        if (isRtl) {
            for (int i = childCount - 1; i >= 0; i--) {
                View child = getChildAt(i);
                C1019b lp = (C1019b) child.getLayoutParams();
                if (lp.f3420b == 0 && m5141d(child) && m5128a(lp.f2312a) == absGrav) {
                    views.add(child);
                }
            }
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View child2 = getChildAt(i2);
            C1019b lp2 = (C1019b) child2.getLayoutParams();
            if (lp2.f3420b == 0 && m5141d(child2) && m5128a(lp2.f2312a) == absGrav) {
                views.add(child2);
            }
        }
    }

    /* renamed from: a */
    private int m5128a(int gravity) {
        int ld = C0646w.m2974h(this);
        int hGrav = C0623f.m2881a(gravity, ld) & 7;
        if (hGrav != 1) {
            int i = 3;
            if (!(hGrav == 3 || hGrav == 5)) {
                if (ld == 1) {
                    i = 5;
                }
                return i;
            }
        }
        return hGrav;
    }

    /* renamed from: d */
    private boolean m5141d(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* renamed from: a */
    private int m5129a(View v) {
        MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
        return C0627h.m2888b(mlp) + C0627h.m2887a(mlp);
    }

    /* renamed from: b */
    private int m5138b(View v) {
        MarginLayoutParams mlp = (MarginLayoutParams) v.getLayoutParams();
        return mlp.topMargin + mlp.bottomMargin;
    }

    public C1019b generateLayoutParams(AttributeSet attrs) {
        return new C1019b(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public C1019b generateLayoutParams(LayoutParams p) {
        if (p instanceof C1019b) {
            return new C1019b((C1019b) p);
        }
        if (p instanceof C0761a) {
            return new C1019b((C0761a) p);
        }
        if (p instanceof MarginLayoutParams) {
            return new C1019b((MarginLayoutParams) p);
        }
        return new C1019b(p);
    }

    /* access modifiers changed from: protected */
    public C1019b generateDefaultLayoutParams() {
        return new C1019b(-2, -2);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(LayoutParams p) {
        return super.checkLayoutParams(p) && (p instanceof C1019b);
    }

    public C1021U getWrapper() {
        if (this.f3382I == null) {
            this.f3382I = new C1140zb(this, true);
        }
        return this.f3382I;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo8280j() {
        for (int i = getChildCount() - 1; i >= 0; i--) {
            View child = getChildAt(i);
            if (!(((C1019b) child.getLayoutParams()).f3420b == 2 || child == this.f3389a)) {
                removeViewAt(i);
                this.f3378E.add(child);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8236a() {
        for (int i = this.f3378E.size() - 1; i >= 0; i--) {
            addView((View) this.f3378E.get(i));
        }
        this.f3378E.clear();
    }

    /* renamed from: c */
    private boolean m5140c(View child) {
        return child.getParent() == this || this.f3378E.contains(child);
    }

    public void setCollapsible(boolean collapsible) {
        this.f3387N = collapsible;
        requestLayout();
    }

    /* renamed from: a */
    public void mo8240a(C0891a pcb, C0874a mcb) {
        this.f3385L = pcb;
        this.f3386M = mcb;
        ActionMenuView actionMenuView = this.f3389a;
        if (actionMenuView != null) {
            actionMenuView.mo7081a(pcb, mcb);
        }
    }

    /* renamed from: l */
    private void m5142l() {
        if (this.f3408t == null) {
            this.f3408t = new C0966Pa();
        }
    }

    /* access modifiers changed from: 0000 */
    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.f3383J;
    }

    /* access modifiers changed from: 0000 */
    public Context getPopupContext() {
        return this.f3398j;
    }
}
