package com.ironsource.sdk.controller;

import p019d.p273h.p285d.p288c.p289a.C12974b.C12975a;

/* renamed from: com.ironsource.sdk.controller.fa */
/* compiled from: MOATJSAdapter */
class C10849fa implements C12975a {

    /* renamed from: a */
    final /* synthetic */ C10881a f33097a;

    /* renamed from: b */
    final /* synthetic */ String f33098b;

    /* renamed from: c */
    final /* synthetic */ String f33099c;

    /* renamed from: d */
    final /* synthetic */ C10851ga f33100d;

    C10849fa(C10851ga this$0, C10881a aVar, String str, String str2) {
        this.f33100d = this$0;
        this.f33097a = aVar;
        this.f33098b = str;
        this.f33099c = str2;
    }

    public void onTrackingStarted(String s) {
        C10881a aVar = this.f33097a;
        if (aVar != null) {
            aVar.mo35606a(true, this.f33098b, s);
        }
    }

    public void onTrackingFailedToStart(String s) {
        C10881a aVar = this.f33097a;
        if (aVar != null) {
            aVar.mo35606a(false, this.f33099c, s);
        }
    }

    public void onTrackingStopped(String s) {
        C10881a aVar = this.f33097a;
        if (aVar != null) {
            aVar.mo35606a(true, this.f33098b, s);
        }
    }
}
