package android.support.p001v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.p000v4.view.C0620e;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import p002b.p003c.p053g.p056b.p057a.C1224b;
import p002b.p003c.p062h.p071g.C1302c;

/* renamed from: android.support.v7.view.menu.q */
/* compiled from: MenuItemWrapperICS */
public class C0880q extends C0862c<C1224b> implements MenuItem {

    /* renamed from: e */
    private Method f2775e;

    /* renamed from: android.support.v7.view.menu.q$a */
    /* compiled from: MenuItemWrapperICS */
    class C0881a extends C0620e {

        /* renamed from: d */
        final ActionProvider f2776d;

        public C0881a(Context context, ActionProvider inner) {
            super(context);
            this.f2776d = inner;
        }

        /* renamed from: c */
        public View mo5651c() {
            return this.f2776d.onCreateActionView();
        }

        /* renamed from: d */
        public boolean mo5652d() {
            return this.f2776d.onPerformDefaultAction();
        }

        /* renamed from: a */
        public boolean mo5649a() {
            return this.f2776d.hasSubMenu();
        }

        /* renamed from: a */
        public void mo5648a(SubMenu subMenu) {
            this.f2776d.onPrepareSubMenu(C0880q.this.mo6667a(subMenu));
        }
    }

    /* renamed from: android.support.v7.view.menu.q$b */
    /* compiled from: MenuItemWrapperICS */
    static class C0882b extends FrameLayout implements C1302c {

        /* renamed from: a */
        final CollapsibleActionView f2778a;

        C0882b(View actionView) {
            super(actionView.getContext());
            this.f2778a = (CollapsibleActionView) actionView;
            addView(actionView);
        }

        public void onActionViewExpanded() {
            this.f2778a.onActionViewExpanded();
        }

        public void onActionViewCollapsed() {
            this.f2778a.onActionViewCollapsed();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public View mo6879a() {
            return (View) this.f2778a;
        }
    }

    /* renamed from: android.support.v7.view.menu.q$c */
    /* compiled from: MenuItemWrapperICS */
    private class C0883c extends C0863d<OnActionExpandListener> implements OnActionExpandListener {
        C0883c(OnActionExpandListener object) {
            super(object);
        }

        public boolean onMenuItemActionExpand(MenuItem item) {
            return ((OnActionExpandListener) this.f2654a).onMenuItemActionExpand(C0880q.this.mo6666a(item));
        }

        public boolean onMenuItemActionCollapse(MenuItem item) {
            return ((OnActionExpandListener) this.f2654a).onMenuItemActionCollapse(C0880q.this.mo6666a(item));
        }
    }

    /* renamed from: android.support.v7.view.menu.q$d */
    /* compiled from: MenuItemWrapperICS */
    private class C0884d extends C0863d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        C0884d(OnMenuItemClickListener object) {
            super(object);
        }

        public boolean onMenuItemClick(MenuItem item) {
            return ((OnMenuItemClickListener) this.f2654a).onMenuItemClick(C0880q.this.mo6666a(item));
        }
    }

    C0880q(Context context, C1224b object) {
        super(context, object);
    }

    public int getItemId() {
        return ((C1224b) this.f2654a).getItemId();
    }

    public int getGroupId() {
        return ((C1224b) this.f2654a).getGroupId();
    }

    public int getOrder() {
        return ((C1224b) this.f2654a).getOrder();
    }

    public MenuItem setTitle(CharSequence title) {
        ((C1224b) this.f2654a).setTitle(title);
        return this;
    }

    public MenuItem setTitle(int title) {
        ((C1224b) this.f2654a).setTitle(title);
        return this;
    }

