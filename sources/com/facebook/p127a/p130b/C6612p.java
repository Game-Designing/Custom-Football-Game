package com.facebook.p127a.p130b;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.C6787r;
import com.facebook.appevents.internal.SubscriptionType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.a.b.p */
/* compiled from: InAppPurchaseActivityLifecycleTracker */
class C6612p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6614r f12012a;

    C6612p(C6614r this$0) {
        this.f12012a = this$0;
    }

    public void run() {
        Context context = C6787r.m13815e();
        C6615s.m13127b(context, C6616t.m13147b(context, C6615s.f12021h));
        Map<String, SubscriptionType> purchasesSubs = C6616t.m13152c(context, C6615s.f12021h);
        C6615s.m13128b(context, purchasesSubs, new HashMap());
        Set<Integer> errorCodes = new HashSet<>();
        purchasesSubs.clear();
        Iterator it = C6616t.m13142a(context, C6615s.f12021h, errorCodes).iterator();
        while (it.hasNext()) {
            purchasesSubs.put((String) it.next(), C6620x.EXPIRE);
        }
        Map<String, String> extraParameters = new HashMap<>();
        if (!errorCodes.isEmpty()) {
            extraParameters.put("error_code", TextUtils.join(",", errorCodes));
        }
        C6615s.m13128b(context, purchasesSubs, extraParameters);
    }
}
