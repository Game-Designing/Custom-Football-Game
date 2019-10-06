package com.facebook.p127a.p128a.p129a;

import com.facebook.appevents.codeless.internal.PathComponent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.app.view.donations.DonationsAnalytics;

/* renamed from: com.facebook.a.a.a.b */
/* compiled from: ParameterComponent */
public final class C6569b {

    /* renamed from: a */
    public final String f11901a;

    /* renamed from: b */
    public final String f11902b;

    /* renamed from: c */
    public final List<C6570c> f11903c;

    /* renamed from: d */
    public final String f11904d;

    public C6569b(JSONObject component) throws JSONException {
        this.f11901a = component.getString("name");
        this.f11902b = component.optString(DonationsAnalytics.VALUE);
        ArrayList<PathComponent> pathComponents = new ArrayList<>();
        JSONArray jsonPathArray = component.optJSONArray("path");
        if (jsonPathArray != null) {
            for (int i = 0; i < jsonPathArray.length(); i++) {
                pathComponents.add(new C6570c(jsonPathArray.getJSONObject(i)));
            }
        }
        this.f11903c = pathComponents;
        this.f11904d = component.optString("path_type", "absolute");
    }
}
