package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.paypal.android.sdk.X */
public class C11777X {

    /* renamed from: a */
    private static final String f37059a = C11777X.class.getSimpleName();

    /* renamed from: b */
    private final List f37060b = new ArrayList();

    /* renamed from: a */
    public final void mo38647a() {
        synchronized (this.f37060b) {
            for (C11780Y remove : this.f37060b) {
                this.f37060b.remove(remove);
            }
        }
    }

    /* renamed from: a */
    public final void mo38648a(C11703Aa aa, long j) {
        new StringBuilder("dispatching ").append(aa.mo38516n());
        if (aa.mo38517o() < 0) {
            new StringBuilder("discarding ").append(aa.mo38516n());
            return;
        }
        ArrayList<C11780Y> arrayList = new ArrayList<>();
        synchronized (this.f37060b) {
            for (C11780Y add : this.f37060b) {
                arrayList.add(0, add);
            }
        }
        for (C11780Y y : arrayList) {
            y.f37067a.mo38665a(aa);
        }
    }

    /* renamed from: a */
    public final void mo38649a(C11783Z z) {
        synchronized (this.f37060b) {
            for (C11780Y y : this.f37060b) {
                if (y.f37067a == z) {
                    new StringBuilder("Ignoring attempt to re-register listener ").append(z);
                    return;
                }
            }
            this.f37060b.add(new C11780Y(this, z));
        }
    }
}
