package android.support.p001v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.view.C0620e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p056b.p057a.C1224b;

/* renamed from: android.support.v7.view.menu.a */
/* compiled from: ActionMenuItem */
public class C0860a implements C1224b {

    /* renamed from: a */
    private final int f2619a;

    /* renamed from: b */
    private final int f2620b;

    /* renamed from: c */
    private final int f2621c;

    /* renamed from: d */
    private final int f2622d;

    /* renamed from: e */
    private CharSequence f2623e;

    /* renamed from: f */
    private CharSequence f2624f;

    /* renamed from: g */
    private Intent f2625g;

    /* renamed from: h */
    private char f2626h;

    /* renamed from: i */
    private int f2627i = Opcodes.ACC_SYNTHETIC;

    /* renamed from: j */
    private char f2628j;

    /* renamed from: k */
    private int f2629k = Opcodes.ACC_SYNTHETIC;

    /* renamed from: l */
    private Drawable f2630l;

    /* renamed from: m */
    private int f2631m = 0;

    /* renamed from: n */
    private Context f2632n;

    /* renamed from: o */
    private OnMenuItemClickListener f2633o;

    /* renamed from: p */
    private CharSequence f2634p;

    /* renamed from: q */
    private CharSequence f2635q;

    /* renamed from: r */
    private ColorStateList f2636r = null;

    /* renamed from: s */
    private Mode f2637s = null;

    /* renamed from: t */
    private boolean f2638t = false;

    /* renamed from: u */
    private boolean f2639u = false;

    /* renamed from: v */
    private int f2640v = 16;

    public C0860a(Context context, int group, int id, int categoryOrder, int ordering, CharSequence title) {
        this.f2632n = context;
        this.f2619a = id;
        this.f2620b = group;
        this.f2621c = categoryOrder;
        this.f2622d = ordering;
        this.f2623e = title;
    }

    public char getAlphabeticShortcut() {
        return this.f2628j;
    }

    public int getAlphabeticModifiers() {
        return this.f2629k;
    }

    public int getGroupId() {
        return this.f2620b;
    }

    public Drawable getIcon() {
        return this.f2630l;
    }

    public Intent getIntent() {
        return this.f2625g;
    }

    public int getItemId() {
        return this.f2619a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f2626h;
    }

    public int getNumericModifiers() {
        return this.f2627i;
    }

    public int getOrder() {
        return this.f2622d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f2623e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f2624f;
        return charSequence != null ? charSequence : this.f2623e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f2640v & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f2640v & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f2640v & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f2640v & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        this.f2628j = Character.toLowerCase(alphaChar);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        this.f2628j = Character.toLowerCase(alphaChar);
        this.f2629k = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    public MenuItem setCheckable(boolean checkable) {
        this.f2640v = (this.f2640v & true) | checkable ? 1 : 0;
        return this;
    }

    public MenuItem setChecked(boolean checked) {
        this.f2640v = (this.f2640v & -3) | (checked ? 2 : 0);
        return this;
    }

    public MenuItem setEnabled(boolean enabled) {
        this.f2640v = (this.f2640v & -17) | (enabled ? 16 : 0);
        return this;
    }

    public MenuItem setIcon(Drawable icon) {
        this.f2630l = icon;
        this.f2631m = 0;
        m4057b();
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        this.f2631m = iconRes;
        this.f2630l = C0510b.m2572c(this.f2632n, iconRes);
        m4057b();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f2625g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        this.f2626h = numericChar;
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        this.f2626h = numericChar;
        this.f2627i = KeyEvent.normalizeMetaState(numericModifiers);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        this.f2633o = menuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        this.f2626h = numericChar;
        this.f2628j = Character.toLowerCase(alphaChar);
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        this.f2626h = numericChar;
        this.f2627i = KeyEvent.normalizeMetaState(numericModifiers);
        this.f2628j = Character.toLowerCase(alphaChar);
        this.f2629k = KeyEvent.normalizeMetaState(alphaModifiers);
        return this;
    }

    public MenuItem setTitle(CharSequence title) {
        this.f2623e = title;
        return this;
    }

    public MenuItem setTitle(int title) {
        this.f2623e = this.f2632n.getResources().getString(title);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        this.f2624f = title;
        return this;
    }

    public MenuItem setVisible(boolean visible) {
        int i = 8;
        int i2 = this.f2640v & 8;
        if (visible) {
            i = 0;
        }
        this.f2640v = i2 | i;
        return this;
    }

    public void setShowAsAction(int show) {
    }

    public C1224b setActionView(View actionView) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C1224b setActionView(int resId) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public C0620e mo6601a() {
        return null;
    }

    /* renamed from: a */
    public C1224b mo6602a(C0620e actionProvider) {
        throw new UnsupportedOperationException();
    }

    public C1224b setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        throw new UnsupportedOperationException();
    }

    public C1224b setContentDescription(CharSequence contentDescription) {
        this.f2634p = contentDescription;
        return this;
    }

    public CharSequence getContentDescription() {
        return this.f2634p;
    }

    public C1224b setTooltipText(CharSequence tooltipText) {
        this.f2635q = tooltipText;
        return this;
    }

    public CharSequence getTooltipText() {
        return this.f2635q;
    }

    public MenuItem setIconTintList(ColorStateList iconTintList) {
        this.f2636r = iconTintList;
        this.f2638t = true;
        m4057b();
        return this;
    }

    public ColorStateList getIconTintList() {
        return this.f2636r;
    }

    public MenuItem setIconTintMode(Mode iconTintMode) {
        this.f2637s = iconTintMode;
        this.f2639u = true;
        m4057b();
        return this;
    }

    public Mode getIconTintMode() {
        return this.f2637s;
    }

    /* renamed from: b */
    private void m4057b() {
        if (this.f2630l == null) {
            return;
        }
        if (this.f2638t || this.f2639u) {
            this.f2630l = C1200a.m5741i(this.f2630l);
            this.f2630l = this.f2630l.mutate();
            if (this.f2638t) {
                C1200a.m5726a(this.f2630l, this.f2636r);
            }
            if (this.f2639u) {
                C1200a.m5729a(this.f2630l, this.f2637s);
            }
        }
    }
}
