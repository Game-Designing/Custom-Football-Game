package com.facebook.p127a;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.C6537C;
import com.facebook.C6787r;
import com.facebook.C6817z;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6738z;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.account.AccountAnalytics;

/* renamed from: com.facebook.a.o */
/* compiled from: AppEventQueue */
class C6635o {

    /* renamed from: a */
    private static final String f12076a = C6635o.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static volatile C6628h f12077b = new C6628h();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final ScheduledExecutorService f12078c = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ScheduledFuture f12079d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final Runnable f12080e = new C6629i();

    C6635o() {
    }

    /* renamed from: f */
    public static void m13208f() {
        f12078c.execute(new C6630j());
    }

    /* renamed from: a */
    public static void m13201a(C6644v reason) {
        f12078c.execute(new C6631k(reason));
    }

    /* renamed from: a */
    public static void m13200a(C6593b accessTokenAppId, C6625g appEvent) {
        f12078c.execute(new C6632l(accessTokenAppId, appEvent));
    }

    /* renamed from: e */
    public static Set<C6593b> m13207e() {
        return f12077b.mo19827b();
    }

    /* renamed from: b */
    static void m13204b(C6644v reason) {
        f12077b.mo19825a(C6636p.m13209a());
        try {
            C6646x flushResults = m13196a(reason, f12077b);
            if (flushResults != null) {
                Intent intent = new Intent("com.facebook.sdk.APP_EVENTS_FLUSHED");
                intent.putExtra("com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED", flushResults.f12113a);
                intent.putExtra("com.facebook.sdk.APP_EVENTS_FLUSH_RESULT", flushResults.f12114b);
                C0515e.m2597a(C6787r.m13815e()).mo5314a(intent);
            }
        } catch (Exception e) {
            Log.w(f12076a, "Caught unexpected exception while flushing app events: ", e);
        }
    }

    /* renamed from: a */
    private static C6646x m13196a(C6644v reason, C6628h appEventCollection) {
        C6646x flushResults = new C6646x();
        boolean limitEventUsage = C6787r.m13807a(C6787r.m13815e());
        List<GraphRequest> requestsToExecute = new ArrayList<>();
        for (C6593b accessTokenAppId : appEventCollection.mo19827b()) {
            GraphRequest request = m13194a(accessTokenAppId, appEventCollection.mo19824a(accessTokenAppId), limitEventUsage, flushResults);
            if (request != null) {
                requestsToExecute.add(request);
            }
        }
        if (requestsToExecute.size() <= 0) {
            return null;
        }
        C6676H.m13323a(C6537C.APP_EVENTS, f12076a, "Flushing %d events due to %s.", Integer.valueOf(flushResults.f12113a), reason.toString());
        for (GraphRequest request2 : requestsToExecute) {
            request2.mo19680b();
        }
        return flushResults;
    }

    /* renamed from: a */
    private static GraphRequest m13194a(C6593b accessTokenAppId, C6562B appEvents, boolean limitEventUsage, C6646x flushState) {
        String applicationId = accessTokenAppId.mo19779b();
        C6738z fetchedAppSettings = C6670D.m13301a(applicationId, false);
        GraphRequest postRequest = GraphRequest.m12875a((AccessToken) null, String.format("%s/activities", new Object[]{applicationId}), (JSONObject) null, (C6545b) null);
        Bundle requestParameters = postRequest.mo19688i();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        requestParameters.putString("access_token", accessTokenAppId.mo19778a());
        String pushNotificationsRegistrationId = C6647y.m13255d();
        if (pushNotificationsRegistrationId != null) {
            requestParameters.putString("device_token", pushNotificationsRegistrationId);
        }
        String installReferrer = C6643u.m13240f();
        if (installReferrer != null) {
            requestParameters.putString("install_referrer", installReferrer);
        }
        postRequest.mo19675a(requestParameters);
        boolean supportsImplicitLogging = false;
        if (fetchedAppSettings != null) {
            supportsImplicitLogging = fetchedAppSettings.mo19982j();
        }
        int numEvents = appEvents.mo19743a(postRequest, C6787r.m13815e(), supportsImplicitLogging, limitEventUsage);
        if (numEvents == 0) {
            return null;
        }
        flushState.f12113a += numEvents;
        postRequest.mo19677a((C6545b) new C6633m(accessTokenAppId, postRequest, appEvents, flushState));
        return postRequest;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m13203b(C6593b accessTokenAppId, GraphRequest request, C6817z response, C6562B appEvents, C6646x flushState) {
        String resultDescription;
        String prettyPrintedEvents;
        C6562B b = appEvents;
        C6646x xVar = flushState;
        FacebookRequestError error = response.mo20227a();
        String resultDescription2 = AccountAnalytics.SUCCESS;
        C6645w flushResult = C6645w.SUCCESS;
        boolean z = true;
        if (error == null) {
            resultDescription = resultDescription2;
        } else if (error.mo19661b() == -1) {
            flushResult = C6645w.NO_CONNECTIVITY;
            resultDescription = "Failed: No Connectivity";
        } else {
            String resultDescription3 = String.format("Failed:\n  Response: %s\n  Error %s", new Object[]{response.toString(), error.toString()});
            flushResult = C6645w.SERVER_ERROR;
            resultDescription = resultDescription3;
        }
        if (C6787r.m13808a(C6537C.APP_EVENTS)) {
            try {
                prettyPrintedEvents = new JSONArray((String) request.mo19690k()).toString(2);
            } catch (JSONException e) {
                prettyPrintedEvents = "<Can't encode events for debug logging>";
            }
            C6676H.m13323a(C6537C.APP_EVENTS, f12076a, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.mo19685f().toString(), resultDescription, prettyPrintedEvents);
        }
        if (error == null) {
            z = false;
        }
        b.mo19745a(z);
        if (flushResult == C6645w.NO_CONNECTIVITY) {
            C6593b bVar = accessTokenAppId;
            C6787r.m13822l().execute(new C6634n(accessTokenAppId, b));
        } else {
            C6593b bVar2 = accessTokenAppId;
        }
        if (flushResult != C6645w.SUCCESS && xVar.f12114b != C6645w.NO_CONNECTIVITY) {
            xVar.f12114b = flushResult;
        }
    }
}
