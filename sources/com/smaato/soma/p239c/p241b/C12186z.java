package com.smaato.soma.p239c.p241b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.smaato.soma.c.b.z */
/* compiled from: OrientationChangeBroadcastReceiver */
class C12186z extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f38208a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f38209b = -1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C12179s f38210c;

    C12186z() {
    }

    public void onReceive(Context context, Intent intent) {
        new C12183w(this, context, intent).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39463a(Context context, C12179s mraidConnector) {
        new C12184x(this, context, mraidConnector).execute();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39462a() {
        new C12185y(this).execute();
    }
}
