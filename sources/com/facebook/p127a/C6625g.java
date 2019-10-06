package com.facebook.p127a;

import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.C6537C;
import com.facebook.FacebookException;
import com.facebook.internal.C6676H;
import com.facebook.internal.C6694S;
import com.facebook.p127a.p130b.C6603i;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;

/* renamed from: com.facebook.a.g */
/* compiled from: AppEvent */
class C6625g implements Serializable {

    /* renamed from: a */
    private static final HashSet<String> f12053a = new HashSet<>();

    /* renamed from: b */
    private final JSONObject f12054b;

    /* renamed from: c */
    private final boolean f12055c;

    /* renamed from: d */
    private final boolean f12056d;

    /* renamed from: e */
    private final String f12057e;

    /* renamed from: f */
    private final String f12058f;

    /* renamed from: com.facebook.a.g$a */
    /* compiled from: AppEvent */
    static class C6626a implements Serializable {

        /* renamed from: a */
        private final String f12059a;

        /* renamed from: b */
        private final boolean f12060b;

        /* renamed from: c */
        private final boolean f12061c;

        private Object readResolve() throws JSONException {
            C6625g gVar = new C6625g(this.f12059a, this.f12060b, this.f12061c, null);
            return gVar;
        }
    }

    /* renamed from: com.facebook.a.g$b */
    /* compiled from: AppEvent */
    static class C6627b implements Serializable {

        /* renamed from: a */
        private final String f12062a;

        /* renamed from: b */
        private final boolean f12063b;

        /* renamed from: c */
        private final boolean f12064c;

        /* renamed from: d */
        private final String f12065d;

        private C6627b(String jsonString, boolean isImplicit, boolean inBackground, String checksum) {
            this.f12062a = jsonString;
            this.f12063b = isImplicit;
            this.f12064c = inBackground;
            this.f12065d = checksum;
        }

        private Object readResolve() throws JSONException {
            C6625g gVar = new C6625g(this.f12062a, this.f12063b, this.f12064c, this.f12065d);
            return gVar;
        }
    }

    public C6625g(String contextName, String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, boolean isInBackground, UUID currentSessionId) throws JSONException, FacebookException {
        this.f12054b = m13180a(contextName, eventName, valueToSum, parameters, isImplicitlyLogged, isInBackground, currentSessionId);
        this.f12055c = isImplicitlyLogged;
        this.f12056d = isInBackground;
        this.f12057e = eventName;
        this.f12058f = m13182e();
    }

    /* renamed from: c */
    public String mo19820c() {
        return this.f12057e;
    }

    private C6625g(String jsonString, boolean isImplicit, boolean inBackground, String checksum) throws JSONException {
        this.f12054b = new JSONObject(jsonString);
        this.f12055c = isImplicit;
        this.f12057e = this.f12054b.optString("_eventName");
        this.f12058f = checksum;
        this.f12056d = inBackground;
    }

    /* renamed from: a */
    public boolean mo19818a() {
        return this.f12055c;
    }

    /* renamed from: b */
    public JSONObject mo19819b() {
        return this.f12054b;
    }

    /* renamed from: d */
    public boolean mo19821d() {
        if (this.f12058f == null) {
            return true;
        }
        return m13182e().equals(this.f12058f);
    }

    /* renamed from: b */
    private static void m13181b(String identifier) throws FacebookException {
        boolean alreadyValidated;
        String str = "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$";
        if (identifier == null || identifier.length() == 0 || identifier.length() > 40) {
            if (identifier == null) {
                identifier = "<None Provided>";
            }
            throw new FacebookException(String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", new Object[]{identifier, Integer.valueOf(40)}));
        }
        synchronized (f12053a) {
            alreadyValidated = f12053a.contains(identifier);
        }
        if (alreadyValidated) {
            return;
        }
        if (identifier.matches("^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$")) {
            synchronized (f12053a) {
                f12053a.add(identifier);
            }
            return;
        }
        throw new FacebookException(String.format("Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", new Object[]{identifier}));
    }

    /* renamed from: a */
    private static JSONObject m13180a(String contextName, String eventName, Double valueToSum, Bundle parameters, boolean isImplicitlyLogged, boolean isInBackground, UUID currentSessionId) throws FacebookException, JSONException {
        m13181b(eventName);
        JSONObject eventObject = new JSONObject();
        eventObject.put("_eventName", eventName);
        eventObject.put("_eventName_md5", m13179a(eventName));
        eventObject.put("_logTime", System.currentTimeMillis() / 1000);
        eventObject.put("_ui", contextName);
        if (currentSessionId != null) {
            eventObject.put("_session_id", currentSessionId);
        }
        if (valueToSum != null) {
            eventObject.put("_valueToSum", valueToSum.doubleValue());
        }
        String str = "1";
        if (isImplicitlyLogged) {
            eventObject.put("_implicitlyLogged", str);
        }
        if (isInBackground) {
            eventObject.put("_inBackground", str);
        }
        if (parameters != null) {
            for (String key : parameters.keySet()) {
                m13181b(key);
                Object value = parameters.get(key);
                if ((value instanceof String) || (value instanceof Number)) {
                    eventObject.put(key, value.toString());
                } else {
                    throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", new Object[]{value, key}));
                }
            }
        }
        if (!isImplicitlyLogged) {
            C6676H.m13323a(C6537C.APP_EVENTS, "AppEvents", "Created app event '%s'", eventObject.toString());
        }
        return eventObject;
    }

    private Object writeReplace() {
        C6627b bVar = new C6627b(this.f12054b.toString(), this.f12055c, this.f12056d, this.f12058f);
        return bVar;
    }

    public String toString() {
        return String.format("\"%s\", implicit: %b, json: %s", new Object[]{this.f12054b.optString("_eventName"), Boolean.valueOf(this.f12055c), this.f12054b.toString()});
    }

    /* renamed from: e */
    private String m13182e() {
        if (VERSION.SDK_INT > 19) {
            return m13179a(this.f12054b.toString());
        }
        ArrayList<String> keys = new ArrayList<>();
        Iterator<String> iterator = this.f12054b.keys();
        while (iterator.hasNext()) {
            keys.add(iterator.next());
        }
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        Iterator it = keys.iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            sb.append(key);
            sb.append(" = ");
            sb.append(this.f12054b.optString(key));
            sb.append(10);
        }
        return m13179a(sb.toString());
    }

    /* renamed from: a */
    private static String m13179a(String toHash) {
        String str = "Failed to generate checksum: ";
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = toHash.getBytes("UTF-8");
            digest.update(bytes, 0, bytes.length);
            return C6603i.m13108a(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            C6694S.m13422a(str, (Exception) e);
            return BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        } catch (UnsupportedEncodingException e2) {
            C6694S.m13422a(str, (Exception) e2);
            return "1";
        }
    }
}
