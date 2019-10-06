package com.facebook.login;

import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.GraphRequest.C6545b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.c */
/* compiled from: DeviceAuthDialog */
class C6758c implements C6545b {

    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f12419a;

    C6758c(DeviceAuthDialog this$0) {
        this.f12419a = this$0;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        if (!this.f12419a.f12362j) {
            if (response.mo20227a() != null) {
                this.f12419a.mo20008a(response.mo20227a().mo19665e());
                return;
            }
            JSONObject jsonObject = response.mo20228b();
            RequestState requestState = new RequestState();
            try {
                requestState.mo20017b(jsonObject.getString("user_code"));
                requestState.mo20014a(jsonObject.getString("code"));
                requestState.mo20013a(jsonObject.getLong("interval"));
                this.f12419a.m13629a(requestState);
            } catch (JSONException ex) {
                this.f12419a.mo20008a(new FacebookException((Throwable) ex));
            }
        }
    }
}
