package com.facebook.p127a;

import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6534A;
import com.facebook.C6537C;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6709b;
import com.facebook.internal.C6720k;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.s */
/* compiled from: AppEventsLoggerImpl */
class C6641s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bundle f12089a;

    /* renamed from: b */
    final /* synthetic */ String f12090b;

    /* renamed from: c */
    final /* synthetic */ C6545b f12091c;

    C6641s(Bundle bundle, String str, C6545b bVar) {
        this.f12089a = bundle;
        this.f12090b = str;
        this.f12091c = bVar;
    }

    public void run() {
        String userID = C6623e.m13176d();
        if (userID == null || userID.isEmpty()) {
            C6676H.m13322a(C6537C.APP_EVENTS, C6643u.f12092a, "AppEventsLogger userID cannot be null or empty");
            return;
        }
        Bundle userPropertiesParams = new Bundle();
        userPropertiesParams.putString("user_unique_id", userID);
        userPropertiesParams.putBundle("custom_data", this.f12089a);
        C6709b identifiers = C6709b.m13508a(C6787r.m13815e());
        if (!(identifiers == null || identifiers.mo19950a() == null)) {
            userPropertiesParams.putString("advertiser_id", identifiers.mo19950a());
        }
        Bundle data = new Bundle();
        try {
            JSONObject userData = C6720k.m13540a(userPropertiesParams);
            JSONArray dataArray = new JSONArray();
            dataArray.put(userData);
            data.putString("data", dataArray.toString());
            Bundle bundle = data;
            GraphRequest request = new GraphRequest(AccessToken.m12820c(), String.format(Locale.US, "%s/user_properties", new Object[]{this.f12090b}), bundle, C6534A.POST, this.f12091c);
            request.mo19679a(true);
            request.mo19681c();
        } catch (JSONException ex) {
            throw new FacebookException("Failed to construct request", ex);
        }
    }
}
