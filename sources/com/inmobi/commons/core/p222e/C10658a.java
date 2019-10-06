package com.inmobi.commons.core.p222e;

import android.util.Log;
import com.inmobi.commons.core.p218a.C10628d;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.e.a */
/* compiled from: CatchEvent */
public final class C10658a extends C10628d {

    /* renamed from: g */
    private static final String f32496g = C10669f.class.getSimpleName();

    public C10658a(Throwable th) {
        super("crashReporting", "catchEvent");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", th.getClass().getSimpleName());
            jSONObject.put("message", th.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(th));
            jSONObject.put("thread", Thread.currentThread().getName());
            this.f32389f = jSONObject.toString();
        } catch (JSONException e) {
            new StringBuilder("JSONException: ").append(e);
        }
    }
}
