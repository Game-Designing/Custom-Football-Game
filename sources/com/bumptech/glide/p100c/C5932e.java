package com.bumptech.glide.p100c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.bumptech.glide.c.e */
/* compiled from: DefaultConnectivityMonitor */
class C5932e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C5933f f10446a;

    C5932e(C5933f this$0) {
        this.f10446a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        C5933f fVar = this.f10446a;
        boolean wasConnected = fVar.f10449c;
        fVar.f10449c = fVar.mo18598a(context);
        if (wasConnected != this.f10446a.f10449c) {
            String str = "ConnectivityMonitor";
            if (Log.isLoggable(str, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("connectivity changed, isConnected: ");
                sb.append(this.f10446a.f10449c);
                Log.d(str, sb.toString());
            }
            C5933f fVar2 = this.f10446a;
            fVar2.f10448b.mo18595a(fVar2.f10449c);
        }
    }
}
