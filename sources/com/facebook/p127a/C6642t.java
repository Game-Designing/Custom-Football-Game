package com.facebook.p127a;

import com.facebook.internal.C6670D;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.facebook.a.t */
/* compiled from: AppEventsLoggerImpl */
class C6642t implements Runnable {
    C6642t() {
    }

    public void run() {
        Set<String> applicationIds = new HashSet<>();
        for (C6593b accessTokenAppId : C6635o.m13207e()) {
            applicationIds.add(accessTokenAppId.mo19779b());
        }
        for (String applicationId : applicationIds) {
            C6670D.m13301a(applicationId, true);
        }
    }
}
