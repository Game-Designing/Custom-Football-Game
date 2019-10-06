package com.facebook.p127a;

import android.content.Context;
import android.os.Bundle;
import com.facebook.GraphRequest;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6709b;
import com.facebook.p127a.p130b.C6605k;
import com.facebook.p127a.p130b.C6605k.C6606a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.B */
/* compiled from: SessionEventsState */
class C6562B {

    /* renamed from: a */
    private List<C6625g> f11874a = new ArrayList();

    /* renamed from: b */
    private List<C6625g> f11875b = new ArrayList();

    /* renamed from: c */
    private int f11876c;

    /* renamed from: d */
    private C6709b f11877d;

    /* renamed from: e */
    private String f11878e;

    /* renamed from: f */
    private final int f11879f = 1000;

    public C6562B(C6709b identifiers, String anonymousGUID) {
        this.f11877d = identifiers;
        this.f11878e = anonymousGUID;
    }

    /* renamed from: a */
    public synchronized void mo19744a(C6625g event) {
        if (this.f11874a.size() + this.f11875b.size() >= 1000) {
            this.f11876c++;
        } else {
            this.f11874a.add(event);
        }
    }

    /* renamed from: a */
    public synchronized int mo19742a() {
        return this.f11874a.size();
    }

    /* renamed from: a */
    public synchronized void mo19745a(boolean moveToAccumulated) {
        if (moveToAccumulated) {
            this.f11874a.addAll(this.f11875b);
        }
        this.f11875b.clear();
        this.f11876c = 0;
    }

    /* renamed from: a */
    public int mo19743a(GraphRequest request, Context applicationContext, boolean includeImplicitEvents, boolean limitEventUsage) {
        synchronized (this) {
            int numSkipped = this.f11876c;
            this.f11875b.addAll(this.f11874a);
            this.f11874a.clear();
            JSONArray jsonArray = new JSONArray();
            for (C6625g event : this.f11875b) {
                if (!event.mo19821d()) {
                    C6694S.m13433b("Event with invalid checksum: %s", event.toString());
                } else if (includeImplicitEvents || !event.mo19818a()) {
                    jsonArray.put(event.mo19819b());
                }
            }
            if (jsonArray.length() == 0) {
                return 0;
            }
            m12991a(request, applicationContext, numSkipped, jsonArray, limitEventUsage);
            return jsonArray.length();
        }
    }

    /* renamed from: b */
    public synchronized List<C6625g> mo19746b() {
        List<C6625g> list;
        list = this.f11874a;
        this.f11874a = new ArrayList();
        return list;
    }

    /* renamed from: a */
    private void m12991a(GraphRequest request, Context applicationContext, int numSkipped, JSONArray events, boolean limitEventUsage) {
        JSONObject publishParams;
        try {
            publishParams = C6605k.m13113a(C6606a.CUSTOM_APP_EVENTS, this.f11877d, this.f11878e, limitEventUsage, applicationContext);
            if (this.f11876c > 0) {
                publishParams.put("num_skipped_events", numSkipped);
            }
        } catch (JSONException e) {
            publishParams = new JSONObject();
        }
        request.mo19678a(publishParams);
        Bundle requestParameters = request.mo19688i();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        String jsonString = events.toString();
        if (jsonString != null) {
            requestParameters.putString("custom_events", jsonString);
            request.mo19682c((Object) jsonString);
        }
        request.mo19675a(requestParameters);
    }
}
