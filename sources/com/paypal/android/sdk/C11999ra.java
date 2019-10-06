package com.paypal.android.sdk;

import java.io.IOException;
import okhttp3.Callback;

/* renamed from: com.paypal.android.sdk.ra */
final class C11999ra implements Runnable {

    /* renamed from: a */
    private /* synthetic */ C11703Aa f37681a;

    /* renamed from: b */
    private /* synthetic */ String f37682b;

    /* renamed from: c */
    private /* synthetic */ C11995qa f37683c;

    C11999ra(C11995qa qaVar, C11703Aa aa, String str) {
        this.f37683c = qaVar;
        this.f37681a = aa;
        this.f37682b = str;
    }

    public final void run() {
        try {
            this.f37683c.m39680a(this.f37681a, this.f37682b, this.f37683c.f37671h, (Callback) new C12015va(this.f37683c, this.f37681a, 0));
        } catch (IOException e) {
        }
    }
}
