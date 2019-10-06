package com.facebook.login;

import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.C6545b;
import com.facebook.p131b.p132a.C6652b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.f */
/* compiled from: DeviceAuthDialog */
class C6761f implements C6545b {

    /* renamed from: a */
    final /* synthetic */ DeviceAuthDialog f12422a;

    C6761f(DeviceAuthDialog this$0) {
        this.f12422a = this$0;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        if (!this.f12422a.f12357e.get()) {
            FacebookRequestError error = response.mo20227a();
            if (error != null) {
                int g = error.mo19667g();
                if (g != 1349152) {
                    switch (g) {
                        case 1349172:
                        case 1349174:
                            this.f12422a.m13644e();
                            break;
                        case 1349173:
                            this.f12422a.mo20011b();
                            break;
                        default:
                            this.f12422a.mo20008a(response.mo20227a().mo19665e());
                            break;
                    }
                } else {
                    if (this.f12422a.f12360h != null) {
                        C6652b.m13274a(this.f12422a.f12360h.mo20019d());
                    }
                    if (this.f12422a.f12364l != null) {
                        DeviceAuthDialog deviceAuthDialog = this.f12422a;
                        deviceAuthDialog.mo20009a(deviceAuthDialog.f12364l);
                    } else {
                        this.f12422a.mo20011b();
                    }
                }
                return;
            }
            try {
                JSONObject resultObject = response.mo20228b();
                this.f12422a.m13636a(resultObject.getString("access_token"), Long.valueOf(resultObject.getLong("expires_in")), Long.valueOf(resultObject.optLong("data_access_expiration_time")));
            } catch (JSONException ex) {
                this.f12422a.mo20008a(new FacebookException((Throwable) ex));
            }
        }
    }
}
