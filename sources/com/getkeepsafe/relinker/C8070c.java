package com.getkeepsafe.relinker;

import android.content.Context;
import com.getkeepsafe.relinker.C8065b.C8068c;

/* renamed from: com.getkeepsafe.relinker.c */
/* compiled from: ReLinkerInstance */
class C8070c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f16430a;

    /* renamed from: b */
    final /* synthetic */ String f16431b;

    /* renamed from: c */
    final /* synthetic */ String f16432c;

    /* renamed from: d */
    final /* synthetic */ C8068c f16433d;

    /* renamed from: e */
    final /* synthetic */ C8072e f16434e;

    C8070c(C8072e this$0, Context context, String str, String str2, C8068c cVar) {
        this.f16434e = this$0;
        this.f16430a = context;
        this.f16431b = str;
        this.f16432c = str2;
        this.f16433d = cVar;
    }

    public void run() {
        try {
            this.f16434e.m18179c(this.f16430a, this.f16431b, this.f16432c);
            this.f16433d.mo24896a();
        } catch (UnsatisfiedLinkError e) {
            this.f16433d.mo24897a(e);
        } catch (MissingLibraryException e2) {
            this.f16433d.mo24897a(e2);
        }
    }
}
