package com.paypal.android.sdk;

import android.text.TextUtils;

/* renamed from: com.paypal.android.sdk.pa */
final class C11859pa implements Runnable {

    /* renamed from: a */
    private /* synthetic */ C11703Aa f37288a;

    /* renamed from: b */
    private /* synthetic */ C11855oa f37289b;

    C11859pa(C11855oa oaVar, C11703Aa aa) {
        this.f37289b = oaVar;
        this.f37288a = aa;
    }

    public final void run() {
        C11855oa.f37282b;
        StringBuilder sb = new StringBuilder("Mock executing ");
        sb.append(this.f37288a.mo38516n());
        sb.append(" request: ");
        sb.append(this.f37288a.mo38509f());
        if (this.f37289b.mo38613c(this.f37288a)) {
            String b = this.f37289b.mo38611b();
            this.f37288a.mo38511h().mo38569a();
            new StringBuilder("mock failure:\n").append(b);
            this.f37288a.mo38504b(b);
            C11847ma.m39201a(this.f37288a, this.f37289b.mo38612c());
        } else {
            String e = this.f37288a.mo38508e();
            if (!TextUtils.isEmpty(e)) {
                this.f37288a.mo38511h().mo38569a();
                new StringBuilder("mock response:").append(e);
                this.f37288a.mo38504b(e);
                C11847ma.m39202b(this.f37288a);
            } else {
                StringBuilder sb2 = new StringBuilder("Empty mock value for ");
                sb2.append(this.f37288a.mo38511h());
                throw new RuntimeException(sb2.toString());
            }
        }
        if (!this.f37288a.mo38502a()) {
            try {
                C11855oa.f37282b;
                StringBuilder sb3 = new StringBuilder("sleep for [");
                sb3.append(this.f37289b.f37285e);
                sb3.append(" ms].");
                Thread.sleep((long) this.f37289b.f37285e);
                C11855oa.f37282b;
                StringBuilder sb4 = new StringBuilder("end [");
                sb4.append(this.f37289b.f37285e);
                sb4.append(" ms] sleep");
            } catch (InterruptedException e2) {
                this.f37288a.mo38511h().mo38569a();
            }
            this.f37289b.f37283c.mo38529a(this.f37288a);
        }
    }
}
