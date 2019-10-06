package com.facebook.p127a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6537C;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6697T;
import com.facebook.internal.C6737y;
import com.facebook.p127a.C6638q.C6639a;
import com.facebook.p127a.p130b.C6602h;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* renamed from: com.facebook.a.u */
/* compiled from: AppEventsLoggerImpl */
class C6643u {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12092a = C6643u.class.getCanonicalName();

    /* renamed from: b */
    private static ScheduledThreadPoolExecutor f12093b;

    /* renamed from: c */
    private static C6639a f12094c = C6639a.AUTO;

    /* renamed from: d */
    private static Object f12095d = new Object();

    /* renamed from: e */
    private static String f12096e;

    /* renamed from: f */
    private static boolean f12097f;

    /* renamed from: g */
    private static String f12098g;

    /* renamed from: h */
    private final String f12099h;

    /* renamed from: i */
    private final C6593b f12100i;

    /* renamed from: a */
    static void m13231a(Application application, String applicationId) {
        if (C6787r.m13829s()) {
            C6623e.m13177e();
            C6563C.m13000b();
            if (applicationId == null) {
                applicationId = C6787r.m13816f();
            }
            C6787r.m13811b(application, applicationId);
            C6602h.m13083a(application, applicationId);
            return;
        }
        throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
    }

    /* renamed from: a */
    static void m13232a(Context context, String applicationId) {
        if (C6787r.m13818h()) {
            f12093b.execute(new C6640r(context, new C6643u(context, applicationId, (AccessToken) null)));
        }
    }

    /* renamed from: e */
    static C6639a m13239e() {
        C6639a aVar;
        synchronized (f12095d) {
            aVar = f12094c;
        }
        return aVar;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19840a(String eventName) {
        mo19842a(eventName, (Bundle) null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19842a(String eventName, Bundle parameters) {
        mo19844a(eventName, null, parameters, false, C6602h.m13102n());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19841a(String eventName, double valueToSum, Bundle parameters) {
        mo19844a(eventName, Double.valueOf(valueToSum), parameters, false, C6602h.m13102n());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19846a(BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        mo19847a(purchaseAmount, currency, parameters, true);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19847a(BigDecimal purchaseAmount, Currency currency, Bundle parameters, boolean isImplicitlyLogged) {
        if (purchaseAmount == null) {
            m13237c("purchaseAmount cannot be null");
        } else if (currency == null) {
            m13237c("currency cannot be null");
        } else {
            if (parameters == null) {
                parameters = new Bundle();
            }
            parameters.putString("fb_currency", currency.getCurrencyCode());
            mo19844a("fb_mobile_purchase", Double.valueOf(purchaseAmount.doubleValue()), parameters, isImplicitlyLogged, C6602h.m13102n());
            m13235b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo19848c() {
        C6635o.m13201a(C6644v.EXPLICIT);
    }

    /* renamed from: h */
    static void m13242h() {
        C6635o.m13208f();
    }

    /* renamed from: g */
    static String m13241g() {
        String str;
        synchronized (f12095d) {
            str = f12098g;
        }
        return str;
    }

    /* renamed from: b */
    static void m13236b(String referrer) {
        SharedPreferences preferences = C6787r.m13815e().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
        if (referrer != null) {
            preferences.edit().putString("install_referrer", referrer).apply();
        }
    }

    /* renamed from: f */
    static String m13240f() {
        return C6787r.m13815e().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", null);
    }

    /* renamed from: a */
    static void m13233a(Bundle parameters, String applicationID, C6545b callback) {
        m13238d().execute(new C6641s(parameters, applicationID, callback));
    }

    C6643u(Context context, String applicationId, AccessToken accessToken) {
        this(C6694S.m13431b(context), applicationId, accessToken);
    }

    C6643u(String activityName, String applicationId, AccessToken accessToken) {
        C6697T.m13468c();
        this.f12099h = activityName;
        if (accessToken == null) {
            accessToken = AccessToken.m12820c();
        }
        if (!AccessToken.m12821m() || (applicationId != null && !applicationId.equals(accessToken.mo19620b()))) {
            if (applicationId == null) {
                applicationId = C6694S.m13437c(C6787r.m13815e());
            }
            this.f12100i = new C6593b(null, applicationId);
        } else {
            this.f12100i = new C6593b(accessToken);
        }
        m13243i();
    }

    /* renamed from: i */
    private static void m13243i() {
        synchronized (f12095d) {
            if (f12093b == null) {
                f12093b = new ScheduledThreadPoolExecutor(1);
                f12093b.scheduleAtFixedRate(new C6642t(), 0, 86400, TimeUnit.SECONDS);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19843a(String eventName, Double valueToSum, Bundle parameters) {
        mo19844a(eventName, valueToSum, parameters, true, C6602h.m13102n());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19845a(String eventName, BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (purchaseAmount == null || currency == null) {
            C6694S.m13433b(f12092a, "purchaseAmount and currency cannot be null");
            return;
        }
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("fb_currency", currency.getCurrencyCode());
        mo19844a(eventName, Double.valueOf(purchaseAmount.doubleValue()), parameters, true, C6602h.m13102n());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo19844a(String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, UUID currentSessionId) {
        String str = "AppEvents";
        if (C6737y.m13573a("app_events_killswitch", C6787r.m13816f(), false)) {
            C6676H.m13323a(C6537C.APP_EVENTS, str, "KillSwitch is enabled and fail to log app event: %s", eventName);
            return;
        }
        try {
            C6625g gVar = new C6625g(this.f12099h, eventName, valueToSum, parameters, isImplicitlyLogged, C6602h.m13104p(), currentSessionId);
            m13234a(gVar, this.f12100i);
        } catch (JSONException jsonException) {
            C6676H.m13323a(C6537C.APP_EVENTS, str, "JSON encoding for app event failed: '%s'", jsonException.toString());
        } catch (FacebookException e) {
            C6676H.m13323a(C6537C.APP_EVENTS, str, "Invalid app event: %s", e.toString());
        }
    }

    /* renamed from: a */
    private static void m13234a(C6625g event, C6593b accessTokenAppId) {
        C6635o.m13200a(accessTokenAppId, event);
        if (!event.mo19818a() && !f12097f) {
            if (event.mo19820c().equals("fb_mobile_activate_app")) {
                f12097f = true;
            } else {
                C6676H.m13322a(C6537C.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
            }
        }
    }

    /* renamed from: b */
    static void m13235b() {
        if (m13239e() != C6639a.EXPLICIT_ONLY) {
            C6635o.m13201a(C6644v.EAGER_FLUSHING_EVENT);
        }
    }

    /* renamed from: c */
    private static void m13237c(String message) {
        C6676H.m13322a(C6537C.DEVELOPER_ERRORS, "AppEvents", message);
    }

    /* renamed from: d */
    static Executor m13238d() {
        if (f12093b == null) {
            m13243i();
        }
        return f12093b;
    }

    /* renamed from: a */
    static String m13230a(Context context) {
        if (f12096e == null) {
            synchronized (f12095d) {
                if (f12096e == null) {
                    f12096e = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (f12096e == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("XZ");
                        sb.append(UUID.randomUUID().toString());
                        f12096e = sb.toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", f12096e).apply();
                    }
                }
            }
        }
        return f12096e;
    }
}
