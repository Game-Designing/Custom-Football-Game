package com.paypal.android.sdk;

import java.util.TimerTask;

/* renamed from: com.paypal.android.sdk.v */
final class C12014v extends TimerTask {

    /* renamed from: a */
    private /* synthetic */ C12010u f37791a;

    C12014v(C12010u uVar) {
        this.f37791a = uVar;
    }

    public final void run() {
        this.f37791a.f37766j = this.f37791a.f37766j + 1;
        String h = C12010u.f37757a;
        StringBuilder sb = new StringBuilder("****** LogRiskMetadataTask #");
        sb.append(this.f37791a.f37766j);
        C11754P.m38931a(h, sb.toString());
        if (C12010u.m39726c(this.f37791a)) {
            String h2 = C12010u.f37757a;
            StringBuilder sb2 = new StringBuilder("No host activity in the last ");
            sb2.append(this.f37791a.f37765i / 1000);
            sb2.append(" seconds. Stopping update interval.");
            C11754P.m38931a(h2, sb2.toString());
            this.f37791a.f37776t.cancel();
            return;
        }
        try {
            C12010u.m39730f(this.f37791a);
        } catch (Exception e) {
            C11754P.m38932a(C12010u.f37757a, "Error in logRiskMetadataTask: ", (Throwable) e);
        }
    }
}
