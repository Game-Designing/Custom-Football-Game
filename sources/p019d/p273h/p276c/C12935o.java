package p019d.p273h.p276c;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.o */
/* compiled from: CallbackThrottler */
class C12935o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39822a;

    /* renamed from: b */
    final /* synthetic */ C12799b f39823b;

    /* renamed from: c */
    final /* synthetic */ C12937p f39824c;

    C12935o(C12937p this$0, String str, C12799b bVar) {
        this.f39824c = this$0;
        this.f39822a = str;
        this.f39823b = bVar;
    }

    public void run() {
        this.f39824c.m42125b(this.f39822a, this.f39823b);
        this.f39824c.f39828c.put(this.f39822a, Boolean.valueOf(false));
    }
}
