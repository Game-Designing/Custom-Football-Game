package p024io.fabric.sdk.android.p348a.p350b;

import p024io.fabric.sdk.android.C13920f;

/* renamed from: io.fabric.sdk.android.a.b.c */
/* compiled from: AdvertisingInfoProvider */
class C13841c extends C13850j {

    /* renamed from: a */
    final /* synthetic */ C13840b f42018a;

    /* renamed from: b */
    final /* synthetic */ C13842d f42019b;

    C13841c(C13842d this$0, C13840b bVar) {
        this.f42019b = this$0;
        this.f42018a = bVar;
    }

    /* renamed from: a */
    public void mo19461a() {
        C13840b infoToStore = this.f42019b.m43996e();
        if (!this.f42018a.equals(infoToStore)) {
            C13920f.m44245e().mo43326c("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            this.f42019b.m43995c(infoToStore);
        }
    }
}
