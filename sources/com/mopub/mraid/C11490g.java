package com.mopub.mraid;

/* renamed from: com.mopub.mraid.g */
/* compiled from: MraidBridge */
class C11490g implements C11483c {

    /* renamed from: a */
    final /* synthetic */ MraidJavascriptCommand f35567a;

    /* renamed from: b */
    final /* synthetic */ MraidBridge f35568b;

    C11490g(MraidBridge this$0, MraidJavascriptCommand mraidJavascriptCommand) {
        this.f35568b = this$0;
        this.f35567a = mraidJavascriptCommand;
    }

    public void onFailure(C11493j exception) {
        this.f35568b.m37957a(this.f35567a, exception.getMessage());
    }
}
