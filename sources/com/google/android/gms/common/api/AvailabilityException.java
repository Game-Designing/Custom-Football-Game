package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import p002b.p003c.p053g.p061f.C1253b;

public class AvailabilityException extends Exception {

    /* renamed from: a */
    private final C1253b<zai<?>, ConnectionResult> f19549a;

    public AvailabilityException(C1253b<zai<?>, ConnectionResult> bVar) {
        this.f19549a = bVar;
    }

    /* renamed from: a */
    public ConnectionResult mo27348a(GoogleApi<? extends ApiOptions> googleApi) {
        zai g = googleApi.mo27368g();
        Preconditions.m21864a(this.f19549a.get(g) != null, (Object) "The given API was not part of the availability request.");
        return (ConnectionResult) this.f19549a.get(g);
    }

    /* renamed from: a */
    public final C1253b<zai<?>, ConnectionResult> mo27347a() {
        return this.f19549a;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (zai zai : this.f19549a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f19549a.get(zai);
            if (connectionResult.mo27281f()) {
                z = false;
            }
            String a = zai.mo27623a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
