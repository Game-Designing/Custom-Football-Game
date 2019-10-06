package com.smaato.soma;

import android.content.DialogInterface;

/* renamed from: com.smaato.soma.ya */
/* compiled from: FullScreenBanner */
class C12522ya extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ DialogInterface f38980a;

    /* renamed from: b */
    final /* synthetic */ C12524za f38981b;

    C12522ya(C12524za this$2, DialogInterface dialogInterface) {
        this.f38981b = this$2;
        this.f38980a = dialogInterface;
    }

    public Void process() throws Exception {
        C12493k kVar = this.f38981b.f38984a.f37874q.f37959b;
        if (kVar != null) {
            kVar.mo40025c();
        }
        C12142b.m39962a(this.f38981b.f38984a.f37874q.f37873f.mo39297l(), this.f38981b.f38984a.getContext());
        this.f38980a.dismiss();
        return null;
    }
}
