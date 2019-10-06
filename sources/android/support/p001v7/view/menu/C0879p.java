package android.support.p001v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0620e;
import android.support.p000v4.view.C0620e.C0622b;
import android.support.p001v7.view.menu.C0892w.C0893a;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p056b.p057a.C1224b;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.view.menu.p */
/* compiled from: MenuItemImpl */
public final class C0879p implements C1224b {

    /* renamed from: a */
    private static String f2740a;

    /* renamed from: b */
    private static String f2741b;

    /* renamed from: c */
    private static String f2742c;

    /* renamed from: d */
    private static String f2743d;

    /* renamed from: A */
    private boolean f2744A = false;

    /* renamed from: B */
    private boolean f2745B = false;

    /* renamed from: C */
    private int f2746C = 16;

    /* renamed from: D */
    private int f2747D = 0;

    /* renamed from: E */
    private View f2748E;

    /* renamed from: F */
    private C0620e f2749F;

    /* renamed from: G */
    private OnActionExpandListener f2750G;

    /* renamed from: H */
    private boolean f2751H = false;

    /* renamed from: I */
    private ContextMenuInfo f2752I;

    /* renamed from: e */
    private final int f2753e;

    /* renamed from: f */
    private final int f2754f;

    /* renamed from: g */
    private final int f2755g;

    /* renamed from: h */
    private final int f2756h;

    /* renamed from: i */
    private CharSequence f2757i;

    /* renamed from: j */
    private CharSequence f2758j;

    /* renamed from: k */
    private Intent f2759k;

    /* renamed from: l */
    private char f2760l;

    /* renamed from: m */
    private int f2761m = Opcodes.ACC_SYNTHETIC;

    /* renamed from: n */
    private char f2762n;

    /* renamed from: o */
    private int f2763o = Opcodes.ACC_SYNTHETIC;

    /* renamed from: p */
    private Drawable f2764p;

    /* renamed from: q */
    private int f2765q = 0;

    /* renamed from: r */
    C0873l f2766r;

    /* renamed from: s */
    private C0858D f2767s;

    /* renamed from: t */
    private Runnable f2768t;

    /* renamed from: u */
    private OnMenuItemClickListener f2769u;

    /* renamed from: v */
    private CharSequence f2770v;

    /* renamed from: w */
    private CharSequence f2771w;

    /* renamed from: x */
    private ColorStateList f2772x = null;

    /* renamed from: y */
    private Mode f2773y = null;

    /* renamed from: z */
    private boolean f2774z = false;

    C0879p(C0873l menu, int group, int id, int categoryOrder, int ordering, CharSequence title, int showAsAction) {
        this.f2766r = menu;
        this.f2753e = id;
        this.f2754f = group;
        this.f2755g = categoryOrder;
        this.f2756h = ordering;
        this.f2757i = title;
        this.f2747D = showAsAction;
    }

