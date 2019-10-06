package com.facebook.p127a.p128a.p129a;

import com.facebook.appevents.codeless.internal.EventBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.a.a */
/* compiled from: EventBinding */
public class C6566a {

    /* renamed from: a */
    private final String f11885a;

    /* renamed from: b */
    private final C6568b f11886b;

    /* renamed from: c */
    private final C6567a f11887c;

    /* renamed from: d */
    private final String f11888d;

    /* renamed from: e */
    private final List<C6570c> f11889e;

    /* renamed from: f */
    private final List<C6569b> f11890f;

    /* renamed from: g */
    private final String f11891g;

    /* renamed from: h */
    private final String f11892h;

    /* renamed from: i */
    private final String f11893i;

    /* renamed from: com.facebook.a.a.a.a$a */
    /* compiled from: EventBinding */
    public enum C6567a {
        CLICK,
        SELECTED,
        TEXT_CHANGED
    }

    /* renamed from: com.facebook.a.a.a.a$b */
    /* compiled from: EventBinding */
    public enum C6568b {
        MANUAL,
        INFERENCE
    }

    public C6566a(String eventName, C6568b method, C6567a type, String appVersion, List<C6570c> path, List<C6569b> parameters, String componentId, String pathType, String activityName) {
        this.f11885a = eventName;
        this.f11886b = method;
        this.f11887c = type;
        this.f11888d = appVersion;
        this.f11889e = path;
        this.f11890f = parameters;
        this.f11891g = componentId;
        this.f11892h = pathType;
        this.f11893i = activityName;
    }

    /* renamed from: a */
    public static List<C6566a> m13003a(JSONArray array) {
        int length;
        List<EventBinding> eventBindings = new ArrayList<>();
        if (array != null) {
            try {
                length = array.length();
            } catch (JSONException e) {
            } catch (IllegalArgumentException e2) {
            }
        } else {
            length = 0;
        }
        for (int i = 0; i < length; i++) {
            eventBindings.add(m13002a(array.getJSONObject(i)));
        }
        return eventBindings;
    }

    /* renamed from: a */
    public static C6566a m13002a(JSONObject mapping) throws JSONException, IllegalArgumentException {
        JSONObject jSONObject = mapping;
        String eventName = jSONObject.getString("event_name");
        C6568b method = C6568b.valueOf(jSONObject.getString("method").toUpperCase(Locale.ENGLISH));
        C6567a type = C6567a.valueOf(jSONObject.getString("event_type").toUpperCase(Locale.ENGLISH));
        String appVersion = jSONObject.getString("app_version");
        JSONArray jsonPathArray = jSONObject.getJSONArray("path");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jsonPathArray.length(); i++) {
            arrayList.add(new C6570c(jsonPathArray.getJSONObject(i)));
        }
        String pathType = jSONObject.optString("path_type", "absolute");
        JSONArray jsonParameterArray = jSONObject.optJSONArray("parameters");
        ArrayList arrayList2 = new ArrayList();
        if (jsonParameterArray != null) {
            for (int i2 = 0; i2 < jsonParameterArray.length(); i2++) {
                arrayList2.add(new C6569b(jsonParameterArray.getJSONObject(i2)));
            }
        }
        ArrayList arrayList3 = arrayList2;
        JSONArray jSONArray = jsonParameterArray;
        ArrayList arrayList4 = arrayList;
        C6566a aVar = new C6566a(eventName, method, type, appVersion, arrayList, arrayList2, jSONObject.optString("component_id"), pathType, jSONObject.optString("activity_name"));
        return aVar;
    }

    /* renamed from: e */
    public List<C6570c> mo19751e() {
        return Collections.unmodifiableList(this.f11889e);
    }

    /* renamed from: d */
    public List<C6569b> mo19750d() {
        return Collections.unmodifiableList(this.f11890f);
    }

    /* renamed from: b */
    public String mo19748b() {
        return this.f11885a;
    }

    /* renamed from: c */
    public C6567a mo19749c() {
        return this.f11887c;
    }

    /* renamed from: a */
    public String mo19747a() {
        return this.f11893i;
    }
}
