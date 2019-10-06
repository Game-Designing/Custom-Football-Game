package com.smaato.soma.p239c.p241b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.c.b.w */
/* compiled from: OrientationChangeBroadcastReceiver */
class C12183w extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Context f38201a;

    /* renamed from: b */
    final /* synthetic */ Intent f38202b;

    /* renamed from: c */
    final /* synthetic */ C12186z f38203c;

    C12183w(C12186z this$0, Context context, Intent intent) {
        this.f38203c = this$0;
        this.f38201a = context;
        this.f38202b = intent;
    }

    public Void process() {
        Context context = this.f38201a;
        if (context == null || !(context instanceof Activity)) {
            return null;
        }
        if ("android.intent.action.CONFIGURATION_CHANGED".equals(this.f38202b.getAction())) {
            int orientation = C12180t.m40071a((Activity) this.f38201a);
            if (!(orientation == this.f38203c.f38209b || this.f38203c.f38210c == null)) {
                this.f38203c.f38209b = orientation;
                this.f38203c.f38210c.mo39459n();
            }
        }
        return null;
    }
}
