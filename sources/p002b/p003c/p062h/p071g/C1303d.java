package p002b.p003c.p062h.p071g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.p001v7.appcompat.C0793R;
import android.view.LayoutInflater;

/* renamed from: b.c.h.g.d */
/* compiled from: ContextThemeWrapper */
public class C1303d extends ContextWrapper {

    /* renamed from: a */
    private int f4126a;

    /* renamed from: b */
    private Theme f4127b;

    /* renamed from: c */
    private LayoutInflater f4128c;

    /* renamed from: d */
    private Configuration f4129d;

    /* renamed from: e */
    private Resources f4130e;

    public C1303d() {
        super(null);
    }

    public C1303d(Context base, int themeResId) {
        super(base);
        this.f4126a = themeResId;
    }

    public C1303d(Context base, Theme theme) {
        super(base);
        this.f4127b = theme;
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    public Resources getResources() {
        return m6071b();
    }

    /* renamed from: b */
    private Resources m6071b() {
        if (this.f4130e == null) {
            Configuration configuration = this.f4129d;
            if (configuration == null) {
                this.f4130e = super.getResources();
            } else if (VERSION.SDK_INT >= 17) {
                this.f4130e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f4130e;
    }

    public void setTheme(int resid) {
        if (this.f4126a != resid) {
            this.f4126a = resid;
            m6072c();
        }
    }

    /* renamed from: a */
    public int mo9231a() {
        return this.f4126a;
    }

    public Theme getTheme() {
        Theme theme = this.f4127b;
        if (theme != null) {
            return theme;
        }
        if (this.f4126a == 0) {
            this.f4126a = C0793R.style.Theme_AppCompat_Light;
        }
        m6072c();
        return this.f4127b;
    }

    public Object getSystemService(String name) {
        if (!"layout_inflater".equals(name)) {
            return getBaseContext().getSystemService(name);
        }
        if (this.f4128c == null) {
            this.f4128c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f4128c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo9232a(Theme theme, int resid, boolean first) {
        theme.applyStyle(resid, true);
    }

    /* renamed from: c */
    private void m6072c() {
        boolean first = this.f4127b == null;
        if (first) {
            this.f4127b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f4127b.setTo(theme);
            }
        }
        mo9232a(this.f4127b, this.f4126a, first);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
