package com.facebook.p127a.p130b;

import android.content.Context;
import com.facebook.C6787r;
import java.util.ArrayList;

/* renamed from: com.facebook.a.b.q */
/* compiled from: InAppPurchaseActivityLifecycleTracker */
class C6613q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6614r f12013a;

    C6613q(C6614r this$0) {
        this.f12013a = this$0;
    }

    public void run() {
        Context context = C6787r.m13815e();
        ArrayList<String> purchases = C6616t.m13147b(context, C6615s.f12021h);
        if (purchases.isEmpty()) {
            purchases = C6616t.m13139a(context, C6615s.f12021h);
        }
        C6615s.m13127b(context, purchases);
    }
}
