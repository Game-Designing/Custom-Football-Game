package com.facebook.p127a.p130b;

import android.os.Bundle;
import com.facebook.C6537C;
import com.facebook.internal.C6676H;
import com.facebook.p127a.C6638q.C6639a;
import com.facebook.p127a.C6647y;
import java.util.Locale;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.notification.PullingContentService;

/* renamed from: com.facebook.a.b.v */
/* compiled from: SessionLogger */
class C6618v {

    /* renamed from: a */
    private static final String f12035a = C6618v.class.getCanonicalName();

    /* renamed from: b */
    private static final long[] f12036b = {300000, 900000, BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS, 3600000, 21600000, 43200000, PullingContentService.UPDATES_INTERVAL, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    C6618v() {
    }

    /* renamed from: a */
    public static void m13167a(String activityName, C6619w sourceApplicationInfo, String appId) {
        String sourAppInfoStr = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle eventParams = new Bundle();
        eventParams.putString("fb_mobile_launch_source", sourAppInfoStr);
        C6647y logger = new C6647y(activityName, appId, null);
        logger.mo19852a("fb_mobile_activate_app", eventParams);
        if (C6647y.m13254c() != C6639a.EXPLICIT_ONLY) {
            logger.mo19849a();
        }
    }

    /* renamed from: a */
    public static void m13166a(String activityName, C6617u sessionInfo, String appId) {
        Long interruptionDurationMillis = Long.valueOf(sessionInfo.mo19806b() - sessionInfo.mo19809e().longValue());
        if (interruptionDurationMillis.longValue() < 0) {
            interruptionDurationMillis = Long.valueOf(0);
            m13165a();
        }
        Long sessionLength = Long.valueOf(sessionInfo.mo19810f());
        if (sessionLength.longValue() < 0) {
            m13165a();
            sessionLength = Long.valueOf(0);
        }
        Bundle eventParams = new Bundle();
        eventParams.putInt("fb_mobile_app_interruptions", sessionInfo.mo19807c());
        eventParams.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", new Object[]{Integer.valueOf(m13164a(interruptionDurationMillis.longValue()))}));
        C6619w sourceApplicationInfo = sessionInfo.mo19811g();
        eventParams.putString("fb_mobile_launch_source", sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified");
        eventParams.putLong("_logTime", sessionInfo.mo19809e().longValue() / 1000);
        C6647y yVar = new C6647y(activityName, appId, null);
        double longValue = (double) sessionLength.longValue();
        Double.isNaN(longValue);
        yVar.mo19851a("fb_mobile_deactivate_app", longValue / 1000.0d, eventParams);
    }

    /* renamed from: a */
    private static void m13165a() {
        C6676H.m13322a(C6537C.APP_EVENTS, f12035a, "Clock skew detected");
    }

    /* renamed from: a */
    private static int m13164a(long timeBetweenSessions) {
        int quantaIndex = 0;
        while (true) {
            long[] jArr = f12036b;
            if (quantaIndex >= jArr.length || jArr[quantaIndex] >= timeBetweenSessions) {
                return quantaIndex;
            }
            quantaIndex++;
        }
        return quantaIndex;
    }
}
