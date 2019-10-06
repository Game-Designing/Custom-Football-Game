package p019d.p143b.p144a.p147c;

import android.app.AlertDialog;
import p019d.p143b.p144a.p146b.C6950D;

/* renamed from: d.b.a.c.aa */
public class C7135aa {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C7142c f13439a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C6950D f13440b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f13441c;

    public C7135aa(C6950D d, C7142c cVar) {
        this.f13439a = cVar;
        this.f13440b = d;
    }

    /* renamed from: a */
    public void mo23015a() {
        this.f13440b.runOnUiThread(new C7139ba(this));
    }

    /* renamed from: b */
    public void mo23016b() {
        this.f13440b.runOnUiThread(new C7143ca(this));
    }

    /* renamed from: c */
    public void mo23017c() {
        this.f13440b.runOnUiThread(new C7155fa(this));
    }

    /* renamed from: d */
    public boolean mo23018d() {
        AlertDialog alertDialog = this.f13441c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }
}
