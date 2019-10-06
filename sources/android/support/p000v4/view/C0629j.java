package android.support.p000v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import p002b.p003c.p053g.p056b.p057a.C1224b;

/* renamed from: android.support.v4.view.j */
/* compiled from: MenuItemCompat */
public final class C0629j {

    /* renamed from: a */
    static final C0632c f1852a;

    /* renamed from: android.support.v4.view.j$a */
    /* compiled from: MenuItemCompat */
    static class C0630a extends C0631b {
        C0630a() {
        }

        /* renamed from: a */
        public void mo5662a(MenuItem item, CharSequence contentDescription) {
            item.setContentDescription(contentDescription);
        }

        /* renamed from: b */
        public void mo5664b(MenuItem item, CharSequence tooltipText) {
            item.setTooltipText(tooltipText);
        }

        /* renamed from: a */
        public void mo5659a(MenuItem item, char alphaChar, int alphaModifiers) {
            item.setAlphabeticShortcut(alphaChar, alphaModifiers);
        }

        /* renamed from: b */
        public void mo5663b(MenuItem item, char numericChar, int numericModifiers) {
            item.setNumericShortcut(numericChar, numericModifiers);
        }

        /* renamed from: a */
        public void mo5660a(MenuItem item, ColorStateList tint) {
            item.setIconTintList(tint);
        }

        /* renamed from: a */
        public void mo5661a(MenuItem item, Mode tintMode) {
            item.setIconTintMode(tintMode);
        }
    }

    /* renamed from: android.support.v4.view.j$b */
    /* compiled from: MenuItemCompat */
    static class C0631b implements C0632c {
        C0631b() {
        }

        /* renamed from: a */
        public void mo5662a(MenuItem item, CharSequence contentDescription) {
        }

        /* renamed from: b */
        public void mo5664b(MenuItem item, CharSequence tooltipText) {
        }

        /* renamed from: a */
        public void mo5659a(MenuItem item, char alphaChar, int alphaModifiers) {
        }

        /* renamed from: b */
        public void mo5663b(MenuItem item, char numericChar, int numericModifiers) {
        }

        /* renamed from: a */
        public void mo5660a(MenuItem item, ColorStateList tint) {
        }

        /* renamed from: a */
        public void mo5661a(MenuItem item, Mode tintMode) {
        }
    }

    /* renamed from: android.support.v4.view.j$c */
    /* compiled from: MenuItemCompat */
    interface C0632c {
        /* renamed from: a */
        void mo5659a(MenuItem menuItem, char c, int i);

        /* renamed from: a */
        void mo5660a(MenuItem menuItem, ColorStateList colorStateList);

        /* renamed from: a */
        void mo5661a(MenuItem menuItem, Mode mode);

        /* renamed from: a */
        void mo5662a(MenuItem menuItem, CharSequence charSequence);

        /* renamed from: b */
        void mo5663b(MenuItem menuItem, char c, int i);

        /* renamed from: b */
        void mo5664b(MenuItem menuItem, CharSequence charSequence);
    }

    @Deprecated
    /* renamed from: android.support.v4.view.j$d */
    /* compiled from: MenuItemCompat */
    public interface C0633d {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f1852a = new C0630a();
        } else {
            f1852a = new C0631b();
        }
    }

    /* renamed from: a */
    public static MenuItem m2889a(MenuItem item, C0620e provider) {
        if (item instanceof C1224b) {
            return ((C1224b) item).mo6602a(provider);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return item;
    }

    @Deprecated
    /* renamed from: a */
    public static MenuItem m2890a(MenuItem item, C0633d listener) {
        return item.setOnActionExpandListener(new C0628i(listener));
    }

    /* renamed from: a */
    public static void m2894a(MenuItem item, CharSequence contentDescription) {
        if (item instanceof C1224b) {
            ((C1224b) item).setContentDescription(contentDescription);
        } else {
            f1852a.mo5662a(item, contentDescription);
        }
    }

    /* renamed from: b */
    public static void m2896b(MenuItem item, CharSequence tooltipText) {
        if (item instanceof C1224b) {
            ((C1224b) item).setTooltipText(tooltipText);
        } else {
            f1852a.mo5664b(item, tooltipText);
        }
    }

    /* renamed from: b */
    public static void m2895b(MenuItem item, char numericChar, int numericModifiers) {
        if (item instanceof C1224b) {
            ((C1224b) item).setNumericShortcut(numericChar, numericModifiers);
        } else {
            f1852a.mo5663b(item, numericChar, numericModifiers);
        }
    }

    /* renamed from: a */
    public static void m2891a(MenuItem item, char alphaChar, int alphaModifiers) {
        if (item instanceof C1224b) {
            ((C1224b) item).setAlphabeticShortcut(alphaChar, alphaModifiers);
        } else {
            f1852a.mo5659a(item, alphaChar, alphaModifiers);
        }
    }

    /* renamed from: a */
    public static void m2892a(MenuItem item, ColorStateList tint) {
        if (item instanceof C1224b) {
            ((C1224b) item).setIconTintList(tint);
        } else {
            f1852a.mo5660a(item, tint);
        }
    }

    /* renamed from: a */
    public static void m2893a(MenuItem item, Mode tintMode) {
        if (item instanceof C1224b) {
            ((C1224b) item).setIconTintMode(tintMode);
        } else {
            f1852a.mo5661a(item, tintMode);
        }
    }
}
