package p019d.p143b.p144a.p147c;

import android.content.Context;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.c.mb */
abstract class C7184mb implements Runnable {

    /* renamed from: a */
    final String f13624a;

    /* renamed from: b */
    protected final C7142c f13625b;

    /* renamed from: c */
    final C7262l f13626c;

    /* renamed from: d */
    final Context f13627d;

    /* renamed from: e */
    protected boolean f13628e = true;

    C7184mb(String str, C7142c cVar) {
        if (cVar != null) {
            this.f13625b = cVar;
            if (str == null) {
                str = getClass().getSimpleName();
            }
            this.f13624a = str;
            this.f13626c = cVar.mo23049b();
            this.f13627d = cVar.mo23068m();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public String mo23203a() {
        return this.f13624a;
    }
}
