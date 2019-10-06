package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C11708Bb;
import com.paypal.android.sdk.C11724Fb;
import p005cm.aptoide.p006pt.install.installer.RootCommandOnSubscribe;

/* renamed from: com.paypal.android.sdk.payments.a */
class C11912a {

    /* renamed from: a */
    private static final String f37493a = C11912a.class.getSimpleName();

    /* renamed from: b */
    private C11940ia f37494b;

    /* renamed from: c */
    private Object f37495c;

    /* renamed from: d */
    private C11931fa f37496d;

    C11912a() {
    }

    /* renamed from: b */
    private void m39515b(C11931fa faVar) {
        faVar.mo38855a(this.f37495c);
        Object obj = this.f37495c;
        boolean z = !(obj instanceof C11708Bb) && !(obj instanceof C11724Fb);
        this.f37495c = null;
        if (z) {
            this.f37496d = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo39069a() {
        if (this.f37495c == null) {
            this.f37495c = RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION;
        }
        C11931fa faVar = this.f37496d;
        if (faVar != null) {
            m39515b(faVar);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo39070a(C11931fa faVar) {
        if (this.f37495c != null) {
            m39515b(faVar);
            return;
        }
        C11940ia iaVar = this.f37494b;
        if (iaVar != null) {
            faVar.mo38854a(iaVar);
            this.f37494b = null;
            this.f37496d = null;
            return;
        }
        this.f37496d = faVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo39071a(C11940ia iaVar) {
        C11931fa faVar = this.f37496d;
        if (faVar != null) {
            faVar.mo38854a(iaVar);
        } else {
            this.f37494b = iaVar;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo39072a(Object obj) {
        this.f37495c = obj;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo39073b() {
        this.f37496d = null;
    }
}
