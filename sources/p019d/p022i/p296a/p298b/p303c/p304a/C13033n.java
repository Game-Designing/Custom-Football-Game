package p019d.p022i.p296a.p298b.p303c.p304a;

import android.support.p001v7.widget.Toolbar;
import android.support.p001v7.widget.Toolbar.C1020c;
import android.view.MenuItem;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p387a.C14521b;

/* renamed from: d.i.a.b.c.a.n */
/* compiled from: ToolbarItemClickOnSubscribe */
final class C13033n implements C0122a<MenuItem> {

    /* renamed from: a */
    final Toolbar f40009a;

    C13033n(Toolbar view) {
        this.f40009a = view;
    }

    /* renamed from: a */
    public void call(C14980ia<? super MenuItem> subscriber) {
        C14521b.verifyMainThread();
        C1020c listener = new C13031l(this, subscriber);
        subscriber.add(new C13032m(this));
        this.f40009a.setOnMenuItemClickListener(listener);
    }
}
