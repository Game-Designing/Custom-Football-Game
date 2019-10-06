package p002b.p003c.p062h.p071g;

import android.content.Context;
import android.support.p001v7.view.menu.C0894x;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import p002b.p003c.p053g.p056b.p057a.C1223a;
import p002b.p003c.p053g.p056b.p057a.C1224b;
import p002b.p003c.p053g.p061f.C1273q;
import p002b.p003c.p062h.p071g.C1300b.C1301a;

/* renamed from: b.c.h.g.f */
/* compiled from: SupportActionModeWrapper */
public class C1305f extends ActionMode {

    /* renamed from: a */
    final Context f4138a;

    /* renamed from: b */
    final C1300b f4139b;

    /* renamed from: b.c.h.g.f$a */
    /* compiled from: SupportActionModeWrapper */
    public static class C1306a implements C1301a {

        /* renamed from: a */
        final Callback f4140a;

        /* renamed from: b */
        final Context f4141b;

        /* renamed from: c */
        final ArrayList<C1305f> f4142c = new ArrayList<>();

        /* renamed from: d */
        final C1273q<Menu, Menu> f4143d = new C1273q<>();

        public C1306a(Context context, Callback supportCallback) {
            this.f4141b = context;
            this.f4140a = supportCallback;
        }

        /* renamed from: a */
        public boolean mo6120a(C1300b mode, Menu menu) {
            return this.f4140a.onCreateActionMode(mo9256b(mode), m6091a(menu));
        }

        /* renamed from: b */
        public boolean mo6122b(C1300b mode, Menu menu) {
            return this.f4140a.onPrepareActionMode(mo9256b(mode), m6091a(menu));
        }

        /* renamed from: a */
        public boolean mo6121a(C1300b mode, MenuItem item) {
            return this.f4140a.onActionItemClicked(mo9256b(mode), C0894x.m4279a(this.f4141b, (C1224b) item));
        }

        /* renamed from: a */
        public void mo6119a(C1300b mode) {
            this.f4140a.onDestroyActionMode(mo9256b(mode));
        }

        /* renamed from: a */
        private Menu m6091a(Menu menu) {
            Menu wrapper = (Menu) this.f4143d.get(menu);
            if (wrapper != null) {
                return wrapper;
            }
            Menu wrapper2 = C0894x.m4278a(this.f4141b, (C1223a) menu);
            this.f4143d.put(menu, wrapper2);
            return wrapper2;
        }

        /* renamed from: b */
        public ActionMode mo9256b(C1300b mode) {
            int count = this.f4142c.size();
            for (int i = 0; i < count; i++) {
                C1305f wrapper = (C1305f) this.f4142c.get(i);
                if (wrapper != null && wrapper.f4139b == mode) {
                    return wrapper;
                }
            }
            C1305f wrapper2 = new C1305f(this.f4141b, mode);
            this.f4142c.add(wrapper2);
            return wrapper2;
        }
    }

    public C1305f(Context context, C1300b supportActionMode) {
        this.f4138a = context;
        this.f4139b = supportActionMode;
    }

    public Object getTag() {
        return this.f4139b.mo9229f();
    }

    public void setTag(Object tag) {
        this.f4139b.mo9228a(tag);
    }

    public void setTitle(CharSequence title) {
        this.f4139b.mo6192b(title);
    }

    public void setSubtitle(CharSequence subtitle) {
        this.f4139b.mo6188a(subtitle);
    }

    public void invalidate() {
        this.f4139b.mo6197i();
    }

    public void finish() {
        this.f4139b.mo6185a();
    }

    public Menu getMenu() {
        return C0894x.m4278a(this.f4138a, (C1223a) this.f4139b.mo6193c());
    }

    public CharSequence getTitle() {
        return this.f4139b.mo6196g();
    }

    public void setTitle(int resId) {
        this.f4139b.mo6191b(resId);
    }

    public CharSequence getSubtitle() {
        return this.f4139b.mo6195e();
    }

    public void setSubtitle(int resId) {
        this.f4139b.mo6186a(resId);
    }

    public View getCustomView() {
        return this.f4139b.mo6190b();
    }

    public void setCustomView(View view) {
        this.f4139b.mo6187a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f4139b.mo6194d();
    }

    public boolean getTitleOptionalHint() {
        return this.f4139b.mo9230h();
    }

    public void setTitleOptionalHint(boolean titleOptional) {
        this.f4139b.mo6189a(titleOptional);
    }

    public boolean isTitleOptional() {
        return this.f4139b.mo6198j();
    }
}
