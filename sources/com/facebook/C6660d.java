package com.facebook;

import android.util.Log;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6694S;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.d */
/* compiled from: AccessTokenManager */
class C6660d implements C6545b {

    /* renamed from: a */
    final /* synthetic */ AtomicBoolean f12126a;

    /* renamed from: b */
    final /* synthetic */ Set f12127b;

    /* renamed from: c */
    final /* synthetic */ Set f12128c;

    /* renamed from: d */
    final /* synthetic */ Set f12129d;

    /* renamed from: e */
    final /* synthetic */ C6663g f12130e;

    C6660d(C6663g this$0, AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
        this.f12130e = this$0;
        this.f12126a = atomicBoolean;
        this.f12127b = set;
        this.f12128c = set2;
        this.f12129d = set3;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        JSONObject result = response.mo20228b();
        if (result != null) {
            JSONArray permissionsArray = result.optJSONArray("data");
            if (permissionsArray != null) {
                this.f12126a.set(true);
                for (int i = 0; i < permissionsArray.length(); i++) {
                    JSONObject permissionEntry = permissionsArray.optJSONObject(i);
                    if (permissionEntry != null) {
                        String permission = permissionEntry.optString("permission");
                        String status = permissionEntry.optString("status");
                        if (!C6694S.m13436b(permission) && !C6694S.m13436b(status)) {
                            String status2 = status.toLowerCase(Locale.US);
                            if (status2.equals("granted")) {
                                this.f12127b.add(permission);
                            } else if (status2.equals("declined")) {
                                this.f12128c.add(permission);
                            } else if (status2.equals("expired")) {
                                this.f12129d.add(permission);
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Unexpected status: ");
                                sb.append(status2);
                                Log.w("AccessTokenManager", sb.toString());
                            }
                        }
                    }
                }
            }
        }
    }
}
