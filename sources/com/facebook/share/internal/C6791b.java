package com.facebook.share.internal;

import com.facebook.C6817z;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest.C6545b;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.share.internal.b */
/* compiled from: DeviceShareDialogFragment */
class C6791b implements C6545b {

    /* renamed from: a */
    final /* synthetic */ DeviceShareDialogFragment f12500a;

    C6791b(DeviceShareDialogFragment this$0) {
        this.f12500a = this$0;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        FacebookRequestError error = response.mo20227a();
        if (error != null) {
            this.f12500a.m13835a(error);
            return;
        }
        JSONObject jsonObject = response.mo20228b();
        RequestState requestState = new RequestState();
        try {
            requestState.mo20145a(jsonObject.getString("user_code"));
            requestState.mo20144a(jsonObject.getLong("expires_in"));
            this.f12500a.m13836a(requestState);
        } catch (JSONException e) {
            this.f12500a.m13835a(new FacebookRequestError(0, "", "Malformed server response"));
        }
    }
}
