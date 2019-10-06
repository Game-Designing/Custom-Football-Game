package p002b.p003c.p053g.p056b.p057a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.p000v4.view.C0620e;
import android.view.MenuItem;
import android.view.View;

/* renamed from: b.c.g.b.a.b */
/* compiled from: SupportMenuItem */
public interface C1224b extends MenuItem {
    /* renamed from: a */
    C0620e mo6601a();

    /* renamed from: a */
    C1224b mo6602a(C0620e eVar);

    boolean collapseActionView();

    boolean expandActionView();

    View getActionView();

    int getAlphabeticModifiers();

    CharSequence getContentDescription();

    ColorStateList getIconTintList();

    Mode getIconTintMode();

    int getNumericModifiers();

    CharSequence getTooltipText();

    boolean isActionViewExpanded();

    MenuItem setActionView(int i);

    MenuItem setActionView(View view);

    MenuItem setAlphabeticShortcut(char c, int i);

    C1224b setContentDescription(CharSequence charSequence);

    MenuItem setIconTintList(ColorStateList colorStateList);

    MenuItem setIconTintMode(Mode mode);

    MenuItem setNumericShortcut(char c, int i);

    MenuItem setShortcut(char c, char c2, int i, int i2);

    void setShowAsAction(int i);

    MenuItem setShowAsActionFlags(int i);

    C1224b setTooltipText(CharSequence charSequence);
}
