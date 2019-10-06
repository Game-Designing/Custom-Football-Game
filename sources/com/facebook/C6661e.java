package com.facebook;

import com.facebook.GraphRequest.C6545b;
import org.json.JSONObject;

/* renamed from: com.facebook.e */
/* compiled from: AccessTokenManager */
class C6661e implements C6545b {

    /* renamed from: a */
    final /* synthetic */ C6664a f12131a;

    /* renamed from: b */
    final /* synthetic */ C6663g f12132b;

    C6661e(C6663g this$0, C6664a aVar) {
        this.f12132b = this$0;
        this.f12131a = aVar;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        JSONObject data = response.mo20228b();
        if (data != null) {
            this.f12131a.f12147a = data.optString("access_token");
            this.f12131a.f12148b = data.optInt("expires_at");
            this.f12131a.f12149c = Long.valueOf(data.optLong("data_access_expiration_time"));
        }
    }
}
