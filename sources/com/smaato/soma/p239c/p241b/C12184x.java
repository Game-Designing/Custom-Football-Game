package com.smaato.soma.p239c.p241b;

import android.content.Context;
import android.content.IntentFilter;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.b.x */
/* compiled from: OrientationChangeBroadcastReceiver */
class C12184x extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Context f38204a;

    /* renamed from: b */
    final /* synthetic */ C12179s f38205b;

    /* renamed from: c */
    final /* synthetic */ C12186z f38206c;

    C12184x(C12186z this$0, Context context, C12179s sVar) {
        this.f38206c = this$0;
        this.f38204a = context;
        this.f38205b = sVar;
    }

    public Void process() {
        this.f38206c.f38208a = this.f38204a;
        this.f38206c.f38210c = this.f38205b;
        if (this.f38206c.f38208a != null) {
            this.f38206c.f38208a.registerReceiver(this.f38206c, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        }
        return null;
    }
}
