package com.facebook.p127a.p130b;

import android.content.Context;
import com.facebook.C6537C;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6709b;
import com.facebook.p127a.C6638q;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.b.k */
/* compiled from: AppEventsLoggerUtility */
public class C6605k {

    /* renamed from: a */
    private static final Map<C6606a, String> f12002a = new C6604j();

    /* renamed from: com.facebook.a.b.k$a */
    /* compiled from: AppEventsLoggerUtility */
    public enum C6606a {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    /* renamed from: a */
    public static JSONObject m13113a(C6606a activityType, C6709b attributionIdentifiers, String anonymousAppDeviceGUID, boolean limitEventUsage, Context context) throws JSONException {
        JSONObject publishParams = new JSONObject();
        publishParams.put("event", f12002a.get(activityType));
        String externalAnalyticsUserId = C6638q.m13224d();
        if (externalAnalyticsUserId != null) {
            publishParams.put("app_user_id", externalAnalyticsUserId);
        }
        String userData = C6638q.m13222c();
        if (!userData.isEmpty()) {
            publishParams.put("ud", userData);
        }
        C6694S.m13426a(publishParams, attributionIdentifiers, anonymousAppDeviceGUID, limitEventUsage);
        try {
            C6694S.m13425a(publishParams, context);
        } catch (Exception e) {
            C6676H.m13323a(C6537C.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        publishParams.put("application_package_name", context.getPackageName());
        return publishParams;
    }
}
