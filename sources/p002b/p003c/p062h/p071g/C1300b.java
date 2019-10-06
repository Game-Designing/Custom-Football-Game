package p002b.p003c.p062h.p071g;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: b.c.h.g.b */
/* compiled from: ActionMode */
public abstract class C1300b {

    /* renamed from: a */
    private Object f4124a;

    /* renamed from: b */
    private boolean f4125b;

    /* renamed from: b.c.h.g.b$a */
    /* compiled from: ActionMode */
    public interface C1301a {
        /* renamed from: a */
        void mo6119a(C1300b bVar);

        /* renamed from: a */
        boolean mo6120a(C1300b bVar, Menu menu);

        /* renamed from: a */
        boolean mo6121a(C1300b bVar, MenuItem menuItem);

        /* renamed from: b */
        boolean mo6122b(C1300b bVar, Menu menu);
    }

    /* renamed from: a */
    public abstract void mo6185a();

    /* renamed from: a */
    public abstract void mo6186a(int i);

    /* renamed from: a */
    public abstract void mo6187a(View view);

    /* renamed from: a */
    public abstract void mo6188a(CharSequence charSequence);

    /* renamed from: b */
    public abstract View mo6190b();

    /* renamed from: b */
    public abstract void mo6191b(int i);

    /* renamed from: b */
    public abstract void mo6192b(CharSequence charSequence);

    /* renamed from: c */
    public abstract Menu mo6193c();

    /* renamed from: d */
    public abstract MenuInflater mo6194d();

    /* renamed from: e */
    public abstract CharSequence mo6195e();

    /* renamed from: g */
    public abstract CharSequence mo6196g();

    /* renamed from: i */
    public abstract void mo6197i();

    /* renamed from: j */
    public abstract boolean mo6198j();

    /* renamed from: a */
    public void mo9228a(Object tag) {
        this.f4124a = tag;
    }

    /* renamed from: f */
    public Object mo9229f() {
        return this.f4124a;
    }

    /* renamed from: a */
    public void mo6189a(boolean titleOptional) {
        this.f4125b = titleOptional;
    }

    /* renamed from: h */
    public boolean mo9230h() {
        return this.f4125b;
    }
}
