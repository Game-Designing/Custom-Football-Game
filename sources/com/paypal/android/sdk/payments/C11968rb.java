package com.paypal.android.sdk.payments;

import android.app.Activity;
import com.paypal.android.sdk.C11724Fb;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;

/* renamed from: com.paypal.android.sdk.payments.rb */
final class C11968rb implements C11931fa {

    /* renamed from: a */
    private /* synthetic */ C11950lb f37606a;

    C11968rb(C11950lb lbVar) {
        this.f37606a = lbVar;
    }

    /* renamed from: a */
    public final void mo38854a(C11940ia iaVar) {
        this.f37606a.dismissDialog(2);
        if (iaVar.f37560b.equals("invalid_nonce")) {
            this.f37606a.f37583g.f37024j.setEnabled(false);
            C11867Da.m39241a((Activity) this.f37606a, C11756Pb.m38949a(C11761Rb.SESSION_EXPIRED_MESSAGE), 4);
            return;
        }
        this.f37606a.f37583g.f37024j.setEnabled(true);
        C11867Da.m39241a((Activity) this.f37606a, C11756Pb.m38950a(iaVar.f37560b), 1);
    }

    /* renamed from: a */
    public final void mo38855a(Object obj) {
        if (obj instanceof C11724Fb) {
            C11950lb.m39605a(this.f37606a, (C11724Fb) obj);
        } else {
            this.f37606a.m39620i();
        }
    }
}
