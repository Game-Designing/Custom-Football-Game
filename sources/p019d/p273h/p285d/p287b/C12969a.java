package p019d.p273h.p285d.p287b;

import android.app.Activity;
import android.content.Context;
import com.ironsource.sdk.controller.C10839b;
import com.ironsource.sdk.controller.C10851ga;
import com.ironsource.sdk.controller.C10860ka;
import com.ironsource.sdk.controller.C10877y;
import p019d.p273h.p285d.p295h.C13004g;

/* renamed from: d.h.d.b.a */
/* compiled from: IronSourceAdsPublisherAgent */
class C12969a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Activity f39914a;

    /* renamed from: b */
    final /* synthetic */ C12971c f39915b;

    C12969a(C12971c this$0, Activity activity) {
        this.f39915b = this$0;
        this.f39914a = activity;
    }

    public void run() {
        this.f39915b.f39924g = new C10877y(C12971c.f39919b, this.f39915b.f39927j);
        this.f39915b.f39924g.mo35456a(new C10851ga(this.f39914a.getApplication()));
        this.f39915b.f39924g.mo35457a(new C10860ka(this.f39914a.getApplicationContext()));
        this.f39915b.f39928k = new C10839b();
        this.f39915b.f39928k.mo35409a(this.f39915b.f39924g.getControllerDelegate());
        this.f39915b.f39924g.mo35455a(this.f39915b.f39928k);
        this.f39915b.f39924g.mo35479c((Context) this.f39914a);
        this.f39915b.f39924g.setDebugMode(C13004g.m42464g());
        this.f39915b.f39924g.mo35483d();
        this.f39915b.f39921d.mo35417b();
        this.f39915b.f39921d.mo35415a();
    }
}
