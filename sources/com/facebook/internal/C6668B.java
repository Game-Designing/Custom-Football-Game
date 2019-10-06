package com.facebook.internal;

import com.facebook.internal.C6670D.C6672b;

/* renamed from: com.facebook.internal.B */
/* compiled from: FetchedAppSettingsManager */
class C6668B implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6672b f12164a;

    C6668B(C6672b bVar) {
        this.f12164a = bVar;
    }

    public void run() {
        this.f12164a.onError();
    }
}
