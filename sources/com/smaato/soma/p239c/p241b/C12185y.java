package com.smaato.soma.p239c.p241b;

import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.b.y */
/* compiled from: OrientationChangeBroadcastReceiver */
class C12185y extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12186z f38207a;

    C12185y(C12186z this$0) {
        this.f38207a = this$0;
    }

    public Void process() {
        if (this.f38207a.f38208a != null) {
            this.f38207a.f38208a.unregisterReceiver(this.f38207a);
            this.f38207a.f38208a = null;
        }
        this.f38207a.f38210c = null;
        return null;
    }
}
