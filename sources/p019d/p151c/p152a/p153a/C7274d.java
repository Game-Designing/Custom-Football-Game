package p019d.p151c.p152a.p153a;

import android.app.Activity;
import p019d.p151c.p152a.C7282e;

/* renamed from: d.c.a.a.d */
/* compiled from: ExpirationDateDialogTheme */
public enum C7274d {
    LIGHT(C7282e.bt_black_87, C7282e.bt_white_87, C7282e.bt_black_38),
    DARK(C7282e.bt_white_87, C7282e.bt_black_87, C7282e.bt_white_38);
    

    /* renamed from: d */
    private final int f14139d;

    /* renamed from: e */
    private final int f14140e;

    /* renamed from: f */
    private final int f14141f;

    /* renamed from: g */
    private int f14142g;

    /* renamed from: h */
    private int f14143h;

    /* renamed from: i */
    private int f14144i;

    /* renamed from: j */
    private int f14145j;

    private C7274d(int itemTextColor, int itemInverseTextColor, int itemDisabledTextColor) {
        this.f14139d = itemTextColor;
        this.f14140e = itemInverseTextColor;
        this.f14141f = itemDisabledTextColor;
    }

    /* renamed from: a */
    public static C7274d m15835a(Activity activity) {
        C7274d theme;
        if (C7278h.m15847a(activity)) {
            theme = LIGHT;
        } else {
            theme = DARK;
        }
        theme.f14142g = activity.getResources().getColor(theme.f14139d);
        theme.f14143h = C7272b.m15830a(activity, "textColorPrimaryInverse", theme.f14140e);
        theme.f14144i = activity.getResources().getColor(theme.f14141f);
        theme.f14145j = C7272b.m15830a(activity, "colorAccent", C7282e.bt_blue);
        return theme;
    }

    /* renamed from: g */
    public int mo23499g() {
        return this.f14142g;
    }

    /* renamed from: f */
    public int mo23498f() {
        return this.f14143h;
    }

    /* renamed from: e */
    public int mo23497e() {
        return this.f14144i;
    }

    /* renamed from: i */
    public int mo23500i() {
        return this.f14145j;
    }
}
