package android.support.p001v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p001v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import p002b.p003c.p062h.p071g.C1300b;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: android.support.v7.app.p */
/* compiled from: AppCompatDelegate */
public abstract class C0776p {

    /* renamed from: a */
    private static int f2341a = -1;

    /* renamed from: b */
    private static boolean f2342b = false;

    /* renamed from: a */
    public abstract <T extends View> T mo6077a(int i);

    /* renamed from: a */
    public abstract C1300b mo6079a(C1301a aVar);

    /* renamed from: a */
    public abstract void mo6081a(Configuration configuration);

    /* renamed from: a */
    public abstract void mo6082a(Bundle bundle);

    /* renamed from: a */
    public abstract void mo6084a(Toolbar toolbar);

    /* renamed from: a */
    public abstract void mo6085a(View view);

    /* renamed from: a */
    public abstract void mo6086a(View view, LayoutParams layoutParams);

    /* renamed from: a */
    public abstract void mo6242a(CharSequence charSequence);

    /* renamed from: a */
    public abstract boolean mo6243a();

    /* renamed from: b */
    public abstract void mo6094b(Bundle bundle);

    /* renamed from: b */
    public abstract void mo6096b(View view, LayoutParams layoutParams);

    /* renamed from: b */
    public abstract boolean mo6098b(int i);

    /* renamed from: c */
    public abstract C0764b mo6244c();

    /* renamed from: c */
    public abstract void mo6100c(int i);

    /* renamed from: c */
    public abstract void mo6245c(Bundle bundle);

    /* renamed from: d */
    public abstract MenuInflater mo6246d();

    /* renamed from: e */
    public abstract C0760a mo6247e();

    /* renamed from: f */
    public abstract void mo6105f();

    /* renamed from: g */
    public abstract void mo6106g();

    /* renamed from: i */
    public abstract void mo6107i();

    /* renamed from: j */
    public abstract void mo6108j();

    /* renamed from: k */
    public abstract void mo6248k();

    /* renamed from: l */
    public abstract void mo6109l();

    /* renamed from: a */
    public static C0776p m3634a(Activity activity, C0020o callback) {
        return m3636a(activity, activity.getWindow(), callback);
    }

    /* renamed from: a */
    public static C0776p m3635a(Dialog dialog, C0020o callback) {
        return m3636a(dialog.getContext(), dialog.getWindow(), callback);
    }

    /* renamed from: a */
    private static C0776p m3636a(Context context, Window window, C0020o callback) {
        int i = VERSION.SDK_INT;
        if (i >= 24) {
            return new C0781s(context, window, callback);
        }
        if (i >= 23) {
            return new C0787v(context, window, callback);
        }
        return new C0783t(context, window, callback);
    }

    C0776p() {
    }

    /* renamed from: b */
    public static int m3637b() {
        return f2341a;
    }

    /* renamed from: h */
    public static boolean m3638h() {
        return f2342b;
    }
}
