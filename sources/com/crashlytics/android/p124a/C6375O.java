package com.crashlytics.android.p124a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p024io.fabric.sdk.android.p348a.p351c.C13871a;

/* renamed from: com.crashlytics.android.a.O */
/* compiled from: SessionEventTransform */
class C6375O implements C13871a<C6371M> {
    C6375O() {
    }

    /* renamed from: b */
    public byte[] mo19373a(C6371M event) throws IOException {
        return mo19372a(event).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    /* renamed from: a */
    public JSONObject mo19372a(C6371M event) throws IOException {
        try {
            JSONObject jsonObject = new JSONObject();
            C6374N eventMetadata = event.f11358a;
            jsonObject.put("appBundleId", eventMetadata.f11383a);
            jsonObject.put("executionId", eventMetadata.f11384b);
            jsonObject.put("installationId", eventMetadata.f11385c);
            jsonObject.put("limitAdTrackingEnabled", eventMetadata.f11386d);
            jsonObject.put("betaDeviceToken", eventMetadata.f11387e);
            jsonObject.put("buildId", eventMetadata.f11388f);
            jsonObject.put("osVersion", eventMetadata.f11389g);
            jsonObject.put("deviceModel", eventMetadata.f11390h);
            jsonObject.put("appVersionCode", eventMetadata.f11391i);
            jsonObject.put("appVersionName", eventMetadata.f11392j);
            jsonObject.put("timestamp", event.f11359b);
            jsonObject.put("type", event.f11360c.toString());
            if (event.f11361d != null) {
                jsonObject.put("details", new JSONObject(event.f11361d));
            }
            jsonObject.put("customType", event.f11362e);
            if (event.f11363f != null) {
                jsonObject.put("customAttributes", new JSONObject(event.f11363f));
            }
            jsonObject.put("predefinedType", event.f11364g);
            if (event.f11365h != null) {
                jsonObject.put("predefinedAttributes", new JSONObject(event.f11365h));
            }
            return jsonObject;
        } catch (JSONException e) {
            if (VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
