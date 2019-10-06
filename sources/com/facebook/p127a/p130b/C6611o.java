package com.facebook.p127a.p130b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.C6787r;

/* renamed from: com.facebook.a.b.o */
/* compiled from: InAppPurchaseActivityLifecycleTracker */
class C6611o implements ServiceConnection {
    C6611o() {
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        C6615s.f12021h = C6616t.m13134a(C6787r.m13815e(), service);
    }

    public void onServiceDisconnected(ComponentName name) {
    }
}