    /* renamed from: g */
    public boolean mo6781g() {
        OnMenuItemClickListener onMenuItemClickListener = this.f2769u;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        C0873l lVar = this.f2766r;
        if (lVar.mo6562a(lVar, (MenuItem) this)) {
            return true;
        }
        Runnable runnable = this.f2768t;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f2759k != null) {
            try {
                this.f2766r.mo6739e().startActivity(this.f2759k);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        C0620e eVar = this.f2749F;
        if (eVar == null || !eVar.mo5652d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f2746C & 16) != 0;
    }

    public MenuItem setEnabled(boolean enabled) {
        if (enabled) {
            this.f2746C |= 16;
        } else {
            this.f2746C &= -17;
        }
        this.f2766r.mo6727b(false);
        return this;
    }

    public int getGroupId() {
        return this.f2754f;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f2753e;
    }

    public int getOrder() {
        return this.f2755g;
    }

    /* renamed from: c */
    public int mo6774c() {
        return this.f2756h;
    }

    public Intent getIntent() {
        return this.f2759k;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2759k = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f2762n;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if (this.f2762n == alphaChar) {
            return this;
        }
        this.f2762n = Character.toLowerCase(alphaChar);
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        if (this.f2762n == alphaChar && this.f2763o == alphaModifiers) {
            return this;
        }
        this.f2762n = Character.toLowerCase(alphaChar);
        this.f2763o = KeyEvent.normalizeMetaState(alphaModifiers);
        this.f2766r.mo6727b(false);
        return this;
    }

    public int getAlphabeticModifiers() {
        return this.f2763o;
    }

    public char getNumericShortcut() {
        return this.f2760l;
    }

    public int getNumericModifiers() {
        return this.f2761m;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        if (this.f2760l == numericChar) {
            return this;
        }
        this.f2760l = numericChar;
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        if (this.f2760l == numericChar && this.f2761m == numericModifiers) {
            return this;
        }
        this.f2760l = numericChar;
        this.f2761m = KeyEvent.normalizeMetaState(numericModifiers);
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.f2760l = numericChar;
        this.f2762n = Character.toLowerCase(alphaChar);
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.f2760l = numericChar;
        this.f2761m = KeyEvent.normalizeMetaState(numericModifiers);
        this.f2762n = Character.toLowerCase(alphaChar);
        this.f2763o = KeyEvent.normalizeMetaState(alphaModifiers);
        this.f2766r.mo6727b(false);
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public char mo6776d() {
        return this.f2766r.mo6568o() ? this.f2762n : this.f2760l;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public String mo6778e() {
        char shortcut = mo6776d();
        if (shortcut == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f2740a);
        if (shortcut == 8) {
            sb.append(f2742c);
        } else if (shortcut == 10) {
            sb.append(f2741b);
        } else if (shortcut != ' ') {
            sb.append(shortcut);
        } else {
            sb.append(f2743d);
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: m */
    public boolean mo6804m() {
        return this.f2766r.mo6569p() && mo6776d() != 0;
    }

    public SubMenu getSubMenu() {
        return this.f2767s;
    }

    public boolean hasSubMenu() {
        return this.f2767s != null;
    }

    /* renamed from: a */
    public void mo6769a(C0858D subMenu) {
        this.f2767s = subMenu;
        subMenu.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f2757i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public CharSequence mo6768a(C0893a itemView) {
        if (itemView == null || !itemView.mo4090h()) {
            return getTitle();
        }
        return getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence title) {
        this.f2757i = title;
        this.f2766r.mo6727b(false);
        C0858D d = this.f2767s;
        if (d != null) {
            d.setHeaderTitle(title);
        }
        return this;
    }

    public MenuItem setTitle(int title) {
        setTitle((CharSequence) this.f2766r.mo6739e().getString(title));
        return this;
    }

    public CharSequence getTitleCondensed() {
        CharSequence ctitle = this.f2758j;
        if (ctitle == null) {
            ctitle = this.f2757i;
        }
        if (VERSION.SDK_INT >= 18 || ctitle == null || (ctitle instanceof String)) {
            return ctitle;
        }
        return ctitle.toString();
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        this.f2758j = title;
        if (title == null) {
            CharSequence title2 = this.f2757i;
        }
        this.f2766r.mo6727b(false);
        return this;
    }

    public Drawable getIcon() {
        Drawable drawable = this.f2764p;
        if (drawable != null) {
            return m4196a(drawable);
        }
        if (this.f2765q == 0) {
            return null;
        }
        Drawable icon = C1282b.m6000b(this.f2766r.mo6739e(), this.f2765q);
        this.f2765q = 0;
        this.f2764p = icon;
        return m4196a(icon);
    }

    public MenuItem setIcon(Drawable icon) {
        this.f2765q = 0;
        this.f2764p = icon;
        this.f2745B = true;
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setIcon(int iconResId) {
        this.f2764p = null;
        this.f2765q = iconResId;
        this.f2745B = true;
        this.f2766r.mo6727b(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.f2772x = iconTintList;
        this.f2774z = true;
        this.f2745B = true;
        this.f2766r.mo6727b(false);
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f2772x;
    }

    public MenuItem setIconTintMode(Mode iconTintMode) {
        this.f2773y = iconTintMode;
        this.f2744A = true;
        this.f2745B = true;
        this.f2766r.mo6727b(false);
        return this;
    }

    public Mode getIconTintMode() {
        return this.f2773y;
    }

    /* renamed from: a */
    private Drawable m4196a(Drawable icon) {
        if (icon != null && this.f2745B && (this.f2774z || this.f2744A)) {
            icon = C1200a.m5741i(icon).mutate();
            if (this.f2774z) {
                C1200a.m5726a(icon, this.f2772x);
            }
            if (this.f2744A) {
                C1200a.m5729a(icon, this.f2773y);
            }
            this.f2745B = false;
        }
        return icon;
    }

    public boolean isCheckable() {
        return (this.f2746C & 1) == 1;
    }

    public MenuItem setCheckable(boolean checkable) {
        int oldFlags = this.f2746C;
        this.f2746C = (this.f2746C & true) | checkable ? 1 : 0;
        if (oldFlags != this.f2746C) {
            this.f2766r.mo6727b(false);
        }
        return this;
    }

    /* renamed from: c */
    public void mo6775c(boolean exclusive) {
        this.f2746C = (this.f2746C & -5) | (exclusive ? 4 : 0);
    }

    /* renamed from: i */
    public boolean mo6796i() {
        return (this.f2746C & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f2746C & 2) == 2;
    }

    public MenuItem setChecked(boolean checked) {
        if ((this.f2746C & 4) != 0) {
            this.f2766r.mo6710a((MenuItem) this);
        } else {
            mo6773b(checked);
        }
        return this;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo6773b(boolean checked) {
        int oldFlags = this.f2746C;
        this.f2746C = (this.f2746C & -3) | (checked ? 2 : 0);
        if (oldFlags != this.f2746C) {
            this.f2766r.mo6727b(false);
        }
    }

    public boolean isVisible() {
        C0620e eVar = this.f2749F;
        boolean z = true;
        if (eVar == null || !eVar.mo5653e()) {
            if ((this.f2746C & 8) != 0) {
                z = false;
            }
            return z;
        }
        if ((this.f2746C & 8) != 0 || !this.f2749F.mo5650b()) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo6779e(boolean shown) {
        int oldFlags = this.f2746C;
        this.f2746C = (this.f2746C & -9) | (shown ? 0 : 8);
        if (oldFlags != this.f2746C) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean shown) {
        if (mo6779e(shown)) {
            this.f2766r.mo6738d(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener clickListener) {
        this.f2769u = clickListener;
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f2757i;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo6770a(ContextMenuInfo menuInfo) {
        this.f2752I = menuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f2752I;
    }

    /* renamed from: b */
    public void mo6772b() {
        this.f2766r.mo6731c(this);
    }

    /* renamed from: l */
    public boolean mo6803l() {
        return this.f2766r.mo6750k();
    }

    /* renamed from: h */
    public boolean mo6794h() {
        return (this.f2746C & 32) == 32;
    }

    /* renamed from: j */
    public boolean mo6801j() {
        return (this.f2747D & 1) == 1;
    }

    /* renamed from: k */
    public boolean mo6802k() {
        return (this.f2747D & 2) == 2;
    }

    /* renamed from: d */
    public void mo6777d(boolean isActionButton) {
        if (isActionButton) {
            this.f2746C |= 32;
        } else {
            this.f2746C &= -33;
        }
    }

    /* renamed from: n */
    public boolean mo6805n() {
        return (this.f2747D & 4) == 4;
    }

    public void setShowAsAction(int actionEnum) {
        int i = actionEnum & 3;
        if (i == 0 || i == 1 || i == 2) {
            this.f2747D = actionEnum;
            this.f2766r.mo6731c(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public C1224b setActionView(View view) {
        this.f2748E = view;
        this.f2749F = null;
        if (view != null && view.getId() == -1) {
            int i = this.f2753e;
            if (i > 0) {
                view.setId(i);
            }
        }
        this.f2766r.mo6731c(this);
        return this;
    }

    public C1224b setActionView(int resId) {
        Context context = this.f2766r.mo6739e();
        setActionView(LayoutInflater.from(context).inflate(resId, new LinearLayout(context), false));
        return this;
    }

    public View getActionView() {
        View view = this.f2748E;
        if (view != null) {
            return view;
        }
        C0620e eVar = this.f2749F;
        if (eVar == null) {
            return null;
        }
        this.f2748E = eVar.mo5645a((MenuItem) this);
        return this.f2748E;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    /* renamed from: a */
    public C0620e mo6601a() {
        return this.f2749F;
    }

    /* renamed from: a */
    public C1224b mo6602a(C0620e actionProvider) {
        C0620e eVar = this.f2749F;
        if (eVar != null) {
            eVar.mo5654f();
        }
        this.f2748E = null;
        this.f2749F = actionProvider;
        this.f2766r.mo6727b(true);
        C0620e eVar2 = this.f2749F;
        if (eVar2 != null) {
            eVar2.mo5647a((C0622b) new C0878o(this));
        }
        return this;
    }

    public C1224b setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    public boolean expandActionView() {
        if (!mo6780f()) {
            return false;
        }
        OnActionExpandListener onActionExpandListener = this.f2750G;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f2766r.mo6564b(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f2747D & 8) == 0) {
            return false;
        }
        if (this.f2748E == null) {
            return true;
        }
        OnActionExpandListener onActionExpandListener = this.f2750G;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f2766r.mo6563a(this);
        }
        return false;
    }

    /* renamed from: f */
    public boolean mo6780f() {
        boolean z = false;
        if ((this.f2747D & 8) == 0) {
            return false;
        }
        if (this.f2748E == null) {
            C0620e eVar = this.f2749F;
            if (eVar != null) {
                this.f2748E = eVar.mo5645a((MenuItem) this);
            }
        }
        if (this.f2748E != null) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public void mo6771a(boolean isExpanded) {
        this.f2751H = isExpanded;
        this.f2766r.mo6727b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f2751H;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        this.f2750G = listener;
        return this;
    }

    public C1224b setContentDescription(CharSequence contentDescription) {
        this.f2770v = contentDescription;
        this.f2766r.mo6727b(false);
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f2770v;
    }

    public C1224b setTooltipText(CharSequence tooltipText) {
        this.f2771w = tooltipText;
        this.f2766r.mo6727b(false);
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f2771w;
    }
}
