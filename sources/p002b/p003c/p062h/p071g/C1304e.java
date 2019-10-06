package p002b.p003c.p062h.p071g;

import android.content.Context;
import android.support.p001v7.view.menu.C0873l;
import android.support.p001v7.view.menu.C0873l.C0874a;
import android.support.p001v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: b.c.h.g.e */
/* compiled from: StandaloneActionMode */
public class C1304e extends C1300b implements C0874a {

    /* renamed from: c */
    private Context f4131c;

    /* renamed from: d */
    private ActionBarContextView f4132d;

    /* renamed from: e */
    private C1301a f4133e;

    /* renamed from: f */
    private WeakReference<View> f4134f;

    /* renamed from: g */
    private boolean f4135g;

    /* renamed from: h */
    private boolean f4136h;

    /* renamed from: i */
    private C0873l f4137i;

    public C1304e(Context context, ActionBarContextView view, C1301a callback, boolean isFocusable) {
        this.f4131c = context;
        this.f4132d = view;
        this.f4133e = callback;
        C0873l lVar = new C0873l(view.getContext());
        lVar.mo6728c(1);
        this.f4137i = lVar;
        this.f4137i.mo6561a((C0874a) this);
        this.f4136h = isFocusable;
    }

    /* renamed from: b */
    public void mo6192b(CharSequence title) {
        this.f4132d.setTitle(title);
    }

    /* renamed from: a */
    public void mo6188a(CharSequence subtitle) {
        this.f4132d.setSubtitle(subtitle);
    }

    /* renamed from: b */
    public void mo6191b(int resId) {
        mo6192b((CharSequence) this.f4131c.getString(resId));
    }

    /* renamed from: a */
    public void mo6186a(int resId) {
        mo6188a((CharSequence) this.f4131c.getString(resId));
    }

    /* renamed from: a */
    public void mo6189a(boolean titleOptional) {
        super.mo6189a(titleOptional);
        this.f4132d.setTitleOptional(titleOptional);
    }

    /* renamed from: j */
    public boolean mo6198j() {
        return this.f4132d.mo7001b();
    }

    /* renamed from: a */
    public void mo6187a(View view) {
        this.f4132d.setCustomView(view);
        this.f4134f = view != null ? new WeakReference<>(view) : null;
    }

    /* renamed from: i */
    public void mo6197i() {
        this.f4133e.mo6122b(this, this.f4137i);
    }

    /* renamed from: a */
    public void mo6185a() {
        if (!this.f4135g) {
            this.f4135g = true;
            this.f4132d.sendAccessibilityEvent(32);
            this.f4133e.mo6119a(this);
        }
    }

    /* renamed from: c */
    public Menu mo6193c() {
        return this.f4137i;
    }

    /* renamed from: g */
    public CharSequence mo6196g() {
        return this.f4132d.getTitle();
    }

    /* renamed from: e */
    public CharSequence mo6195e() {
        return this.f4132d.getSubtitle();
    }

    /* renamed from: b */
    public View mo6190b() {
        WeakReference<View> weakReference = this.f4134f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* renamed from: d */
    public MenuInflater mo6194d() {
        return new C1307g(this.f4132d.getContext());
    }

    /* renamed from: a */
    public boolean mo4699a(C0873l menu, MenuItem item) {
        return this.f4133e.mo6121a((C1300b) this, item);
    }

    /* renamed from: a */
    public void mo4698a(C0873l menu) {
        mo6197i();
        this.f4132d.mo7003d();
    }
}
