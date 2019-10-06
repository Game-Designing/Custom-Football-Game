package p002b.p003c.p062h.p071g;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.p001v7.appcompat.C0793R;
import android.view.ViewConfiguration;

/* renamed from: b.c.h.g.a */
/* compiled from: ActionBarPolicy */
public class C1299a {

    /* renamed from: a */
    private Context f4123a;

    /* renamed from: a */
    public static C1299a m6042a(Context context) {
        return new C1299a(context);
    }

    private C1299a(Context context) {
        this.f4123a = context;
    }

    /* renamed from: c */
    public int mo9223c() {
        Configuration configuration = this.f4123a.getResources().getConfiguration();
        int widthDp = configuration.screenWidthDp;
        int heightDp = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || widthDp > 600 || ((widthDp > 960 && heightDp > 720) || (widthDp > 720 && heightDp > 960))) {
            return 5;
        }
        if (widthDp >= 500 || ((widthDp > 640 && heightDp > 480) || (widthDp > 480 && heightDp > 640))) {
            return 4;
        }
        if (widthDp >= 360) {
            return 3;
        }
        return 2;
    }

    /* renamed from: g */
    public boolean mo9227g() {
        if (VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f4123a).hasPermanentMenuKey();
    }

    /* renamed from: b */
    public int mo9222b() {
        return this.f4123a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* renamed from: f */
    public boolean mo9226f() {
        return this.f4123a.getResources().getBoolean(C0793R.bool.abc_action_bar_embed_tabs);
    }

    /* renamed from: e */
    public int mo9225e() {
        TypedArray a = this.f4123a.obtainStyledAttributes(null, C0793R.styleable.ActionBar, C0793R.attr.actionBarStyle, 0);
        int height = a.getLayoutDimension(C0793R.styleable.ActionBar_height, 0);
        Resources r = this.f4123a.getResources();
        if (!mo9226f()) {
            height = Math.min(height, r.getDimensionPixelSize(C0793R.dimen.abc_action_bar_stacked_max_height));
        }
        a.recycle();
        return height;
    }

    /* renamed from: a */
    public boolean mo9221a() {
        return this.f4123a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* renamed from: d */
    public int mo9224d() {
        return this.f4123a.getResources().getDimensionPixelSize(C0793R.dimen.abc_action_bar_stacked_tab_max_width);
    }
}
