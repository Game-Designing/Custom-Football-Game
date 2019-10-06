package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.sa */
final class C12003sa implements Runnable {

    /* renamed from: a */
    private /* synthetic */ C11995qa f37687a;

    C12003sa(C11995qa qaVar) {
        this.f37687a = qaVar;
    }

    public final void run() {
        ((Runnable) this.f37687a.f37674k.poll()).run();
    }
}