    public CharSequence getTitle() {
        return ((C1224b) this.f2654a).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        ((C1224b) this.f2654a).setTitleCondensed(title);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C1224b) this.f2654a).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable icon) {
        ((C1224b) this.f2654a).setIcon(icon);
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        ((C1224b) this.f2654a).setIcon(iconRes);
        return this;
    }

    public Drawable getIcon() {
        return ((C1224b) this.f2654a).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C1224b) this.f2654a).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C1224b) this.f2654a).getIntent();
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        ((C1224b) this.f2654a).setShortcut(numericChar, alphaChar);
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar, int numericModifiers, int alphaModifiers) {
        ((C1224b) this.f2654a).setShortcut(numericChar, alphaChar, numericModifiers, alphaModifiers);
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        ((C1224b) this.f2654a).setNumericShortcut(numericChar);
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar, int numericModifiers) {
        ((C1224b) this.f2654a).setNumericShortcut(numericChar, numericModifiers);
        return this;
    }

    public char getNumericShortcut() {
        return ((C1224b) this.f2654a).getNumericShortcut();
    }

    public int getNumericModifiers() {
        return ((C1224b) this.f2654a).getNumericModifiers();
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        ((C1224b) this.f2654a).setAlphabeticShortcut(alphaChar);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar, int alphaModifiers) {
        ((C1224b) this.f2654a).setAlphabeticShortcut(alphaChar, alphaModifiers);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C1224b) this.f2654a).getAlphabeticShortcut();
    }

    public int getAlphabeticModifiers() {
        return ((C1224b) this.f2654a).getAlphabeticModifiers();
    }

    public MenuItem setCheckable(boolean checkable) {
        ((C1224b) this.f2654a).setCheckable(checkable);
        return this;
    }

    public boolean isCheckable() {
        return ((C1224b) this.f2654a).isCheckable();
    }

    public MenuItem setChecked(boolean checked) {
        ((C1224b) this.f2654a).setChecked(checked);
        return this;
    }

    public boolean isChecked() {
        return ((C1224b) this.f2654a).isChecked();
    }

    public MenuItem setVisible(boolean visible) {
        return ((C1224b) this.f2654a).setVisible(visible);
    }

    public boolean isVisible() {
        return ((C1224b) this.f2654a).isVisible();
    }

    public MenuItem setEnabled(boolean enabled) {
        ((C1224b) this.f2654a).setEnabled(enabled);
        return this;
    }

    public boolean isEnabled() {
        return ((C1224b) this.f2654a).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C1224b) this.f2654a).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return mo6667a(((C1224b) this.f2654a).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        ((C1224b) this.f2654a).setOnMenuItemClickListener(menuItemClickListener != null ? new C0884d(menuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C1224b) this.f2654a).getMenuInfo();
    }

    public void setShowAsAction(int actionEnum) {
        ((C1224b) this.f2654a).setShowAsAction(actionEnum);
    }

    public MenuItem setShowAsActionFlags(int actionEnum) {
        ((C1224b) this.f2654a).setShowAsActionFlags(actionEnum);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0882b(view);
        }
        ((C1224b) this.f2654a).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int resId) {
        ((C1224b) this.f2654a).setActionView(resId);
        View actionView = ((C1224b) this.f2654a).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C1224b) this.f2654a).setActionView((View) new C0882b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C1224b) this.f2654a).getActionView();
        if (actionView instanceof C0882b) {
            return ((C0882b) actionView).mo6879a();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider provider) {
        ((C1224b) this.f2654a).mo6602a(provider != null ? mo6823a(provider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0620e provider = ((C1224b) this.f2654a).mo6601a();
        if (provider instanceof C0881a) {
            return ((C0881a) provider).f2776d;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C1224b) this.f2654a).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C1224b) this.f2654a).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C1224b) this.f2654a).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        ((C1224b) this.f2654a).setOnActionExpandListener(listener != null ? new C0883c(listener) : null);
        return this;
    }

    public MenuItem setContentDescription(CharSequence contentDescription) {
        ((C1224b) this.f2654a).setContentDescription(contentDescription);
        return this;
    }

    public CharSequence getContentDescription() {
        return ((C1224b) this.f2654a).getContentDescription();
    }

    public MenuItem setTooltipText(CharSequence tooltipText) {
        ((C1224b) this.f2654a).setTooltipText(tooltipText);
        return this;
    }

    public CharSequence getTooltipText() {
        return ((C1224b) this.f2654a).getTooltipText();
    }

    public MenuItem setIconTintList(ColorStateList tint) {
        ((C1224b) this.f2654a).setIconTintList(tint);
        return this;
    }

    public ColorStateList getIconTintList() {
        return ((C1224b) this.f2654a).getIconTintList();
    }

    public MenuItem setIconTintMode(Mode tintMode) {
        ((C1224b) this.f2654a).setIconTintMode(tintMode);
        return this;
    }

    public Mode getIconTintMode() {
        return ((C1224b) this.f2654a).getIconTintMode();
    }

    /* renamed from: a */
    public void mo6824a(boolean checkable) {
        try {
            if (this.f2775e == null) {
                this.f2775e = ((C1224b) this.f2654a).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f2775e.invoke(this.f2654a, new Object[]{Boolean.valueOf(checkable)});
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C0881a mo6823a(ActionProvider provider) {
        return new C0881a(this.f2651b, provider);
    }
}
