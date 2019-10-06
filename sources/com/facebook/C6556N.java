package com.facebook;

import android.os.Bundle;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6709b;
import com.facebook.internal.C6738z;
import org.json.JSONObject;

/* renamed from: com.facebook.N */
/* compiled from: UserSettingsManager */
class C6556N implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f11852a;

    C6556N(long j) {
        this.f11852a = j;
    }

    public void run() {
        if (C6557O.f11857e.mo19730a()) {
            C6738z appSettings = C6670D.m13301a(C6787r.m13816f(), false);
            if (appSettings != null && appSettings.mo19974b()) {
                String advertiser_id = null;
                C6709b identifiers = C6709b.m13508a(C6787r.m13815e());
                if (!(identifiers == null || identifiers.mo19950a() == null)) {
                    advertiser_id = identifiers.mo19950a();
                }
                if (advertiser_id != null) {
                    Bundle codelessSettingsParams = new Bundle();
                    codelessSettingsParams.putString("advertiser_id", identifiers.mo19950a());
                    String str = "auto_event_setup_enabled";
                    codelessSettingsParams.putString("fields", str);
                    GraphRequest codelessRequest = GraphRequest.m12874a((AccessToken) null, C6787r.m13816f(), (C6545b) null);
                    codelessRequest.mo19679a(true);
                    codelessRequest.mo19675a(codelessSettingsParams);
                    JSONObject response = codelessRequest.mo19680b().mo20228b();
                    if (response != null) {
                        C6557O.f11858f.f11862b = Boolean.valueOf(response.optBoolean(str, false));
                        C6557O.f11858f.f11864d = this.f11852a;
                        C6557O.m12972d(C6557O.f11858f);
                    }
                }
            }
        }
    }
}
