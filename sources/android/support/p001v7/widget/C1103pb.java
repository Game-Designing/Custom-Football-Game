package android.support.p001v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.widget.pb */
/* compiled from: TintContextWrapper */
public class C1103pb extends ContextWrapper {

    /* renamed from: a */
    private static final Object f3678a = new Object();

    /* renamed from: b */
    private static ArrayList<WeakReference<C1103pb>> f3679b;

    /* renamed from: c */
    private final Resources f3680c;

    /* renamed from: d */
    private final Theme f3681d;

    /* renamed from: a */
    public static Context m5450a(Context context) {
        if (!m5451b(context)) {
            return context;
        }
        synchronized (f3678a) {
            if (f3679b == null) {
                f3679b = new ArrayList<>();
            } else {
                for (int i = f3679b.size() - 1; i >= 0; i--) {
                    WeakReference<TintContextWrapper> ref = (WeakReference) f3679b.get(i);
                    if (ref == null || ref.get() == null) {
                        f3679b.remove(i);
                    }
                }
                for (int i2 = f3679b.size() - 1; i2 >= 0; i2--) {
                    WeakReference<TintContextWrapper> ref2 = (WeakReference) f3679b.get(i2);
                    C1103pb wrapper = ref2 != null ? (C1103pb) ref2.get() : null;
                    if (wrapper != null && wrapper.getBaseContext() == context) {
                        return wrapper;
                    }
                }
            }
            C1103pb wrapper2 = new C1103pb(context);
            f3679b.add(new WeakReference(wrapper2));
            return wrapper2;
        }
    }

    /* renamed from: b */
    private static boolean m5451b(Context context) {
        boolean z = false;
        if ((context instanceof C1103pb) || (context.getResources() instanceof C1109rb) || (context.getResources() instanceof C0930Fb)) {
            return false;
        }
        if (VERSION.SDK_INT < 21 || C0930Fb.m4471a()) {
            z = true;
        }
        return z;
    }

    private C1103pb(Context base) {
        super(base);
        if (C0930Fb.m4471a()) {
            this.f3680c = new C0930Fb(this, base.getResources());
            this.f3681d = this.f3680c.newTheme();
            this.f3681d.setTo(base.getTheme());
            return;
        }
        this.f3680c = new C1109rb(this, base.getResources());
        this.f3681d = null;
    }

    public Theme getTheme() {
        Theme theme = this.f3681d;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int resid) {
        Theme theme = this.f3681d;
        if (theme == null) {
            super.setTheme(resid);
        } else {
            theme.applyStyle(resid, true);
        }
    }

    public Resources getResources() {
        return this.f3680c;
    }

    public AssetManager getAssets() {
        return this.f3680c.getAssets();
    }
}
