package com.paypal.android.sdk;

import java.util.TimerTask;

/* renamed from: com.paypal.android.sdk.w */
final class C12018w extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C12010u f37796a;

    C12018w(C12010u uVar) {
        this.f37796a = uVar;
    }

    public final void run() {
        this.f37796a.f37767k = this.f37796a.f37767k + 1;
        String h = C12010u.f37757a;
        StringBuilder sb = new StringBuilder("****** LoadConfigurationTask #");
        sb.append(this.f37796a.f37767k);
        C11754P.m38931a(h, sb.toString());
        C11739K.m38870a().mo38579a(new C11722F(this.f37796a.f37762f, this.f37796a.f37769m, this.f37796a.f37777u));
    }
}
